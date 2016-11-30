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
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int azR;
    public int azS;
    private int azT;
    private int azU;
    private TextView azV;
    private int azW;
    private int azX;
    private HashMap<String, a> azY;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.azR = 0;
        this.azY = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azR = 0;
        this.azY = new HashMap<>();
        init();
    }

    private void init() {
        this.azW = getResources().getDimensionPixelSize(r.e.ds2);
        this.azX = getResources().getDimensionPixelSize(r.e.ds12);
        this.azV = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.azV.setLayoutParams(layoutParams);
        this.azV.setGravity(17);
        this.azV.setDuplicateParentStateEnabled(true);
        addView(this.azV);
    }

    public void setContentTvTopMargin(int i) {
        if (this.azV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azV.getLayoutParams();
            layoutParams.topMargin = i;
            this.azV.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.azY.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.azY.entrySet().iterator();
        while (it.hasNext() && this.azV.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.azV.getPaint().measureText(this.azV.getText().toString());
            if (value.azZ) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.nC;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.nC) - (measureText / 2);
            }
            if (this.azR == 1) {
                i5 = measuredWidth - this.azX;
                measuredHeight = this.azW;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.azR = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.azY.put(str, aVar);
        }
    }

    public a gh(String str) {
        return this.azY.get(str);
    }

    public void setText(int i) {
        this.azV.setText(i);
    }

    public void setText(String str) {
        this.azV.setText(str);
        this.azV.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.azV.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(r.j.talk_checked_tip)) + charSequence;
        }
        this.azV.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.azV.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.azT = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.azU = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.azV.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.azV.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.azV.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.azS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dm(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dm(int i) {
        at.c(this.azV, this.azS, 1);
        if (this.azV != null) {
            this.azV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, this.azT), at.getDrawable(this.azU), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.azY.entrySet()) {
            entry.getValue().dm(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aAa;
        public FragmentTabIndicator aAc;
        public int nC;
        public View view;
        public boolean azZ = true;
        public int aAb = r.d.common_color_10225;

        public void dm(int i) {
            if (this.aAa != 0) {
                at.k(this.view, this.aAa);
            }
            if (this.view instanceof TextView) {
                if (this.aAb != 0) {
                    at.c((TextView) this.view, this.aAb, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    at.k((TextView) this.view, r.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    at.k((TextView) this.view, r.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    at.k((TextView) this.view, r.f.icon_news_head_prompt_more);
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

    public void EL() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azV.getLayoutParams();
        layoutParams.width = -2;
        this.azV.setLayoutParams(layoutParams);
    }
}
