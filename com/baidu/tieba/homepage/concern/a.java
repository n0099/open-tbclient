package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
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
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> fFA = new ArrayList();
    private BdTypeListView fFB;
    private com.baidu.tieba.b.a fFC;
    private f fFD;
    private d fFE;
    private com.baidu.tieba.homepage.concern.a.b fFF;
    private com.baidu.tieba.homepage.concern.a.a fFG;
    private e fFH;
    private h fFI;
    private h fFJ;
    private c fFK;
    private g fFL;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.fFB = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        dN(context);
        bdTypeListView.addAdapters(this.fFA);
    }

    private void dN(Context context) {
        this.fFC = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cgS);
        this.fFH = new e(this.mPageContext, k.TYPE);
        this.fFI = new h(this.mPageContext, l.elw);
        this.fFJ = new h(this.mPageContext, l.elx);
        this.fFD = new f(this.mPageContext.getContext());
        this.fFE = new d(this.mPageContext.getContext());
        this.fFF = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fGM);
        this.fFG = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fGN);
        this.fFK = new c(this.mPageContext, j.TYPE);
        this.fFL = new g(this.mPageContext, k.bBl);
        this.fFA.add(this.fFC);
        this.fFA.add(this.fFH);
        this.fFA.add(this.fFI);
        this.fFA.add(this.fFJ);
        this.fFA.add(this.fFD);
        this.fFA.add(this.fFE);
        this.fFA.add(this.fFF);
        this.fFA.add(this.fFG);
        this.fFA.add(this.fFK);
        this.fFA.add(this.fFL);
        qM("page_concern");
    }

    public void ay(List<m> list) {
        this.fFB.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fFB != null && (this.fFB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fFB.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fFK.coa = bdUniqueId;
        this.fFH.coa = bdUniqueId;
        this.fFI.coa = bdUniqueId;
        this.fFJ.coa = bdUniqueId;
        this.fFF.coa = bdUniqueId;
        this.fFG.coa = bdUniqueId;
        this.fFK.coa = bdUniqueId;
        this.fFL.coa = bdUniqueId;
    }

    private void qM(String str) {
        if (this.fFA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFA) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
                }
            }
        }
    }
}
