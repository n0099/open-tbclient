package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeListView aoB;
    private List<AbsDelegateAdapter> aoz = new ArrayList();
    private b fkN;
    private c fkO;
    private e fkP;
    private f fkQ;
    private d fkR;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aoB = bdTypeListView;
        uR();
    }

    private void uR() {
        this.fkN = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fkU);
        this.fkO = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fkX);
        this.fkP = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.fkZ);
        this.fkQ = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fla);
        this.fkR = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fkY);
        this.aoz.add(this.fkN);
        this.aoz.add(this.fkO);
        this.aoz.add(this.fkP);
        this.aoz.add(this.fkQ);
        this.aoz.add(this.fkR);
        this.aoB.addAdapters(this.aoz);
    }

    public void onDestroy() {
        if (this.fkN != null) {
            this.fkN.onDestroy();
        }
        if (this.fkO != null) {
            this.fkO.onDestroy();
        }
    }
}
