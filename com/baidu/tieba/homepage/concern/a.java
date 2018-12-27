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
    private List<com.baidu.adp.widget.ListView.a> esI = new ArrayList();
    private BdTypeListView esJ;
    private com.baidu.tieba.b.a esK;
    private f esL;
    private d esM;
    private com.baidu.tieba.homepage.concern.a.b esN;
    private com.baidu.tieba.homepage.concern.a.a esO;
    private e esP;
    private h esQ;
    private h esR;
    private c esS;
    private g esT;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.esJ = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        cs(context);
        bdTypeListView.addAdapters(this.esI);
    }

    private void cs(Context context) {
        this.esK = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aWM);
        this.esP = new e(this.mPageContext, k.TYPE);
        this.esQ = new h(this.mPageContext, l.daZ);
        this.esR = new h(this.mPageContext, l.dba);
        this.esL = new f(this.mPageContext.getContext());
        this.esM = new d(this.mPageContext.getContext());
        this.esN = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.etU);
        this.esO = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.etV);
        this.esS = new c(this.mPageContext, j.TYPE);
        this.esT = new g(this.mPageContext, k.atn);
        this.esI.add(this.esK);
        this.esI.add(this.esP);
        this.esI.add(this.esQ);
        this.esI.add(this.esR);
        this.esI.add(this.esL);
        this.esI.add(this.esM);
        this.esI.add(this.esN);
        this.esI.add(this.esO);
        this.esI.add(this.esS);
        this.esI.add(this.esT);
        jL("page_concern");
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        this.esJ.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.esJ != null && (this.esJ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.esJ.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.esS.bdH = bdUniqueId;
        this.esP.bdH = bdUniqueId;
        this.esQ.bdH = bdUniqueId;
        this.esR.bdH = bdUniqueId;
        this.esN.bdH = bdUniqueId;
        this.esO.bdH = bdUniqueId;
        this.esS.bdH = bdUniqueId;
        this.esT.bdH = bdUniqueId;
    }

    private void jL(String str) {
        if (this.esI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.esI) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jL(str);
                }
            }
        }
    }
}
