package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.b;
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class z extends FrameLayout {
    private com.baidu.tbadk.g.f Fn;
    private final CustomMessageListener bEF;
    private PbListView bjZ;
    private TagInfo ctE;
    private BdTypeListView ctF;
    private com.baidu.tieba.homepage.personalize.a.ad ctG;
    private com.baidu.tieba.homepage.framework.c ctH;
    private b ctI;
    private com.baidu.tieba.homepage.personalize.b.f ctJ;
    private long ctK;
    private TextView ctL;
    private b.a ctM;
    private com.baidu.tbadk.core.view.w mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.g.h refreshView;

    public BdTypeListView getListView() {
        return this.ctF;
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.ctI != null) {
            this.ctI.a(aVar, onTouchListener, viewGroup);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ctI != null) {
            this.ctI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void XC() {
        if (this.ctI != null) {
            this.ctI.XC();
        }
    }

    public void jz() {
        if (this.ctF != null) {
            this.ctF.jz();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.ctI != null) {
            this.ctI.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ctG != null) {
            this.ctG.setPageUniqueId(bdUniqueId);
        }
        if (this.ctI != null) {
            this.ctI.j(bdUniqueId);
        }
        if (this.ctJ != null) {
            this.ctJ.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bEF != null) {
            this.bEF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bEF);
        }
    }

    public z(Context context) {
        super(context);
        this.ctK = 0L;
        this.ctM = new aa(this);
        this.bEF = new ab(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.ctF = new BdTypeListView(context);
        this.ctF.setDividerHeight(0);
        this.ctF.setSelector(17170445);
        this.bjZ = new PbListView(context);
        this.bjZ.jp();
        this.bjZ.cS(u.d.cp_bg_line_c);
        this.bjZ.setTextColor(av.getColor(u.d.cp_cont_d));
        this.bjZ.cT(TbadkCoreApplication.m10getInst().getSkinType());
        this.ctF.setNextPage(this.bjZ);
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.ctF.setPullRefresh(this.mPullView);
        this.ctL = new TextView(context);
        this.ctL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(context, u.e.ds176)));
        this.ctF.f(this.ctL, 0);
        this.mPullView.S(true);
        this.mPullView.a(new ac(this));
        this.mPullView.a(new ad(this));
        this.ctF.setOnSrollToBottomListener(new ae(this));
        this.mPullView.a(new af(this));
        this.ctJ = new com.baidu.tieba.homepage.personalize.b.f();
        this.ctG = new com.baidu.tieba.homepage.personalize.a.ad(context, this.ctF);
        this.ctG.b(this.ctJ);
        this.ctI = new b(this.pageContext, this.ctF, this.ctL, this.ctG, this);
        this.ctI.a(this.ctM);
        addView(this.ctF);
        this.ctF.setRecyclerListener(new ag(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.ctH = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.ctE = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bjZ != null) {
            this.bjZ.vi();
            this.bjZ.cU(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), u.e.ds110));
        }
        this.ctI.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.ctL != null) {
            av.l(this.ctL, u.d.cp_bg_line_d);
        }
        if (this.Fn != null) {
            this.Fn.sd();
        }
        if (this.refreshView != null) {
            this.refreshView.sd();
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.bjZ != null) {
            this.bjZ.setTextColor(av.getColor(u.d.cp_cont_d));
            this.bjZ.cT(i);
        }
        this.ctG.onChangeSkinType(i);
        av.l(this, u.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.ctE == null || this.ctE.tag_code == null) {
            return 0L;
        }
        return this.ctE.tag_code.longValue();
    }

    public void V(String str, int i) {
        if (this.bjZ != null) {
            this.bjZ.vi();
            this.bjZ.cU(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), u.e.ds110));
        }
        this.ctI.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getContext(), new ah(this));
        }
        this.refreshView.eF(getContext().getResources().getDimensionPixelSize(u.e.ds280));
        this.refreshView.fV(str);
        this.refreshView.c(view, z);
        this.refreshView.Dh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        if (this.refreshView != null) {
            this.refreshView.K(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        if (this.Fn != null) {
            this.Fn.K(this);
            this.Fn = null;
        }
        if (this.ctH != null) {
            this.ctH.agM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahL() {
        if (this.refreshView != null) {
            return this.refreshView.Da();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.Fn == null) {
            if (i < 0) {
                this.Fn = new com.baidu.tbadk.g.f(getContext());
            } else {
                this.Fn = new com.baidu.tbadk.g.f(getContext(), i);
            }
            this.Fn.sd();
        }
        this.Fn.c(this, z);
    }

    public void ahM() {
        setViewForeground(false);
        if (this.ctI != null) {
            this.ctI.dn(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.ctK = System.currentTimeMillis();
        if (this.ctI != null) {
            this.ctI.eC(z);
        }
    }

    public void agU() {
        if (this.ctI != null) {
            this.ctI.update();
        }
    }

    public void reload() {
        if (this.ctF != null) {
            XC();
            this.ctF.setSelection(0);
            if (this.ctF.jB()) {
                if (this.ctI != null && this.ctI.Ij() != null) {
                    this.ctI.Ij().aWB();
                    this.ctI.eF(false);
                }
                this.ctF.jA();
            }
        }
    }

    public void onDestroy() {
        this.ctI.onDestroy();
    }

    public void onPause() {
        this.ctI.onPause();
    }

    public void agq() {
        if (this.ctG != null) {
            this.ctG.notifyDataSetChanged();
        }
    }

    public void ahN() {
        if (this.ctI != null) {
            this.ctI.dn(true);
        }
        if (this.ctK > 0) {
            TiebaStatic.log(new ay("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.ctK) / 1000)));
            this.ctK = 0L;
        }
        bw.Lf().cl(false);
    }

    public void ahO() {
        this.ctI.ahJ();
    }
}
