package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class c {
    public boolean abX = true;
    public int abY;
    public int abZ;
    public FragmentTabIndicator aca;
    public int jM;
    public View view;

    public void cm(int i) {
        if (this.abY != 0) {
            ax.i(this.view, this.abY);
        }
        if (this.view instanceof TextView) {
            if (this.abZ != 0) {
                ax.b((TextView) this.view, this.abZ, 1);
            }
            int b = b((TextView) this.view);
            if (b > 0 && b < 10) {
                ax.i((View) ((TextView) this.view), v.icon_news_head_prompt_one);
            } else if (b >= 10 && b < 100) {
                ax.i((View) ((TextView) this.view), v.icon_news_head_prompt_two);
            } else if (b >= 100) {
                ax.i((View) ((TextView) this.view), v.icon_news_head_prompt_more);
            }
        }
    }

    private int b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        String charSequence = ((TextView) this.view).getText().toString();
        if ("   ".equals(charSequence)) {
            return 100;
        }
        return com.baidu.adp.lib.g.c.toInt(charSequence, -1);
    }
}
