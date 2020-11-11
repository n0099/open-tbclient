package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int fil;
    private int fim;
    private Runnable fin;
    private View fio;
    private View fiq;
    private String fir;
    private Context mContext;

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fil = 0;
        this.fim = 0;
        this.fin = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.fio != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.fio) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.fio = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.fio = null;
        this.fiq = null;
        this.fir = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fio != null) {
            post(this.fin);
        }
    }

    public String getSelectedFilter() {
        return this.fiq != null ? (String) ((View) this.fiq.getTag()).getTag() : "normal";
    }
}
