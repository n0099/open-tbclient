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
    private BdTypeListView aTO;
    private List<com.baidu.adp.widget.ListView.a> cRC = new ArrayList();
    private com.baidu.tieba.a.d cRD;
    private com.baidu.tieba.homepage.concern.a.d cRE;
    private com.baidu.tieba.homepage.concern.a.a cRF;
    private com.baidu.tieba.homepage.concern.a.c cRG;
    private e cRH;
    private e cRI;
    private com.baidu.tieba.homepage.concern.a.b cRJ;
    private g cnx;
    private TbPageContext<?> oV;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aTO = bdTypeListView;
        this.oV = (TbPageContext) i.aa(context);
        bm(context);
        bdTypeListView.addAdapters(this.cRC);
    }

    private void bm(Context context) {
        this.cRD = new com.baidu.tieba.a.d(this.oV, com.baidu.tbadk.data.e.aAx);
        this.cRG = new com.baidu.tieba.homepage.concern.a.c(this.oV, l.TYPE);
        this.cRH = new e(this.oV, n.bKw);
        this.cRI = new e(this.oV, n.bKx);
        this.cRE = new com.baidu.tieba.homepage.concern.a.d(this.oV.getContext());
        this.cRF = new com.baidu.tieba.homepage.concern.a.a(this.oV);
        this.cRJ = new com.baidu.tieba.homepage.concern.a.b(this.oV, k.TYPE);
        this.cnx = new g(this.oV, this.oV.getUniqueId(), 1, 0L, "");
        this.cRD.setClickListener(this.cnx);
        this.cRC.add(this.cRD);
        this.cRC.add(this.cRG);
        this.cRC.add(this.cRH);
        this.cRC.add(this.cRI);
        this.cRC.add(this.cRE);
        this.cRC.add(this.cRF);
        this.cRC.add(this.cRJ);
    }

    public void br(List<f> list) {
        this.aTO.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aTO != null && (this.aTO.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTO.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }
}
