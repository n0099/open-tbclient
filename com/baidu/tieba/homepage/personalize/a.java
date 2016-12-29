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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private com.baidu.tbadk.f.f HB;
    private PbListView aMJ;
    private final CustomMessageListener bzh;
    private TagInfo cpQ;
    private BdTypeListView cpR;
    private com.baidu.tieba.homepage.personalize.b.ab cpS;
    private com.baidu.tieba.homepage.framework.c cpT;
    private n cpU;
    private com.baidu.tieba.homepage.personalize.c.f cpV;
    private long cpW;
    private TextView cpX;
    private o.a cpY;
    private n.a cpZ;
    private View.OnClickListener cqa;
    private com.baidu.tbadk.core.view.ac mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cpU != null) {
            this.cpU.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cpU != null) {
            this.cpU.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void Us() {
        if (this.cpU != null) {
            this.cpU.Us();
        }
    }

    public void ku() {
        if (this.cpR != null) {
            this.cpR.ku();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cpU != null) {
            this.cpU.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cpS != null) {
            this.cpS.setPageUniqueId(bdUniqueId);
        }
        if (this.cpU != null) {
            this.cpU.j(bdUniqueId);
        }
        if (this.cpV != null) {
            this.cpV.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bzh != null) {
            this.bzh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bzh);
        }
    }

    public a(Context context) {
        super(context);
        this.cpW = 0L;
        this.cpY = new b(this);
        this.cpZ = new d(this);
        this.bzh = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cqa = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.cpR = new BdTypeListView(context);
        this.cpR.setDividerHeight(0);
        this.cpR.setSelector(17170445);
        this.aMJ = new PbListView(context);
        this.aMJ.kk();
        this.aMJ.dj(r.d.cp_bg_line_c);
        this.aMJ.setTextColor(ar.getColor(r.d.cp_cont_d));
        this.aMJ.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.aMJ.setOnClickListener(this.cqa);
        this.cpR.setNextPage(this.aMJ);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.pageContext);
        this.cpR.setPullRefresh(this.mPullView);
        this.cpX = new TextView(context);
        this.cpX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(context, r.e.ds176)));
        this.cpR.f(this.cpX, 0);
        this.mPullView.U(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.cpR.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.cpV = new com.baidu.tieba.homepage.personalize.c.f();
        this.cpS = new com.baidu.tieba.homepage.personalize.b.ab(context, this.cpR);
        this.cpS.b(this.cpV);
        this.cpS.a(this.cpY);
        this.cpU = new n(this.pageContext, this.cpR, this.cpX, this.cpS, this);
        this.cpU.a(this.cpZ);
        addView(this.cpR);
        this.cpR.setRecyclerListener(new l(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cpT = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cpQ = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aMJ != null) {
            this.aMJ.wq();
            this.aMJ.dl(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cpU.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cpX != null) {
            ar.l(this.cpX, r.d.cp_bg_line_d);
        }
        if (this.HB != null) {
            this.HB.tm();
        }
        if (this.refreshView != null) {
            this.refreshView.tm();
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aMJ != null) {
            this.aMJ.setTextColor(ar.getColor(r.d.cp_cont_d));
            this.aMJ.dk(i);
        }
        this.cpS.onChangeSkinType(i);
        ar.l(this, r.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cpQ == null || this.cpQ.tag_code == null) {
            return 0L;
        }
        return this.cpQ.tag_code.longValue();
    }

    public void T(String str, int i) {
        if (this.aMJ != null) {
            this.aMJ.wq();
            this.aMJ.dl(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cpU.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new c(this));
        }
        this.refreshView.eW(getContext().getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gb(str);
        this.refreshView.b(view, z);
        this.refreshView.Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        if (this.refreshView != null) {
            this.refreshView.M(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj() {
        if (this.HB != null) {
            this.HB.M(this);
            this.HB = null;
        }
        if (this.cpT != null) {
            this.cpT.aig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiS() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.HB == null) {
            if (i < 0) {
                this.HB = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.HB = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.HB.tm();
        }
        this.HB.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cpU != null) {
            this.cpU.setTabInForeBackgroundState(z);
        }
    }

    public void aiT() {
        setViewForeground(false);
        if (this.cpU != null) {
            this.cpU.dB(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cpW = System.currentTimeMillis();
        if (this.cpU != null) {
            this.cpU.eZ(z);
        }
    }

    public void aio() {
        if (this.cpU != null) {
            this.cpU.update();
        }
    }

    public void reload() {
        if (this.cpR != null) {
            Us();
            this.cpR.setSelection(0);
            if (this.cpR.kw()) {
                if (this.cpU != null && this.cpU.JI() != null) {
                    this.cpU.JI().alQ();
                    this.cpU.fc(false);
                }
                this.cpR.kv();
            }
        }
    }

    public void onDestroy() {
        this.cpU.onDestroy();
    }

    public void onPause() {
        this.cpU.onPause();
    }

    public void onResume() {
        this.cpU.onResume();
    }

    public void ahK() {
        if (this.cpS != null) {
            this.cpS.notifyDataSetChanged();
        }
    }

    public void aiU() {
        if (this.cpU != null) {
            this.cpU.dB(true);
        }
        if (this.cpW > 0) {
            TiebaStatic.log(new at("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cpW) / 1000)));
            this.cpW = 0L;
        }
        bz.OH().cy(false);
    }

    public void aiV() {
        this.cpU.ajk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WJ() {
        if (this.aMJ != null && !this.aMJ.wv()) {
            this.aMJ.wp();
            this.aMJ.dl(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cpU.WJ();
    }
}
