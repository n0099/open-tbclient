package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeListView bkA;
    private List<AbsDelegateAdapter> bky = new ArrayList();
    private b hAm;
    private c hAn;
    private e hAo;
    private f hAp;
    private d hAq;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bkA = bdTypeListView;
        LY();
    }

    private void LY() {
        this.hAm = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hAt);
        this.hAn = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hAw);
        this.hAo = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hAy);
        this.hAp = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hAz);
        this.hAq = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hAx);
        this.bky.add(this.hAm);
        this.bky.add(this.hAn);
        this.bky.add(this.hAo);
        this.bky.add(this.hAp);
        this.bky.add(this.hAq);
        this.bkA.addAdapters(this.bky);
    }

    public void onDestroy() {
        if (this.hAm != null) {
            this.hAm.onDestroy();
        }
        if (this.hAn != null) {
            this.hAn.onDestroy();
        }
    }
}
