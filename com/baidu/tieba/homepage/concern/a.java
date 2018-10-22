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
    private List<com.baidu.adp.widget.ListView.a> ehD = new ArrayList();
    private BdTypeListView ehE;
    private com.baidu.tieba.b.a ehF;
    private f ehG;
    private d ehH;
    private com.baidu.tieba.homepage.concern.a.b ehI;
    private com.baidu.tieba.homepage.concern.a.a ehJ;
    private e ehK;
    private h ehL;
    private h ehM;
    private c ehN;
    private g ehO;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.ehE = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        ct(context);
        bdTypeListView.addAdapters(this.ehD);
    }

    private void ct(Context context) {
        this.ehF = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aSw);
        this.ehK = new e(this.mPageContext, k.TYPE);
        this.ehL = new h(this.mPageContext, l.cQu);
        this.ehM = new h(this.mPageContext, l.cQv);
        this.ehG = new f(this.mPageContext.getContext());
        this.ehH = new d(this.mPageContext.getContext());
        this.ehI = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eiO);
        this.ehJ = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eiP);
        this.ehN = new c(this.mPageContext, j.TYPE);
        this.ehO = new g(this.mPageContext, k.aoZ);
        this.ehD.add(this.ehF);
        this.ehD.add(this.ehK);
        this.ehD.add(this.ehL);
        this.ehD.add(this.ehM);
        this.ehD.add(this.ehG);
        this.ehD.add(this.ehH);
        this.ehD.add(this.ehI);
        this.ehD.add(this.ehJ);
        this.ehD.add(this.ehN);
        this.ehD.add(this.ehO);
        jq("page_concern");
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        this.ehE.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.ehE != null && (this.ehE.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ehE.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ehN.aZt = bdUniqueId;
        this.ehK.aZt = bdUniqueId;
        this.ehL.aZt = bdUniqueId;
        this.ehM.aZt = bdUniqueId;
        this.ehI.aZt = bdUniqueId;
        this.ehJ.aZt = bdUniqueId;
        this.ehN.aZt = bdUniqueId;
        this.ehO.aZt = bdUniqueId;
    }

    private void jq(String str) {
        if (this.ehD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ehD) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jq(str);
                }
            }
        }
    }
}
