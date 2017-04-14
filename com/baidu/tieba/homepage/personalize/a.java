package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private static boolean cwW = false;
    private BdTypeListView aPE;
    private PbListView aRM;
    private com.baidu.tbadk.i.f aRN;
    private final CustomMessageListener bNF;
    private TagInfo cwP;
    private com.baidu.tieba.homepage.personalize.b.ad cwQ;
    private com.baidu.tieba.homepage.framework.c cwR;
    private n cwS;
    private com.baidu.tieba.homepage.personalize.model.f cwT;
    private long cwU;
    private TextView cwV;
    private o.a cwX;
    private n.a cwY;
    private View.OnClickListener cwZ;
    private com.baidu.tbadk.core.view.ae mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.i.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cwS != null) {
            this.cwS.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cwS != null) {
            this.cwS.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void Xj() {
        if (this.cwS != null) {
            this.cwS.Xj();
        }
    }

    public void completePullRefresh() {
        if (this.aPE != null) {
            this.aPE.completePullRefresh();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cwS != null) {
            this.cwS.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cwQ != null) {
            this.cwQ.setPageUniqueId(bdUniqueId);
        }
        if (this.cwS != null) {
            this.cwS.j(bdUniqueId);
        }
        if (this.cwT != null) {
            this.cwT.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bNF != null) {
            this.bNF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bNF);
        }
    }

    public a(Context context) {
        super(context);
        this.cwU = 0L;
        this.cwX = new b(this);
        this.cwY = new d(this);
        this.bNF = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cwZ = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.aPE = new BdTypeListView(context);
        this.aPE.setDividerHeight(0);
        this.aPE.setSelector(17170445);
        this.aRM = new PbListView(context);
        this.aRM.le();
        this.aRM.dj(w.e.cp_bg_line_c);
        this.aRM.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRM.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.aRM.setOnClickListener(this.cwZ);
        this.aPE.setNextPage(this.aRM);
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.pageContext);
        this.aPE.setPullRefresh(this.mPullView);
        this.cwV = new TextView(context);
        this.cwV.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(context, w.f.ds176)));
        this.aPE.addHeaderView(this.cwV, 0);
        this.mPullView.V(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.aPE.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.cwT = new com.baidu.tieba.homepage.personalize.model.f();
        this.cwQ = new com.baidu.tieba.homepage.personalize.b.ad(context, this.aPE);
        this.cwQ.b(this.cwT);
        this.cwQ.a(this.cwX);
        this.cwS = new n(this.pageContext, this.aPE, this.cwV, this.cwQ, this);
        this.cwS.a(this.cwY);
        addView(this.aPE);
        this.aPE.setRecyclerListener(new l(this));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cwR = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cwP = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aRM != null) {
            this.aRM.xe();
            this.aRM.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cwS.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cwV != null) {
            aq.k(this.cwV, w.e.cp_bg_line_d);
        }
        if (this.aRN != null) {
            this.aRN.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aRM != null) {
            this.aRM.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRM.dk(i);
        }
        this.cwQ.onChangeSkinType(i);
        aq.k(this, w.e.cp_bg_line_d);
        aq.j(this.aPE, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cwP == null || this.cwP.tag_code == null) {
            return 0L;
        }
        return this.cwP.tag_code.longValue();
    }

    public void M(String str, int i) {
        if (this.aRM != null) {
            this.aRM.xe();
            this.aRM.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cwS.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getContext(), new c(this));
        }
        this.refreshView.eV(getContext().getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fT(str);
        this.refreshView.b(view, z);
        this.refreshView.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        if (this.aRN != null) {
            this.aRN.I(this);
            this.aRN = null;
        }
        if (this.cwR != null) {
            this.cwR.aiu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajf() {
        if (this.refreshView != null) {
            return this.refreshView.ET();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.aRN == null) {
            if (i < 0) {
                this.aRN = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.aRN = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.aRN.onChangeSkinType();
        }
        this.aRN.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cwS != null) {
            this.cwS.setTabInForeBackgroundState(z);
        }
    }

    public void ajg() {
        setViewForeground(false);
        if (this.cwS != null) {
            this.cwS.dJ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void setViewForeground(boolean z) {
        this.cwU = System.currentTimeMillis();
        if (this.cwS != null) {
            this.cwS.eU(z);
        }
    }

    public void aiC() {
        if (this.cwS != null) {
            this.cwS.update();
        }
    }

    public void reload() {
        if (this.aPE != null) {
            Xj();
            this.aPE.setSelection(0);
            if (this.aPE.isRefreshDone()) {
                if (this.cwS != null && this.cwS.Lc() != null) {
                    this.cwS.Lc().alF();
                    this.cwS.eX(false);
                }
                this.aPE.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cwS.onDestroy();
    }

    public void onPause() {
        this.cwS.onPause();
    }

    public void onResume() {
        this.cwS.onResume();
    }

    public void ahW() {
        if (this.cwQ != null) {
            this.cwQ.notifyDataSetChanged();
        }
    }

    public void ajh() {
        if (this.cwS != null) {
            this.cwS.dJ(true);
        }
        if (this.cwU > 0) {
            TiebaStatic.log(new as("c10794").aa("obj_duration", String.valueOf((System.currentTimeMillis() - this.cwU) / 1000)));
            this.cwU = 0L;
        }
        cc.ST().cO(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aji() {
        this.cwS.ajx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zv() {
        if (this.aRM != null && !this.aRM.xj()) {
            this.aRM.xd();
            this.aRM.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cwS.Zv();
    }
}
