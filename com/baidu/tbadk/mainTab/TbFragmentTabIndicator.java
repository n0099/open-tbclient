package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean cwC;
    protected float cwD;
    protected float cwE;
    protected int cwF;
    protected int cwG;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.cwC = false;
        this.cwD = 0.0f;
        this.cwE = 0.0f;
        this.cwF = 0;
        this.cwG = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwC = false;
        this.cwD = 0.0f;
        this.cwE = 0.0f;
        this.cwF = 0;
        this.cwG = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cwC = false;
        this.cwD = 0.0f;
        this.cwE = 0.0f;
        this.cwF = 0;
        this.cwG = 0;
    }

    public void iW(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void fp(boolean z) {
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

    public a qz(String str) {
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

    public void asL() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.cwC = z;
    }

    public void setContentSelectTextSize(float f) {
        this.cwD = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.cwE = f;
    }

    public void setContentSelectTextColor(int i) {
        this.cwF = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.cwG = i;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int cwI;
        public TbFragmentTabIndicator cwK;
        public View view;
        public int zL;
        public boolean cwH = true;
        public int cwJ = R.color.common_color_10225;

        public void iW(int i) {
            if (this.cwI != 0) {
                al.k(this.view, this.cwI);
            }
            if (this.view instanceof TextView) {
                if (this.cwJ != 0) {
                    al.f(this.view, this.cwJ, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    al.k(this.view, R.drawable.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    al.k(this.view, R.drawable.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    al.k(this.view, R.drawable.icon_news_head_prompt_more);
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
