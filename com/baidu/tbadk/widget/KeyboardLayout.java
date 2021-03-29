package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class KeyboardLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f14061e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14062f;

    /* renamed from: g  reason: collision with root package name */
    public int f14063g;

    /* renamed from: h  reason: collision with root package name */
    public a f14064h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14061e = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f14061e) {
            this.f14061e = true;
            this.f14063g = i4;
            a aVar = this.f14064h;
            if (aVar != null) {
                aVar.a(-1);
            }
        } else {
            int i5 = this.f14063g;
            if (i5 < i4) {
                i5 = i4;
            }
            this.f14063g = i5;
        }
        if (this.f14061e && this.f14063g > i4) {
            this.f14062f = true;
            a aVar2 = this.f14064h;
            if (aVar2 != null) {
                aVar2.a(-3);
            }
        }
        if (this.f14061e && this.f14062f && this.f14063g == i4) {
            this.f14062f = false;
            a aVar3 = this.f14064h;
            if (aVar3 != null) {
                aVar3.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(a aVar) {
        this.f14064h = aVar;
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14061e = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.f14061e = false;
    }
}
