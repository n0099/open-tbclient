package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, p pVar, int i);

    void a(ce ceVar);

    void ae(View view);

    TabData aeI();

    View aeJ();

    View aeK();

    void b(BdListView bdListView, int i);

    void eh(boolean z);

    void onChangeSkinType(int i);

    void u(BdListView bdListView);
}
