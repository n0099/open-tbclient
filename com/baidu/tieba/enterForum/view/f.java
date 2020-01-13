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
/* loaded from: classes7.dex */
public class f {
    private View fDU;
    private com.baidu.tieba.enterForum.data.b fQS;
    private RecentlyVisitedForumModel fYb;
    private ImageView fYc;
    private TextView fYd;
    private View fYe;
    private com.baidu.tieba.enterForum.a.b fYf;
    private ViewEventCenter fYg;
    private com.baidu.tieba.enterForum.home.e fYh;
    private k fYi;
    private a fYj;
    private RecyclerView mListView;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean fWU = true;
    private boolean fRf = false;
    private CustomMessageListener fYk = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.fYi == null) {
                        f.this.fYi = new k(new i());
                    }
                    f.this.fYi.a(f.this.mListView, 1);
                } else if (f.this.fYi != null) {
                    f.this.fYi.km();
                }
            }
        }
    };
    private CustomMessageListener dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bvX();
            }
        }
    };
    private CustomMessageListener fYl = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.gw(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void bvZ();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fYb = recentlyVisitedForumModel;
        this.fYg = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.fYh = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.fYk);
        MessageManager.getInstance().registerListener(this.dRk);
        initData();
        initView();
    }

    private void initData() {
        this.fWU = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.fDU = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.fYc = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.fYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.byf();
            }
        });
        this.fYd = (TextView) this.mRootView.findViewById(R.id.done);
        this.fYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.hv(false);
            }
        });
        this.fYe = this.mRootView.findViewById(R.id.gap);
        this.mListView = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.fYf = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.mListView.setAdapter(this.fYf);
        this.mListView.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fYi = new k(new i());
            this.fYi.a(this.mListView, 1);
        }
        this.mListView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mListView.setItemAnimator(new DefaultItemAnimator());
        this.mListView.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.fYf.a(new b.InterfaceC0486b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0486b
            public void a(b.a aVar) {
                if (!f.this.fRf && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.aLI());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").cp("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fYf.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.hv(true);
                return true;
            }
        });
        this.fYf.u(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fYb != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fYb.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").cp("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fYb.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void rL(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.fYh != null) {
                    f.this.fYh.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.fYl);
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
            BarImageView barImageView = aVar.fRl;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.ddX;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.fRn;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bvX() {
        if (this.fRf) {
            hv(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(boolean z) {
        if (this.fRf != z && this.fYf != null) {
            this.fRf = z;
            if (this.fRf) {
                this.fYd.setVisibility(0);
                this.fYc.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.fYg != null) {
                    this.fYg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.fYd.setVisibility(8);
                this.fYc.setVisibility(0);
                if (this.fYg != null) {
                    this.fYg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.fYf.hv(this.fRf);
        }
    }

    public boolean bye() {
        return this.fRf;
    }

    public void byf() {
        this.fWU = !this.fWU;
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_recently_visited_forum_extend_state", this.fWU);
        if (this.fWU) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        byh();
    }

    public boolean byg() {
        return this.fWU;
    }

    private void byh() {
        int i = R.color.white_alpha100;
        if (this.fWU) {
            this.mListView.setVisibility(0);
            this.fYe.setVisibility(8);
            if (this.fQS == null || !this.fQS.fRw) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aEp().a(this.fYc, R.drawable.icon_pure_ba_show24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.mListView.setVisibility(8);
            this.fYe.setVisibility(0);
            if (this.fQS == null || !this.fQS.fRw) {
                i = R.color.cp_cont_j;
            }
            SvgManager.aEp().a(this.fYc, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fYj != null) {
            this.fYj.bvZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.fDU.setVisibility(0);
            byh();
        } else {
            this.fDU.setVisibility(8);
            this.mListView.setVisibility(8);
            this.fYe.setVisibility(8);
        }
        if (this.fYj != null) {
            this.fYj.bvZ();
        }
    }

    public boolean isShow() {
        return this.fDU.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.fYf != null && linkedList != null) {
            byh();
            this.fYf.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void byi() {
        if (this.fYb != null) {
            this.fYb.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fYf != null) {
            this.fYf.notifyDataSetChanged();
            if (this.fYf.getItemCount() > 0) {
                gw(true);
            } else {
                gw(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.fYf != null) {
            this.fYf.notifyItemRemoved(i);
            if (this.fYf.getItemCount() == 0) {
                hv(false);
                gw(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fQS = bVar;
        byj();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            byj();
        }
    }

    private void byj() {
        if (this.fQS != null && this.fQS.fRw) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.a((View) this.fYd, (int) R.color.cp_bg_line_d, (int) R.color.cp_bg_line_d_alpha50, 0);
            this.fYd.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fYd, (int) R.color.cp_link_tip_a);
            this.fYd.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        byh();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fYl.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fYk);
        MessageManager.getInstance().unRegisterListener(this.dRk);
        if (this.fYh != null) {
            this.fYh.onDestroy();
        }
    }

    public void a(a aVar) {
        this.fYj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int fYn;
        private int fYo;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.fYn = i;
            this.fYo = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.fYn;
                } else {
                    rect.top = this.fYo;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.fYn;
            } else {
                rect.left = this.fYo;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b byk() {
        return this.fQS;
    }
}
