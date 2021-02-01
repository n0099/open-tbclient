package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.List;
/* loaded from: classes8.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    TypeAdapter.ViewHolder a(ViewGroup viewGroup, Object obj);

    void a(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj);

    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    List<Integer> bJt();

    void bP(List<Object> list);

    void changeSkinType(int i);

    void d(List<c> list, int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);
}
