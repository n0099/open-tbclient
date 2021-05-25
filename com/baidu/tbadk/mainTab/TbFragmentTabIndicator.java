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
    public boolean f12862e;

    /* renamed from: f  reason: collision with root package name */
    public float f12863f;

    /* renamed from: g  reason: collision with root package name */
    public float f12864g;

    /* renamed from: h  reason: collision with root package name */
    public int f12865h;

    /* renamed from: i  reason: collision with root package name */
    public int f12866i;
    public ThemeColorInfo j;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f12867a;

        /* renamed from: c  reason: collision with root package name */
        public int f12869c;

        /* renamed from: d  reason: collision with root package name */
        public int f12870d;

        /* renamed from: f  reason: collision with root package name */
        public TbFragmentTabIndicator f12872f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12868b = true;

        /* renamed from: e  reason: collision with root package name */
        public int f12871e = R.color.common_color_10225;

        public final int a(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.f12867a).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return b.d(charSequence, -1);
        }

        public void b(int i2) {
            int i3 = this.f12870d;
            if (i3 != 0) {
                SkinManager.setBackgroundResource(this.f12867a, i3);
            }
            View view = this.f12867a;
            if (view instanceof TextView) {
                int i4 = this.f12871e;
                if (i4 != 0) {
                    SkinManager.setViewTextColor(view, i4, 1);
                }
                int a2 = a((TextView) this.f12867a);
                if (a2 > 0 && a2 < 10) {
                    SkinManager.setBackgroundResource(this.f12867a, R.drawable.icon_news_head_prompt_one);
                } else if (a2 >= 10 && a2 < 100) {
                    SkinManager.setBackgroundResource(this.f12867a, R.drawable.icon_news_head_prompt_two);
                } else if (a2 >= 100) {
                    SkinManager.setBackgroundResource(this.f12867a, R.drawable.icon_news_head_prompt_more);
                }
            }
            View view2 = this.f12867a;
            if (view2 instanceof MessageRedDotView) {
                ((MessageRedDotView) view2).e();
            }
        }
    }

    public TbFragmentTabIndicator(Context context) {
        super(context);
        this.f12862e = false;
        this.f12863f = 0.0f;
        this.f12864g = 0.0f;
        this.f12865h = 0;
        this.f12866i = 0;
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
        this.f12866i = i2;
    }

    public void setContentDefaultTextSize(float f2) {
        this.f12864g = f2;
    }

    public void setContentSelectTextColor(int i2) {
        this.f12865h = i2;
    }

    public void setContentSelectTextSize(float f2) {
        this.f12863f = f2;
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
        this.f12862e = z;
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
        this.f12862e = false;
        this.f12863f = 0.0f;
        this.f12864g = 0.0f;
        this.f12865h = 0;
        this.f12866i = 0;
    }

    public TbFragmentTabIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12862e = false;
        this.f12863f = 0.0f;
        this.f12864g = 0.0f;
        this.f12865h = 0;
        this.f12866i = 0;
    }
}
