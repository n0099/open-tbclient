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
    private Vibrator dPV;
    private com.baidu.tieba.enterForum.data.c iFO;
    private RecentlyVisitedForumModel iPW;
    private ImageView iPX;
    private TextView iPY;
    private RecyclerView iPZ;
    private View iQa;
    private RecentlyVisitedForumListAdapter iQb;
    private ViewEventCenter iQc;
    private com.baidu.tieba.enterForum.home.e iQd;
    private l iQe;
    private a iQf;
    private View isz;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean iON = true;
    private boolean iFZ = false;
    private CustomMessageListener iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iQe == null) {
                        f.this.iQe = new l(new j());
                    }
                    f.this.iQe.a(f.this.iPZ, 1);
                } else if (f.this.iQe != null) {
                    f.this.iQe.qL();
                }
            }
        }
    };
    private CustomMessageListener iQh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cxy();
            }
        }
    };
    private CustomMessageListener iQi = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.kQ(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cxA();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iPW = recentlyVisitedForumModel;
        this.iQc = viewEventCenter;
        this.dPV = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iQd = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iQg);
        MessageManager.getInstance().registerListener(this.iQh);
        initData();
        initView();
    }

    private void initData() {
        this.iON = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.isz = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iPX = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iPX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cAt();
            }
        });
        this.iPY = (TextView) this.mRootView.findViewById(R.id.done);
        this.iPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.mc(false);
            }
        });
        this.iQa = this.mRootView.findViewById(R.id.gap);
        this.iPZ = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iQb = new RecentlyVisitedForumListAdapter(this.mPageContext);
        this.iPZ.setAdapter(this.iQb);
        this.iPZ.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iQe = new l(new j());
            this.iQe.a(this.iPZ, 1);
        }
        this.iPZ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iPZ.setItemAnimator(new DefaultItemAnimator());
        this.iPZ.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iQb.a(new RecentlyVisitedForumListAdapter.a() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
            public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
                if (!f.this.iFZ && forumViewHolder != null && forumViewHolder.itemView != null && (forumViewHolder.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(forumViewHolder, callFrom.getIntent(), visitedForumData.bEq());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dX("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iQb.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.mc(true);
                return true;
            }
        });
        this.iQb.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iPW != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iPW.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dX("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iPW.a(new a.InterfaceC0721a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0721a
            public void yX(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0721a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0721a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iQd != null) {
                    f.this.iQd.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iQi);
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
            BarImageView barImageView = forumViewHolder.iGf;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.fni;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.iGh;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cxy() {
        if (this.iFZ) {
            mc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (this.iFZ != z && this.iQb != null) {
            this.iFZ = z;
            if (this.iFZ) {
                this.iPY.setVisibility(0);
                this.iPX.setVisibility(8);
                if (this.dPV != null) {
                    this.dPV.vibrate(10L);
                }
                if (this.iQc != null) {
                    this.iQc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iPY.setVisibility(8);
                this.iPX.setVisibility(0);
                if (this.iQc != null) {
                    this.iQc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iQb.mc(this.iFZ);
        }
    }

    public boolean cAs() {
        return this.iFZ;
    }

    public void cAt() {
        this.iON = !this.iON;
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_recently_visited_forum_extend_state", this.iON);
        if (this.iON) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        cAv();
    }

    public boolean cAu() {
        return this.iON;
    }

    private void cAv() {
        int i;
        int i2;
        if (this.iON) {
            this.iPZ.setVisibility(0);
            this.iQa.setVisibility(8);
            if (this.iFO != null && this.iFO.iGq) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bwr().a(this.iPX, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iPZ.setVisibility(8);
            this.iQa.setVisibility(0);
            if (this.iFO != null && this.iFO.iGq) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bwr().a(this.iPX, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iQf != null) {
            this.iQf.cxA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.isz.setVisibility(0);
            cAv();
        } else {
            this.isz.setVisibility(8);
            this.iPZ.setVisibility(8);
            this.iQa.setVisibility(8);
        }
        if (this.iQf != null) {
            this.iQf.cxA();
        }
    }

    public boolean isShow() {
        return this.isz.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iQb != null && linkedList != null) {
            cAv();
            this.iQb.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cAw() {
        if (this.iPW != null) {
            this.iPW.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iQb != null) {
            this.iQb.notifyDataSetChanged();
            if (this.iQb.getItemCount() > 0) {
                kQ(true);
            } else {
                kQ(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iQb != null) {
            this.iQb.notifyItemRemoved(i);
            if (this.iQb.getItemCount() == 0) {
                mc(false);
                kQ(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iFO = cVar;
        cAx();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cAx();
        }
    }

    private void cAx() {
        if (this.iFO != null && this.iFO.iGq) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ao.a((View) this.iPY, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iPY.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ao.setViewTextColor(this.iPY, R.color.CAM_X0302);
            this.iPY.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cAv();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iQi.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iQg);
        MessageManager.getInstance().unRegisterListener(this.iQh);
        if (this.iQd != null) {
            this.iQd.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iQf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Yk;
        private int Yl;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Yk = i;
            this.Yl = i2;
            this.mEnd = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Yk;
                } else {
                    rect.top = this.Yl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Yk;
            } else {
                rect.left = this.Yl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cAy() {
        return this.iFO;
    }
}
