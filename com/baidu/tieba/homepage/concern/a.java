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
    private BdTypeListView aSB;
    private TbPageContext<?> ako;
    private List<com.baidu.adp.widget.ListView.a> cOk = new ArrayList();
    private com.baidu.tieba.a.d cOl;
    private com.baidu.tieba.homepage.concern.a.d cOm;
    private com.baidu.tieba.homepage.concern.a.a cOn;
    private com.baidu.tieba.homepage.concern.a.c cOo;
    private e cOp;
    private e cOq;
    private com.baidu.tieba.homepage.concern.a.b cOr;
    private g clC;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aSB = bdTypeListView;
        this.ako = (TbPageContext) i.Z(context);
        bm(context);
        bdTypeListView.addAdapters(this.cOk);
    }

    private void bm(Context context) {
        this.cOl = new com.baidu.tieba.a.d(this.ako, com.baidu.tbadk.data.e.azf);
        this.cOo = new com.baidu.tieba.homepage.concern.a.c(this.ako, l.TYPE);
        this.cOp = new e(this.ako, n.bID);
        this.cOq = new e(this.ako, n.bIE);
        this.cOm = new com.baidu.tieba.homepage.concern.a.d(this.ako.getContext());
        this.cOn = new com.baidu.tieba.homepage.concern.a.a(this.ako);
        this.cOr = new com.baidu.tieba.homepage.concern.a.b(this.ako, k.TYPE);
        this.clC = new g(this.ako, this.ako.getUniqueId(), 1, 0L, "");
        this.cOl.setClickListener(this.clC);
        this.cOk.add(this.cOl);
        this.cOk.add(this.cOo);
        this.cOk.add(this.cOp);
        this.cOk.add(this.cOq);
        this.cOk.add(this.cOm);
        this.cOk.add(this.cOn);
        this.cOk.add(this.cOr);
    }

    public void bo(List<f> list) {
        this.aSB.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aSB != null && (this.aSB.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aSB.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }
}
