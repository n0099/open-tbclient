package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class RecommendViewPager extends ViewPager {

    /* renamed from: e  reason: collision with root package name */
    public float f16733e;

    /* renamed from: f  reason: collision with root package name */
    public float f16734f;

    public RecommendViewPager(@NonNull Context context) {
        super(context);
        this.f16733e = 0.0f;
        this.f16734f = 0.0f;
    }

    public void a(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (r1 != 3) goto L16;
     */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int currentItem = getCurrentItem();
        boolean z = (currentItem == 0 || currentItem == (getAdapter() == null ? 0 : getAdapter().getCount()) - 1) ? false : true;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float abs = Math.abs(motionEvent.getX() - this.f16733e);
                    float abs2 = Math.abs(motionEvent.getY() - this.f16734f);
                    this.f16733e = motionEvent.getX();
                    this.f16734f = motionEvent.getY();
                    if (abs2 / abs < 1.0f && z) {
                        a(true);
                    } else {
                        a(false);
                    }
                }
            }
            a(false);
        } else {
            this.f16733e = motionEvent.getX();
            this.f16734f = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16733e = 0.0f;
        this.f16734f = 0.0f;
    }
}
