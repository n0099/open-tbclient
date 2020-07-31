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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.a.b;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class f {
    private View gTu;
    private com.baidu.tieba.enterForum.data.c hgv;
    private RecentlyVisitedForumModel hqJ;
    private ImageView hqK;
    private TextView hqL;
    private RecyclerView hqM;
    private View hqN;
    private com.baidu.tieba.enterForum.a.b hqO;
    private ViewEventCenter hqP;
    private com.baidu.tieba.enterForum.home.e hqQ;
    private n hqR;
    private a hqS;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hpB = true;
    private boolean hgG = false;
    private CustomMessageListener hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hqR == null) {
                        f.this.hqR = new n(new l());
                    }
                    f.this.hqR.a(f.this.hqM, 1);
                } else if (f.this.hqR != null) {
                    f.this.hqR.pD();
                }
            }
        }
    };
    private CustomMessageListener hqU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.bUg();
            }
        }
    };
    private CustomMessageListener hqV = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.iL(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void bUi();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hqJ = recentlyVisitedForumModel;
        this.hqP = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hqQ = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hqT);
        MessageManager.getInstance().registerListener(this.hqU);
        initData();
        initView();
    }

    private void initData() {
        this.hpB = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.gTu = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hqK = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.bWZ();
            }
        });
        this.hqL = (TextView) this.mRootView.findViewById(R.id.done);
        this.hqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.jO(false);
            }
        });
        this.hqN = this.mRootView.findViewById(R.id.gap);
        this.hqM = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hqO = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hqM.setAdapter(this.hqO);
        this.hqM.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hqR = new n(new l());
            this.hqR.a(this.hqM, 1);
        }
        this.hqM.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hqM.setItemAnimator(new DefaultItemAnimator());
        this.hqM.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hqO.a(new b.InterfaceC0617b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0617b
            public void a(b.a aVar) {
                if (!f.this.hgG && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.biv());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new ap("c13002").dn("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hqO.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.jO(true);
                return true;
            }
        });
        this.hqO.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hqJ != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hqJ.d(visitedForumData);
                    TiebaStatic.log(new ap("c13005").dn("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hqJ.a(new RecentlyVisitedForumModel.a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void tM(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel.a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.hqQ != null) {
                    f.this.hqQ.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hqV);
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
            BarImageView barImageView = aVar.hgM;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.ekx;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.hgO;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean bUg() {
        if (this.hgG) {
            jO(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(boolean z) {
        if (this.hgG != z && this.hqO != null) {
            this.hgG = z;
            if (this.hgG) {
                this.hqL.setVisibility(0);
                this.hqK.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hqP != null) {
                    this.hqP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hqL.setVisibility(8);
                this.hqK.setVisibility(0);
                if (this.hqP != null) {
                    this.hqP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hqO.jO(this.hgG);
        }
    }

    public boolean bWY() {
        return this.hgG;
    }

    public void bWZ() {
        this.hpB = !this.hpB;
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_recently_visited_forum_extend_state", this.hpB);
        if (this.hpB) {
            TiebaStatic.log(new ap("c13003"));
        } else {
            TiebaStatic.log(new ap("c13004"));
        }
        bXb();
    }

    public boolean bXa() {
        return this.hpB;
    }

    private void bXb() {
        int i;
        int i2;
        if (this.hpB) {
            this.hqM.setVisibility(0);
            this.hqN.setVisibility(8);
            if (this.hgv != null && this.hgv.hgX) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.baR().a(this.hqK, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hqM.setVisibility(8);
            this.hqN.setVisibility(0);
            if (this.hgv != null && this.hgv.hgX) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.baR().a(this.hqK, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hqS != null) {
            this.hqS.bUi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.gTu.setVisibility(0);
            bXb();
        } else {
            this.gTu.setVisibility(8);
            this.hqM.setVisibility(8);
            this.hqN.setVisibility(8);
        }
        if (this.hqS != null) {
            this.hqS.bUi();
        }
    }

    public boolean isShow() {
        return this.gTu.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hqO != null && linkedList != null) {
            bXb();
            this.hqO.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void bXc() {
        if (this.hqJ != null) {
            this.hqJ.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hqO != null) {
            this.hqO.notifyDataSetChanged();
            if (this.hqO.getItemCount() > 0) {
                iL(true);
            } else {
                iL(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hqO != null) {
            this.hqO.notifyItemRemoved(i);
            if (this.hqO.getItemCount() == 0) {
                jO(false);
                iL(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hgv = cVar;
        bXd();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            bXd();
        }
    }

    private void bXd() {
        if (this.hgv != null && this.hgv.hgX) {
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ao.a((View) this.hqL, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.hqL.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.hqL, R.color.cp_link_tip_a);
            this.hqL.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        bXb();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hqV.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqT);
        MessageManager.getInstance().unRegisterListener(this.hqU);
        if (this.hqQ != null) {
            this.hqQ.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hqS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int Wa;
        private int Wb;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.Wa = i;
            this.Wb = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Wa;
                } else {
                    rect.top = this.Wb;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Wa;
            } else {
                rect.left = this.Wb;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c bXe() {
        return this.hgv;
    }
}
