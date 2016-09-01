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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private TextView azA;
    private int azB;
    private int azC;
    private HashMap<String, a> azD;
    private int azw;
    public int azx;
    private int azy;
    private int azz;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.azw = 0;
        this.azD = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azw = 0;
        this.azD = new HashMap<>();
        init();
    }

    private void init() {
        this.azB = getResources().getDimensionPixelSize(t.e.ds2);
        this.azC = getResources().getDimensionPixelSize(t.e.ds12);
        this.azA = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.azA.setLayoutParams(layoutParams);
        this.azA.setGravity(17);
        this.azA.setDuplicateParentStateEnabled(true);
        addView(this.azA);
    }

    public void setContentTvTopMargin(int i) {
        if (this.azA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azA.getLayoutParams();
            layoutParams.topMargin = i;
            this.azA.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.azD.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.azD.entrySet().iterator();
        while (it.hasNext() && this.azA.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.azA.getPaint().measureText(this.azA.getText().toString());
            if (value.azE) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.nB;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.nB) - (measureText / 2);
            }
            if (this.azw == 1) {
                i5 = measuredWidth - this.azC;
                measuredHeight = this.azB;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.azw = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.azD.put(str, aVar);
        }
    }

    public a ga(String str) {
        return this.azD.get(str);
    }

    public void setText(int i) {
        this.azA.setText(i);
    }

    public void setText(String str) {
        this.azA.setText(str);
        this.azA.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.azA.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(t.j.talk_checked_tip)) + charSequence;
        }
        this.azA.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.azA.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.azy = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.azz = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.azA.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.azA.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.azA.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.azx = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        av.c(this.azA, this.azx, 1);
        if (this.azA != null) {
            this.azA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.c((Resources) null, this.azy), av.getDrawable(this.azz), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.azD.entrySet()) {
            entry.getValue().dl(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int azF;
        public FragmentTabIndicator azH;
        public int nB;
        public View view;
        public boolean azE = true;
        public int azG = t.d.common_color_10225;

        public void dl(int i) {
            if (this.azF != 0) {
                av.k(this.view, this.azF);
            }
            if (this.view instanceof TextView) {
                if (this.azG != 0) {
                    av.c((TextView) this.view, this.azG, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    av.k((TextView) this.view, t.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    av.k((TextView) this.view, t.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    av.k((TextView) this.view, t.f.icon_news_head_prompt_more);
                }
            }
        }

        private int c(TextView textView) {
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

    public void EG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azA.getLayoutParams();
        layoutParams.width = -2;
        this.azA.setLayoutParams(layoutParams);
    }
}
