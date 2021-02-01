package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<AbsDelegateAdapter> bns = new ArrayList();
    private BdTypeListView bnu;
    private b hVA;
    private c hVB;
    private e hVC;
    private f hVD;
    private d hVE;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bnu = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.hVA = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hVH);
        this.hVB = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hVK);
        this.hVC = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hVM);
        this.hVD = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hVN);
        this.hVE = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hVL);
        this.bns.add(this.hVA);
        this.bns.add(this.hVB);
        this.bns.add(this.hVC);
        this.bns.add(this.hVD);
        this.bns.add(this.hVE);
        this.bnu.addAdapters(this.bns);
    }

    public void onDestroy() {
        if (this.hVA != null) {
            this.hVA.onDestroy();
        }
        if (this.hVB != null) {
            this.hVB.onDestroy();
        }
    }
}
