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
/* loaded from: classes4.dex */
public class f {
    private Vibrator bqL;
    private View eIM;
    private com.baidu.tieba.enterForum.data.b eZb;
    private RecentlyVisitedForumModel fgo;
    private ImageView fgp;
    private TextView fgq;
    private RecyclerView fgr;
    private View fgs;
    private com.baidu.tieba.enterForum.a.b fgt;
    private ViewEventCenter fgu;
    private com.baidu.tieba.enterForum.home.e fgv;
    private k fgw;
    private a fgx;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean ffh = true;
    private boolean eZo = false;
    private CustomMessageListener fgy = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.fgw == null) {
                        f.this.fgw = new k(new i());
                    }
                    f.this.fgw.a(f.this.fgr, 1);
                } else if (f.this.fgw != null) {
                    f.this.fgw.jU();
                }
            }
        }
    };
    private CustomMessageListener ddg = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bdz();
            }
        }
    };
    private CustomMessageListener fgz = new CustomMessageListener(2921347) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.fg(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void bdB();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.fgo = recentlyVisitedForumModel;
        this.fgu = viewEventCenter;
        this.bqL = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.fgv = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.fgy);
        MessageManager.getInstance().registerListener(this.ddg);
        initData();
        initView();
    }

    private void initData() {
        this.ffh = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.eIM = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.fgp = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.fgp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bfI();
            }
        });
        this.fgq = (TextView) this.mRootView.findViewById(R.id.done);
        this.fgq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gc(false);
            }
        });
        this.fgs = this.mRootView.findViewById(R.id.gap);
        this.fgr = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.fgt = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.fgr.setAdapter(this.fgt);
        this.fgr.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fgw = new k(new i());
            this.fgw.a(this.fgr, 1);
        }
        this.fgr.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.fgr.setItemAnimator(new DefaultItemAnimator());
        this.fgr.addItemDecoration(new b(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds35), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds1), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.fgt.a(new b.InterfaceC0394b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0394b
            public void a(b.a aVar) {
                if (!f.this.eZo && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.atK());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new an("c13002").bS("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fgt.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.gc(true);
                return true;
            }
        });
        this.fgt.t(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fgo != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.fgo.d(visitedForumData);
                    TiebaStatic.log(new an("c13005").bS("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.fgo.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void pA(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.fgv != null) {
                    f.this.fgv.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.fgz);
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
            BarImageView barImageView = aVar.eZu;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.cqt;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.eZw;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            intent.putExtra("info_forum_head_background_vector", aVar.eZy.getUrl());
        }
    }

    public boolean bdz() {
        if (this.eZo) {
            gc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(boolean z) {
        if (this.eZo != z && this.fgt != null) {
            this.eZo = z;
            if (this.eZo) {
                this.fgq.setVisibility(0);
                this.fgp.setVisibility(8);
                if (this.bqL != null) {
                    this.bqL.vibrate(10L);
                }
                if (this.fgu != null) {
                    this.fgu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.fgq.setVisibility(8);
                this.fgp.setVisibility(0);
                if (this.fgu != null) {
                    this.fgu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.fgt.gc(this.eZo);
        }
    }

    public boolean bfH() {
        return this.eZo;
    }

    public void bfI() {
        this.ffh = !this.ffh;
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_recently_visited_forum_extend_state", this.ffh);
        if (this.ffh) {
            TiebaStatic.log(new an("c13003"));
        } else {
            TiebaStatic.log(new an("c13004"));
        }
        bfK();
    }

    public boolean bfJ() {
        return this.ffh;
    }

    private void bfK() {
        int i = R.color.white_alpha100;
        if (this.ffh) {
            this.fgr.setVisibility(0);
            this.fgs.setVisibility(8);
            if (this.eZb == null || !this.eZb.eZG) {
                i = R.color.cp_cont_j;
            }
            SvgManager.amL().a(this.fgp, R.drawable.icon_pure_ba_show_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.fgr.setVisibility(8);
            this.fgs.setVisibility(0);
            if (this.eZb == null || !this.eZb.eZG) {
                i = R.color.cp_cont_j;
            }
            SvgManager.amL().a(this.fgp, R.drawable.icon_pure_ba_hide_n_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.fgx != null) {
            this.fgx.bdB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.eIM.setVisibility(0);
            bfK();
        } else {
            this.eIM.setVisibility(8);
            this.fgr.setVisibility(8);
            this.fgs.setVisibility(8);
        }
        if (this.fgx != null) {
            this.fgx.bdB();
        }
    }

    public boolean isShow() {
        return this.eIM.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.fgt != null && linkedList != null) {
            bfK();
            this.fgt.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bfL() {
        if (this.fgo != null) {
            this.fgo.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fgt != null) {
            this.fgt.notifyDataSetChanged();
            if (this.fgt.getItemCount() > 0) {
                fg(true);
            } else {
                fg(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.fgt != null) {
            this.fgt.notifyItemRemoved(i);
            if (this.fgt.getItemCount() == 0) {
                gc(false);
                fg(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZb = bVar;
        bfM();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bfM();
        }
    }

    private void bfM() {
        if (this.eZb != null && this.eZb.eZG) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            am.c(this.fgq, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.fgq.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fgq, (int) R.color.cp_link_tip_a);
            this.fgq.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bfK();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fgz.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fgy);
        MessageManager.getInstance().unRegisterListener(this.ddg);
        if (this.fgv != null) {
            this.fgv.onDestroy();
        }
    }

    public void a(a aVar) {
        this.fgx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int fgB;
        private int fgC;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.fgB = i;
            this.fgC = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.fgB;
                } else {
                    rect.top = this.fgC;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.fgB;
            } else {
                rect.left = this.fgC;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.b bfN() {
        return this.eZb;
    }
}
