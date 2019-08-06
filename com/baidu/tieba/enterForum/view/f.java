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
    private Vibrator aYc;
    private com.baidu.tieba.enterForum.data.b eVA;
    private View ezm;
    private RecentlyVisitedForumModel fcI;
    private ImageView fcJ;
    private TextView fcK;
    private RecyclerView fcL;
    private View fcM;
    private com.baidu.tieba.enterForum.a.b fcN;
    private ViewEventCenter fcO;
    private com.baidu.tieba.enterForum.home.e fcP;
    private k fcQ;
    private a fcR;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean fbH = true;
    private boolean eVN = false;
    private CustomMessageListener fcS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.fcQ == null) {
                        f.this.fcQ = new k(new i());
                    }
                    f.this.fcQ.a(f.this.fcL, 1);
                } else if (f.this.fcQ != null) {
                    f.this.fcQ.ow();
                }
            }
        }
    };
    private CustomMessageListener cTK = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bfd();
            }
        }
    };
    private CustomMessageListener fcT = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.fj(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bff();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fcI = recentlyVisitedForumModel;
        this.fcO = viewEventCenter;
        this.aYc = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.fcP = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.fcS);
        MessageManager.getInstance().registerListener(this.cTK);
        initData();
        initView();
    }

    private void initData() {
        this.fbH = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.ezm = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.fcJ = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.fcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bhh();
            }
        });
        this.fcK = (TextView) this.mRootView.findViewById(R.id.done);
        this.fcK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gk(false);
            }
        });
        this.fcM = this.mRootView.findViewById(R.id.gap);
        this.fcL = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.fcN = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.fcL.setAdapter(this.fcN);
        this.fcL.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcQ = new k(new i());
            this.fcQ.a(this.fcL, 1);
        }
        this.fcL.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.fcL.setItemAnimator(new DefaultItemAnimator());
        this.fcL.addItemDecoration(new b(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.g(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.fcN.a(new b.InterfaceC0301b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0301b
            public void a(b.a aVar) {
                if (!f.this.eVN && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.arM());
                    f.this.mPageContext.sendMessage(new CustomMessage(2003000, callFrom));
                    TiebaStatic.log(new an("c13002").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fcN.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gk(true);
                return true;
            }
        });
        this.fcN.r(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fcI != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fcI.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").bT("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fcI.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void qC(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.n(linkedList);
                if (!z && f.this.fcP != null) {
                    f.this.fcP.d(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.fcT);
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
            BarImageView barImageView = aVar.eVT;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.ccd;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eVV;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eVX.getUrl());
        }
    }

    public boolean bfd() {
        if (this.eVN) {
            gk(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(boolean z) {
        if (this.eVN != z && this.fcN != null) {
            this.eVN = z;
            if (this.eVN) {
                this.fcK.setVisibility(0);
                this.fcJ.setVisibility(8);
                if (this.aYc != null) {
                    this.aYc.vibrate(10L);
                }
                if (this.fcO != null) {
                    this.fcO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
            } else {
                this.fcK.setVisibility(8);
                this.fcJ.setVisibility(0);
                if (this.fcO != null) {
                    this.fcO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.fcN.gk(this.eVN);
        }
    }

    public boolean bhg() {
        return this.eVN;
    }

    public void bhh() {
        this.fbH = !this.fbH;
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_recently_visited_forum_extend_state", this.fbH);
        if (this.fbH) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bhj();
    }

    public boolean bhi() {
        return this.fbH;
    }

    private void bhj() {
        if (this.fbH) {
            this.fcL.setVisibility(0);
            this.fcM.setVisibility(8);
            if (this.eVA != null && this.eVA.eWf) {
                am.c(this.fcJ, (int) R.drawable.icon_ba_show_white);
            } else {
                am.c(this.fcJ, (int) R.drawable.icon_ba_show_black);
            }
        } else {
            this.fcL.setVisibility(8);
            this.fcM.setVisibility(0);
            if (this.eVA != null && this.eVA.eWf) {
                am.c(this.fcJ, (int) R.drawable.icon_ba_hide_white);
            } else {
                am.c(this.fcJ, (int) R.drawable.icon_ba_hide_black);
            }
        }
        if (this.fcR != null) {
            this.fcR.bff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.ezm.setVisibility(0);
            bhj();
        } else {
            this.ezm.setVisibility(8);
            this.fcL.setVisibility(8);
            this.fcM.setVisibility(8);
        }
        if (this.fcR != null) {
            this.fcR.bff();
        }
    }

    public boolean isShow() {
        return this.ezm.getVisibility() == 0;
    }

    public void n(LinkedList<VisitedForumData> linkedList) {
        if (this.fcN != null && linkedList != null) {
            bhj();
            this.fcN.l(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bhk() {
        if (this.fcI != null) {
            this.fcI.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fcN != null) {
            this.fcN.notifyDataSetChanged();
            if (this.fcN.getItemCount() > 0) {
                fj(true);
            } else {
                fj(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.fcN != null) {
            this.fcN.notifyItemRemoved(i);
            if (this.fcN.getItemCount() == 0) {
                gk(false);
                fj(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVA = bVar;
        bhl();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bhl();
        }
    }

    private void bhl() {
        if (this.eVA != null && this.eVA.eWf) {
            am.j(this.mTitle, R.color.cp_btn_a);
            this.mRootView.setBackgroundColor(0);
            am.e(this.fcK, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.fcK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.mRootView, R.color.cp_bg_line_f);
            am.j(this.fcK, R.color.cp_link_tip_a);
            this.fcK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bhj();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fcT.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcS);
        MessageManager.getInstance().unRegisterListener(this.cTK);
        if (this.fcP != null) {
            this.fcP.onDestroy();
        }
    }

    public void a(a aVar) {
        this.fcR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int fcV;
        private int fcW;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.fcV = i;
            this.fcW = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.fcV;
                } else {
                    rect.top = this.fcW;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.fcV;
            } else {
                rect.left = this.fcW;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bhm() {
        return this.eVA;
    }
}
