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
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int avA;
    public int avB;
    private int avC;
    private int avD;
    private TextView avE;
    private int avF;
    private int avG;
    private HashMap<String, a> avH;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.avA = 0;
        this.avH = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avA = 0;
        this.avH = new HashMap<>();
        init();
    }

    private void init() {
        this.avF = getResources().getDimensionPixelSize(u.e.ds2);
        this.avG = getResources().getDimensionPixelSize(u.e.ds12);
        this.avE = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.avE.setLayoutParams(layoutParams);
        this.avE.setGravity(17);
        this.avE.setDuplicateParentStateEnabled(true);
        addView(this.avE);
    }

    public void setContentTvTopMargin(int i) {
        if (this.avE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avE.getLayoutParams();
            layoutParams.topMargin = i;
            this.avE.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.avH.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.avH.entrySet().iterator();
        while (it.hasNext() && this.avE.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.avE.getPaint().measureText(this.avE.getText().toString());
            if (value.avI) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.kD;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.kD) - (measureText / 2);
            }
            if (this.avA == 1) {
                i5 = measuredWidth - this.avG;
                measuredHeight = this.avF;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.avA = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.avH.put(str, aVar);
        }
    }

    public a fZ(String str) {
        return this.avH.get(str);
    }

    public void setText(int i) {
        this.avE.setText(i);
    }

    public void setText(String str) {
        this.avE.setText(str);
        this.avE.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.avE.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(u.j.talk_checked_tip)) + charSequence;
        }
        this.avE.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.avE.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.avC = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.avD = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.avE.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.avE.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.avE.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.avB = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cX(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cX(int i) {
        av.c(this.avE, this.avB, 1);
        if (this.avE != null) {
            this.avE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.c((Resources) null, this.avC), av.getDrawable(this.avD), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.avH.entrySet()) {
            entry.getValue().cX(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int avJ;
        public FragmentTabIndicator avL;
        public int kD;
        public View view;
        public boolean avI = true;
        public int avK = u.d.common_color_10225;

        public void cX(int i) {
            if (this.avJ != 0) {
                av.k(this.view, this.avJ);
            }
            if (this.view instanceof TextView) {
                if (this.avK != 0) {
                    av.c((TextView) this.view, this.avK, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    av.k((TextView) this.view, u.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    av.k((TextView) this.view, u.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    av.k((TextView) this.view, u.f.icon_news_head_prompt_more);
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

    public void Dn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avE.getLayoutParams();
        layoutParams.width = -2;
        this.avE.setLayoutParams(layoutParams);
    }
}
