package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private e dJb;
    private BdTypeListView faQ;
    private a hCG;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.dJb = eVar;
        this.faQ = bdTypeListView;
        CY();
    }

    private void CY() {
        this.hCG = new a((TbPageContext) this.dJb, d.hDc);
        this.aSj.add(this.hCG);
        this.faQ.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (this.faQ != null) {
            this.faQ.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0616a interfaceC0616a) {
        this.hCG.setClickListener(interfaceC0616a);
    }
}
