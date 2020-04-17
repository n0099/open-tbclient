package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import java.util.List;
/* loaded from: classes8.dex */
public interface d extends com.baidu.tieba.InjectPlugin.a.a<com.baidu.tieba.InjectPlugin.a.c> {
    y.a a(ViewGroup viewGroup, Object obj);

    void a(int i, ViewGroup viewGroup, y.a aVar, Object obj);

    void a(List<c> list, String str, String str2, String str3, String str4, boolean z, int i);

    void a(List<c> list, List<c> list2, boolean z, int i);

    void bc(List<Object> list);

    List<Integer> bdO();

    void changeSkinType(int i);

    void e(List<c> list, int i);

    View getView(int i, View view, ViewGroup viewGroup, Object obj);
}
