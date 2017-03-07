package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, int i);

    void a(BdListView bdListView, n nVar, int i);

    void a(cb cbVar);

    TabData abc();

    View abd();

    View abe();

    void ah(View view);

    void b(BdListView bdListView);

    void dW(boolean z);

    void onChangeSkinType(int i);
}
