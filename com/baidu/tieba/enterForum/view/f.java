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
    private View fGG;
    private com.baidu.tieba.enterForum.data.b fTC;
    private RecentlyVisitedForumModel gaq;
    private ImageView gar;
    private TextView gas;
    private View gat;
    private com.baidu.tieba.enterForum.a.b gau;
    private ViewEventCenter gav;
    private com.baidu.tieba.enterForum.home.e gaw;
    private k gax;
    private a gay;
    private RecyclerView mListView;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean fZk = true;
    private boolean fTP = false;
    private CustomMessageListener gaz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gax == null) {
                        f.this.gax = new k(new i());
                    }
                    f.this.gax.a(f.this.mListView, 1);
                } else if (f.this.gax != null) {
                    f.this.gax.kB();
                }
            }
        }
    };
    private CustomMessageListener dVD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bxE();
            }
        }
    };
    private CustomMessageListener gaA = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
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
        void bxG();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gaq = recentlyVisitedForumModel;
        this.gav = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gaw = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gaz);
        MessageManager.getInstance().registerListener(this.dVD);
        initData();
        initView();
    }

    private void initData() {
        this.fZk = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.fGG = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gar = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bzK();
            }
        });
        this.gas = (TextView) this.mRootView.findViewById(R.id.done);
        this.gas.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.hC(false);
            }
        });
        this.gat = this.mRootView.findViewById(R.id.gap);
        this.mListView = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gau = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.mListView.setAdapter(this.gau);
        this.mListView.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gax = new k(new i());
            this.gax.a(this.mListView, 1);
        }
        this.mListView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mListView.setItemAnimator(new DefaultItemAnimator());
        this.mListView.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gau.a(new b.InterfaceC0494b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0494b
            public void a(b.a aVar) {
                if (!f.this.fTP && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aOh());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cy("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gau.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.hC(true);
                return true;
            }
        });
        this.gau.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gaq != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gaq.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cy("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gaq.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
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
                if (!z && f.this.gaw != null) {
                    f.this.gaw.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gaA);
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
            BarImageView barImageView = aVar.fTV;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.diq;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.fTX;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bxE() {
        if (this.fTP) {
            hC(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        if (this.fTP != z && this.gau != null) {
            this.fTP = z;
            if (this.fTP) {
                this.gas.setVisibility(0);
                this.gar.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gav != null) {
                    this.gav.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gas.setVisibility(8);
                this.gar.setVisibility(0);
                if (this.gav != null) {
                    this.gav.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gau.hC(this.fTP);
        }
    }

    public boolean bzJ() {
        return this.fTP;
    }

    public void bzK() {
        this.fZk = !this.fZk;
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_recently_visited_forum_extend_state", this.fZk);
        if (this.fZk) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bzM();
    }

    public boolean bzL() {
        return this.fZk;
    }

    private void bzM() {
        int i = R.color.white_alpha100;
        if (this.fZk) {
            this.mListView.setVisibility(0);
            this.gat.setVisibility(8);
            if (this.fTC == null || !this.fTC.fUg) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGC().a(this.gar, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.mListView.setVisibility(8);
            this.gat.setVisibility(0);
            if (this.fTC == null || !this.fTC.fUg) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aGC().a(this.gar, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gay != null) {
            this.gay.bxG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.fGG.setVisibility(0);
            bzM();
        } else {
            this.fGG.setVisibility(8);
            this.mListView.setVisibility(8);
            this.gat.setVisibility(8);
        }
        if (this.gay != null) {
            this.gay.bxG();
        }
    }

    public boolean isShow() {
        return this.fGG.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gau != null && linkedList != null) {
            bzM();
            this.gau.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bzN() {
        if (this.gaq != null) {
            this.gaq.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gau != null) {
            this.gau.notifyDataSetChanged();
            if (this.gau.getItemCount() > 0) {
                gD(true);
            } else {
                gD(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gau != null) {
            this.gau.notifyItemRemoved(i);
            if (this.gau.getItemCount() == 0) {
                hC(false);
                gD(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTC = bVar;
        bzO();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bzO();
        }
    }

    private void bzO() {
        if (this.fTC != null && this.fTC.fUg) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gas, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gas.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gas, (int) R.color.cp_link_tip_a);
            this.gas.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bzM();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gaA.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gaz);
        MessageManager.getInstance().unRegisterListener(this.dVD);
        if (this.gaw != null) {
            this.gaw.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gay = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gaC;
        private int gaD;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gaC = i;
            this.gaD = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gaC;
                } else {
                    rect.top = this.gaD;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gaC;
            } else {
                rect.left = this.gaD;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bzP() {
        return this.fTC;
    }
}
