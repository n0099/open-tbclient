package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> aWf = new ArrayList();
    private BdTypeListView aWh;
    private b gDk;
    private c gDl;
    private e gDm;
    private f gDn;
    private d gDo;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aWh = bdTypeListView;
        DS();
    }

    private void DS() {
        this.gDk = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gDr);
        this.gDl = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gDu);
        this.gDm = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gDw);
        this.gDn = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gDx);
        this.gDo = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gDv);
        this.aWf.add(this.gDk);
        this.aWf.add(this.gDl);
        this.aWf.add(this.gDm);
        this.aWf.add(this.gDn);
        this.aWf.add(this.gDo);
        this.aWh.addAdapters(this.aWf);
    }

    public void onDestroy() {
        if (this.gDk != null) {
            this.gDk.onDestroy();
        }
        if (this.gDl != null) {
            this.gDl.onDestroy();
        }
    }
}
