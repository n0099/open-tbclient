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
    private int awp;
    public int awq;
    private int awr;
    private int aws;
    private TextView awt;
    private int awu;
    private int awv;
    private HashMap<String, a> aww;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.awp = 0;
        this.aww = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awp = 0;
        this.aww = new HashMap<>();
        init();
    }

    private void init() {
        this.awu = getResources().getDimensionPixelSize(u.e.ds2);
        this.awv = getResources().getDimensionPixelSize(u.e.ds12);
        this.awt = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.awt.setLayoutParams(layoutParams);
        this.awt.setGravity(17);
        this.awt.setDuplicateParentStateEnabled(true);
        addView(this.awt);
    }

    public void setContentTvTopMargin(int i) {
        if (this.awt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awt.getLayoutParams();
            layoutParams.topMargin = i;
            this.awt.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aww.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aww.entrySet().iterator();
        while (it.hasNext() && this.awt.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.awt.getPaint().measureText(this.awt.getText().toString());
            if (value.awx) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.lg;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.lg) - (measureText / 2);
            }
            if (this.awp == 1) {
                i5 = measuredWidth - this.awv;
                measuredHeight = this.awu;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.awp = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aww.put(str, aVar);
        }
    }

    public a fX(String str) {
        return this.aww.get(str);
    }

    public void setText(int i) {
        this.awt.setText(i);
    }

    public void setText(String str) {
        this.awt.setText(str);
        this.awt.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.awt.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(u.j.talk_checked_tip)) + charSequence;
        }
        this.awt.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.awt.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.awr = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aws = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.awt.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.awt.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.awt.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.awq = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cX(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void cX(int i) {
        av.c(this.awt, this.awq, 1);
        if (this.awt != null) {
            this.awt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.c((Resources) null, this.awr), av.getDrawable(this.aws), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.aww.entrySet()) {
            entry.getValue().cX(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public FragmentTabIndicator awA;
        public int awy;
        public int lg;
        public View view;
        public boolean awx = true;
        public int awz = u.d.common_color_10225;

        public void cX(int i) {
            if (this.awy != 0) {
                av.k(this.view, this.awy);
            }
            if (this.view instanceof TextView) {
                if (this.awz != 0) {
                    av.c((TextView) this.view, this.awz, 1);
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

    public void Dm() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awt.getLayoutParams();
        layoutParams.width = -2;
        this.awt.setLayoutParams(layoutParams);
    }
}
