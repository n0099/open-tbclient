package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, int i);

    void a(BdListView bdListView, n nVar, int i);

    void a(bz bzVar);

    TabData afI();

    View afJ();

    View afK();

    void ag(View view);

    void b(BdListView bdListView);

    void eG(boolean z);

    void onChangeSkinType(int i);
}
