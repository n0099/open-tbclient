package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class FiltersView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public Runnable f13748e;

    /* renamed from: f  reason: collision with root package name */
    public View f13749f;

    /* renamed from: g  reason: collision with root package name */
    public View f13750g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (FiltersView.this.f13749f == null) {
                return;
            }
            int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                if (childAt == FiltersView.this.f13749f) {
                    i = childAt.getRight();
                    break;
                }
                i2++;
            }
            FiltersView.this.f13749f = null;
            int width = i - FiltersView.this.getWidth();
            if (width > 0) {
                FiltersView.this.scrollBy(width, 0);
            }
        }
    }

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13748e = new a();
        this.f13749f = null;
        this.f13750g = null;
    }

    public String getSelectedFilter() {
        View view = this.f13750g;
        return view != null ? (String) ((View) view.getTag()).getTag() : "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f13749f != null) {
            post(this.f13748e);
        }
    }
}
