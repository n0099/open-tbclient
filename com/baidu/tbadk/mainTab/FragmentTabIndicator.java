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
    private int aDD;
    public int aDE;
    private int aDF;
    private int aDG;
    private TextView aDH;
    private int aDI;
    private int aDJ;
    private HashMap<String, a> aDK;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aDD = 0;
        this.aDK = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDD = 0;
        this.aDK = new HashMap<>();
        init();
    }

    private void init() {
        this.aDI = getResources().getDimensionPixelSize(w.f.ds2);
        this.aDJ = getResources().getDimensionPixelSize(w.f.ds12);
        this.aDH = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aDH.setLayoutParams(layoutParams);
        this.aDH.setGravity(17);
        this.aDH.setDuplicateParentStateEnabled(true);
        addView(this.aDH);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aDH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDH.getLayoutParams();
            layoutParams.topMargin = i;
            this.aDH.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aDK.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aDK.entrySet().iterator();
        while (it.hasNext() && this.aDH.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aDH.getPaint().measureText(this.aDH.getText().toString());
            if (value.aDL) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.vk;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.vk) - (measureText / 2);
            }
            if (this.aDD == 1) {
                i5 = measuredWidth - this.aDJ;
                measuredHeight = this.aDI;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aDD = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aDK.put(str, aVar);
        }
    }

    public a fP(String str) {
        return this.aDK.get(str);
    }

    public void setText(int i) {
        this.aDH.setText(i);
    }

    public void setText(String str) {
        this.aDH.setText(str);
        this.aDH.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aDH.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aDH.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aDH.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aDF = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aDG = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aDH.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aDH.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aDH.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aDE = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        aq.c(this.aDH, this.aDE, 1);
        if (this.aDH != null) {
            this.aDH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.c((Resources) null, this.aDF), aq.getDrawable(this.aDG), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.aDK.entrySet()) {
            entry.getValue().dl(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aDM;
        public FragmentTabIndicator aDO;
        public View view;
        public int vk;
        public boolean aDL = true;
        public int aDN = w.e.common_color_10225;

        public void dl(int i) {
            if (this.aDM != 0) {
                aq.j(this.view, this.aDM);
            }
            if (this.view instanceof TextView) {
                if (this.aDN != 0) {
                    aq.c((TextView) this.view, this.aDN, 1);
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
