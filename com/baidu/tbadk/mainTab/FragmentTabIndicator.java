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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int ayj;
    public int ayk;
    private int ayl;
    private int aym;
    private TextView ayn;
    private int ayo;
    private int ayp;
    private HashMap<String, a> ayq;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.ayj = 0;
        this.ayq = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayj = 0;
        this.ayq = new HashMap<>();
        init();
    }

    private void init() {
        this.ayo = getResources().getDimensionPixelSize(r.f.ds2);
        this.ayp = getResources().getDimensionPixelSize(r.f.ds12);
        this.ayn = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.ayn.setLayoutParams(layoutParams);
        this.ayn.setGravity(17);
        this.ayn.setDuplicateParentStateEnabled(true);
        addView(this.ayn);
    }

    public void setContentTvTopMargin(int i) {
        if (this.ayn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayn.getLayoutParams();
            layoutParams.topMargin = i;
            this.ayn.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.ayq.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.ayq.entrySet().iterator();
        while (it.hasNext() && this.ayn.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.ayn.getPaint().measureText(this.ayn.getText().toString());
            if (value.ayr) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.nv;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.nv) - (measureText / 2);
            }
            if (this.ayj == 1) {
                i5 = measuredWidth - this.ayp;
                measuredHeight = this.ayo;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.ayj = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.ayq.put(str, aVar);
        }
    }

    public a ga(String str) {
        return this.ayq.get(str);
    }

    public void setText(int i) {
        this.ayn.setText(i);
    }

    public void setText(String str) {
        this.ayn.setText(str);
        this.ayn.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.ayn.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(r.l.talk_checked_tip)) + charSequence;
        }
        this.ayn.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.ayn.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.ayl = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aym = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.ayn.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.ayn.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.ayn.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.ayk = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dp(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dp(int i) {
        ap.c(this.ayn, this.ayk, 1);
        if (this.ayn != null) {
            this.ayn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.c((Resources) null, this.ayl), ap.getDrawable(this.aym), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.ayq.entrySet()) {
            entry.getValue().dp(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ays;
        public FragmentTabIndicator ayu;
        public int nv;
        public View view;
        public boolean ayr = true;
        public int ayt = r.e.common_color_10225;

        public void dp(int i) {
            if (this.ays != 0) {
                ap.j(this.view, this.ays);
            }
            if (this.view instanceof TextView) {
                if (this.ayt != 0) {
                    ap.c((TextView) this.view, this.ayt, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    ap.j((View) ((TextView) this.view), r.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    ap.j((View) ((TextView) this.view), r.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    ap.j((View) ((TextView) this.view), r.g.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.g(charSequence, -1);
        }
    }
}
