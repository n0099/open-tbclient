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
/* loaded from: classes2.dex */
public class a {
    private f dSA;
    private d dSB;
    private com.baidu.tieba.homepage.concern.a.b dSC;
    private com.baidu.tieba.homepage.concern.a.a dSD;
    private e dSE;
    private h dSF;
    private h dSG;
    private c dSH;
    private g dSI;
    private List<com.baidu.adp.widget.ListView.a> dSx = new ArrayList();
    private BdTypeListView dSy;
    private com.baidu.tieba.b.a dSz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dSy = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ad(context);
        bz(context);
        bdTypeListView.addAdapters(this.dSx);
    }

    private void bz(Context context) {
        this.dSz = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aKH);
        this.dSE = new e(this.mPageContext, k.TYPE);
        this.dSF = new h(this.mPageContext, l.cCn);
        this.dSG = new h(this.mPageContext, l.cCo);
        this.dSA = new f(this.mPageContext.getContext());
        this.dSB = new d(this.mPageContext.getContext());
        this.dSC = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dTG);
        this.dSD = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dTH);
        this.dSH = new c(this.mPageContext, j.TYPE);
        this.dSI = new g(this.mPageContext, k.ahE);
        this.dSx.add(this.dSz);
        this.dSx.add(this.dSE);
        this.dSx.add(this.dSF);
        this.dSx.add(this.dSG);
        this.dSx.add(this.dSA);
        this.dSx.add(this.dSB);
        this.dSx.add(this.dSC);
        this.dSx.add(this.dSD);
        this.dSx.add(this.dSH);
        this.dSx.add(this.dSI);
        iA("page_concern");
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        this.dSy.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dSy != null && (this.dSy.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dSy.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dSH.aRF = bdUniqueId;
        this.dSE.aRF = bdUniqueId;
        this.dSF.aRF = bdUniqueId;
        this.dSG.aRF = bdUniqueId;
        this.dSC.aRF = bdUniqueId;
        this.dSD.aRF = bdUniqueId;
        this.dSH.aRF = bdUniqueId;
        this.dSI.aRF = bdUniqueId;
    }

    private void iA(String str) {
        if (this.dSx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dSx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iA(str);
                }
            }
        }
    }
}
