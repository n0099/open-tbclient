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
    protected boolean aRf;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.aRf = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRf = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRf = false;
    }

    public void dC(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void bN(boolean z) {
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

    public a hk(String str) {
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

    public void au(String str, String str2) {
    }

    public void Jc() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.aRf = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aRh;
        public TbFragmentTabIndicator aRj;
        public View view;
        public int zd;
        public boolean aRg = true;
        public int aRi = d.C0141d.common_color_10225;

        public void dC(int i) {
            if (this.aRh != 0) {
                al.i(this.view, this.aRh);
            }
            if (this.view instanceof TextView) {
                if (this.aRi != 0) {
                    al.c(this.view, this.aRi, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    al.i(this.view, d.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    al.i(this.view, d.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    al.i(this.view, d.f.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.g(charSequence, -1);
        }
    }
}
