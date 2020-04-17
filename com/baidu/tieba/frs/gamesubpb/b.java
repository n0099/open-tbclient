package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private e dvc;
    private BdTypeListView eOe;
    private a hnM;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.dvc = eVar;
        this.eOe = bdTypeListView;
        BC();
    }

    private void BC() {
        this.hnM = new a((TbPageContext) this.dvc, d.hoi);
        this.aMd.add(this.hnM);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0545a interfaceC0545a) {
        this.hnM.setClickListener(interfaceC0545a);
    }
}
