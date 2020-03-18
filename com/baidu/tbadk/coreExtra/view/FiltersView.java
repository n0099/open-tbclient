package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int drM;
    private int drN;
    private Runnable drO;
    private View drP;
    private View drQ;
    private String drR;
    private Context mContext;

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drM = 0;
        this.drN = 0;
        this.drO = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.drP != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.drP) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.drP = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.drP = null;
        this.drQ = null;
        this.drR = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.drP != null) {
            post(this.drO);
        }
    }

    public String getSelectedFilter() {
        return this.drQ != null ? (String) ((View) this.drQ.getTag()).getTag() : "normal";
    }
}
