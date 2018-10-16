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
    private List<com.baidu.adp.widget.ListView.a> ehC = new ArrayList();
    private BdTypeListView ehD;
    private com.baidu.tieba.b.a ehE;
    private f ehF;
    private d ehG;
    private com.baidu.tieba.homepage.concern.a.b ehH;
    private com.baidu.tieba.homepage.concern.a.a ehI;
    private e ehJ;
    private h ehK;
    private h ehL;
    private c ehM;
    private g ehN;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.ehD = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        ct(context);
        bdTypeListView.addAdapters(this.ehC);
    }

    private void ct(Context context) {
        this.ehE = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aSw);
        this.ehJ = new e(this.mPageContext, k.TYPE);
        this.ehK = new h(this.mPageContext, l.cQu);
        this.ehL = new h(this.mPageContext, l.cQv);
        this.ehF = new f(this.mPageContext.getContext());
        this.ehG = new d(this.mPageContext.getContext());
        this.ehH = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eiN);
        this.ehI = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eiO);
        this.ehM = new c(this.mPageContext, j.TYPE);
        this.ehN = new g(this.mPageContext, k.aoZ);
        this.ehC.add(this.ehE);
        this.ehC.add(this.ehJ);
        this.ehC.add(this.ehK);
        this.ehC.add(this.ehL);
        this.ehC.add(this.ehF);
        this.ehC.add(this.ehG);
        this.ehC.add(this.ehH);
        this.ehC.add(this.ehI);
        this.ehC.add(this.ehM);
        this.ehC.add(this.ehN);
        jq("page_concern");
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        this.ehD.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.ehD != null && (this.ehD.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ehD.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ehM.aZt = bdUniqueId;
        this.ehJ.aZt = bdUniqueId;
        this.ehK.aZt = bdUniqueId;
        this.ehL.aZt = bdUniqueId;
        this.ehH.aZt = bdUniqueId;
        this.ehI.aZt = bdUniqueId;
        this.ehM.aZt = bdUniqueId;
        this.ehN.aZt = bdUniqueId;
    }

    private void jq(String str) {
        if (this.ehC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ehC) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jq(str);
                }
            }
        }
    }
}
