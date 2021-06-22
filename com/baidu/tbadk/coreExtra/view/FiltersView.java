package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class FiltersView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public Runnable f12782e;

    /* renamed from: f  reason: collision with root package name */
    public View f12783f;

    /* renamed from: g  reason: collision with root package name */
    public View f12784g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            if (FiltersView.this.f12783f == null) {
                return;
            }
            int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    i2 = 0;
                    break;
                }
                View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i3);
                if (childAt == FiltersView.this.f12783f) {
                    i2 = childAt.getRight();
                    break;
                }
                i3++;
            }
            FiltersView.this.f12783f = null;
            int width = i2 - FiltersView.this.getWidth();
            if (width > 0) {
                FiltersView.this.scrollBy(width, 0);
            }
        }
    }

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12782e = new a();
        this.f12783f = null;
        this.f12784g = null;
    }

    public String getSelectedFilter() {
        View view = this.f12784g;
        return view != null ? (String) ((View) view.getTag()).getTag() : "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f12783f != null) {
            post(this.f12782e);
        }
    }
}
