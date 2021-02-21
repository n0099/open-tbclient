package com.baidu.tieba.forumsearch.controller;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    com.baidu.tieba.forumsearch.a.c jeh;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.tieba.forumsearch.a.a(tbPageContext, com.baidu.tieba.forumsearch.b.a.jeC, tbPageContext.getUniqueId()));
            this.jeh = new com.baidu.tieba.forumsearch.a.c(tbPageContext, com.baidu.tieba.forumsearch.b.b.jeK, tbPageContext.getUniqueId());
            arrayList.add(this.jeh);
            arrayList.add(new com.baidu.tieba.forumsearch.a.b(tbPageContext, com.baidu.tieba.forumsearch.b.a.jeB, tbPageContext.getUniqueId()));
            arrayList.add(new com.baidu.tieba.forumsearch.a.d(tbPageContext, com.baidu.tieba.forumsearch.b.a.jeD, tbPageContext.getUniqueId()));
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.jeh.A(onClickListener);
    }
}
