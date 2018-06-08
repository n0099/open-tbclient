package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class FiltersView extends HorizontalScrollView {
    private int aGf;
    private int aGg;
    private ImageView[] aGh;
    private View aGi;
    private View aGj;
    private a aGk;
    private boolean aGl;
    private String aGm;
    private Context mContext;
    private Runnable scrollRunnable;

    /* loaded from: classes.dex */
    public interface a {
    }

    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGf = 0;
        this.aGg = 0;
        this.scrollRunnable = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.FiltersView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (FiltersView.this.aGi != null) {
                    int childCount = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            i = 0;
                            break;
                        }
                        View childAt = ((LinearLayout) FiltersView.this.getChildAt(0)).getChildAt(i2);
                        if (childAt != FiltersView.this.aGi) {
                            i2++;
                        } else {
                            i = childAt.getRight();
                            break;
                        }
                    }
                    FiltersView.this.aGi = null;
                    int width = i - FiltersView.this.getWidth();
                    if (width > 0) {
                        FiltersView.this.scrollBy(width, 0);
                    }
                }
            }
        };
        this.mContext = null;
        this.aGh = null;
        this.aGi = null;
        this.aGj = null;
        this.aGk = null;
        this.aGl = true;
        this.aGm = "normal";
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aGi != null) {
            post(this.scrollRunnable);
        }
    }

    public String getSelectedFilter() {
        return this.aGj != null ? (String) ((View) this.aGj.getTag()).getTag() : "normal";
    }

    public void setCanbeClick(boolean z) {
        this.aGl = z;
    }

    public static int fY(String str) {
        if (TbadkCoreApplication.getMotuFilterImageMap() == null || TbadkCoreApplication.getMotuFilterImageMap().size() == 0) {
            return 0;
        }
        if (str == null || str.equals("normal")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("normal").intValue();
        }
        if (str.equals("clvivid")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clvivid").intValue();
        }
        if (str.equals("cllomoscenery")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("cllomoscenery").intValue();
        }
        if (str.equals("clcaisefupian")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clcaisefupian").intValue();
        }
        if (str.equals("clm3")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clm3").intValue();
        }
        if (str.equals("cqiuse")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("cqiuse").intValue();
        }
        if (str.equals("clzaoan")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clzaoan").intValue();
        }
        if (str.equals("clfuguscenery")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clfuguscenery").intValue();
        }
        if (str.equals("clheibai")) {
            return TbadkCoreApplication.getMotuFilterImageMap().get("clheibai").intValue();
        }
        return TbadkCoreApplication.getMotuFilterImageMap().get("normal").intValue();
    }
}
