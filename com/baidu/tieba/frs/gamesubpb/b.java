package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private f eTl;
    private BdTypeListView gwr;
    private a jvj;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.eTl = fVar;
        this.gwr = bdTypeListView;
        IY();
    }

    private void IY() {
        this.jvj = new a((TbPageContext) this.eTl, d.jvF);
        this.bjZ.add(this.jvj);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        if (this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.jvj.setClickListener(interfaceC0730a);
    }
}
