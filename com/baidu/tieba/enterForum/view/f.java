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
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tieba.enterForum.a.c;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class f {
    private View gBd;
    private com.baidu.tieba.enterForum.data.d gNU;
    private RecentlyVisitedForumModel gYi;
    private ImageView gYj;
    private TextView gYk;
    private RecyclerView gYl;
    private View gYm;
    private com.baidu.tieba.enterForum.a.c gYn;
    private ViewEventCenter gYo;
    private com.baidu.tieba.enterForum.home.e gYp;
    private m gYq;
    private a gYr;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean gXd = true;
    private boolean gOo = false;
    private CustomMessageListener gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.gYq == null) {
                        f.this.gYq = new m(new k());
                    }
                    f.this.gYq.a(f.this.gYl, 1);
                } else if (f.this.gYq != null) {
                    f.this.gYq.pl();
                }
            }
        }
    };
    private CustomMessageListener eKK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bNP();
            }
        }
    };
    private CustomMessageListener gYt = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.hY(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bNR();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.gYi = recentlyVisitedForumModel;
        this.gYo = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.gYp = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.gYs);
        MessageManager.getInstance().registerListener(this.eKK);
        initData();
        initView();
    }

    private void initData() {
        this.gXd = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.gBd = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.gYj = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.gYj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bQC();
            }
        });
        this.gYk = (TextView) this.mRootView.findViewById(R.id.done);
        this.gYk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.iY(false);
            }
        });
        this.gYm = this.mRootView.findViewById(R.id.gap);
        this.gYl = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.gYn = new com.baidu.tieba.enterForum.a.c(this.mPageContext);
        this.gYl.setAdapter(this.gYn);
        this.gYl.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYq = new m(new k());
            this.gYq.a(this.gYl, 1);
        }
        this.gYl.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.gYl.setItemAnimator(new DefaultItemAnimator());
        this.gYl.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.gYn.a(new c.b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.c.b
            public void a(c.a aVar) {
                if (!f.this.gOo && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bcK());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").dh("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gYn.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.iY(true);
                return true;
            }
        });
        this.gYn.u(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gYi != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.gYi.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").dh("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.gYi.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void sT(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.gYp != null) {
                    f.this.gYp.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.gYt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar, Intent intent, boolean z) {
        if (aVar != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = aVar.gOu;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.dWR;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.gOw;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bNP() {
        if (this.gOo) {
            iY(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(boolean z) {
        if (this.gOo != z && this.gYn != null) {
            this.gOo = z;
            if (this.gOo) {
                this.gYk.setVisibility(0);
                this.gYj.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.gYo != null) {
                    this.gYo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.gYk.setVisibility(8);
                this.gYj.setVisibility(0);
                if (this.gYo != null) {
                    this.gYo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.gYn.iY(this.gOo);
        }
    }

    public boolean bQB() {
        return this.gOo;
    }

    public void bQC() {
        this.gXd = !this.gXd;
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_recently_visited_forum_extend_state", this.gXd);
        if (this.gXd) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bQE();
    }

    public boolean bQD() {
        return this.gXd;
    }

    private void bQE() {
        int i = R.color.white_alpha100;
        if (this.gXd) {
            this.gYl.setVisibility(0);
            this.gYm.setVisibility(8);
            if (this.gNU == null || !this.gNU.gOF) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aUW().a(this.gYj, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.gYl.setVisibility(8);
            this.gYm.setVisibility(0);
            if (this.gNU == null || !this.gNU.gOF) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aUW().a(this.gYj, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.gYr != null) {
            this.gYr.bNR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.gBd.setVisibility(0);
            bQE();
        } else {
            this.gBd.setVisibility(8);
            this.gYl.setVisibility(8);
            this.gYm.setVisibility(8);
        }
        if (this.gYr != null) {
            this.gYr.bNR();
        }
    }

    public boolean isShow() {
        return this.gBd.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.gYn != null && linkedList != null) {
            bQE();
            this.gYn.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bQF() {
        if (this.gYi != null) {
            this.gYi.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gYn != null) {
            this.gYn.notifyDataSetChanged();
            if (this.gYn.getItemCount() > 0) {
                hY(true);
            } else {
                hY(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.gYn != null) {
            this.gYn.notifyItemRemoved(i);
            if (this.gYn.getItemCount() == 0) {
                iY(false);
                hY(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNU = dVar;
        bQG();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bQG();
        }
    }

    private void bQG() {
        if (this.gNU != null && this.gNU.gOF) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.gYk, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.gYk.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gYk, (int) R.color.cp_link_tip_a);
            this.gYk.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bQE();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gYt.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYs);
        MessageManager.getInstance().unRegisterListener(this.eKK);
        if (this.gYp != null) {
            this.gYp.onDestroy();
        }
    }

    public void a(a aVar) {
        this.gYr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int gYv;
        private int gYw;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.gYv = i;
            this.gYw = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gYv;
                } else {
                    rect.top = this.gYw;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gYv;
            } else {
                rect.left = this.gYw;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.d bQH() {
        return this.gNU;
    }
}
