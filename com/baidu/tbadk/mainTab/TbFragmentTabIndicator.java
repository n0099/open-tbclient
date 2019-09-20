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
    protected boolean cyV;
    protected float cyW;
    protected float cyX;
    protected int cyY;
    protected int cyZ;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.cyV = false;
        this.cyW = 0.0f;
        this.cyX = 0.0f;
        this.cyY = 0;
        this.cyZ = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyV = false;
        this.cyW = 0.0f;
        this.cyX = 0.0f;
        this.cyY = 0;
        this.cyZ = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyV = false;
        this.cyW = 0.0f;
        this.cyX = 0.0f;
        this.cyY = 0;
        this.cyZ = 0;
    }

    public void jg(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void fw(boolean z) {
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

    public a ra(String str) {
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

    public void auh() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.cyV = z;
    }

    public void setContentSelectTextSize(float f) {
        this.cyW = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.cyX = f;
    }

    public void setContentSelectTextColor(int i) {
        this.cyY = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.cyZ = i;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int czb;
        public TbFragmentTabIndicator czd;
        public View view;
        public int zQ;
        public boolean cza = true;
        public int czc = R.color.common_color_10225;

        public void jg(int i) {
            if (this.czb != 0) {
                am.k(this.view, this.czb);
            }
            if (this.view instanceof TextView) {
                if (this.czc != 0) {
                    am.f(this.view, this.czc, 1);
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
