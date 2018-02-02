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
    protected boolean bwg;

    public e(Context context) {
        super(context);
        this.bwg = false;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwg = false;
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwg = false;
    }

    public void gz(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void cn(boolean z) {
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

    public a gO(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void aJ(int i, int i2) {
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
        this.bwg = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aiF;
        public int bwi;
        public e bwk;
        public View view;
        public boolean bwh = true;
        public int bwj = d.C0108d.common_color_10225;

        public void gz(int i) {
            if (this.bwi != 0) {
                aj.s(this.view, this.bwi);
            }
            if (this.view instanceof TextView) {
                if (this.bwj != 0) {
                    aj.e((TextView) this.view, this.bwj, 1);
                }
                int e = e((TextView) this.view);
                if (e > 0 && e < 10) {
                    aj.s((TextView) this.view, d.f.icon_news_head_prompt_one);
                } else if (e >= 10 && e < 100) {
                    aj.s((TextView) this.view, d.f.icon_news_head_prompt_two);
                } else if (e >= 100) {
                    aj.s((TextView) this.view, d.f.icon_news_head_prompt_more);
                }
            }
        }

        private int e(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return com.baidu.adp.lib.g.b.h(charSequence, -1);
        }
    }
}
