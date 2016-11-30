package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.j.n;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
public interface b {
    int a(int i, m mVar);

    View a(Context context, BdTypeListView bdTypeListView);

    void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar);

    void a(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView);

    void a(n nVar, p pVar);

    void a(boolean z, d dVar, n nVar, au auVar, p pVar);

    void ad(View view);

    void b(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView);

    boolean ie(int i);
}
