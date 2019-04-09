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
    protected boolean cov;
    protected float cow;
    protected float cox;
    protected int coy;
    protected int coz;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.cov = false;
        this.cow = 0.0f;
        this.cox = 0.0f;
        this.coy = 0;
        this.coz = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cov = false;
        this.cow = 0.0f;
        this.cox = 0.0f;
        this.coy = 0;
        this.coz = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cov = false;
        this.cow = 0.0f;
        this.cox = 0.0f;
        this.coy = 0;
        this.coz = 0;
    }

    public void ii(int i) {
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

    public a pr(String str) {
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

    public void anI() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.cov = z;
    }

    public void setContentSelectTextSize(float f) {
        this.cow = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.cox = f;
    }

    public void setContentSelectTextColor(int i) {
        this.coy = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.coz = i;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Cc;
        public int coB;
        public TbFragmentTabIndicator coD;
        public View view;
        public boolean coA = true;
        public int coC = d.C0277d.common_color_10225;

        public void ii(int i) {
            if (this.coB != 0) {
                al.k(this.view, this.coB);
            }
            if (this.view instanceof TextView) {
                if (this.coC != 0) {
                    al.d(this.view, this.coC, 1);
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
