package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private e ceS;
    private BdTypeListView duK;
    private a fJF;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.ceS = eVar;
        this.duK = bdTypeListView;
        sY();
    }

    private void sY() {
        this.fJF = new a((TbPageContext) this.ceS, d.fKb);
        this.agy.add(this.fJF);
        this.duK.addAdapters(this.agy);
    }

    public void setData(List<m> list) {
        if (this.duK != null) {
            this.duK.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0409a interfaceC0409a) {
        this.fJF.setClickListener(interfaceC0409a);
    }
}
