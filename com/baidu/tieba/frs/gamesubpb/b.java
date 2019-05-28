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
    private a fDB;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;
    private e mPageContext;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.fDB = new a((TbPageContext) this.mPageContext, d.fDX);
        this.mAdapters.add(this.fDB);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<m> list) {
        if (this.mListView != null) {
            this.mListView.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0311a interfaceC0311a) {
        this.fDB.setClickListener(interfaceC0311a);
    }
}
