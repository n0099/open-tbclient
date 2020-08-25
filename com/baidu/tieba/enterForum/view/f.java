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
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.c.a;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class f {
    private RecentlyVisitedForumModel hDA;
    private ImageView hDB;
    private TextView hDC;
    private RecyclerView hDD;
    private View hDE;
    private com.baidu.tieba.enterForum.a.b hDF;
    private ViewEventCenter hDG;
    private com.baidu.tieba.enterForum.home.e hDH;
    private n hDI;
    private a hDJ;
    private View hgn;
    private com.baidu.tieba.enterForum.data.c hto;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hCs = true;
    private boolean htz = false;
    private CustomMessageListener hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hDI == null) {
                        f.this.hDI = new n(new l());
                    }
                    f.this.hDI.a(f.this.hDD, 1);
                } else if (f.this.hDI != null) {
                    f.this.hDI.rc();
                }
            }
        }
    };
    private CustomMessageListener hDL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.ces();
            }
        }
    };
    private CustomMessageListener hDM = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.jj(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void ceu();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hDA = recentlyVisitedForumModel;
        this.hDG = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hDH = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hDK);
        MessageManager.getInstance().registerListener(this.hDL);
        initData();
        initView();
    }

    private void initData() {
        this.hCs = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hgn = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hDB = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.chm();
            }
        });
        this.hDC = (TextView) this.mRootView.findViewById(R.id.done);
        this.hDC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.km(false);
            }
        });
        this.hDE = this.mRootView.findViewById(R.id.gap);
        this.hDD = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hDF = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hDD.setAdapter(this.hDF);
        this.hDD.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDI = new n(new l());
            this.hDI.a(this.hDD, 1);
        }
        this.hDD.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hDD.setItemAnimator(new DefaultItemAnimator());
        this.hDD.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hDF.a(new b.InterfaceC0667b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0667b
            public void a(b.a aVar) {
                if (!f.this.htz && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.brh());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dD("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hDF.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.km(true);
                return true;
            }
        });
        this.hDF.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hDA != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hDA.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dD("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hDA.a(new a.InterfaceC0668a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0668a
            public void vW(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0668a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0668a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.hDH != null) {
                    f.this.hDH.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hDM);
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
            BarImageView barImageView = aVar.htF;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.eus;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.htH;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean ces() {
        if (this.htz) {
            km(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (this.htz != z && this.hDF != null) {
            this.htz = z;
            if (this.htz) {
                this.hDC.setVisibility(0);
                this.hDB.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hDG != null) {
                    this.hDG.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hDC.setVisibility(8);
                this.hDB.setVisibility(0);
                if (this.hDG != null) {
                    this.hDG.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hDF.km(this.htz);
        }
    }

    public boolean chl() {
        return this.htz;
    }

    public void chm() {
        this.hCs = !this.hCs;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_recently_visited_forum_extend_state", this.hCs);
        if (this.hCs) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        cho();
    }

    public boolean chn() {
        return this.hCs;
    }

    private void cho() {
        int i;
        int i2;
        if (this.hCs) {
            this.hDD.setVisibility(0);
            this.hDE.setVisibility(8);
            if (this.hto != null && this.hto.htQ) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.bjq().a(this.hDB, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hDD.setVisibility(8);
            this.hDE.setVisibility(0);
            if (this.hto != null && this.hto.htQ) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.bjq().a(this.hDB, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hDJ != null) {
            this.hDJ.ceu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hgn.setVisibility(0);
            cho();
        } else {
            this.hgn.setVisibility(8);
            this.hDD.setVisibility(8);
            this.hDE.setVisibility(8);
        }
        if (this.hDJ != null) {
            this.hDJ.ceu();
        }
    }

    public boolean isShow() {
        return this.hgn.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hDF != null && linkedList != null) {
            cho();
            this.hDF.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void chp() {
        if (this.hDA != null) {
            this.hDA.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hDF != null) {
            this.hDF.notifyDataSetChanged();
            if (this.hDF.getItemCount() > 0) {
                jj(true);
            } else {
                jj(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hDF != null) {
            this.hDF.notifyItemRemoved(i);
            if (this.hDF.getItemCount() == 0) {
                km(false);
                jj(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hto = cVar;
        chq();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            chq();
        }
    }

    private void chq() {
        if (this.hto != null && this.hto.htQ) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.hDC, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.hDC.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hDC, R.color.cp_link_tip_a);
            this.hDC.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        cho();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hDM.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDK);
        MessageManager.getInstance().unRegisterListener(this.hDL);
        if (this.hDH != null) {
            this.hDH.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hDJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int WB;
        private int WC;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.WB = i;
            this.WC = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.WB;
                } else {
                    rect.top = this.WC;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.WB;
            } else {
                rect.left = this.WC;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c chr() {
        return this.hto;
    }
}
