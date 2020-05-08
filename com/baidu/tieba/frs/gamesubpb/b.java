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
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private e dvg;
    private BdTypeListView eOj;
    private a hnS;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.dvg = eVar;
        this.eOj = bdTypeListView;
        BB();
    }

    private void BB() {
        this.hnS = new a((TbPageContext) this.dvg, d.hoo);
        this.aMj.add(this.hnS);
        this.eOj.addAdapters(this.aMj);
    }

    public void setData(List<m> list) {
        if (this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0566a interfaceC0566a) {
        this.hnS.setClickListener(interfaceC0566a);
    }
}
