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
    private b gkV;
    private c gkW;
    private e gkX;
    private f gkY;
    private d gkZ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aSl = bdTypeListView;
        CY();
    }

    private void CY() {
        this.gkV = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.glc);
        this.gkW = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.glf);
        this.gkX = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.glh);
        this.gkY = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gli);
        this.gkZ = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.glg);
        this.aSj.add(this.gkV);
        this.aSj.add(this.gkW);
        this.aSj.add(this.gkX);
        this.aSj.add(this.gkY);
        this.aSj.add(this.gkZ);
        this.aSl.addAdapters(this.aSj);
    }

    public void onDestroy() {
        if (this.gkV != null) {
            this.gkV.onDestroy();
        }
        if (this.gkW != null) {
            this.gkW.onDestroy();
        }
    }
}
