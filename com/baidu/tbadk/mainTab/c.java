package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    public boolean VQ = true;
    public int VR;
    public int VS;
    public FragmentTabIndicator VT;
    public int jI;
    public View view;

    public void bN(int i) {
        if (this.VR != 0) {
            aw.h(this.view, this.VR);
        }
        if (this.view instanceof TextView) {
            if (this.VS != 0) {
                aw.b((TextView) this.view, this.VS, 1);
            }
            int b = b((TextView) this.view);
            if (b > 0 && b < 10) {
                aw.h((View) ((TextView) this.view), u.icon_news_head_prompt_one);
            } else if (b >= 10 && b < 100) {
                aw.h((View) ((TextView) this.view), u.icon_news_head_prompt_two);
            } else if (b >= 100) {
                aw.h((View) ((TextView) this.view), u.icon_news_head_prompt_more);
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
        return com.baidu.adp.lib.g.c.f(charSequence, -1);
    }
}
