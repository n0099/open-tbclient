package com.baidu.tieba.enterForum.view;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class f {
    private Vibrator aYA;
    private View eAV;
    private com.baidu.tieba.enterForum.data.b eXg;
    private com.baidu.tieba.enterForum.a.b feA;
    private ViewEventCenter feB;
    private com.baidu.tieba.enterForum.home.e feC;
    private k feD;
    private a feE;
    private RecentlyVisitedForumModel fev;
    private ImageView few;
    private TextView fex;
    private RecyclerView fey;
    private View fez;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean fdn = true;
    private boolean eXt = false;
    private CustomMessageListener feF = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.feD == null) {
                        f.this.feD = new k(new i());
                    }
                    f.this.feD.a(f.this.fey, 1);
                } else if (f.this.feD != null) {
                    f.this.feD.ox();
                }
            }
        }
    };
    private CustomMessageListener cUD = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bfH();
            }
        }
    };
    private CustomMessageListener feG = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.fm(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bfJ();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fev = recentlyVisitedForumModel;
        this.feB = viewEventCenter;
        this.aYA = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.feC = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.feF);
        MessageManager.getInstance().registerListener(this.cUD);
        initData();
        initView();
    }

    private void initData() {
        this.fdn = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.eAV = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.few = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.few.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bhS();
            }
        });
        this.fex = (TextView) this.mRootView.findViewById(R.id.done);
        this.fex.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gn(false);
            }
        });
        this.fez = this.mRootView.findViewById(R.id.gap);
        this.fey = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.feA = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.fey.setAdapter(this.feA);
        this.fey.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.feD = new k(new i());
            this.feD.a(this.fey, 1);
        }
        this.fey.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.fey.setItemAnimator(new DefaultItemAnimator());
        this.fey.addItemDecoration(new b(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.feA.a(new b.InterfaceC0310b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0310b
            public void a(b.a aVar) {
                if (!f.this.eXt && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.arY());
                    f.this.mPageContext.sendMessage(new CustomMessage(2003000, callFrom));
                    TiebaStatic.log(new an("c13002").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.feA.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gn(true);
                return true;
            }
        });
        this.feA.r(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fev != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fev.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fev.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void qF(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.n(linkedList);
                if (!z && f.this.feC != null) {
                    f.this.feC.d(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.feG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.eXz;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.ccX;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eXB;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eXD.getUrl());
        }
    }

    public boolean bfH() {
        if (this.eXt) {
            gn(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(boolean z) {
        if (this.eXt != z && this.feA != null) {
            this.eXt = z;
            if (this.eXt) {
                this.fex.setVisibility(0);
                this.few.setVisibility(8);
                if (this.aYA != null) {
                    this.aYA.vibrate(10L);
                }
                if (this.feB != null) {
                    this.feB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.fex.setVisibility(8);
                this.few.setVisibility(0);
                if (this.feB != null) {
                    this.feB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.feA.gn(this.eXt);
        }
    }

    public boolean bhR() {
        return this.eXt;
    }

    public void bhS() {
        this.fdn = !this.fdn;
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_recently_visited_forum_extend_state", this.fdn);
        if (this.fdn) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bhU();
    }

    public boolean bhT() {
        return this.fdn;
    }

    private void bhU() {
        int i = R.color.white_alpha100;
        if (this.fdn) {
            this.fey.setVisibility(0);
            this.fez.setVisibility(8);
            if (this.eXg == null || !this.eXg.eXL) {
                i = R.color.cp_cont_j;
            }
            SvgManager.ajv().a(this.few, R.drawable.icon_pure_ba_show_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.fey.setVisibility(8);
            this.fez.setVisibility(0);
            if (this.eXg == null || !this.eXg.eXL) {
                i = R.color.cp_cont_j;
            }
            SvgManager.ajv().a(this.few, R.drawable.icon_pure_ba_hide_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.feE != null) {
            this.feE.bfJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.eAV.setVisibility(0);
            bhU();
        } else {
            this.eAV.setVisibility(8);
            this.fey.setVisibility(8);
            this.fez.setVisibility(8);
        }
        if (this.feE != null) {
            this.feE.bfJ();
        }
    }

    public boolean isShow() {
        return this.eAV.getVisibility() == 0;
    }

    public void n(LinkedList<VisitedForumData> linkedList) {
        if (this.feA != null && linkedList != null) {
            bhU();
            this.feA.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bhV() {
        if (this.fev != null) {
            this.fev.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.feA != null) {
            this.feA.notifyDataSetChanged();
            if (this.feA.getItemCount() > 0) {
                fm(true);
            } else {
                fm(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.feA != null) {
            this.feA.notifyItemRemoved(i);
            if (this.feA.getItemCount() == 0) {
                gn(false);
                fm(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXg = bVar;
        bhW();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bhW();
        }
    }

    private void bhW() {
        if (this.eXg != null && this.eXg.eXL) {
            am.j(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.e(this.fex, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.fex.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.mRootView, R.color.cp_bg_line_e);
            am.j(this.fex, R.color.cp_link_tip_a);
            this.fex.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bhU();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.feG.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.feF);
        MessageManager.getInstance().unRegisterListener(this.cUD);
        if (this.feC != null) {
            this.feC.onDestroy();
        }
    }

    public void a(a aVar) {
        this.feE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int feI;
        private int feJ;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.feI = i;
            this.feJ = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.feI;
                } else {
                    rect.top = this.feJ;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.feI;
            } else {
                rect.left = this.feJ;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bhX() {
        return this.eXg;
    }
}
