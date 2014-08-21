package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    public View a;
    public boolean b = true;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public FragmentTabIndicator h;

    public void a(int i) {
        Context applicationContext = TbadkApplication.m252getInst().getApplicationContext();
        if (i == 1) {
            if (this.e != 0) {
                this.a.setBackgroundResource(this.e);
            }
            if (this.a instanceof TextView) {
                if (this.g != 0) {
                    ((TextView) this.a).setTextColor(applicationContext.getResources().getColor(this.g));
                }
                int a = a((TextView) this.a);
                if (a > 0 && a < 10) {
                    ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_one_1);
                    return;
                } else if (a >= 10 && a < 100) {
                    ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_two_1);
                    return;
                } else if (a >= 100) {
                    ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_more_1);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        if (this.d != 0) {
            this.a.setBackgroundResource(this.d);
        }
        if (this.a instanceof TextView) {
            if (this.f != 0) {
                ((TextView) this.a).setTextColor(applicationContext.getResources().getColor(this.f));
            }
            int a2 = a((TextView) this.a);
            if (a2 > 0 && a2 < 10) {
                ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_one);
            } else if (a2 >= 10 && a2 < 100) {
                ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_two);
            } else if (a2 >= 100) {
                ((TextView) this.a).setBackgroundResource(t.icon_news_head_prompt_more);
            }
        }
    }

    private int a(TextView textView) {
        if (textView == null) {
            return -1;
        }
        String charSequence = ((TextView) this.a).getText().toString();
        if ("   ".equals(charSequence)) {
            return 100;
        }
        return com.baidu.adp.lib.e.c.a(charSequence, -1);
    }
}
