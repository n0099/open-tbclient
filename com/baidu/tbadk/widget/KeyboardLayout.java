package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class KeyboardLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12982e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12983f;

    /* renamed from: g  reason: collision with root package name */
    public int f12984g;

    /* renamed from: h  reason: collision with root package name */
    public a f12985h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12982e = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.f12982e) {
            this.f12982e = true;
            this.f12984g = i5;
            a aVar = this.f12985h;
            if (aVar != null) {
                aVar.a(-1);
            }
        } else {
            int i6 = this.f12984g;
            if (i6 < i5) {
                i6 = i5;
            }
            this.f12984g = i6;
        }
        if (this.f12982e && this.f12984g > i5) {
            this.f12983f = true;
            a aVar2 = this.f12985h;
            if (aVar2 != null) {
                aVar2.a(-3);
            }
        }
        if (this.f12982e && this.f12983f && this.f12984g == i5) {
            this.f12983f = false;
            a aVar3 = this.f12985h;
            if (aVar3 != null) {
                aVar3.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(a aVar) {
        this.f12985h = aVar;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12982e = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.f12982e = false;
    }
}
