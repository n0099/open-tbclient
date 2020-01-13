package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {
    protected float dxu;
    protected float dxv;
    protected int dxw;
    protected int dxx;
    protected boolean mIsContentSelectBold;
    protected ThemeColorInfo mThemeColorInfo;

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.mIsContentSelectBold = false;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0;
        this.dxx = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsContentSelectBold = false;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0;
        this.dxx = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsContentSelectBold = false;
        this.dxu = 0.0f;
        this.dxv = 0.0f;
        this.dxw = 0;
        this.dxx = 0;
    }

    public void onChangeSkin(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void onTabSelected(boolean z) {
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

    public a vi(String str) {
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

    public void aNz() {
    }

    public void setAnimationResId(int i) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.mIsContentSelectBold = z;
    }

    public void setContentSelectTextSize(float f) {
        this.dxu = f;
    }

    public void setContentDefaultTextSize(float f) {
        this.dxv = f;
    }

    public void setContentSelectTextColor(int i) {
        this.dxw = i;
    }

    public void setContentDefaultTextColor(int i) {
        this.dxx = i;
    }

    public void setThemeColorInfo(ThemeColorInfo themeColorInfo) {
        this.mThemeColorInfo = themeColorInfo;
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bgDayRes;
        public TbFragmentTabIndicator dxy;
        public int offsetX;
        public View view;
        public boolean isRight = true;
        public int textDayColor = R.color.common_color_10225;

        public void onChangeSkin(int i) {
            if (this.bgDayRes != 0) {
                am.setBackgroundResource(this.view, this.bgDayRes);
            }
            if (this.view instanceof TextView) {
                if (this.textDayColor != 0) {
                    am.setViewTextColor(this.view, this.textDayColor, 1);
                }
                int messageCount = getMessageCount((TextView) this.view);
                if (messageCount > 0 && messageCount < 10) {
                    am.setBackgroundResource(this.view, R.drawable.icon_news_head_prompt_one);
                } else if (messageCount >= 10 && messageCount < 100) {
                    am.setBackgroundResource(this.view, R.drawable.icon_news_head_prompt_two);
                } else if (messageCount >= 100) {
                    am.setBackgroundResource(this.view, R.drawable.icon_news_head_prompt_more);
                }
            }
            if (this.view instanceof MessageRedDotView) {
                ((MessageRedDotView) this.view).onChangeSkinType();
            }
        }

        private int getMessageCount(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return com.baidu.adp.lib.f.b.toInt(charSequence, -1);
        }
    }
}
