package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<AbsDelegateAdapter> bbu = new ArrayList();
    private BdTypeListView bbw;
    private b gPJ;
    private c gPK;
    private e gPL;
    private f gPM;
    private d gPN;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bbw = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.gPJ = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gPQ);
        this.gPK = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gPT);
        this.gPL = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gPV);
        this.gPM = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gPW);
        this.gPN = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gPU);
        this.bbu.add(this.gPJ);
        this.bbu.add(this.gPK);
        this.bbu.add(this.gPL);
        this.bbu.add(this.gPM);
        this.bbu.add(this.gPN);
        this.bbw.addAdapters(this.bbu);
    }

    public void onDestroy() {
        if (this.gPJ != null) {
            this.gPJ.onDestroy();
        }
        if (this.gPK != null) {
            this.gPK.onDestroy();
        }
    }
}
