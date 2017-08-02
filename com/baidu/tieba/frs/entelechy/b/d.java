package com.baidu.tieba.frs.entelechy.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public interface d {
    void a(AbsListView absListView, int i, int i2, int i3, int i4);

    void a(BdListView bdListView, int i);

    void a(BdListView bdListView, i iVar, int i);

    void a(ai aiVar);

    TabData agS();

    View agT();

    View agU();

    void al(View view);

    void b(BdListView bdListView);

    void eR(boolean z);

    void onChangeSkinType(int i);
}
