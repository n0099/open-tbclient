package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public interface d {
    TabData Zd();

    View Ze();

    View Zf();

    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, o oVar, int i);

    void a(cd cdVar);

    void ae(View view);

    void b(BdListView bdListView, int i);

    void dR(boolean z);

    void onChangeSkinType(int i);

    void u(BdListView bdListView);
}
