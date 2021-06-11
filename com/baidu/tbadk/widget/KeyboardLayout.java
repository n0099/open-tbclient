package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class KeyboardLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13047e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13048f;

    /* renamed from: g  reason: collision with root package name */
    public int f13049g;

    /* renamed from: h  reason: collision with root package name */
    public a f13050h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13047e = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.f13047e) {
            this.f13047e = true;
            this.f13049g = i5;
            a aVar = this.f13050h;
            if (aVar != null) {
                aVar.a(-1);
            }
        } else {
            int i6 = this.f13049g;
            if (i6 < i5) {
                i6 = i5;
            }
            this.f13049g = i6;
        }
        if (this.f13047e && this.f13049g > i5) {
            this.f13048f = true;
            a aVar2 = this.f13050h;
            if (aVar2 != null) {
                aVar2.a(-3);
            }
        }
        if (this.f13047e && this.f13048f && this.f13049g == i5) {
            this.f13048f = false;
            a aVar3 = this.f13050h;
            if (aVar3 != null) {
                aVar3.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(a aVar) {
        this.f13050h = aVar;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13047e = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.f13047e = false;
    }
}
