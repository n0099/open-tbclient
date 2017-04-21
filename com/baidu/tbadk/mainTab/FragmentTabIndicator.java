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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int aDV;
    public int aDW;
    private int aDX;
    private int aDY;
    private TextView aDZ;
    private int aEa;
    private int aEb;
    private HashMap<String, a> aEc;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aDV = 0;
        this.aEc = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDV = 0;
        this.aEc = new HashMap<>();
        init();
    }

    private void init() {
        this.aEa = getResources().getDimensionPixelSize(w.f.ds2);
        this.aEb = getResources().getDimensionPixelSize(w.f.ds12);
        this.aDZ = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aDZ.setLayoutParams(layoutParams);
        this.aDZ.setGravity(17);
        this.aDZ.setDuplicateParentStateEnabled(true);
        addView(this.aDZ);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aDZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDZ.getLayoutParams();
            layoutParams.topMargin = i;
            this.aDZ.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aEc.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aEc.entrySet().iterator();
        while (it.hasNext() && this.aDZ.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aDZ.getPaint().measureText(this.aDZ.getText().toString());
            if (value.aEd) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uS;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uS) - (measureText / 2);
            }
            if (this.aDV == 1) {
                i5 = measuredWidth - this.aEb;
                measuredHeight = this.aEa;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aDV = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aEc.put(str, aVar);
        }
    }

    public a fV(String str) {
        return this.aEc.get(str);
    }

    public void setText(int i) {
        this.aDZ.setText(i);
    }

    public void setText(String str) {
        this.aDZ.setText(str);
        this.aDZ.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aDZ.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aDZ.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aDZ.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aDX = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aDY = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aDZ.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aDZ.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aDZ.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aDW = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14do(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(int i) {
        aq.c(this.aDZ, this.aDW, 1);
        if (this.aDZ != null) {
            this.aDZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.c((Resources) null, this.aDX), aq.getDrawable(this.aDY), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.aEc.entrySet()) {
            entry.getValue().m15do(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aEe;
        public FragmentTabIndicator aEg;
        public int uS;
        public View view;
        public boolean aEd = true;
        public int aEf = w.e.common_color_10225;

        /* renamed from: do  reason: not valid java name */
        public void m15do(int i) {
            if (this.aEe != 0) {
                aq.j(this.view, this.aEe);
            }
            if (this.view instanceof TextView) {
                if (this.aEf != 0) {
                    aq.c((TextView) this.view, this.aEf, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_more);
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
