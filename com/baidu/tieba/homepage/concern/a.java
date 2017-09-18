package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aTw;
    private List<com.baidu.adp.widget.ListView.a> cYO = new ArrayList();
    private com.baidu.tieba.a.d cYP;
    private e cYQ;
    private com.baidu.tieba.homepage.concern.a.b cYR;
    private com.baidu.tieba.homepage.concern.a.a cYS;
    private com.baidu.tieba.homepage.concern.a.d cYT;
    private f cYU;
    private f cYV;
    private com.baidu.tieba.homepage.concern.a.c cYW;
    private boolean cYX;
    private g cuU;
    private TbPageContext<?> mF;
    private BdUniqueId mId;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aTw = bdTypeListView;
        this.mF = (TbPageContext) i.Y(context);
        bv(context);
        bdTypeListView.addAdapters(this.cYO);
    }

    private void bv(Context context) {
        this.cYP = new com.baidu.tieba.a.d(this.mF, com.baidu.tbadk.data.e.azG);
        this.cYT = new com.baidu.tieba.homepage.concern.a.d(this.mF, l.TYPE);
        this.cYU = new f(this.mF, n.bOg);
        this.cYV = new f(this.mF, n.bOh);
        this.cYQ = new e(this.mF.getContext());
        this.cYR = new com.baidu.tieba.homepage.concern.a.b(this.mF, com.baidu.tieba.homepage.concern.b.b.cZQ);
        this.cYS = new com.baidu.tieba.homepage.concern.a.a(this.mF, com.baidu.tieba.homepage.concern.b.b.cZR);
        this.cYW = new com.baidu.tieba.homepage.concern.a.c(this.mF, k.TYPE);
        this.cuU = new g(this.mF, 1, 0L, "");
        this.cYP.setClickListener(this.cuU);
        this.cYO.add(this.cYP);
        this.cYO.add(this.cYT);
        this.cYO.add(this.cYU);
        this.cYO.add(this.cYV);
        this.cYO.add(this.cYQ);
        this.cYO.add(this.cYR);
        this.cYO.add(this.cYS);
        this.cYO.add(this.cYW);
    }

    public void bw(List<com.baidu.adp.widget.ListView.f> list) {
        this.aTw.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aTw != null && (this.aTw.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTw.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.cYW.aOu = bdUniqueId;
        this.cYT.aOu = bdUniqueId;
        this.cYU.aOu = bdUniqueId;
        this.cYV.aOu = bdUniqueId;
        this.cYR.aOu = bdUniqueId;
        this.cYS.aOu = bdUniqueId;
        this.cYW.aOu = bdUniqueId;
    }

    public void aqg() {
        if (!this.cYX) {
            this.cYX = true;
            this.cYP.k(this.mId);
        }
    }
}
