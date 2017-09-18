package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class e extends FrameLayout {
    protected boolean aHl;

    public e(Context context) {
        super(context);
        this.aHl = false;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHl = false;
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHl = false;
    }

    public void du(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void bR(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setTipPosType(int i) {
    }

    public void a(String str, a aVar) {
    }

    public a gw(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void K(int i, int i2) {
    }

    public void setCompoundDrawablesTopResId(int i) {
    }

    public void setCompoundDrawablePadding(int i) {
    }

    public void setContentTvTopMargin(int i) {
    }

    public void setTextSize(float f) {
    }

    public void setTextSize(int i, float f) {
    }

    public void setTextColorResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.aHl = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aHn;
        public e aHp;
        public int uo;
        public View view;
        public boolean aHm = true;
        public int aHo = d.e.common_color_10225;

        public void du(int i) {
            if (this.aHn != 0) {
                aj.j(this.view, this.aHn);
            }
            if (this.view instanceof TextView) {
                if (this.aHo != 0) {
                    aj.c((TextView) this.view, this.aHo, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    aj.j((TextView) this.view, d.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    aj.j((TextView) this.view, d.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    aj.j((TextView) this.view, d.g.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.g(charSequence, -1);
        }
    }
}
