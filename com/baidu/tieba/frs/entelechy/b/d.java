package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.k;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, int i);

    void a(BdListView bdListView, k kVar, int i);

    void a(aj ajVar);

    TabData anI();

    View anJ();

    View anK();

    void ax(View view);

    void b(BdListView bdListView);

    void fl(boolean z);

    void onChangeSkinType(int i);
}
