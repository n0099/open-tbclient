package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class c {
    public boolean anb = true;
    public int anc;
    public int and;
    public FragmentTabIndicator ane;
    public int ur;
    public View view;

    public void cz(int i) {
        if (this.anc != 0) {
            ay.i(this.view, this.anc);
        }
        if (this.view instanceof TextView) {
            if (this.and != 0) {
                ay.b((TextView) this.view, this.and, 1);
            }
            int b = b((TextView) this.view);
            if (b > 0 && b < 10) {
                ay.i((View) ((TextView) this.view), p.icon_news_head_prompt_one);
            } else if (b >= 10 && b < 100) {
                ay.i((View) ((TextView) this.view), p.icon_news_head_prompt_two);
            } else if (b >= 100) {
                ay.i((View) ((TextView) this.view), p.icon_news_head_prompt_more);
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
