package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.l.c;
import d.a.c.e.m.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    public final c<d.a.c.k.d.a> A;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public String r;
    public String s;
    public BdUniqueId t;
    public ImageView u;
    public TextView v;
    public int w;
    public int x;
    public boolean y;
    public HashMap<String, TbFragmentTabIndicator.a> z;

    /* loaded from: classes3.dex */
    public class a extends d {
        public a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            FragmentTabIndicator.this.p = true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c<d.a.c.k.d.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (FragmentTabIndicator.this.u == null || aVar == null || !aVar.w()) {
                FragmentTabIndicator.this.l();
                return;
            }
            FragmentTabIndicator.this.u.setBackgroundResource(0);
            FragmentTabIndicator.this.u.setImageDrawable(null);
            aVar.h(FragmentTabIndicator.this.u);
        }
    }

    public FragmentTabIndicator(Context context) {
        super(context);
        this.k = 0;
        this.o = 0;
        this.p = true;
        this.y = true;
        this.z = new HashMap<>();
        this.A = new b();
        j();
    }

    private BdUniqueId getBdUniqueId() {
        BdUniqueId bdUniqueId = this.t;
        if (bdUniqueId != null) {
            return bdUniqueId;
        }
        f<?> a2 = j.a(getContext());
        if (a2 != null) {
            this.t = a2.getUniqueId();
        }
        return this.t;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view = aVar.f13014a;
        if (view != null) {
            addView(view);
            this.z.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void c() {
        if (this.o <= 0 || !this.p) {
            return;
        }
        try {
            this.p = false;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.u.getContext(), this.o);
            loadAnimation.setAnimationListener(new a());
            this.u.startAnimation(loadAnimation);
        } catch (Exception unused) {
            this.p = true;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        return this.z.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i2) {
        if (this.y) {
            SkinManager.setViewTextColor(this.v, this.l, 1);
        } else {
            SkinManager.setViewTextColor(this.v, this.l, 1, 0);
        }
        if (this.v != null) {
            this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.m), SkinManager.getSkinDrawable(null, this.n), (Drawable) null);
        }
        k();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.z.entrySet()) {
            entry.getValue().b(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        super.f(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.v;
    }

    public final void j() {
        this.w = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.x = getResources().getDimensionPixelSize(R.dimen.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
        this.u = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.view_bottom_text);
        this.v = textView;
        textView.setDuplicateParentStateEnabled(true);
        l();
    }

    public final void k() {
        if (this.m > 0 || this.n > 0) {
            return;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.s)) {
            d.a.c.e.l.d.h().m(this.s, 10, this.A, getBdUniqueId());
        } else if (!TextUtils.isEmpty(this.r)) {
            d.a.c.e.l.d.h().m(this.r, 10, this.A, getBdUniqueId());
        } else {
            l();
        }
    }

    public final void l() {
        int i2 = this.q;
        if (i2 > 0) {
            SkinManager.setImageResource(this.u, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth;
        int measuredHeight;
        super.onLayout(z, i2, i3, i4, i5);
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.z.entrySet().iterator();
        while (it.hasNext() && this.v.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.f13014a.getMeasuredWidth();
            int measuredHeight2 = value.f13014a.getMeasuredHeight();
            int measureText = (int) this.v.getPaint().measureText(this.v.getText().toString());
            if (value.f13015b) {
                measuredWidth = (getMeasuredWidth() / 2) + value.f13016c + (measureText / 2);
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.f13016c) - (measureText / 2);
            }
            if (this.k == 1) {
                measuredWidth -= this.x;
                measuredHeight = this.w;
            } else {
                measuredHeight = (getMeasuredHeight() / 2) - (value.f13014a.getMeasuredHeight() / 2);
            }
            value.f13014a.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.z.entrySet()) {
            TbFragmentTabIndicator.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.f13014a.getLayoutParams();
            int i4 = layoutParams.width;
            if (i4 == -2) {
                value.f13014a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            } else {
                if (i4 > size) {
                    i4 = size;
                }
                int i5 = layoutParams.height;
                if (i5 > size2) {
                    i5 = size2;
                }
                value.f13014a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        this.o = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.v.getText().toString();
        if (z) {
            charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
        }
        this.v.setContentDescription(charSequence);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i2) {
        this.v.setCompoundDrawablePadding(i2);
    }

    public void setCompoundDrawablesRightResId(int i2) {
        this.n = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i2) {
        this.m = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i2) {
        super.setContentDefaultTextColor(i2);
        this.v.setTextColor(i2);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i2) {
        if (this.v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.topMargin = i2;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        layoutParams.width = -2;
        this.v.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i2) {
        this.q = i2;
        l();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i2, int i3) {
        this.v.setVisibility(0);
        this.u.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.v.setLayoutParams(layoutParams);
        if (i2 > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            layoutParams2.bottomMargin = i3;
            layoutParams2.addRule(2, this.u.getId());
            layoutParams2.addRule(14, -1);
            this.u.setLayoutParams(layoutParams2);
        }
        k();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i2, int i3) {
        setClipToPadding(false);
        setClipChildren(false);
        this.v.setVisibility(8);
        this.u.setVisibility(0);
        if (i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = i2;
            layoutParams.height = i2;
            layoutParams.bottomMargin = i3;
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.u.setLayoutParams(layoutParams);
        }
        k();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.f13009e = z;
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            SkinManager.setViewTextColor(this.v, this.l, 1, 0);
        }
        this.y = z;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.f13009e) {
            this.v.getPaint().setFakeBoldText(z);
        }
        if (z) {
            float f2 = this.f13010f;
            if (f2 != 0.0f) {
                this.v.setTextSize(0, f2);
            }
            ThemeColorInfo themeColorInfo = this.j;
            if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    this.v.setTextColor(d.a.o0.e3.c.c(this.j.dark.font_color));
                    return;
                } else if (skinType == 1) {
                    this.v.setTextColor(d.a.o0.e3.c.c(this.j.night.font_color));
                    return;
                } else {
                    this.v.setTextColor(d.a.o0.e3.c.c(this.j.day.font_color));
                    return;
                }
            }
            int i2 = this.f13012h;
            if (i2 != 0) {
                SkinManager.setViewTextColor(this.v, i2);
                return;
            }
            return;
        }
        float f3 = this.f13011g;
        if (f3 != 0.0f) {
            this.v.setTextSize(0, f3);
        }
        int i3 = this.f13013i;
        if (i3 != 0) {
            SkinManager.setViewTextColor(this.v, i3);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        this.v.setText(i2);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        this.l = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f2) {
        this.v.setTextSize(f2);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.v.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        this.k = i2;
    }

    public void setTipTopMargin(int i2) {
        this.w = i2;
    }

    public void setWidth(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, -2);
        layoutParams.addRule(13, -1);
        this.v.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.v.setText(str);
        this.v.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i2, float f2) {
        this.v.setTextSize(i2, f2);
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.o = 0;
        this.p = true;
        this.y = true;
        this.z = new HashMap<>();
        this.A = new b();
        j();
    }
}
