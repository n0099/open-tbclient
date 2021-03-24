package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectRuleView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14086e;

    /* renamed from: f  reason: collision with root package name */
    public int f14087f;

    /* renamed from: g  reason: collision with root package name */
    public int f14088g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f14089h;
    public List<String> i;
    public List<String> j;

    public SelectRuleView(Context context) {
        this(context, null);
    }

    public final List<String> a(List<String> list, int i, int i2) {
        if (ListUtils.isEmpty(list) || i > list.size() || i < 0) {
            return null;
        }
        if (list.size() >= i2) {
            return list.subList(i, i2);
        }
        ArrayList arrayList = new ArrayList(list.subList(i, list.size()));
        for (int i3 = 0; i3 < i2 - list.size(); i3++) {
            arrayList.add("");
        }
        return arrayList;
    }

    public final void b() {
        removeAllViews();
    }

    public final void c() {
        setOrientation(1);
        setGravity(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void d(int i) {
        if (this.f14088g == i) {
            return;
        }
        int i2 = this.f14086e;
        if (i2 == 0) {
            setData(this.f14089h, this.i);
        } else if (i2 == 1) {
            setData(this.j, this.f14089h, this.i);
        }
    }

    public void setColumn(int i) {
        this.f14087f = i;
    }

    public void setData(List<String> list, List<String> list2) {
        if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
            return;
        }
        b();
        this.f14089h = list;
        this.i = list2;
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(list2);
        int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        while (arrayList2.size() < size) {
            arrayList2.add("");
        }
        while (arrayList.size() < size) {
            arrayList.add("");
        }
        int i = 0;
        while (true) {
            int i2 = this.f14087f;
            if (i >= ((size + i2) - 1) / i2) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f14086e);
            int i3 = this.f14087f;
            int i4 = i * i3;
            i++;
            int i5 = i3 * i;
            selectRuleRowItem.setData(a(arrayList, i4, i5), a(arrayList2, i4, i5));
            addView(selectRuleRowItem);
        }
    }

    public void setType(int i) {
        this.f14086e = i;
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14086e = 0;
        this.f14087f = 2;
        this.f14088g = 3;
        c();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        if (ListUtils.isEmpty(list2) && ListUtils.isEmpty(list3) && ListUtils.isEmpty(list)) {
            return;
        }
        b();
        this.f14089h = list2;
        this.i = list3;
        this.j = list;
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(list2);
        List<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(list3);
        List<String> arrayList3 = new ArrayList<>();
        arrayList3.addAll(list);
        int size = list2.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        if (size <= arrayList3.size()) {
            size = arrayList3.size();
        }
        while (arrayList2.size() < size) {
            arrayList2.add("");
        }
        while (arrayList.size() < size) {
            arrayList.add("");
        }
        while (arrayList3.size() < size) {
            arrayList3.add("");
        }
        int i = 0;
        while (true) {
            int i2 = this.f14087f;
            if (i >= ((size + i2) - 1) / i2) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f14086e);
            int i3 = this.f14087f;
            int i4 = i * i3;
            i++;
            int i5 = i3 * i;
            selectRuleRowItem.setData(a(arrayList3, i4, i5), a(arrayList, i4, i5), a(arrayList2, i4, i5));
            addView(selectRuleRowItem);
        }
    }
}
