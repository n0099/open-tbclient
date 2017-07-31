package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aTN;
    private TbPageContext<?> alI;
    private List<com.baidu.adp.widget.ListView.a> cPF = new ArrayList();
    private com.baidu.tieba.a.d cPG;
    private com.baidu.tieba.homepage.concern.a.d cPH;
    private com.baidu.tieba.homepage.concern.a.a cPI;
    private com.baidu.tieba.homepage.concern.a.c cPJ;
    private e cPK;
    private e cPL;
    private com.baidu.tieba.homepage.concern.a.b cPM;
    private g cmK;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aTN = bdTypeListView;
        this.alI = (TbPageContext) i.aa(context);
        bm(context);
        bdTypeListView.addAdapters(this.cPF);
    }

    private void bm(Context context) {
        this.cPG = new com.baidu.tieba.a.d(this.alI, com.baidu.tbadk.data.e.aAw);
        this.cPJ = new com.baidu.tieba.homepage.concern.a.c(this.alI, l.TYPE);
        this.cPK = new e(this.alI, n.bJN);
        this.cPL = new e(this.alI, n.bJO);
        this.cPH = new com.baidu.tieba.homepage.concern.a.d(this.alI.getContext());
        this.cPI = new com.baidu.tieba.homepage.concern.a.a(this.alI);
        this.cPM = new com.baidu.tieba.homepage.concern.a.b(this.alI, k.TYPE);
        this.cmK = new g(this.alI, this.alI.getUniqueId(), 1, 0L, "");
        this.cPG.setClickListener(this.cmK);
        this.cPF.add(this.cPG);
        this.cPF.add(this.cPJ);
        this.cPF.add(this.cPK);
        this.cPF.add(this.cPL);
        this.cPF.add(this.cPH);
        this.cPF.add(this.cPI);
        this.cPF.add(this.cPM);
    }

    public void bo(List<f> list) {
        this.aTN.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aTN != null && (this.aTN.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }
}
