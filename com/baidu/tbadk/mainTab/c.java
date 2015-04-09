package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    public boolean alZ = true;
    public int ama;
    public int amb;
    public FragmentTabIndicator amc;
    public int vf;
    public View view;

    public void cu(int i) {
        if (this.ama != 0) {
            ba.i(this.view, this.ama);
        }
        if (this.view instanceof TextView) {
            if (this.amb != 0) {
                ba.b((TextView) this.view, this.amb, 1);
            }
            int b = b((TextView) this.view);
            if (b > 0 && b < 10) {
                ba.i((View) ((TextView) this.view), u.icon_news_head_prompt_one);
            } else if (b >= 10 && b < 100) {
                ba.i((View) ((TextView) this.view), u.icon_news_head_prompt_two);
            } else if (b >= 100) {
                ba.i((View) ((TextView) this.view), u.icon_news_head_prompt_more);
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
