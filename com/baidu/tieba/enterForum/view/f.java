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
    private RecentlyVisitedForumModel hDG;
    private ImageView hDH;
    private TextView hDI;
    private RecyclerView hDJ;
    private View hDK;
    private com.baidu.tieba.enterForum.a.b hDL;
    private ViewEventCenter hDM;
    private com.baidu.tieba.enterForum.home.e hDN;
    private n hDO;
    private a hDP;
    private View hgr;
    private com.baidu.tieba.enterForum.data.c htu;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hCy = true;
    private boolean htF = false;
    private CustomMessageListener hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hDO == null) {
                        f.this.hDO = new n(new l());
                    }
                    f.this.hDO.a(f.this.hDJ, 1);
                } else if (f.this.hDO != null) {
                    f.this.hDO.rc();
                }
            }
        }
    };
    private CustomMessageListener hDR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.cet();
            }
        }
    };
    private CustomMessageListener hDS = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.jl(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void cev();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hDG = recentlyVisitedForumModel;
        this.hDM = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hDN = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hDQ);
        MessageManager.getInstance().registerListener(this.hDR);
        initData();
        initView();
    }

    private void initData() {
        this.hCy = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hgr = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hDH = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hDH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.chn();
            }
        });
        this.hDI = (TextView) this.mRootView.findViewById(R.id.done);
        this.hDI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ko(false);
            }
        });
        this.hDK = this.mRootView.findViewById(R.id.gap);
        this.hDJ = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hDL = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hDJ.setAdapter(this.hDL);
        this.hDJ.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDO = new n(new l());
            this.hDO.a(this.hDJ, 1);
        }
        this.hDJ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hDJ.setItemAnimator(new DefaultItemAnimator());
        this.hDJ.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hDL.a(new b.InterfaceC0667b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0667b
            public void a(b.a aVar) {
                if (!f.this.htF && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bri());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dD("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hDL.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.ko(true);
                return true;
            }
        });
        this.hDL.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hDG != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hDG.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dD("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hDG.a(new a.InterfaceC0668a() { // from class: com.baidu.tieba.enterForum.view.f.8
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
                if (!z && f.this.hDN != null) {
                    f.this.hDN.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hDS);
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
            BarImageView barImageView = aVar.htL;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.euw;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.htN;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean cet() {
        if (this.htF) {
            ko(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (this.htF != z && this.hDL != null) {
            this.htF = z;
            if (this.htF) {
                this.hDI.setVisibility(0);
                this.hDH.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hDM != null) {
                    this.hDM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hDI.setVisibility(8);
                this.hDH.setVisibility(0);
                if (this.hDM != null) {
                    this.hDM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hDL.ko(this.htF);
        }
    }

    public boolean chm() {
        return this.htF;
    }

    public void chn() {
        this.hCy = !this.hCy;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_recently_visited_forum_extend_state", this.hCy);
        if (this.hCy) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        chp();
    }

    public boolean cho() {
        return this.hCy;
    }

    private void chp() {
        int i;
        int i2;
        if (this.hCy) {
            this.hDJ.setVisibility(0);
            this.hDK.setVisibility(8);
            if (this.htu != null && this.htu.htW) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.bjq().a(this.hDH, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hDJ.setVisibility(8);
            this.hDK.setVisibility(0);
            if (this.htu != null && this.htu.htW) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.bjq().a(this.hDH, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hDP != null) {
            this.hDP.cev();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jl(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hgr.setVisibility(0);
            chp();
        } else {
            this.hgr.setVisibility(8);
            this.hDJ.setVisibility(8);
            this.hDK.setVisibility(8);
        }
        if (this.hDP != null) {
            this.hDP.cev();
        }
    }

    public boolean isShow() {
        return this.hgr.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hDL != null && linkedList != null) {
            chp();
            this.hDL.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void chq() {
        if (this.hDG != null) {
            this.hDG.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hDL != null) {
            this.hDL.notifyDataSetChanged();
            if (this.hDL.getItemCount() > 0) {
                jl(true);
            } else {
                jl(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hDL != null) {
            this.hDL.notifyItemRemoved(i);
            if (this.hDL.getItemCount() == 0) {
                ko(false);
                jl(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.htu = cVar;
        chr();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            chr();
        }
    }

    private void chr() {
        if (this.htu != null && this.htu.htW) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.hDI, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.hDI.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hDI, R.color.cp_link_tip_a);
            this.hDI.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        chp();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hDS.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDQ);
        MessageManager.getInstance().unRegisterListener(this.hDR);
        if (this.hDN != null) {
            this.hDN.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hDP = aVar;
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

    public com.baidu.tieba.enterForum.data.c chs() {
        return this.htu;
    }
}
