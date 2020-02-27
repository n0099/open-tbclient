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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes9.dex */
public class f {
    private View fGr;
    private com.baidu.tieba.enterForum.data.b fTn;
    private RecentlyVisitedForumModel gab;
    private ImageView gac;
    private TextView gad;
    private View gae;
    private com.baidu.tieba.enterForum.a.b gaf;
    private ViewEventCenter gag;
    private com.baidu.tieba.enterForum.home.e gah;
    private k gai;
    private a gaj;
    private RecyclerView mListView;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean fYV = true;
    private boolean fTA = false;
    private CustomMessageListener gak = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gai == null) {
                        f.this.gai = new k(new i());
                    }
                    f.this.gai.a(f.this.mListView, 1);
                } else if (f.this.gai != null) {
                    f.this.gai.kB();
                }
            }
        }
    };
    private CustomMessageListener dVp = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bxB();
            }
        }
    };
    private CustomMessageListener gal = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.gD(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bxD();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gab = recentlyVisitedForumModel;
        this.gag = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gah = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gak);
        MessageManager.getInstance().registerListener(this.dVp);
        initData();
        initView();
    }

    private void initData() {
        this.fYV = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.fGr = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gac = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bzH();
            }
        });
        this.gad = (TextView) this.mRootView.findViewById(R.id.done);
        this.gad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.hC(false);
            }
        });
        this.gae = this.mRootView.findViewById(R.id.gap);
        this.mListView = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gaf = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.mListView.setAdapter(this.gaf);
        this.mListView.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gai = new k(new i());
            this.gai.a(this.mListView, 1);
        }
        this.mListView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mListView.setItemAnimator(new DefaultItemAnimator());
        this.mListView.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gaf.a(new b.InterfaceC0494b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0494b
            public void a(b.a aVar) {
                if (!f.this.fTA && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aOe());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cy("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gaf.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.hC(true);
                return true;
            }
        });
        this.gaf.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gab != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gab.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cy("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gab.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void rS(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.gah != null) {
                    f.this.gah.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gal);
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
            BarImageView barImageView = aVar.fTG;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.dib;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.fTI;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bxB() {
        if (this.fTA) {
            hC(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        if (this.fTA != z && this.gaf != null) {
            this.fTA = z;
            if (this.fTA) {
                this.gad.setVisibility(0);
                this.gac.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gag != null) {
                    this.gag.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gad.setVisibility(8);
                this.gac.setVisibility(0);
                if (this.gag != null) {
                    this.gag.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gaf.hC(this.fTA);
        }
    }

    public boolean bzG() {
        return this.fTA;
    }

    public void bzH() {
        this.fYV = !this.fYV;
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_recently_visited_forum_extend_state", this.fYV);
        if (this.fYV) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bzJ();
    }

    public boolean bzI() {
        return this.fYV;
    }

    private void bzJ() {
        int i = R.color.white_alpha100;
        if (this.fYV) {
            this.mListView.setVisibility(0);
            this.gae.setVisibility(8);
            if (this.fTn == null || !this.fTn.fTR) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGA().a(this.gac, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.mListView.setVisibility(8);
            this.gae.setVisibility(0);
            if (this.fTn == null || !this.fTn.fTR) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGA().a(this.gac, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gaj != null) {
            this.gaj.bxD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.fGr.setVisibility(0);
            bzJ();
        } else {
            this.fGr.setVisibility(8);
            this.mListView.setVisibility(8);
            this.gae.setVisibility(8);
        }
        if (this.gaj != null) {
            this.gaj.bxD();
        }
    }

    public boolean isShow() {
        return this.fGr.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gaf != null && linkedList != null) {
            bzJ();
            this.gaf.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bzK() {
        if (this.gab != null) {
            this.gab.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gaf != null) {
            this.gaf.notifyDataSetChanged();
            if (this.gaf.getItemCount() > 0) {
                gD(true);
            } else {
                gD(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gaf != null) {
            this.gaf.notifyItemRemoved(i);
            if (this.gaf.getItemCount() == 0) {
                hC(false);
                gD(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTn = bVar;
        bzL();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bzL();
        }
    }

    private void bzL() {
        if (this.fTn != null && this.fTn.fTR) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gad, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gad.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gad, (int) R.color.cp_link_tip_a);
            this.gad.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bzJ();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gal.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gak);
        MessageManager.getInstance().unRegisterListener(this.dVp);
        if (this.gah != null) {
            this.gah.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gaj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gan;
        private int gao;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gan = i;
            this.gao = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gan;
                } else {
                    rect.top = this.gao;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gan;
            } else {
                rect.left = this.gao;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bzM() {
        return this.fTn;
    }
}
