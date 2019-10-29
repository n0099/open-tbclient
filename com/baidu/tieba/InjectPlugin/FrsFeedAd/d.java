package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes3.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    v.a a(ViewGroup viewGroup, Object obj);

    void a(int i, ViewGroup viewGroup, v.a aVar, Object obj);

    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    List<Integer> aBa();

    void aM(List<Object> list);

    void c(List<c> list, int i);

    void changeSkinType(int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);
}
