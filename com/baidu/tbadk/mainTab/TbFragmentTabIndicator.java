package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean cos;
    protected float cot;
    protected float cou;
    protected int cov;
    protected int cow;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.cos = false;
        this.cot = 0.0f;
        this.cou = 0.0f;
        this.cov = 0;
        this.cow = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cos = false;
        this.cot = 0.0f;
        this.cou = 0.0f;
        this.cov = 0;
        this.cow = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cos = false;
        this.cot = 0.0f;
        this.cou = 0.0f;
        this.cov = 0;
        this.cow = 0;
    }

    public void ij(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void eT(boolean z) {
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

    public a pq(String str) {
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

    public void anL() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.cos = z;
    }

    public void setContentSelectTextSize(float f) {
        this.cot = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.cou = f;
    }

    public void setContentSelectTextColor(int i) {
        this.cov = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.cow = i;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Cd;
        public TbFragmentTabIndicator coA;
        public int coy;
        public View view;
        public boolean cox = true;
        public int coz = d.C0277d.common_color_10225;

        public void ij(int i) {
            if (this.coy != 0) {
                al.k(this.view, this.coy);
            }
            if (this.view instanceof TextView) {
                if (this.coz != 0) {
                    al.d(this.view, this.coz, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    al.k(this.view, d.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    al.k(this.view, d.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    al.k(this.view, d.f.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.l(charSequence, -1);
        }
    }
}
