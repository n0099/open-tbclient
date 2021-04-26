package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13618e;

    /* renamed from: f  reason: collision with root package name */
    public float f13619f;

    /* renamed from: g  reason: collision with root package name */
    public float f13620g;

    /* renamed from: h  reason: collision with root package name */
    public int f13621h;

    /* renamed from: i  reason: collision with root package name */
    public int f13622i;
    public ThemeColorInfo j;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f13623a;

        /* renamed from: c  reason: collision with root package name */
        public int f13625c;

        /* renamed from: d  reason: collision with root package name */
        public int f13626d;

        /* renamed from: f  reason: collision with root package name */
        public TbFragmentTabIndicator f13628f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13624b = true;

        /* renamed from: e  reason: collision with root package name */
        public int f13627e = R.color.common_color_10225;

        public final int a(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.f13623a).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return b.d(charSequence, -1);
        }

        public void b(int i2) {
            int i3 = this.f13626d;
            if (i3 != 0) {
                SkinManager.setBackgroundResource(this.f13623a, i3);
            }
            View view = this.f13623a;
            if (view instanceof TextView) {
                int i4 = this.f13627e;
                if (i4 != 0) {
                    SkinManager.setViewTextColor(view, i4, 1);
                }
                int a2 = a((TextView) this.f13623a);
                if (a2 > 0 && a2 < 10) {
                    SkinManager.setBackgroundResource(this.f13623a, R.drawable.icon_news_head_prompt_one);
                } else if (a2 >= 10 && a2 < 100) {
                    SkinManager.setBackgroundResource(this.f13623a, R.drawable.icon_news_head_prompt_two);
                } else if (a2 >= 100) {
                    SkinManager.setBackgroundResource(this.f13623a, R.drawable.icon_news_head_prompt_more);
                }
            }
            View view2 = this.f13623a;
            if (view2 instanceof MessageRedDotView) {
                ((MessageRedDotView) view2).e();
            }
        }
    }

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.f13618e = false;
        this.f13619f = 0.0f;
        this.f13620g = 0.0f;
        this.f13621h = 0;
        this.f13622i = 0;
    }

    public void a(String str, a aVar) {
    }

    public void b(String str, a aVar) {
    }

    public void c() {
    }

    public a d(String str) {
        return null;
    }

    public void e(int i2) {
    }

    public void f(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setAnimationResId(int i2) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void setCompoundDrawablePadding(int i2) {
    }

    public void setCompoundDrawablesTopResId(int i2) {
    }

    public void setContentDefaultTextColor(int i2) {
        this.f13622i = i2;
    }

    public void setContentDefaultTextSize(float f2) {
        this.f13620g = f2;
    }

    public void setContentSelectTextColor(int i2) {
        this.f13621h = i2;
    }

    public void setContentSelectTextSize(float f2) {
        this.f13619f = f2;
    }

    public void setContentTvTopMargin(int i2) {
    }

    public void setIconResourceId(int i2) {
    }

    public void setIconViewWithText(int i2, int i3) {
    }

    public void setIconViewWithoutText(int i2, int i3) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.f13618e = z;
    }

    public void setText(int i2) {
    }

    public void setText(String str) {
    }

    public void setTextColorResId(int i2) {
    }

    public void setTextSize(float f2) {
    }

    public void setTextSize(int i2, float f2) {
    }

    public void setThemeColorInfo(ThemeColorInfo themeColorInfo) {
        this.j = themeColorInfo;
    }

    public void setTipPosType(int i2) {
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13618e = false;
        this.f13619f = 0.0f;
        this.f13620g = 0.0f;
        this.f13621h = 0;
        this.f13622i = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13618e = false;
        this.f13619f = 0.0f;
        this.f13620g = 0.0f;
        this.f13621h = 0;
        this.f13622i = 0;
    }
}
