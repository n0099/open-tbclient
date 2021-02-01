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
    private com.baidu.tieba.enterForum.data.c iGR;
    private RecentlyVisitedForumModel iQX;
    private ImageView iQY;
    private TextView iQZ;
    private RecyclerView iRa;
    private View iRb;
    private RecentlyVisitedForumListAdapter iRc;
    private ViewEventCenter iRd;
    private com.baidu.tieba.enterForum.home.e iRe;
    private l iRf;
    private a iRg;
    private View itw;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean iPO = true;
    private boolean iHc = false;
    private CustomMessageListener iRh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iRf == null) {
                        f.this.iRf = new l(new j());
                    }
                    f.this.iRf.a(f.this.iRa, 1);
                } else if (f.this.iRf != null) {
                    f.this.iRf.qJ();
                }
            }
        }
    };
    private CustomMessageListener iRi = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cuS();
            }
        }
    };
    private CustomMessageListener iRj = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
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
        void cuU();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iQX = recentlyVisitedForumModel;
        this.iRd = viewEventCenter;
        this.dNn = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iRe = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iRh);
        MessageManager.getInstance().registerListener(this.iRi);
        initData();
        initView();
    }

    private void initData() {
        this.iPO = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.itw = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iQY = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iQY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cxN();
            }
        });
        this.iQZ = (TextView) this.mRootView.findViewById(R.id.done);
        this.iQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.mc(false);
            }
        });
        this.iRb = this.mRootView.findViewById(R.id.gap);
        this.iRa = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iRc = new RecentlyVisitedForumListAdapter(this.mPageContext);
        this.iRa.setAdapter(this.iRc);
        this.iRa.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRf = new l(new j());
            this.iRf.a(this.iRa, 1);
        }
        this.iRa.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iRa.setItemAnimator(new DefaultItemAnimator());
        this.iRa.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iRc.a(new RecentlyVisitedForumListAdapter.a() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
            public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
                if (!f.this.iHc && forumViewHolder != null && forumViewHolder.itemView != null && (forumViewHolder.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(forumViewHolder, callFrom.getIntent(), visitedForumData.bAO());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iRc.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.mc(true);
                return true;
            }
        });
        this.iRc.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iQX != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iQX.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iQX.a(new a.InterfaceC0704a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void xB(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0704a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iRe != null) {
                    f.this.iRe.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iRj);
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
            BarImageView barImageView = forumViewHolder.iHi;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.fkQ;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.iHk;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cuS() {
        if (this.iHc) {
            mc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (this.iHc != z && this.iRc != null) {
            this.iHc = z;
            if (this.iHc) {
                this.iQZ.setVisibility(0);
                this.iQY.setVisibility(8);
                if (this.dNn != null) {
                    this.dNn.vibrate(10L);
                }
                if (this.iRd != null) {
                    this.iRd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iQZ.setVisibility(8);
                this.iQY.setVisibility(0);
                if (this.iRd != null) {
                    this.iRd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iRc.mc(this.iHc);
        }
    }

    public boolean cxM() {
        return this.iHc;
    }

    public void cxN() {
        this.iPO = !this.iPO;
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_recently_visited_forum_extend_state", this.iPO);
        if (this.iPO) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        cxP();
    }

    public boolean cxO() {
        return this.iPO;
    }

    private void cxP() {
        int i;
        int i2;
        if (this.iPO) {
            this.iRa.setVisibility(0);
            this.iRb.setVisibility(8);
            if (this.iGR != null && this.iGR.iHt) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bsR().a(this.iQY, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iRa.setVisibility(8);
            this.iRb.setVisibility(0);
            if (this.iGR != null && this.iGR.iHt) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bsR().a(this.iQY, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iRg != null) {
            this.iRg.cuU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.itw.setVisibility(0);
            cxP();
        } else {
            this.itw.setVisibility(8);
            this.iRa.setVisibility(8);
            this.iRb.setVisibility(8);
        }
        if (this.iRg != null) {
            this.iRg.cuU();
        }
    }

    public boolean isShow() {
        return this.itw.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iRc != null && linkedList != null) {
            cxP();
            this.iRc.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cxQ() {
        if (this.iQX != null) {
            this.iQX.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iRc != null) {
            this.iRc.notifyDataSetChanged();
            if (this.iRc.getItemCount() > 0) {
                kP(true);
            } else {
                kP(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iRc != null) {
            this.iRc.notifyItemRemoved(i);
            if (this.iRc.getItemCount() == 0) {
                mc(false);
                kP(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iGR = cVar;
        cxR();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cxR();
        }
    }

    private void cxR() {
        if (this.iGR != null && this.iGR.iHt) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.iQZ, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iQZ.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.iQZ, R.color.CAM_X0302);
            this.iQZ.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cxP();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iRj.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRh);
        MessageManager.getInstance().unRegisterListener(this.iRi);
        if (this.iRe != null) {
            this.iRe.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iRg = aVar;
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

    public com.baidu.tieba.enterForum.data.c cxS() {
        return this.iGR;
    }
}
