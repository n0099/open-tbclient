package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes3.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    void an(List<Object> list);

    List<Integer> aug();

    void changeSkinType(int i);

    void f(List<c> list, int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);

    v.a onCreateViewHolder(ViewGroup viewGroup, Object obj);

    void onFillViewHolder(int i, ViewGroup viewGroup, v.a aVar, Object obj);
}
