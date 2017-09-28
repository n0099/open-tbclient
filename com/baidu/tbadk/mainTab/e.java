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
    protected boolean aGM;

    public e(Context context) {
        super(context);
        this.aGM = false;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGM = false;
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGM = false;
    }

    public void dE(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void bQ(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setTipPosType(int i) {
    }

    public void a(String str, a aVar) {
    }

    public a gt(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void L(int i, int i2) {
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
        this.aGM = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aGO;
        public e aGQ;
        public int uq;
        public View view;
        public boolean aGN = true;
        public int aGP = d.e.common_color_10225;

        public void dE(int i) {
            if (this.aGO != 0) {
                aj.j(this.view, this.aGO);
            }
            if (this.view instanceof TextView) {
                if (this.aGP != 0) {
                    aj.c((TextView) this.view, this.aGP, 1);
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
