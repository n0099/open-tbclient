package com.baidu.tieba.forumsearch.controller;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a {
    com.baidu.tieba.forumsearch.a.c hxw;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.tieba.forumsearch.a.a(tbPageContext, com.baidu.tieba.forumsearch.b.a.hxS, tbPageContext.getUniqueId()));
            this.hxw = new com.baidu.tieba.forumsearch.a.c(tbPageContext, com.baidu.tieba.forumsearch.b.b.hya, tbPageContext.getUniqueId());
            arrayList.add(this.hxw);
            arrayList.add(new com.baidu.tieba.forumsearch.a.b(tbPageContext, com.baidu.tieba.forumsearch.b.a.hxR, tbPageContext.getUniqueId()));
            arrayList.add(new com.baidu.tieba.forumsearch.a.d(tbPageContext, com.baidu.tieba.forumsearch.b.a.hxT, tbPageContext.getUniqueId()));
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.hxw.y(onClickListener);
    }
}
