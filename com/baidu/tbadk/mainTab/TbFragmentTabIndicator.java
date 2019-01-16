package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean beP;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.beP = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beP = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beP = false;
    }

    public void eD(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void cF(boolean z) {
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

    public a iD(String str) {
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

    public void aM(String str, String str2) {
    }

    public void Oi() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.beP = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Cd;
        public int beR;
        public TbFragmentTabIndicator beT;
        public View view;
        public boolean beQ = true;
        public int beS = e.d.common_color_10225;

        public void eD(int i) {
            if (this.beR != 0) {
                al.i(this.view, this.beR);
            }
            if (this.view instanceof TextView) {
                if (this.beS != 0) {
                    al.c(this.view, this.beS, 1);
                }
                int a = a((TextView) this.view);
                if (a > 0 && a < 10) {
                    al.i(this.view, e.f.icon_news_head_prompt_one);
                } else if (a >= 10 && a < 100) {
                    al.i(this.view, e.f.icon_news_head_prompt_two);
                } else if (a >= 100) {
                    al.i(this.view, e.f.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.l(charSequence, -1);
        }
    }
}
