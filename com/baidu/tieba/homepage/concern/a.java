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
    private BdTypeListView aUv;
    private List<com.baidu.adp.widget.ListView.a> cVh = new ArrayList();
    private com.baidu.tieba.a.d cVi;
    private f cVj;
    private com.baidu.tieba.homepage.concern.a.d cVk;
    private com.baidu.tieba.homepage.concern.a.b cVl;
    private com.baidu.tieba.homepage.concern.a.a cVm;
    private e cVn;
    private g cVo;
    private g cVp;
    private com.baidu.tieba.homepage.concern.a.c cVq;
    private boolean cVr;
    private com.baidu.tieba.story.g cvz;
    private TbPageContext<?> mG;
    private BdUniqueId mId;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aUv = bdTypeListView;
        this.mG = (TbPageContext) i.Y(context);
        bt(context);
        bdTypeListView.addAdapters(this.cVh);
    }

    private void bt(Context context) {
        this.cVi = new com.baidu.tieba.a.d(this.mG, com.baidu.tbadk.data.d.aza);
        this.cVn = new e(this.mG, l.TYPE);
        this.cVo = new g(this.mG, n.bNL);
        this.cVp = new g(this.mG, n.bNM);
        this.cVj = new f(this.mG.getContext());
        this.cVk = new com.baidu.tieba.homepage.concern.a.d(this.mG.getContext());
        this.cVl = new com.baidu.tieba.homepage.concern.a.b(this.mG, com.baidu.tieba.homepage.concern.b.b.cWt);
        this.cVm = new com.baidu.tieba.homepage.concern.a.a(this.mG, com.baidu.tieba.homepage.concern.b.b.cWu);
        this.cVq = new com.baidu.tieba.homepage.concern.a.c(this.mG, k.TYPE);
        this.cvz = new com.baidu.tieba.story.g(this.mG, 1, 0L, "");
        this.cVi.setClickListener(this.cvz);
        this.cVh.add(this.cVi);
        this.cVh.add(this.cVn);
        this.cVh.add(this.cVo);
        this.cVh.add(this.cVp);
        this.cVh.add(this.cVj);
        this.cVh.add(this.cVk);
        this.cVh.add(this.cVl);
        this.cVh.add(this.cVm);
        this.cVh.add(this.cVq);
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
        this.cVq.aPx = bdUniqueId;
        this.cVn.aPx = bdUniqueId;
        this.cVo.aPx = bdUniqueId;
        this.cVp.aPx = bdUniqueId;
        this.cVl.aPx = bdUniqueId;
        this.cVm.aPx = bdUniqueId;
        this.cVq.aPx = bdUniqueId;
    }

    public void aoJ() {
        if (!this.cVr) {
            this.cVr = true;
            this.cVi.j(this.mId);
        }
    }
}
