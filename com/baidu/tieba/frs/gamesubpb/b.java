package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private e cRA;
    private BdTypeListView efW;
    private a gBe;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cRA = eVar;
        this.efW = bdTypeListView;
        vi();
    }

    private void vi() {
        this.gBe = new a((TbPageContext) this.cRA, d.gBA);
        this.apl.add(this.gBe);
        this.efW.addAdapters(this.apl);
    }

    public void setData(List<m> list) {
        if (this.efW != null) {
            this.efW.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0501a interfaceC0501a) {
        this.gBe.setClickListener(interfaceC0501a);
    }
}
