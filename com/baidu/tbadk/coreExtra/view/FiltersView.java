package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int eoS;
    private int eoT;
    private Runnable eoU;
    private View eoV;
    private View eoW;
    private String eoX;
    private Context mContext;

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoS = 0;
        this.eoT = 0;
        this.eoU = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.eoV != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.eoV) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.eoV = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.eoV = null;
        this.eoW = null;
        this.eoX = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eoV != null) {
            post(this.eoU);
        }
    }

    public String getSelectedFilter() {
        return this.eoW != null ? (String) ((View) this.eoW.getTag()).getTag() : "normal";
    }
}
