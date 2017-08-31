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
    private BdTypeListView aTz;
    private List<com.baidu.adp.widget.ListView.a> cXU = new ArrayList();
    private com.baidu.tieba.a.d cXV;
    private e cXW;
    private com.baidu.tieba.homepage.concern.a.b cXX;
    private com.baidu.tieba.homepage.concern.a.a cXY;
    private com.baidu.tieba.homepage.concern.a.d cXZ;
    private f cYa;
    private f cYb;
    private com.baidu.tieba.homepage.concern.a.c cYc;
    private boolean cYd;
    private g cuc;
    private TbPageContext<?> mF;
    private BdUniqueId mId;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aTz = bdTypeListView;
        this.mF = (TbPageContext) i.X(context);
        bu(context);
        bdTypeListView.addAdapters(this.cXU);
    }

    private void bu(Context context) {
        this.cXV = new com.baidu.tieba.a.d(this.mF, com.baidu.tbadk.data.e.azJ);
        this.cXZ = new com.baidu.tieba.homepage.concern.a.d(this.mF, l.TYPE);
        this.cYa = new f(this.mF, n.bNp);
        this.cYb = new f(this.mF, n.bNq);
        this.cXW = new e(this.mF.getContext());
        this.cXX = new com.baidu.tieba.homepage.concern.a.b(this.mF, com.baidu.tieba.homepage.concern.b.b.cYW);
        this.cXY = new com.baidu.tieba.homepage.concern.a.a(this.mF, com.baidu.tieba.homepage.concern.b.b.cYX);
        this.cYc = new com.baidu.tieba.homepage.concern.a.c(this.mF, k.TYPE);
        this.cuc = new g(this.mF, 1, 0L, "");
        this.cXV.setClickListener(this.cuc);
        this.cXU.add(this.cXV);
        this.cXU.add(this.cXZ);
        this.cXU.add(this.cYa);
        this.cXU.add(this.cYb);
        this.cXU.add(this.cXW);
        this.cXU.add(this.cXX);
        this.cXU.add(this.cXY);
        this.cXU.add(this.cYc);
    }

    public void bv(List<com.baidu.adp.widget.ListView.f> list) {
        this.aTz.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aTz != null && (this.aTz.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTz.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.cYc.aOx = bdUniqueId;
        this.cXZ.aOx = bdUniqueId;
        this.cYa.aOx = bdUniqueId;
        this.cYb.aOx = bdUniqueId;
        this.cXX.aOx = bdUniqueId;
        this.cXY.aOx = bdUniqueId;
        this.cYc.aOx = bdUniqueId;
    }

    public void apV() {
        if (!this.cYd) {
            this.cYd = true;
            this.cXV.k(this.mId);
        }
    }
}
