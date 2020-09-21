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
/* loaded from: classes21.dex */
public class f {
    private com.baidu.tieba.enterForum.data.c hAz;
    private RecentlyVisitedForumModel hKI;
    private ImageView hKJ;
    private TextView hKK;
    private RecyclerView hKL;
    private View hKM;
    private com.baidu.tieba.enterForum.a.b hKN;
    private ViewEventCenter hKO;
    private com.baidu.tieba.enterForum.home.e hKP;
    private n hKQ;
    private a hKR;
    private View hns;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private TextView mTitle;
    private Vibrator mVibrator;
    private int mSkinType = 3;
    private boolean hJA = true;
    private boolean hAK = false;
    private CustomMessageListener hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.enterForum.view.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (f.this.hKQ == null) {
                        f.this.hKQ = new n(new l());
                    }
                    f.this.hKQ.a(f.this.hKL, 1);
                } else if (f.this.hKQ != null) {
                    f.this.hKQ.rh();
                }
            }
        }
    };
    private CustomMessageListener hKT = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.enterForum.view.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.chI();
            }
        }
    };
    private CustomMessageListener hKU = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME) { // from class: com.baidu.tieba.enterForum.view.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                f.this.jj(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void chK();
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.mPageContext = tbPageContext;
        this.hKI = recentlyVisitedForumModel;
        this.hKO = viewEventCenter;
        this.mVibrator = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.hKP = new com.baidu.tieba.enterForum.home.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.hKS);
        MessageManager.getInstance().registerListener(this.hKT);
        initData();
        initView();
    }

    private void initData() {
        this.hJA = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_recently_visited_forum_extend_state", true);
    }

    private void initView() {
        this.mRootView = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.hns = this.mRootView.findViewById(R.id.title_container);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.title);
        this.hKJ = (ImageView) this.mRootView.findViewById(R.id.extend_image);
        this.hKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ckC();
            }
        });
        this.hKK = (TextView) this.mRootView.findViewById(R.id.done);
        this.hKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.kp(false);
            }
        });
        this.hKM = this.mRootView.findViewById(R.id.gap);
        this.hKL = (RecyclerView) this.mRootView.findViewById(R.id.list);
        this.hKN = new com.baidu.tieba.enterForum.a.b(this.mPageContext);
        this.hKL.setAdapter(this.hKN);
        this.hKL.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hKQ = new n(new l());
            this.hKQ.a(this.hKL, 1);
        }
        this.hKL.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.hKL.setItemAnimator(new DefaultItemAnimator());
        this.hKL.addItemDecoration(new b(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44)));
        this.hKN.a(new b.InterfaceC0664b() { // from class: com.baidu.tieba.enterForum.view.f.5
            @Override // com.baidu.tieba.enterForum.a.b.InterfaceC0664b
            public void a(b.a aVar) {
                if (!f.this.hAK && aVar != null && aVar.itemView != null && (aVar.itemView.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) aVar.itemView.getTag();
                    FrsActivityConfig callFrom = new FrsActivityConfig(f.this.mPageContext.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
                    f.this.a(aVar, callFrom.getIntent(), visitedForumData.bsc());
                    f.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, callFrom));
                    TiebaStatic.log(new aq("c13002").dF("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hKN.a(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.f.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f.this.kp(true);
                return true;
            }
        });
        this.hKN.v(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hKI != null && view.getTag() != null && (view.getTag() instanceof VisitedForumData)) {
                    VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
                    f.this.hKI.e(visitedForumData);
                    TiebaStatic.log(new aq("c13005").dF("fid", visitedForumData.getForumId()));
                }
            }
        });
        this.hKI.a(new a.InterfaceC0665a() { // from class: com.baidu.tieba.enterForum.view.f.8
            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0665a
            public void wv(int i) {
                f.this.notifyItemRemoved(i);
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0665a
            public void onNotify() {
                f.this.notifyDataSetChanged();
            }

            @Override // com.baidu.tieba.enterForum.c.a.InterfaceC0665a
            public void b(LinkedList<VisitedForumData> linkedList, boolean z) {
                f.this.j(linkedList);
                if (!z && f.this.hKP != null) {
                    f.this.hKP.a(linkedList, f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mPageContext.registerListener(this.hKU);
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
            BarImageView barImageView = aVar.hAQ;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = aVar.ewA;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = aVar.hAS;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
        }
    }

    public boolean chI() {
        if (this.hAK) {
            kp(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        if (this.hAK != z && this.hKN != null) {
            this.hAK = z;
            if (this.hAK) {
                this.hKK.setVisibility(0);
                this.hKJ.setVisibility(8);
                if (this.mVibrator != null) {
                    this.mVibrator.vibrate(10L);
                }
                if (this.hKO != null) {
                    this.hKO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(10, null, null, null));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT, 2));
            } else {
                this.hKK.setVisibility(8);
                this.hKJ.setVisibility(0);
                if (this.hKO != null) {
                    this.hKO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(11, null, null, null));
                }
            }
            this.hKN.kp(this.hAK);
        }
    }

    public boolean ckB() {
        return this.hAK;
    }

    public void ckC() {
        this.hJA = !this.hJA;
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_recently_visited_forum_extend_state", this.hJA);
        if (this.hJA) {
            TiebaStatic.log(new aq("c13003"));
        } else {
            TiebaStatic.log(new aq("c13004"));
        }
        ckE();
    }

    public boolean ckD() {
        return this.hJA;
    }

    private void ckE() {
        int i;
        int i2;
        if (this.hJA) {
            this.hKL.setVisibility(0);
            this.hKM.setVisibility(8);
            if (this.hAz != null && this.hAz.hBb) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.cp_cont_j;
            }
            SvgManager.bkl().a(this.hKJ, R.drawable.icon_pure_ba_show24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.hKL.setVisibility(8);
            this.hKM.setVisibility(0);
            if (this.hAz != null && this.hAz.hBb) {
                i = R.color.white_alpha100;
            } else {
                i = R.color.cp_cont_j;
            }
            SvgManager.bkl().a(this.hKJ, R.drawable.icon_pure_ba_hide24_svg, i, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.hKR != null) {
            this.hKR.chK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(boolean z) {
        if (z && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
            this.hns.setVisibility(0);
            ckE();
        } else {
            this.hns.setVisibility(8);
            this.hKL.setVisibility(8);
            this.hKM.setVisibility(8);
        }
        if (this.hKR != null) {
            this.hKR.chK();
        }
    }

    public boolean isShow() {
        return this.hns.getVisibility() == 0;
    }

    public void j(LinkedList<VisitedForumData> linkedList) {
        if (this.hKN != null && linkedList != null) {
            ckE();
            this.hKN.h(linkedList);
            notifyDataSetChanged();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ckF() {
        if (this.hKI != null) {
            this.hKI.refresh();
        }
    }

    public void notifyDataSetChanged() {
        if (this.hKN != null) {
            this.hKN.notifyDataSetChanged();
            if (this.hKN.getItemCount() > 0) {
                jj(true);
            } else {
                jj(false);
            }
        }
    }

    public void notifyItemRemoved(int i) {
        if (this.hKN != null) {
            this.hKN.notifyItemRemoved(i);
            if (this.hKN.getItemCount() == 0) {
                kp(false);
                jj(false);
            }
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hAz = cVar;
        ckG();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ckG();
        }
    }

    private void ckG() {
        if (this.hAz != null && this.hAz.hBb) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            this.mRootView.setBackgroundColor(0);
            ap.a((View) this.hKK, R.color.cp_bg_line_d, R.color.cp_bg_line_d_alpha50, 0);
            this.hKK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hKK, R.color.cp_link_tip_a);
            this.hKK.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        ckE();
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hKU.setTag(bdUniqueId);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hKS);
        MessageManager.getInstance().unRegisterListener(this.hKT);
        if (this.hKP != null) {
            this.hKP.onDestroy();
        }
    }

    public void a(a aVar) {
        this.hKR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ItemDecoration {
        private int WT;
        private int WU;
        private int mEnd;

        public b(int i, int i2, int i3) {
            this.WT = i;
            this.WU = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.WT;
                } else {
                    rect.top = this.WU;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.WT;
            } else {
                rect.left = this.WU;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }

    public com.baidu.tieba.enterForum.data.c ckH() {
        return this.hAz;
    }
}
