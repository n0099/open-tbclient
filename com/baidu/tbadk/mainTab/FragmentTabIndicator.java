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
    private int ayJ;
    public int ayK;
    private int ayL;
    private int ayM;
    private TextView ayN;
    private int ayO;
    private int ayP;
    private HashMap<String, a> ayQ;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.ayJ = 0;
        this.ayQ = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayJ = 0;
        this.ayQ = new HashMap<>();
        init();
    }

    private void init() {
        this.ayO = getResources().getDimensionPixelSize(t.e.ds2);
        this.ayP = getResources().getDimensionPixelSize(t.e.ds12);
        this.ayN = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.ayN.setLayoutParams(layoutParams);
        this.ayN.setGravity(17);
        this.ayN.setDuplicateParentStateEnabled(true);
        addView(this.ayN);
    }

    public void setContentTvTopMargin(int i) {
        if (this.ayN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayN.getLayoutParams();
            layoutParams.topMargin = i;
            this.ayN.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.ayQ.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.ayQ.entrySet().iterator();
        while (it.hasNext() && this.ayN.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.ayN.getPaint().measureText(this.ayN.getText().toString());
            if (value.ayR) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uO;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uO) - (measureText / 2);
            }
            if (this.ayJ == 1) {
                i5 = measuredWidth - this.ayP;
                measuredHeight = this.ayO;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.ayJ = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.ayQ.put(str, aVar);
        }
    }

    public a fW(String str) {
        return this.ayQ.get(str);
    }

    public void setText(int i) {
        this.ayN.setText(i);
    }

    public void setText(String str) {
        this.ayN.setText(str);
        this.ayN.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.ayN.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(t.j.talk_checked_tip)) + charSequence;
        }
        this.ayN.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.ayN.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.ayL = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.ayM = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.ayN.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.ayN.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.ayN.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.ayK = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dn(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dn(int i) {
        at.b(this.ayN, this.ayK, 1);
        if (this.ayN != null) {
            this.ayN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.c((Resources) null, this.ayL), at.getDrawable(this.ayM), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.ayQ.entrySet()) {
            entry.getValue().dn(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ayS;
        public FragmentTabIndicator ayU;
        public int uO;
        public View view;
        public boolean ayR = true;
        public int ayT = t.d.frs_slidebar_message_text;

        public void dn(int i) {
            if (this.ayS != 0) {
                at.k(this.view, this.ayS);
            }
            if (this.view instanceof TextView) {
                if (this.ayT != 0) {
                    at.b((TextView) this.view, this.ayT, 1);
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

    public void Fm() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayN.getLayoutParams();
        layoutParams.width = -2;
        this.ayN.setLayoutParams(layoutParams);
    }
}
