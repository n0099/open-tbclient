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
import com.baidu.tieba.homepage.personalize.a;
import com.baidu.tieba.homepage.personalize.a.ad;
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class s extends FrameLayout {
    private com.baidu.tbadk.g.f EN;
    private final CustomMessageListener bDv;
    private PbListView biC;
    private TagInfo cqU;
    private BdTypeListView cqV;
    private ad cqW;
    private com.baidu.tieba.homepage.framework.c cqX;
    private a cqY;
    private com.baidu.tieba.homepage.personalize.b.f cqZ;
    private long cra;
    private TextView crb;
    private a.InterfaceC0060a crc;
    private com.baidu.tbadk.core.view.w mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.g.h refreshView;

    public BdTypeListView getListView() {
        return this.cqV;
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.cqY != null) {
            this.cqY.a(aVar, onTouchListener, viewGroup);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cqY != null) {
            this.cqY.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void Xk() {
        if (this.cqY != null) {
            this.cqY.Xk();
        }
    }

    public void jA() {
        if (this.cqV != null) {
            this.cqV.jA();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cqY != null) {
            this.cqY.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cqW != null) {
            this.cqW.setPageUniqueId(bdUniqueId);
        }
        if (this.cqY != null) {
            this.cqY.j(bdUniqueId);
        }
        if (this.cqZ != null) {
            this.cqZ.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bDv != null) {
            this.bDv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bDv);
        }
    }

    public s(Context context) {
        super(context);
        this.cra = 0L;
        this.crc = new t(this);
        this.bDv = new u(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.cqV = new BdTypeListView(context);
        this.cqV.setDividerHeight(0);
        this.cqV.setSelector(17170445);
        this.biC = new PbListView(context);
        this.biC.jq();
        this.biC.cS(u.d.cp_bg_line_c);
        this.biC.setTextColor(av.getColor(u.d.cp_cont_d));
        this.biC.cT(TbadkCoreApplication.m9getInst().getSkinType());
        this.cqV.setNextPage(this.biC);
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.cqV.setPullRefresh(this.mPullView);
        this.crb = new TextView(context);
        this.crb.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(context, u.e.ds176)));
        this.cqV.f(this.crb, 0);
        this.mPullView.Q(true);
        this.mPullView.a(new v(this));
        this.mPullView.a(new w(this));
        this.cqV.setOnSrollToBottomListener(new x(this));
        this.mPullView.a(new y(this));
        this.cqZ = new com.baidu.tieba.homepage.personalize.b.f();
        this.cqW = new ad(context, this.cqV);
        this.cqW.b(this.cqZ);
        this.cqY = new a(this.pageContext, this.cqV, this.crb, this.cqW, this);
        this.cqY.a(this.crc);
        addView(this.cqV);
        this.cqV.setRecyclerListener(new z(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cqX = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cqU = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.biC != null) {
            this.biC.vi();
            this.biC.cU(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), u.e.ds110));
        }
        this.cqY.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.crb != null) {
            av.l(this.crb, u.d.cp_bg_line_d);
        }
        if (this.EN != null) {
            this.EN.se();
        }
        if (this.refreshView != null) {
            this.refreshView.se();
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.biC != null) {
            this.biC.setTextColor(av.getColor(u.d.cp_cont_d));
            this.biC.cT(i);
        }
        this.cqW.onChangeSkinType(i);
        av.l(this, u.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cqU == null && this.cqU.tag_code == null) {
            return 0L;
        }
        return this.cqU.tag_code.longValue();
    }

    public void V(String str, int i) {
        if (this.biC != null) {
            this.biC.vi();
            this.biC.cU(com.baidu.adp.lib.util.k.c(this.pageContext.getPageActivity(), u.e.ds110));
        }
        this.cqY.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getContext(), new aa(this));
        }
        this.refreshView.eF(getContext().getResources().getDimensionPixelSize(u.e.ds280));
        this.refreshView.fX(str);
        this.refreshView.c(view, z);
        this.refreshView.Di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        if (this.refreshView != null) {
            this.refreshView.K(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (this.EN != null) {
            this.EN.K(this);
            this.EN = null;
        }
        if (this.cqX != null) {
            this.cqX.agj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahd() {
        if (this.refreshView != null) {
            return this.refreshView.Db();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.EN == null) {
            if (i < 0) {
                this.EN = new com.baidu.tbadk.g.f(getContext());
            } else {
                this.EN = new com.baidu.tbadk.g.f(getContext(), i);
            }
            this.EN.se();
        }
        this.EN.c(this, z);
    }

    public void ahe() {
        setViewForeground(false);
        if (this.cqY != null) {
            this.cqY.dq(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cra = System.currentTimeMillis();
        if (this.cqY != null) {
            this.cqY.eB(z);
        }
    }

    public void agr() {
        if (this.cqY != null) {
            this.cqY.update();
        }
    }

    public void reload() {
        if (this.cqV != null) {
            Xk();
            this.cqV.setSelection(0);
            if (this.cqV.jC()) {
                if (this.cqY != null && this.cqY.Il() != null) {
                    this.cqY.Il().aTy();
                    this.cqY.eE(false);
                }
                this.cqV.jB();
            }
        }
    }

    public void onDestroy() {
        this.cqY.onDestroy();
    }

    public void afN() {
        if (this.cqW != null) {
            this.cqW.notifyDataSetChanged();
        }
    }

    public void ahf() {
        if (this.cqY != null) {
            this.cqY.dq(true);
        }
        if (this.cra > 0) {
            TiebaStatic.log(new ay("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cra) / 1000)));
            this.cra = 0L;
        }
        bw.Lg().cj(false);
    }
}
