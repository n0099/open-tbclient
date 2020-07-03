package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> aUP = new ArrayList();
    private BdTypeListView aUR;
    private b gxJ;
    private c gxK;
    private e gxL;
    private f gxM;
    private d gxN;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aUR = bdTypeListView;
        Dz();
    }

    private void Dz() {
        this.gxJ = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gxQ);
        this.gxK = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gxT);
        this.gxL = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gxV);
        this.gxM = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gxW);
        this.gxN = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gxU);
        this.aUP.add(this.gxJ);
        this.aUP.add(this.gxK);
        this.aUP.add(this.gxL);
        this.aUP.add(this.gxM);
        this.aUP.add(this.gxN);
        this.aUR.addAdapters(this.aUP);
    }

    public void onDestroy() {
        if (this.gxJ != null) {
            this.gxJ.onDestroy();
        }
        if (this.gxK != null) {
            this.gxK.onDestroy();
        }
    }
}
