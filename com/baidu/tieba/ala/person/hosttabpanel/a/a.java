package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> aSj = new ArrayList();
    private BdTypeListView aSl;
    private b gkK;
    private c gkL;
    private e gkM;
    private f gkN;
    private d gkO;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aSl = bdTypeListView;
        CY();
    }

    private void CY() {
        this.gkK = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gkR);
        this.gkL = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gkU);
        this.gkM = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gkW);
        this.gkN = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gkX);
        this.gkO = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gkV);
        this.aSj.add(this.gkK);
        this.aSj.add(this.gkL);
        this.aSj.add(this.gkM);
        this.aSj.add(this.gkN);
        this.aSj.add(this.gkO);
        this.aSl.addAdapters(this.aSj);
    }

    public void onDestroy() {
        if (this.gkK != null) {
            this.gkK.onDestroy();
        }
        if (this.gkL != null) {
            this.gkL.onDestroy();
        }
    }
}
