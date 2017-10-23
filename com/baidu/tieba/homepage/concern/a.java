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
import com.baidu.tieba.homepage.concern.a.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aUi;
    private List<com.baidu.adp.widget.ListView.a> cUV = new ArrayList();
    private com.baidu.tieba.a.d cUW;
    private f cUX;
    private com.baidu.tieba.homepage.concern.a.d cUY;
    private com.baidu.tieba.homepage.concern.a.b cUZ;
    private com.baidu.tieba.homepage.concern.a.a cVa;
    private e cVb;
    private g cVc;
    private g cVd;
    private com.baidu.tieba.homepage.concern.a.c cVe;
    private boolean cVf;
    private com.baidu.tieba.story.g cvn;
    private TbPageContext<?> mH;
    private BdUniqueId mId;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aUi = bdTypeListView;
        this.mH = (TbPageContext) i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.cUV);
    }

    private void bs(Context context) {
        this.cUW = new com.baidu.tieba.a.d(this.mH, com.baidu.tbadk.data.d.ayO);
        this.cVb = new e(this.mH, l.TYPE);
        this.cVc = new g(this.mH, n.bNz);
        this.cVd = new g(this.mH, n.bNA);
        this.cUX = new f(this.mH.getContext());
        this.cUY = new com.baidu.tieba.homepage.concern.a.d(this.mH.getContext());
        this.cUZ = new com.baidu.tieba.homepage.concern.a.b(this.mH, com.baidu.tieba.homepage.concern.b.b.cWh);
        this.cVa = new com.baidu.tieba.homepage.concern.a.a(this.mH, com.baidu.tieba.homepage.concern.b.b.cWi);
        this.cVe = new com.baidu.tieba.homepage.concern.a.c(this.mH, k.TYPE);
        this.cvn = new com.baidu.tieba.story.g(this.mH, 1, 0L, "");
        this.cUW.setClickListener(this.cvn);
        this.cUV.add(this.cUW);
        this.cUV.add(this.cVb);
        this.cUV.add(this.cVc);
        this.cUV.add(this.cVd);
        this.cUV.add(this.cUX);
        this.cUV.add(this.cUY);
        this.cUV.add(this.cUZ);
        this.cUV.add(this.cVa);
        this.cUV.add(this.cVe);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        this.aUi.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aUi != null && (this.aUi.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.cVe.aPk = bdUniqueId;
        this.cVb.aPk = bdUniqueId;
        this.cVc.aPk = bdUniqueId;
        this.cVd.aPk = bdUniqueId;
        this.cUZ.aPk = bdUniqueId;
        this.cVa.aPk = bdUniqueId;
        this.cVe.aPk = bdUniqueId;
    }

    public void aoE() {
        if (!this.cVf) {
            this.cVf = true;
            this.cUW.j(this.mId);
        }
    }
}
