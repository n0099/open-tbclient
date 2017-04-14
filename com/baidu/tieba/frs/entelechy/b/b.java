package com.baidu.tieba.frs.entelechy.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.g.u;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public interface b {
    int a(int i, FrsRequestData frsRequestData);

    void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar);

    void a(u uVar, n nVar);

    void a(boolean z, d dVar, u uVar, az azVar, n nVar);

    void ag(View view);

    View b(Context context, BdTypeListView bdTypeListView);

    boolean hZ(int i);
}
