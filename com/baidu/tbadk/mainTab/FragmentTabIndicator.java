package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int azo;
    public int azp;
    private int azq;
    private int azr;
    private TextView azs;
    private int azt;
    private int azu;
    private HashMap<String, a> azv;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.azo = 0;
        this.azv = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azo = 0;
        this.azv = new HashMap<>();
        init();
    }

    private void init() {
        this.azt = getResources().getDimensionPixelSize(r.e.ds2);
        this.azu = getResources().getDimensionPixelSize(r.e.ds12);
        this.azs = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.azs.setLayoutParams(layoutParams);
        this.azs.setGravity(17);
        this.azs.setDuplicateParentStateEnabled(true);
        addView(this.azs);
    }

    public void setContentTvTopMargin(int i) {
        if (this.azs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azs.getLayoutParams();
            layoutParams.topMargin = i;
            this.azs.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.azv.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.azv.entrySet().iterator();
        while (it.hasNext() && this.azs.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.azs.getPaint().measureText(this.azs.getText().toString());
            if (value.azw) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.nC;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.nC) - (measureText / 2);
            }
            if (this.azo == 1) {
                i5 = measuredWidth - this.azu;
                measuredHeight = this.azt;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.azo = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.azv.put(str, aVar);
        }
    }

    public a gd(String str) {
        return this.azv.get(str);
    }

    public void setText(int i) {
        this.azs.setText(i);
    }

    public void setText(String str) {
        this.azs.setText(str);
        this.azs.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.azs.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(r.j.talk_checked_tip)) + charSequence;
        }
        this.azs.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.azs.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.azq = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.azr = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.azs.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.azs.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.azs.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.azp = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14do(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(int i) {
        ar.c(this.azs, this.azp, 1);
        if (this.azs != null) {
            this.azs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.c((Resources) null, this.azq), ar.getDrawable(this.azr), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.azv.entrySet()) {
            entry.getValue().m15do(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int azx;
        public FragmentTabIndicator azz;
        public int nC;
        public View view;
        public boolean azw = true;
        public int azy = r.d.common_color_10225;

        /* renamed from: do  reason: not valid java name */
        public void m15do(int i) {
            if (this.azx != 0) {
                ar.k(this.view, this.azx);
            }
            if (this.view instanceof TextView) {
                if (this.azy != 0) {
                    ar.c((TextView) this.view, this.azy, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    ar.k((TextView) this.view, r.f.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    ar.k((TextView) this.view, r.f.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    ar.k((TextView) this.view, r.f.icon_news_head_prompt_more);
                }
            }
        }

        private int b(TextView textView) {
            if (textView == null) {
                return -1;
            }
            String charSequence = ((TextView) this.view).getText().toString();
            if ("   ".equals(charSequence)) {
                return 100;
            }
            return com.baidu.adp.lib.h.b.g(charSequence, -1);
        }
    }

    public void Et() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azs.getLayoutParams();
        layoutParams.width = -2;
        this.azs.setLayoutParams(layoutParams);
    }
}
