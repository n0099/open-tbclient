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
    private int aDT;
    public int aDU;
    private int aDV;
    private int aDW;
    private TextView aDX;
    private int aDY;
    private int aDZ;
    private HashMap<String, a> aEa;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aDT = 0;
        this.aEa = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDT = 0;
        this.aEa = new HashMap<>();
        init();
    }

    private void init() {
        this.aDY = getResources().getDimensionPixelSize(w.f.ds2);
        this.aDZ = getResources().getDimensionPixelSize(w.f.ds12);
        this.aDX = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aDX.setLayoutParams(layoutParams);
        this.aDX.setGravity(17);
        this.aDX.setDuplicateParentStateEnabled(true);
        addView(this.aDX);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aDX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDX.getLayoutParams();
            layoutParams.topMargin = i;
            this.aDX.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aEa.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aEa.entrySet().iterator();
        while (it.hasNext() && this.aDX.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aDX.getPaint().measureText(this.aDX.getText().toString());
            if (value.aEb) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uN;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uN) - (measureText / 2);
            }
            if (this.aDT == 1) {
                i5 = measuredWidth - this.aDZ;
                measuredHeight = this.aDY;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aDT = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aEa.put(str, aVar);
        }
    }

    public a fV(String str) {
        return this.aEa.get(str);
    }

    public void setText(int i) {
        this.aDX.setText(i);
    }

    public void setText(String str) {
        this.aDX.setText(str);
        this.aDX.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aDX.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aDX.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aDX.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aDV = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aDW = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aDX.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aDX.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aDX.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aDU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14do(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* renamed from: do  reason: not valid java name */
    public void m14do(int i) {
        aq.c(this.aDX, this.aDU, 1);
        if (this.aDX != null) {
            this.aDX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.c((Resources) null, this.aDV), aq.getDrawable(this.aDW), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.aEa.entrySet()) {
            entry.getValue().m15do(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aEc;
        public FragmentTabIndicator aEe;
        public int uN;
        public View view;
        public boolean aEb = true;
        public int aEd = w.e.common_color_10225;

        /* renamed from: do  reason: not valid java name */
        public void m15do(int i) {
            if (this.aEc != 0) {
                aq.j(this.view, this.aEc);
            }
            if (this.view instanceof TextView) {
                if (this.aEd != 0) {
                    aq.c((TextView) this.view, this.aEd, 1);
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
