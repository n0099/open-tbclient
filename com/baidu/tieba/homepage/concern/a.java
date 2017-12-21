package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.h;
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aXC;
    private g cME;
    private com.baidu.tieba.homepage.concern.a.b dnA;
    private com.baidu.tieba.homepage.concern.a.a dnB;
    private e dnC;
    private h dnD;
    private h dnE;
    private com.baidu.tieba.homepage.concern.a.c dnF;
    private com.baidu.tieba.homepage.concern.a.g dnG;
    private boolean dnH;
    private List<com.baidu.adp.widget.ListView.a> dnw = new ArrayList();
    private f dnx;
    private com.baidu.tieba.homepage.concern.a.f dny;
    private com.baidu.tieba.homepage.concern.a.d dnz;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aXC = bdTypeListView;
        this.mPageContext = (TbPageContext) i.Y(context);
        bu(context);
        bdTypeListView.addAdapters(this.dnw);
    }

    private void bu(Context context) {
        this.dnx = new f(this.mPageContext, com.baidu.tbadk.data.f.aAp);
        this.dnC = new e(this.mPageContext, l.TYPE);
        this.dnD = new h(this.mPageContext, n.cec);
        this.dnE = new h(this.mPageContext, n.ced);
        this.dny = new com.baidu.tieba.homepage.concern.a.f(this.mPageContext.getContext());
        this.dnz = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.dnA = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.doI);
        this.dnB = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.doJ);
        this.dnF = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.dnG = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, l.YK);
        this.cME = new g(this.mPageContext, 1, 0L, "");
        this.dnx.setClickListener(this.cME);
        this.dnw.add(this.dnx);
        this.dnw.add(this.dnC);
        this.dnw.add(this.dnD);
        this.dnw.add(this.dnE);
        this.dnw.add(this.dny);
        this.dnw.add(this.dnz);
        this.dnw.add(this.dnA);
        this.dnw.add(this.dnB);
        this.dnw.add(this.dnF);
        this.dnw.add(this.dnG);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        this.aXC.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aXC != null && (this.aXC.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXC.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.dnF.aSB = bdUniqueId;
        this.dnC.aSB = bdUniqueId;
        this.dnD.aSB = bdUniqueId;
        this.dnE.aSB = bdUniqueId;
        this.dnA.aSB = bdUniqueId;
        this.dnB.aSB = bdUniqueId;
        this.dnF.aSB = bdUniqueId;
        this.dnG.aSB = bdUniqueId;
    }

    public void atx() {
        if (!this.dnH) {
            this.dnH = true;
            this.dnx.j(this.mId);
        }
    }
}
