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
    private Vibrator dOO;
    private com.baidu.tieba.enterForum.data.c iIO;
    private RecentlyVisitedForumModel iSU;
    private ImageView iSV;
    private TextView iSW;
    private RecyclerView iSX;
    private View iSY;
    private RecentlyVisitedForumListAdapter iSZ;
    private ViewEventCenter iTa;
    private com.baidu.tieba.enterForum.home.e iTb;
    private l iTc;
    private a iTd;
    private View ivt;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private int mSkinType = 3;
    private boolean iRL = true;
    private boolean iIZ = false;
    private CustomMessageListener iTe = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.iTc == null) {
                        f.this.iTc = new l(new j());
                    }
                    f.this.iTc.a(f.this.iSX, 1);
                } else if (f.this.iTc != null) {
                    f.this.iTc.qJ();
                }
            }
        }
    };
    private CustomMessageListener iTf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cvf();
            }
        }
    };
    private CustomMessageListener iTg = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
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
        void cvh();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.iSU = recentlyVisitedForumModel;
        this.iTa = viewEventCenter;
        this.dOO = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.iTb = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.iTe);
        MessageManager.getInstance().registerListener(this.iTf);
        initData();
        initView();
    }

    private void initData() {
        this.iRL = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.ivt = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.iSV = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.iSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cya();
            }
        });
        this.iSW = (TextView) this.mRootView.findViewById(R.id.done);
        this.iSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.mc(false);
            }
        });
        this.iSY = this.mRootView.findViewById(R.id.gap);
        this.iSX = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.iSZ = new RecentlyVisitedForumListAdapter(this.mPageContext);
        this.iSX.setAdapter(this.iSZ);
        this.iSX.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iTc = new l(new j());
            this.iTc.a(this.iSX, 1);
        }
        this.iSX.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.iSX.setItemAnimator(new DefaultItemAnimator());
        this.iSX.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.iSZ.a(new RecentlyVisitedForumListAdapter.a() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
            public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
                if (!f.this.iIZ && forumViewHolder != null && forumViewHolder.itemView != null && (forumViewHolder.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(forumViewHolder, callFrom.getIntent(), visitedForumData.bAR());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ar("c13002").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iSZ.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.mc(true);
                return true;
            }
        });
        this.iSZ.x(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.iSU != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.iSU.e(visitedForumData);
                    TiebaStatic.log(new ar("c13005").dR("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.iSU.a(new a.InterfaceC0711a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0711a
            public void xC(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0711a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.b.a.InterfaceC0711a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.iTb != null) {
                    f.this.iTb.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.iTg);
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
            BarImageView barImageView = forumViewHolder.iJf;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.fmq;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.iJh;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cvf() {
        if (this.iIZ) {
            mc(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (this.iIZ != z && this.iSZ != null) {
            this.iIZ = z;
            if (this.iIZ) {
                this.iSW.setVisibility(0);
                this.iSV.setVisibility(8);
                if (this.dOO != null) {
                    this.dOO.vibrate(10L);
                }
                if (this.iTa != null) {
                    this.iTa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.iSW.setVisibility(8);
                this.iSV.setVisibility(0);
                if (this.iTa != null) {
                    this.iTa.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.iSZ.mc(this.iIZ);
        }
    }

    public boolean cxZ() {
        return this.iIZ;
    }

    public void cya() {
        this.iRL = !this.iRL;
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_recently_visited_forum_extend_state", this.iRL);
        if (this.iRL) {
            TiebaStatic.log(new ar("c13003"));
        } else {
            TiebaStatic.log(new ar("c13004"));
        }
        cyc();
    }

    public boolean cyb() {
        return this.iRL;
    }

    private void cyc() {
        int i;
        int i2;
        if (this.iRL) {
            this.iSX.setVisibility(0);
            this.iSY.setVisibility(8);
            if (this.iIO != null && this.iIO.iJq) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.bsU().a(this.iSV, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.iSX.setVisibility(8);
            this.iSY.setVisibility(0);
            if (this.iIO != null && this.iIO.iJq) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.CAM_X0107;
            }
            SvgManager.bsU().a(this.iSV, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iTd != null) {
            this.iTd.cvh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.ivt.setVisibility(0);
            cyc();
        } else {
            this.ivt.setVisibility(8);
            this.iSX.setVisibility(8);
            this.iSY.setVisibility(8);
        }
        if (this.iTd != null) {
            this.iTd.cvh();
        }
    }

    public boolean isShow() {
        return this.ivt.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.iSZ != null && linkedList != null) {
            cyc();
            this.iSZ.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void cyd() {
        if (this.iSU != null) {
            this.iSU.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.iSZ != null) {
            this.iSZ.notifyDataSetChanged();
            if (this.iSZ.getItemCount() > 0) {
                kP(true);
            } else {
                kP(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.iSZ != null) {
            this.iSZ.notifyItemRemoved(i);
            if (this.iSZ.getItemCount() == 0) {
                mc(false);
                kP(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iIO = cVar;
        cye();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            cye();
        }
    }

    private void cye() {
        if (this.iIO != null && this.iIO.iJq) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.iSW, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.iSW.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
            ap.setViewTextColor(this.iSW, R.color.CAM_X0302);
            this.iSW.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cyc();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iTg.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iTe);
        MessageManager.getInstance().unRegisterListener(this.iTf);
        if (this.iTb != null) {
            this.iTb.onDestroy();
        }
    }

    public void a(a aVar) {
        this.iTd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Zx;
        private int Zy;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Zx = i;
            this.Zy = i2;
            this.mEnd = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Zx;
                } else {
                    rect.top = this.Zy;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Zx;
            } else {
                rect.left = this.Zy;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c cyf() {
        return this.iIO;
    }
}
