package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<AbsDelegateAdapter> agQ = new ArrayList();
    private BdTypeListView agS;
    private b eui;
    private c euj;
    private e euk;
    private f eul;
    private d eum;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.agS = bdTypeListView;
        sX();
    }

    private void sX() {
        this.eui = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.eup);
        this.euj = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.eus);
        this.euk = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.euu);
        this.eul = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.euv);
        this.eum = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.eut);
        this.agQ.add(this.eui);
        this.agQ.add(this.euj);
        this.agQ.add(this.euk);
        this.agQ.add(this.eul);
        this.agQ.add(this.eum);
        this.agS.addAdapters(this.agQ);
    }

    public void onDestroy() {
        if (this.eui != null) {
            this.eui.onDestroy();
        }
        if (this.euj != null) {
            this.euj.onDestroy();
        }
    }
}
