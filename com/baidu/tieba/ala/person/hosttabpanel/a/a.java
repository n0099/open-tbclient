package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> bdV = new ArrayList();
    private BdTypeListView bdX;
    private b gTv;
    private c gTw;
    private e gTx;
    private f gTy;
    private d gTz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bdX = bdTypeListView;
        JZ();
    }

    private void JZ() {
        this.gTv = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.gTC);
        this.gTw = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.gTF);
        this.gTx = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.gTH);
        this.gTy = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.gTI);
        this.gTz = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.gTG);
        this.bdV.add(this.gTv);
        this.bdV.add(this.gTw);
        this.bdV.add(this.gTx);
        this.bdV.add(this.gTy);
        this.bdV.add(this.gTz);
        this.bdX.addAdapters(this.bdV);
    }

    public void onDestroy() {
        if (this.gTv != null) {
            this.gTv.onDestroy();
        }
        if (this.gTw != null) {
            this.gTw.onDestroy();
        }
    }
}
