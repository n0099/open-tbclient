package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean aSb;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.aSb = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSb = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSb = false;
    }

    public void dF(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void bP(boolean z) {
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

    public a hl(String str) {
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

    public void ap(String str, String str2) {
    }

    public void Jp() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.aSb = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aSd;
        public TbFragmentTabIndicator aSf;
        public View view;
        public int yX;
        public boolean aSc = true;
        public int aSe = f.d.common_color_10225;

        public void dF(int i) {
            if (this.aSd != 0) {
                am.i(this.view, this.aSd);
            }
            if (this.view instanceof TextView) {
                if (this.aSe != 0) {
                    am.c(this.view, this.aSe, 1);
                }
                int a = a((TextView) this.view);
                if (a > 0 && a < 10) {
                    am.i(this.view, f.C0146f.icon_news_head_prompt_one);
                } else if (a >= 10 && a < 100) {
                    am.i(this.view, f.C0146f.icon_news_head_prompt_two);
                } else if (a >= 100) {
                    am.i(this.view, f.C0146f.icon_news_head_prompt_more);
                }
            }
            if (this.view instanceof MessageRedDotView) {
                ((MessageRedDotView) this.view).onChangeSkinType();
            }
        }

        private int a(TextView textView) {
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
