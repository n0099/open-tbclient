package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int eHQ;
    private int eHR;
    private Runnable eHS;
    private View eHT;
    private View eHU;
    private String eHV;
    private Context mContext;

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHQ = 0;
        this.eHR = 0;
        this.eHS = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.eHT != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.eHT) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.eHT = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.eHT = null;
        this.eHU = null;
        this.eHV = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.eHT != null) {
            post(this.eHS);
        }
    }

    public String getSelectedFilter() {
        return this.eHU != null ? (String) ((View) this.eHU.getTag()).getTag() : "normal";
    }
}
