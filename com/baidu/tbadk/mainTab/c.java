package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class c {
    public boolean acv = true;
    public int acw;
    public int acx;
    public FragmentTabIndicator acy;
    public int jO;
    public View view;

    public void ct(int i) {
        if (this.acw != 0) {
            bc.i(this.view, this.acw);
        }
        if (this.view instanceof TextView) {
            if (this.acx != 0) {
                bc.b((TextView) this.view, this.acx, 1);
            }
            int b = b((TextView) this.view);
            if (b > 0 && b < 10) {
                bc.i((View) ((TextView) this.view), v.icon_news_head_prompt_one);
            } else if (b >= 10 && b < 100) {
                bc.i((View) ((TextView) this.view), v.icon_news_head_prompt_two);
            } else if (b >= 100) {
                bc.i((View) ((TextView) this.view), v.icon_news_head_prompt_more);
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
