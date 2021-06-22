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
    public int f13174e;

    /* renamed from: f  reason: collision with root package name */
    public int f13175f;

    /* renamed from: g  reason: collision with root package name */
    public int f13176g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f13177h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f13178i;
    public List<String> j;

    public SelectRuleView(Context context) {
        this(context, null);
    }

    public final List<String> a(List<String> list, int i2, int i3) {
        if (ListUtils.isEmpty(list) || i2 > list.size() || i2 < 0) {
            return null;
        }
        if (list.size() >= i3) {
            return list.subList(i2, i3);
        }
        ArrayList arrayList = new ArrayList(list.subList(i2, list.size()));
        for (int i4 = 0; i4 < i3 - list.size(); i4++) {
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

    public void d(int i2) {
        if (this.f13176g == i2) {
            return;
        }
        int i3 = this.f13174e;
        if (i3 == 0) {
            setData(this.f13177h, this.f13178i);
        } else if (i3 == 1) {
            setData(this.j, this.f13177h, this.f13178i);
        }
    }

    public void setColumn(int i2) {
        this.f13175f = i2;
    }

    public void setData(List<String> list, List<String> list2) {
        if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
            return;
        }
        b();
        this.f13177h = list;
        this.f13178i = list2;
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
        int i2 = 0;
        while (true) {
            int i3 = this.f13175f;
            if (i2 >= ((size + i3) - 1) / i3) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f13174e);
            int i4 = this.f13175f;
            int i5 = i2 * i4;
            i2++;
            int i6 = i4 * i2;
            selectRuleRowItem.setData(a(arrayList, i5, i6), a(arrayList2, i5, i6));
            addView(selectRuleRowItem);
        }
    }

    public void setType(int i2) {
        this.f13174e = i2;
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectRuleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13174e = 0;
        this.f13175f = 2;
        this.f13176g = 3;
        c();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        if (ListUtils.isEmpty(list2) && ListUtils.isEmpty(list3) && ListUtils.isEmpty(list)) {
            return;
        }
        b();
        this.f13177h = list2;
        this.f13178i = list3;
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
        int i2 = 0;
        while (true) {
            int i3 = this.f13175f;
            if (i2 >= ((size + i3) - 1) / i3) {
                return;
            }
            SelectRuleRowItem selectRuleRowItem = new SelectRuleRowItem(getContext());
            selectRuleRowItem.setType(this.f13174e);
            int i4 = this.f13175f;
            int i5 = i2 * i4;
            i2++;
            int i6 = i4 * i2;
            selectRuleRowItem.setData(a(arrayList3, i5, i6), a(arrayList, i5, i6), a(arrayList2, i5, i6));
            addView(selectRuleRowItem);
        }
    }
}
