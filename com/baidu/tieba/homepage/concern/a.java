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
    private BdTypeListView aTP;
    private List<com.baidu.adp.widget.ListView.a> cRC = new ArrayList();
    private com.baidu.tieba.a.d cRD;
    private com.baidu.tieba.homepage.concern.a.d cRE;
    private com.baidu.tieba.homepage.concern.a.a cRF;
    private com.baidu.tieba.homepage.concern.a.c cRG;
    private e cRH;
    private e cRI;
    private com.baidu.tieba.homepage.concern.a.b cRJ;
    private g cny;
    private TbPageContext<?> oW;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aTP = bdTypeListView;
        this.oW = (TbPageContext) i.aa(context);
        bm(context);
        bdTypeListView.addAdapters(this.cRC);
    }

    private void bm(Context context) {
        this.cRD = new com.baidu.tieba.a.d(this.oW, com.baidu.tbadk.data.e.aAy);
        this.cRG = new com.baidu.tieba.homepage.concern.a.c(this.oW, l.TYPE);
        this.cRH = new e(this.oW, n.bKx);
        this.cRI = new e(this.oW, n.bKy);
        this.cRE = new com.baidu.tieba.homepage.concern.a.d(this.oW.getContext());
        this.cRF = new com.baidu.tieba.homepage.concern.a.a(this.oW);
        this.cRJ = new com.baidu.tieba.homepage.concern.a.b(this.oW, k.TYPE);
        this.cny = new g(this.oW, this.oW.getUniqueId(), 1, 0L, "");
        this.cRD.setClickListener(this.cny);
        this.cRC.add(this.cRD);
        this.cRC.add(this.cRG);
        this.cRC.add(this.cRH);
        this.cRC.add(this.cRI);
        this.cRC.add(this.cRE);
        this.cRC.add(this.cRF);
        this.cRC.add(this.cRJ);
    }

    public void br(List<f> list) {
        this.aTP.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aTP != null && (this.aTP.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTP.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }
}
