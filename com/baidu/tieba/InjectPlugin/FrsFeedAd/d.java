package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import java.util.List;
/* loaded from: classes15.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    ad.a a(ViewGroup viewGroup, Object obj);

    void a(int i, ViewGroup viewGroup, ad.a aVar, Object obj);

    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    void bl(List<Object> list);

    List<Integer> bqt();

    void changeSkinType(int i);

    void d(List<c> list, int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);
}
