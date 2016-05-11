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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int auK;
    public int auL;
    private int auM;
    private int auN;
    private TextView auO;
    private int auP;
    private int auQ;
    private HashMap<String, a> auR;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.auK = 0;
        this.auR = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auK = 0;
        this.auR = new HashMap<>();
        init();
    }

    private void init() {
        this.auP = getResources().getDimensionPixelSize(t.e.ds2);
        this.auQ = getResources().getDimensionPixelSize(t.e.ds12);
        this.auO = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.auO.setLayoutParams(layoutParams);
        this.auO.setGravity(17);
        this.auO.setDuplicateParentStateEnabled(true);
        addView(this.auO);
    }

    public void setContentTvTopMargin(int i) {
        if (this.auO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auO.getLayoutParams();
            layoutParams.topMargin = i;
            this.auO.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.auR.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.auR.entrySet().iterator();
        while (it.hasNext() && this.auO.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.auO.getPaint().measureText(this.auO.getText().toString());
            if (value.auS) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.kF;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.kF) - (measureText / 2);
            }
            if (this.auK == 1) {
                i5 = measuredWidth - this.auQ;
                measuredHeight = this.auP;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.auK = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.auR.put(str, aVar);
        }
    }

    public a fT(String str) {
        return this.auR.get(str);
    }

    public void setText(int i) {
        this.auO.setText(i);
    }

    public void setText(String str) {
        this.auO.setText(str);
        this.auO.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.auO.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(t.j.talk_checked_tip)) + charSequence;
        }
        this.auO.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.auO.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.auM = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.auN = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.auO.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.auO.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.auO.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.auL = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cW(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void cW(int i) {
        at.c(this.auO, this.auL, 1);
        if (this.auO != null) {
            this.auO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, this.auM), at.getDrawable(this.auN), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.auR.entrySet()) {
            entry.getValue().cW(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int auT;
        public FragmentTabIndicator auV;
        public int kF;
        public View view;
        public boolean auS = true;
        public int auU = t.d.frs_slidebar_message_text;

        public void cW(int i) {
            if (this.auT != 0) {
                at.k(this.view, this.auT);
            }
            if (this.view instanceof TextView) {
                if (this.auU != 0) {
                    at.c((TextView) this.view, this.auU, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    at.k((TextView) this.view, t.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    at.k((TextView) this.view, t.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    at.k((TextView) this.view, t.f.icon_news_head_prompt_more);
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

    public void De() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auO.getLayoutParams();
        layoutParams.width = -2;
        this.auO.setLayoutParams(layoutParams);
    }
}
