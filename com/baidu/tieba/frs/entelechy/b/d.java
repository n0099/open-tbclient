package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, int i);

    void a(BdListView bdListView, j jVar, int i);

    void a(aj ajVar);

    View alA();

    View alB();

    TabData alz();

    void av(View view);

    void b(BdListView bdListView);

    void eP(boolean z);

    void onChangeSkinType(int i);
}
