package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.j.p;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes.dex */
public interface b {
    int a(int i, m mVar);

    View a(Context context, BdTypeListView bdTypeListView);

    void a(BdTypeListView bdTypeListView, BannerView bannerView);

    void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar);

    void a(p pVar, com.baidu.tieba.tbadkCore.p pVar2);

    void a(boolean z, d dVar, p pVar, bq bqVar, com.baidu.tieba.tbadkCore.p pVar2);

    void ad(View view);

    BannerView at(Context context);

    void b(BdTypeListView bdTypeListView, BannerView bannerView);

    boolean hy(int i);
}
