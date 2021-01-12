package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int ftS;
    private int ftT;
    private Runnable ftU;
    private View ftV;
    private View ftW;
    private String ftX;
    private Context mContext;

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftS = 0;
        this.ftT = 0;
        this.ftU = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.ftV != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.ftV) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.ftV = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.ftV = null;
        this.ftW = null;
        this.ftX = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ftV != null) {
            post(this.ftU);
        }
    }

    public String getSelectedFilter() {
        return this.ftW != null ? (String) ((View) this.ftW.getTag()).getTag() : "normal";
    }
}
