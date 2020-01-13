package com.baidu.tieba.forumsearch.controller;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    com.baidu.tieba.forumsearch.a.c gki;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.tieba.forumsearch.a.a(tbPageContext, com.baidu.tieba.forumsearch.b.a.gkE, tbPageContext.getUniqueId()));
            this.gki = new com.baidu.tieba.forumsearch.a.c(tbPageContext, com.baidu.tieba.forumsearch.b.b.gkL, tbPageContext.getUniqueId());
            arrayList.add(this.gki);
            arrayList.add(new com.baidu.tieba.forumsearch.a.b(tbPageContext, com.baidu.tieba.forumsearch.b.a.gkD, tbPageContext.getUniqueId()));
            arrayList.add(new com.baidu.tieba.forumsearch.a.d(tbPageContext, com.baidu.tieba.forumsearch.b.a.gkF, tbPageContext.getUniqueId()));
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.gki.w(onClickListener);
    }
}
