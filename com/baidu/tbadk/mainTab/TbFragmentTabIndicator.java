package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected boolean aID;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.aID = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aID = false;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aID = false;
    }

    public void dz(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void bJ(boolean z) {
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

    public a gM(String str) {
        return null;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void setIconViewWithoutText(int i, int i2) {
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
        this.aID = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aIF;
        public TbFragmentTabIndicator aIH;
        public int sU;

        /* renamed from: view  reason: collision with root package name */
        public View f7view;
        public boolean aIE = true;
        public int aIG = d.C0126d.common_color_10225;

        public void dz(int i) {
            if (this.aIF != 0) {
                ak.i(this.f7view, this.aIF);
            }
            if (this.f7view instanceof TextView) {
                if (this.aIG != 0) {
                    ak.c((TextView) this.f7view, this.aIG, 1);
                }
                int c = c((TextView) this.f7view);
                if (c > 0 && c < 10) {
                    ak.i((TextView) this.f7view, d.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    ak.i((TextView) this.f7view, d.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    ak.i((TextView) this.f7view, d.f.icon_news_head_prompt_more);
                }
            }
            if (this.f7view instanceof MessageRedDotView) {
                ((MessageRedDotView) this.f7view).onChangeSkinType();
            }
        }

        private int c(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.f7view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return com.baidu.adp.lib.g.b.g(charSequence, -1);
        }
    }
}
