package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<AbsDelegateAdapter> bbw = new ArrayList();
    private BdTypeListView bby;
    private b gPN;
    private c gPO;
    private e gPP;
    private f gPQ;
    private d gPR;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bby = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.gPN = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gPU);
        this.gPO = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gPX);
        this.gPP = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gPZ);
        this.gPQ = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gQa);
        this.gPR = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gPY);
        this.bbw.add(this.gPN);
        this.bbw.add(this.gPO);
        this.bbw.add(this.gPP);
        this.bbw.add(this.gPQ);
        this.bbw.add(this.gPR);
        this.bby.addAdapters(this.bbw);
    }

    public void onDestroy() {
        if (this.gPN != null) {
            this.gPN.onDestroy();
        }
        if (this.gPO != null) {
            this.gPO.onDestroy();
        }
    }
}
