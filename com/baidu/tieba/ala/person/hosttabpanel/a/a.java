package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> bhH = new ArrayList();
    private BdTypeListView bhJ;
    private b hit;
    private c hiu;
    private e hiv;
    private f hiw;
    private d hix;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bhJ = bdTypeListView;
        Le();
    }

    private void Le() {
        this.hit = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hiA);
        this.hiu = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hiD);
        this.hiv = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hiF);
        this.hiw = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hiG);
        this.hix = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hiE);
        this.bhH.add(this.hit);
        this.bhH.add(this.hiu);
        this.bhH.add(this.hiv);
        this.bhH.add(this.hiw);
        this.bhH.add(this.hix);
        this.bhJ.addAdapters(this.bhH);
    }

    public void onDestroy() {
        if (this.hit != null) {
            this.hit.onDestroy();
        }
        if (this.hiu != null) {
            this.hiu.onDestroy();
        }
    }
}
