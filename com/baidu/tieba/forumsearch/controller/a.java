package com.baidu.tieba.forumsearch.controller;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class a {
    com.baidu.tieba.forumsearch.a.c iEZ;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.baidu.tieba.forumsearch.a.a(tbPageContext, com.baidu.tieba.forumsearch.b.a.iFu, tbPageContext.getUniqueId()));
            this.iEZ = new com.baidu.tieba.forumsearch.a.c(tbPageContext, com.baidu.tieba.forumsearch.b.b.iFC, tbPageContext.getUniqueId());
            arrayList.add(this.iEZ);
            arrayList.add(new com.baidu.tieba.forumsearch.a.b(tbPageContext, com.baidu.tieba.forumsearch.b.a.iFt, tbPageContext.getUniqueId()));
            arrayList.add(new com.baidu.tieba.forumsearch.a.d(tbPageContext, com.baidu.tieba.forumsearch.b.a.iFv, tbPageContext.getUniqueId()));
            bdTypeListView.addAdapters(arrayList);
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.iEZ.z(onClickListener);
    }
}
