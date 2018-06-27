package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private a dxw;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;
    private e mPageContext;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.dxw = new a((TbPageContext) this.mPageContext, d.dxS);
        this.mAdapters.add(this.dxw);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<h> list) {
        if (this.mListView != null) {
            this.mListView.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0157a interfaceC0157a) {
        this.dxw.setClickListener(interfaceC0157a);
    }
}
