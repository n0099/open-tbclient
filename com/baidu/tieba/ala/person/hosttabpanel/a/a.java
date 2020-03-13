package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> asF = new ArrayList();
    private BdTypeListView asH;
    private b fqP;
    private c fqQ;
    private e fqR;
    private f fqS;
    private d fqT;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.asH = bdTypeListView;
        wM();
    }

    private void wM() {
        this.fqP = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fqW);
        this.fqQ = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fqZ);
        this.fqR = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.frb);
        this.fqS = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.frc);
        this.fqT = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fra);
        this.asF.add(this.fqP);
        this.asF.add(this.fqQ);
        this.asF.add(this.fqR);
        this.asF.add(this.fqS);
        this.asF.add(this.fqT);
        this.asH.addAdapters(this.asF);
    }

    public void onDestroy() {
        if (this.fqP != null) {
            this.fqP.onDestroy();
        }
        if (this.fqQ != null) {
            this.fqQ.onDestroy();
        }
    }
}
