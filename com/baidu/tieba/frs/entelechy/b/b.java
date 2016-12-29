package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.h.s;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public interface b {
    int a(int i, l lVar);

    View a(Context context, BdTypeListView bdTypeListView);

    void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar);

    void a(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView);

    void a(s sVar, o oVar);

    void a(boolean z, d dVar, s sVar, ax axVar, o oVar);

    void ad(View view);

    void b(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView);

    boolean ho(int i);
}
