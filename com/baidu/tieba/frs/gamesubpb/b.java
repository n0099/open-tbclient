package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private e efO;
    private BdTypeListView fCT;
    private a ikP;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.efO = eVar;
        this.fCT = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.ikP = new a((TbPageContext) this.efO, d.ill);
        this.bbw.add(this.ikP);
        this.fCT.addAdapters(this.bbw);
    }

    public void setData(List<q> list) {
        if (this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0685a interfaceC0685a) {
        this.ikP.setClickListener(interfaceC0685a);
    }
}
