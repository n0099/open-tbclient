package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import d.b.b.e.m.b;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public abstract class TbFragmentTabIndicator extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13951e;

    /* renamed from: f  reason: collision with root package name */
    public float f13952f;

    /* renamed from: g  reason: collision with root package name */
    public float f13953g;

    /* renamed from: h  reason: collision with root package name */
    public int f13954h;
    public int i;
    public ThemeColorInfo j;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f13955a;

        /* renamed from: c  reason: collision with root package name */
        public int f13957c;

        /* renamed from: d  reason: collision with root package name */
        public int f13958d;

        /* renamed from: f  reason: collision with root package name */
        public TbFragmentTabIndicator f13960f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13956b = true;

        /* renamed from: e  reason: collision with root package name */
        public int f13959e = R.color.common_color_10225;

        public final int a(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.f13955a).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return b.d(charSequence, -1);
        }

        public void b(int i) {
            int i2 = this.f13958d;
            if (i2 != 0) {
                SkinManager.setBackgroundResource(this.f13955a, i2);
            }
            View view = this.f13955a;
            if (view instanceof TextView) {
                int i3 = this.f13959e;
                if (i3 != 0) {
                    SkinManager.setViewTextColor(view, i3, 1);
                }
                int a2 = a((TextView) this.f13955a);
                if (a2 > 0 && a2 < 10) {
                    SkinManager.setBackgroundResource(this.f13955a, R.drawable.icon_news_head_prompt_one);
                } else if (a2 >= 10 && a2 < 100) {
                    SkinManager.setBackgroundResource(this.f13955a, R.drawable.icon_news_head_prompt_two);
                } else if (a2 >= 100) {
                    SkinManager.setBackgroundResource(this.f13955a, R.drawable.icon_news_head_prompt_more);
                }
            }
            View view2 = this.f13955a;
            if (view2 instanceof MessageRedDotView) {
                ((MessageRedDotView) view2).e();
            }
        }
    }

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.f13951e = false;
        this.f13952f = 0.0f;
        this.f13953g = 0.0f;
        this.f13954h = 0;
        this.i = 0;
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

    public void e(int i) {
    }

    public void f(boolean z) {
    }

    public View getContentTv() {
        return null;
    }

    public void setAnimationResId(int i) {
    }

    public void setCheckDescriptionText(boolean z) {
    }

    public void setCompoundDrawablePadding(int i) {
    }

    public void setCompoundDrawablesTopResId(int i) {
    }

    public void setContentDefaultTextColor(int i) {
        this.i = i;
    }

    public void setContentDefaultTextSize(float f2) {
        this.f13953g = f2;
    }

    public void setContentSelectTextColor(int i) {
        this.f13954h = i;
    }

    public void setContentSelectTextSize(float f2) {
        this.f13952f = f2;
    }

    public void setContentTvTopMargin(int i) {
    }

    public void setIconResourceId(int i) {
    }

    public void setIconViewWithText(int i, int i2) {
    }

    public void setIconViewWithoutText(int i, int i2) {
    }

    public void setIsContentSelectBold(boolean z) {
        this.f13951e = z;
    }

    public void setText(int i) {
    }

    public void setText(String str) {
    }

    public void setTextColorResId(int i) {
    }

    public void setTextSize(float f2) {
    }

    public void setTextSize(int i, float f2) {
    }

    public void setThemeColorInfo(ThemeColorInfo themeColorInfo) {
        this.j = themeColorInfo;
    }

    public void setTipPosType(int i) {
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13951e = false;
        this.f13952f = 0.0f;
        this.f13953g = 0.0f;
        this.f13954h = 0;
        this.i = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13951e = false;
        this.f13952f = 0.0f;
        this.f13953g = 0.0f;
        this.f13954h = 0;
        this.i = 0;
    }
}
