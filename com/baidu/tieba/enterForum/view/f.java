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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private Vibrator dNn;
    private com.baidu.tieba.enterForum.data.c iHf;
    private RecentlyVisitedForumModel iRl;
    private ImageView iRm;
    private TextView iRn;
    private RecyclerView iRo;
    private View iRp;
    private RecentlyVisitedForumListAdapter iRq;
    private ViewEventCenter iRr;
    private com.baidu.tieba.enterForum.home.e iRs;
    private l iRt;
    private a iRu;
    private View itK;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean iQc = true;
    private boolean iHq = false;
    private CustomMessageListener iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iRt == null) {
                        f.this.iRt = new l(new j());
                    }
                    f.this.iRt.a(f.this.iRo, 1);
                } else if (f.this.iRt != null) {
                    f.this.iRt.qJ();
                }
            }
        }
    };
    private CustomMessageListener iRw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cuZ();
            }
        }
    };
    private CustomMessageListener iRx = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.kP(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cvb();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iRl = recentlyVisitedForumModel;
        this.iRr = viewEventCenter;
        this.dNn = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iRs = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iRv);
        MessageManager.getInstance().registerListener(this.iRw);
        initData();
        initView();
    }

    private void initData() {
        this.iQc = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.itK = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iRm = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iRm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cxU();
            }
        });
        this.iRn = (TextView) this.mRootView.findViewById(R.id.done);
        this.iRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.mc(false);
            }
        });
        this.iRp = this.mRootView.findViewById(R.id.gap);
        this.iRo = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iRq = new RecentlyVisitedForumListAdapter(this.mPageContext);
        this.iRo.setAdapter(this.iRq);
        this.iRo.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRt = new l(new j());
            this.iRt.a(this.iRo, 1);
        }
        this.iRo.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iRo.setItemAnimator(new DefaultItemAnimator());
        this.iRo.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iRq.a(new RecentlyVisitedForumListAdapter.a() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
            public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
                if (!f.this.iHq && forumViewHolder != null && forumViewHolder.itemView != null && (forumViewHolder.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(forumViewHolder, callFrom.getIntent(), visitedForumData.bAO());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iRq.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.mc(true);
                return true;
            }
        });
        this.iRq.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iRl != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iRl.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iRl.a(new a.InterfaceC0705a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0705a
            public void xB(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0705a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0705a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iRs != null) {
                    f.this.iRs.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iRx);
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
            BarImageView barImageView = forumViewHolder.iHw;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.fkQ;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.iHy;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cuZ() {
        if (this.iHq) {
            mc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (this.iHq != z && this.iRq != null) {
            this.iHq = z;
            if (this.iHq) {
                this.iRn.setVisibility(0);
                this.iRm.setVisibility(8);
                if (this.dNn != null) {
                    this.dNn.vibrate(10L);
                }
                if (this.iRr != null) {
                    this.iRr.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iRn.setVisibility(8);
                this.iRm.setVisibility(0);
                if (this.iRr != null) {
                    this.iRr.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iRq.mc(this.iHq);
        }
    }

    public boolean cxT() {
        return this.iHq;
    }

    public void cxU() {
        this.iQc = !this.iQc;
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_recently_visited_forum_extend_state", this.iQc);
        if (this.iQc) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        cxW();
    }

    public boolean cxV() {
        return this.iQc;
    }

    private void cxW() {
        int i;
        int i2;
        if (this.iQc) {
            this.iRo.setVisibility(0);
            this.iRp.setVisibility(8);
            if (this.iHf != null && this.iHf.iHH) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bsR().a(this.iRm, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iRo.setVisibility(8);
            this.iRp.setVisibility(0);
            if (this.iHf != null && this.iHf.iHH) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bsR().a(this.iRm, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iRu != null) {
            this.iRu.cvb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.itK.setVisibility(0);
            cxW();
        } else {
            this.itK.setVisibility(8);
            this.iRo.setVisibility(8);
            this.iRp.setVisibility(8);
        }
        if (this.iRu != null) {
            this.iRu.cvb();
        }
    }

    public boolean isShow() {
        return this.itK.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iRq != null && linkedList != null) {
            cxW();
            this.iRq.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cxX() {
        if (this.iRl != null) {
            this.iRl.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iRq != null) {
            this.iRq.notifyDataSetChanged();
            if (this.iRq.getItemCount() > 0) {
                kP(true);
            } else {
                kP(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iRq != null) {
            this.iRq.notifyItemRemoved(i);
            if (this.iRq.getItemCount() == 0) {
                mc(false);
                kP(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iHf = cVar;
        cxY();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cxY();
        }
    }

    private void cxY() {
        if (this.iHf != null && this.iHf.iHH) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.iRn, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iRn.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.iRn, R.color.CAM_X0302);
            this.iRn.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cxW();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iRx.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRv);
        MessageManager.getInstance().unRegisterListener(this.iRw);
        if (this.iRs != null) {
            this.iRs.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iRu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Ye;
        private int Yf;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Ye = i;
            this.Yf = i2;
            this.mEnd = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Ye;
                } else {
                    rect.top = this.Yf;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Ye;
            } else {
                rect.left = this.Yf;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cxZ() {
        return this.iHf;
    }
}
