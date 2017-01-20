package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private static boolean cwX = false;
    private com.baidu.tbadk.f.f GL;
    private BdTypeListView aJF;
    private PbListView aLK;
    private final CustomMessageListener bGH;
    private TagInfo cwQ;
    private com.baidu.tieba.homepage.personalize.b.ad cwR;
    private com.baidu.tieba.homepage.framework.c cwS;
    private n cwT;
    private com.baidu.tieba.homepage.personalize.model.f cwU;
    private long cwV;
    private TextView cwW;
    private o.a cwY;
    private n.a cwZ;
    private View.OnClickListener cxa;
    private com.baidu.tbadk.core.view.ad mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cwT != null) {
            this.cwT.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cwT != null) {
            this.cwT.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void VN() {
        if (this.cwT != null) {
            this.cwT.VN();
        }
    }

    public void completePullRefresh() {
        if (this.aJF != null) {
            this.aJF.completePullRefresh();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cwT != null) {
            this.cwT.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cwR != null) {
            this.cwR.setPageUniqueId(bdUniqueId);
        }
        if (this.cwT != null) {
            this.cwT.j(bdUniqueId);
        }
        if (this.cwU != null) {
            this.cwU.o(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bGH != null) {
            this.bGH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bGH);
        }
    }

    public a(Context context) {
        super(context);
        this.cwV = 0L;
        this.cwY = new b(this);
        this.cwZ = new d(this);
        this.bGH = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cxa = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.aJF = new BdTypeListView(context);
        this.aJF.setDividerHeight(0);
        this.aJF.setSelector(17170445);
        this.aLK = new PbListView(context);
        this.aLK.kg();
        this.aLK.dk(r.e.cp_bg_line_c);
        this.aLK.setTextColor(ap.getColor(r.e.cp_cont_d));
        this.aLK.dl(TbadkCoreApplication.m9getInst().getSkinType());
        this.aLK.setOnClickListener(this.cxa);
        this.aJF.setNextPage(this.aLK);
        com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.pageContext);
        this.aJF.setPullRefresh(this.mPullView);
        this.cwW = new TextView(context);
        this.cwW.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(context, r.f.ds176)));
        this.aJF.addHeaderView(this.cwW, 0);
        this.mPullView.U(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.aJF.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.cwU = new com.baidu.tieba.homepage.personalize.model.f();
        this.cwR = new com.baidu.tieba.homepage.personalize.b.ad(context, this.aJF);
        this.cwR.b(this.cwU);
        this.cwR.a(this.cwY);
        this.cwT = new n(this.pageContext, this.aJF, this.cwW, this.cwR, this);
        this.cwT.a(this.cwZ);
        addView(this.aJF);
        this.aJF.setRecyclerListener(new l(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cwS = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cwQ = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aLK != null) {
            this.aLK.wl();
            this.aLK.dm(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.f.ds110));
        }
        this.cwT.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cwW != null) {
            ap.k(this.cwW, r.e.cp_bg_line_d);
        }
        if (this.GL != null) {
            this.GL.tg();
        }
        if (this.refreshView != null) {
            this.refreshView.tg();
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.aLK != null) {
            this.aLK.setTextColor(ap.getColor(r.e.cp_cont_d));
            this.aLK.dl(i);
        }
        this.cwR.onChangeSkinType(i);
        ap.k(this, r.e.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cwQ == null || this.cwQ.tag_code == null) {
            return 0L;
        }
        return this.cwQ.tag_code.longValue();
    }

    public void T(String str, int i) {
        if (this.aLK != null) {
            this.aLK.wl();
            this.aLK.dm(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.f.ds110));
        }
        this.cwT.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new c(this));
        }
        this.refreshView.eX(getContext().getResources().getDimensionPixelSize(r.f.ds280));
        this.refreshView.fY(str);
        this.refreshView.b(view, z);
        this.refreshView.Ej();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        if (this.refreshView != null) {
            this.refreshView.K(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        if (this.GL != null) {
            this.GL.K(this);
            this.GL = null;
        }
        if (this.cwS != null) {
            this.cwS.ajn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajZ() {
        if (this.refreshView != null) {
            return this.refreshView.Ec();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.GL == null) {
            if (i < 0) {
                this.GL = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.GL = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.GL.tg();
        }
        this.GL.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cwT != null) {
            this.cwT.setTabInForeBackgroundState(z);
        }
    }

    public void aka() {
        setViewForeground(false);
        if (this.cwT != null) {
            this.cwT.dH(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cwV = System.currentTimeMillis();
        if (this.cwT != null) {
            this.cwT.fd(z);
        }
    }

    public void ajv() {
        if (this.cwT != null) {
            this.cwT.update();
        }
    }

    public void reload() {
        if (this.aJF != null) {
            VN();
            this.aJF.setSelection(0);
            if (this.aJF.isRefreshDone()) {
                if (this.cwT != null && this.cwT.JX() != null) {
                    this.cwT.JX().amY();
                    this.cwT.fg(false);
                }
                this.aJF.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cwT.onDestroy();
    }

    public void onPause() {
        this.cwT.onPause();
    }

    public void onResume() {
        this.cwT.onResume();
    }

    public void aiP() {
        if (this.cwR != null) {
            this.cwR.notifyDataSetChanged();
        }
    }

    public void akb() {
        if (this.cwT != null) {
            this.cwT.dH(true);
        }
        if (this.cwV > 0) {
            TiebaStatic.log(new ar("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cwV) / 1000)));
            this.cwV = 0L;
        }
        cc.Rx().cM(false);
    }

    public void akc() {
        this.cwT.akr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        if (this.aLK != null && !this.aLK.wq()) {
            this.aLK.wk();
            this.aLK.dm(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.f.ds110));
        }
        this.cwT.Ya();
    }
}
