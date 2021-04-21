package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class KeyboardLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13730e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13731f;

    /* renamed from: g  reason: collision with root package name */
    public int f13732g;

    /* renamed from: h  reason: collision with root package name */
    public a f13733h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13730e = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f13730e) {
            this.f13730e = true;
            this.f13732g = i4;
            a aVar = this.f13733h;
            if (aVar != null) {
                aVar.a(-1);
            }
        } else {
            int i5 = this.f13732g;
            if (i5 < i4) {
                i5 = i4;
            }
            this.f13732g = i5;
        }
        if (this.f13730e && this.f13732g > i4) {
            this.f13731f = true;
            a aVar2 = this.f13733h;
            if (aVar2 != null) {
                aVar2.a(-3);
            }
        }
        if (this.f13730e && this.f13731f && this.f13732g == i4) {
            this.f13731f = false;
            a aVar3 = this.f13733h;
            if (aVar3 != null) {
                aVar3.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(a aVar) {
        this.f13733h = aVar;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13730e = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.f13730e = false;
    }
}
