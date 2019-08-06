package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean cxZ;
    protected float cya;
    protected float cyb;
    protected int cyc;
    protected int cyd;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.cxZ = false;
        this.cya = 0.0f;
        this.cyb = 0.0f;
        this.cyc = 0;
        this.cyd = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxZ = false;
        this.cya = 0.0f;
        this.cyb = 0.0f;
        this.cyc = 0;
        this.cyd = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxZ = false;
        this.cya = 0.0f;
        this.cyb = 0.0f;
        this.cyc = 0;
        this.cyd = 0;
    }

    public void jd(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void ft(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setTipPosType(int i) {
    }

    public void a(String str, a aVar) {
    }

    public void b(String str, a aVar) {
    }

    public a qP(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void setIconResourceId(int i) {
    }

    public void setIconViewWithoutText(int i, int i2) {
    }

    public void setIconViewWithText(int i, int i2) {
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

    public void atV() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.cxZ = z;
    }

    public void setContentSelectTextSize(float f) {
        this.cya = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.cyb = f;
    }

    public void setContentSelectTextColor(int i) {
        this.cyc = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.cyd = i;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int cyf;
        public TbFragmentTabIndicator cyh;
        public View view;
        public int zQ;
        public boolean cye = true;
        public int cyg = R.color.common_color_10225;

        public void jd(int i) {
            if (this.cyf != 0) {
                am.k(this.view, this.cyf);
            }
            if (this.view instanceof TextView) {
                if (this.cyg != 0) {
                    am.f(this.view, this.cyg, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    am.k(this.view, R.drawable.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    am.k(this.view, R.drawable.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    am.k(this.view, R.drawable.icon_news_head_prompt_more);
                }
            }
            if (this.view instanceof MessageRedDotView) {
                ((MessageRedDotView) this.view).onChangeSkinType();
            }
        }

        private int c(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return com.baidu.adp.lib.g.b.f(charSequence, -1);
        }
    }
}
