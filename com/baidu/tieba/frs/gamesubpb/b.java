package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private a dPO;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;
    private e mPageContext;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.dPO = new a((TbPageContext) this.mPageContext, d.dQk);
        this.mAdapters.add(this.dPO);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<i> list) {
        if (this.mListView != null) {
            this.mListView.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0155a interfaceC0155a) {
        this.dPO.setClickListener(interfaceC0155a);
    }
}
