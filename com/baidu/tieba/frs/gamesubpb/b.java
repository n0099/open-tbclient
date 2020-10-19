package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private e eul;
    private BdTypeListView fSo;
    private a iGK;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eul = eVar;
        this.fSo = bdTypeListView;
        Le();
    }

    private void Le() {
        this.iGK = new a((TbPageContext) this.eul, d.iHg);
        this.bhH.add(this.iGK);
        this.fSo.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        if (this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0700a interfaceC0700a) {
        this.iGK.setClickListener(interfaceC0700a);
    }
}
