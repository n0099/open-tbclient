package com.baidu.tieba.forumsearch.controller;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    com.baidu.tieba.forumsearch.a.c jcT;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.tieba.forumsearch.a.a(tbPageContext, com.baidu.tieba.forumsearch.b.a.jdo, tbPageContext.getUniqueId()));
            this.jcT = new com.baidu.tieba.forumsearch.a.c(tbPageContext, com.baidu.tieba.forumsearch.b.b.jdw, tbPageContext.getUniqueId());
            arrayList.add(this.jcT);
            arrayList.add(new com.baidu.tieba.forumsearch.a.b(tbPageContext, com.baidu.tieba.forumsearch.b.a.jdn, tbPageContext.getUniqueId()));
            arrayList.add(new com.baidu.tieba.forumsearch.a.d(tbPageContext, com.baidu.tieba.forumsearch.b.a.jdp, tbPageContext.getUniqueId()));
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.jcT.A(onClickListener);
    }
}
