package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes3.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    List<Integer> OE();

    void R(List<Object> list);

    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    void changeSkinType(int i);

    void g(List<c> list, int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);

    q.a onCreateViewHolder(ViewGroup viewGroup, Object obj);

    void onFillViewHolder(int i, ViewGroup viewGroup, q.a aVar, Object obj);
}
