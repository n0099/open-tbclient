package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.f.u;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public interface b {
    int a(int i, FrsRequestData frsRequestData);

    void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar);

    void a(u uVar, n nVar);

    void a(boolean z, d dVar, u uVar, ax axVar, n nVar);

    void ag(View view);

    View b(Context context, BdTypeListView bdTypeListView);

    boolean hW(int i);
}
