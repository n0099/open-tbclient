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
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aUv;
    private g cDm;
    private List<com.baidu.adp.widget.ListView.a> ddI = new ArrayList();
    private f ddJ;
    private com.baidu.tieba.homepage.concern.a.f ddK;
    private com.baidu.tieba.homepage.concern.a.d ddL;
    private com.baidu.tieba.homepage.concern.a.b ddM;
    private com.baidu.tieba.homepage.concern.a.a ddN;
    private e ddO;
    private com.baidu.tieba.homepage.concern.a.g ddP;
    private com.baidu.tieba.homepage.concern.a.g ddQ;
    private com.baidu.tieba.homepage.concern.a.c ddR;
    private boolean ddS;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aUv = bdTypeListView;
        this.mPageContext = (TbPageContext) i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.ddI);
    }

    private void bs(Context context) {
        this.ddJ = new f(this.mPageContext, com.baidu.tbadk.data.f.azG);
        this.ddO = new e(this.mPageContext, l.TYPE);
        this.ddP = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, n.bVq);
        this.ddQ = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, n.bVr);
        this.ddK = new com.baidu.tieba.homepage.concern.a.f(this.mPageContext.getContext());
        this.ddL = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.ddM = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.deR);
        this.ddN = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.deS);
        this.ddR = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.cDm = new g(this.mPageContext, 1, 0L, "");
        this.ddJ.setClickListener(this.cDm);
        this.ddI.add(this.ddJ);
        this.ddI.add(this.ddO);
        this.ddI.add(this.ddP);
        this.ddI.add(this.ddQ);
        this.ddI.add(this.ddK);
        this.ddI.add(this.ddL);
        this.ddI.add(this.ddM);
        this.ddI.add(this.ddN);
        this.ddI.add(this.ddR);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        this.aUv.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aUv != null && (this.aUv.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUv.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.ddR.aPy = bdUniqueId;
        this.ddO.aPy = bdUniqueId;
        this.ddP.aPy = bdUniqueId;
        this.ddQ.aPy = bdUniqueId;
        this.ddM.aPy = bdUniqueId;
        this.ddN.aPy = bdUniqueId;
        this.ddR.aPy = bdUniqueId;
    }

    public void arv() {
        if (!this.ddS) {
            this.ddS = true;
            this.ddJ.j(this.mId);
        }
    }
}
