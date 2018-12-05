package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.concern.a.c;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> epR = new ArrayList();
    private BdTypeListView epS;
    private com.baidu.tieba.b.a epT;
    private f epU;
    private d epV;
    private com.baidu.tieba.homepage.concern.a.b epW;
    private com.baidu.tieba.homepage.concern.a.a epX;
    private e epY;
    private h epZ;
    private h eqa;
    private c eqb;
    private g eqc;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.epS = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        cs(context);
        bdTypeListView.addAdapters(this.epR);
    }

    private void cs(Context context) {
        this.epT = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aWJ);
        this.epY = new e(this.mPageContext, k.TYPE);
        this.epZ = new h(this.mPageContext, l.cYh);
        this.eqa = new h(this.mPageContext, l.cYi);
        this.epU = new f(this.mPageContext.getContext());
        this.epV = new d(this.mPageContext.getContext());
        this.epW = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.erc);
        this.epX = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.erd);
        this.eqb = new c(this.mPageContext, j.TYPE);
        this.eqc = new g(this.mPageContext, k.atn);
        this.epR.add(this.epT);
        this.epR.add(this.epY);
        this.epR.add(this.epZ);
        this.epR.add(this.eqa);
        this.epR.add(this.epU);
        this.epR.add(this.epV);
        this.epR.add(this.epW);
        this.epR.add(this.epX);
        this.epR.add(this.eqb);
        this.epR.add(this.eqc);
        jK("page_concern");
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        this.epS.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.epS != null && (this.epS.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.epS.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eqb.bdE = bdUniqueId;
        this.epY.bdE = bdUniqueId;
        this.epZ.bdE = bdUniqueId;
        this.eqa.bdE = bdUniqueId;
        this.epW.bdE = bdUniqueId;
        this.epX.bdE = bdUniqueId;
        this.eqb.bdE = bdUniqueId;
        this.eqc.bdE = bdUniqueId;
    }

    private void jK(String str) {
        if (this.epR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.epR) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jK(str);
                }
            }
        }
    }
}
