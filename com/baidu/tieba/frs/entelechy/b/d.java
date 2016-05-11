package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public interface d {
    TabData SD();

    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, o oVar);

    void a(fg fgVar);

    void ae(View view);

    void b(BdListView bdListView, int i);

    void de(boolean z);

    void onChangeSkinType(int i);

    void u(BdListView bdListView);
}
