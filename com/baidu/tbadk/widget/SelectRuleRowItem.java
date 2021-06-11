package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tieba.view.AdapterLinearLayout;
import d.a.m0.b1.a;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectRuleRowItem extends AdapterLinearLayout {

    /* renamed from: g  reason: collision with root package name */
    public a f13091g;

    public SelectRuleRowItem(Context context) {
        this(context, null);
    }

    public final void b() {
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        a aVar = new a(getContext());
        this.f13091g = aVar;
        setAdapter(aVar);
    }

    public void setData(List<String> list, List<String> list2) {
        this.f13091g.c(list, list2);
    }

    public void setType(int i2) {
        this.f13091g.e(i2);
    }

    public SelectRuleRowItem(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.f13091g.d(list, list2, list3);
    }

    public SelectRuleRowItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
