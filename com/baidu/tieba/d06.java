package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.List;
/* loaded from: classes5.dex */
public interface d06 extends g06<i06> {
    void a(int i);

    List<Integer> d();

    void e(List<c06> list, String str, String str2, String str3, String str4, boolean z, int i);

    TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj);

    void i(List<c06> list, int i);

    void k(List<Object> list);

    View m(int i, View view2, ViewGroup viewGroup, Object obj);

    void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj);

    void o(List<c06> list, List<c06> list2, boolean z, int i);

    void p(String str);
}
