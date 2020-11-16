package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> biN = new ArrayList();
    private BdTypeListView biP;
    private b hzT;
    private c hzU;
    private e hzV;
    private f hzW;
    private d hzX;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.biP = bdTypeListView;
        Lp();
    }

    private void Lp() {
        this.hzT = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hAa);
        this.hzU = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hAd);
        this.hzV = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hAf);
        this.hzW = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hAg);
        this.hzX = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hAe);
        this.biN.add(this.hzT);
        this.biN.add(this.hzU);
        this.biN.add(this.hzV);
        this.biN.add(this.hzW);
        this.biN.add(this.hzX);
        this.biP.addAdapters(this.biN);
    }

    public void onDestroy() {
        if (this.hzT != null) {
            this.hzT.onDestroy();
        }
        if (this.hzU != null) {
            this.hzU.onDestroy();
        }
    }
}
