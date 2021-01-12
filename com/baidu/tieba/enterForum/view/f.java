package com.baidu.tieba.enterForum.view;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter;
import com.baidu.tieba.enterForum.b.a;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class f {
    private Vibrator dLj;
    private com.baidu.tieba.enterForum.data.c iBh;
    private RecentlyVisitedForumModel iLp;
    private ImageView iLq;
    private TextView iLr;
    private RecyclerView iLs;
    private View iLt;
    private RecentlyVisitedForumListAdapter iLu;
    private ViewEventCenter iLv;
    private com.baidu.tieba.enterForum.home.e iLw;
    private l iLx;
    private a iLy;
    private View inS;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean iKg = true;
    private boolean iBs = false;
    private CustomMessageListener iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iLx == null) {
                        f.this.iLx = new l(new j());
                    }
                    f.this.iLx.a(f.this.iLs, 1);
                } else if (f.this.iLx != null) {
                    f.this.iLx.qL();
                }
            }
        }
    };
    private CustomMessageListener iLA = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.ctG();
            }
        }
    };
    private CustomMessageListener iLB = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.kM(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void ctI();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iLp = recentlyVisitedForumModel;
        this.iLv = viewEventCenter;
        this.dLj = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iLw = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iLz);
        MessageManager.getInstance().registerListener(this.iLA);
        initData();
        initView();
    }

    private void initData() {
        this.iKg = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.inS = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iLq = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cwB();
            }
        });
        this.iLr = (TextView) this.mRootView.findViewById(R.id.done);
        this.iLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.lY(false);
            }
        });
        this.iLt = this.mRootView.findViewById(R.id.gap);
        this.iLs = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iLu = new RecentlyVisitedForumListAdapter(this.mPageContext);
        this.iLs.setAdapter(this.iLu);
        this.iLs.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iLx = new l(new j());
            this.iLx.a(this.iLs, 1);
        }
        this.iLs.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iLs.setItemAnimator(new DefaultItemAnimator());
        this.iLs.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iLu.a(new RecentlyVisitedForumListAdapter.a() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
            public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
                if (!f.this.iBs && forumViewHolder != null && forumViewHolder.itemView != null && (forumViewHolder.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(forumViewHolder, callFrom.getIntent(), visitedForumData.bAw());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dW("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iLu.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.lY(true);
                return true;
            }
        });
        this.iLu.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iLp != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iLp.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dW("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iLp.a(new a.InterfaceC0704a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void xr(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iLw != null) {
                    f.this.iLw.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iLB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder, Intent intent, boolean z) {
        if (forumViewHolder != null && intent != null) {
            if (!z || !TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                intent.putExtra("transition_type", 0);
                return;
            }
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = forumViewHolder.iBy;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.fiz;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.iBA;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean ctG() {
        if (this.iBs) {
            lY(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (this.iBs != z && this.iLu != null) {
            this.iBs = z;
            if (this.iBs) {
                this.iLr.setVisibility(0);
                this.iLq.setVisibility(8);
                if (this.dLj != null) {
                    this.dLj.vibrate(10L);
                }
                if (this.iLv != null) {
                    this.iLv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iLr.setVisibility(8);
                this.iLq.setVisibility(0);
                if (this.iLv != null) {
                    this.iLv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iLu.lY(this.iBs);
        }
    }

    public boolean cwA() {
        return this.iBs;
    }

    public void cwB() {
        this.iKg = !this.iKg;
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_recently_visited_forum_extend_state", this.iKg);
        if (this.iKg) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        cwD();
    }

    public boolean cwC() {
        return this.iKg;
    }

    private void cwD() {
        int i;
        int i2;
        if (this.iKg) {
            this.iLs.setVisibility(0);
            this.iLt.setVisibility(8);
            if (this.iBh != null && this.iBh.iBJ) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bsx().a(this.iLq, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iLs.setVisibility(8);
            this.iLt.setVisibility(0);
            if (this.iBh != null && this.iBh.iBJ) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bsx().a(this.iLq, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iLy != null) {
            this.iLy.ctI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.inS.setVisibility(0);
            cwD();
        } else {
            this.inS.setVisibility(8);
            this.iLs.setVisibility(8);
            this.iLt.setVisibility(8);
        }
        if (this.iLy != null) {
            this.iLy.ctI();
        }
    }

    public boolean isShow() {
        return this.inS.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iLu != null && linkedList != null) {
            cwD();
            this.iLu.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cwE() {
        if (this.iLp != null) {
            this.iLp.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iLu != null) {
            this.iLu.notifyDataSetChanged();
            if (this.iLu.getItemCount() > 0) {
                kM(true);
            } else {
                kM(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iLu != null) {
            this.iLu.notifyItemRemoved(i);
            if (this.iLu.getItemCount() == 0) {
                lY(false);
                kM(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iBh = cVar;
        cwF();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cwF();
        }
    }

    private void cwF() {
        if (this.iBh != null && this.iBh.iBJ) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ao.a((View) this.iLr, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iLr.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ao.setViewTextColor(this.iLr, R.color.CAM_X0302);
            this.iLr.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cwD();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iLB.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iLz);
        MessageManager.getInstance().unRegisterListener(this.iLA);
        if (this.iLw != null) {
            this.iLw.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iLy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Yi;
        private int Yj;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Yi = i;
            this.Yj = i2;
            this.mEnd = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Yi;
                } else {
                    rect.top = this.Yj;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Yi;
            } else {
                rect.left = this.Yj;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cwG() {
        return this.iBh;
    }
}
