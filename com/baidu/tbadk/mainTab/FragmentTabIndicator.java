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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int ayc;
    public int ayd;
    private int aye;
    private int ayf;
    private TextView ayg;
    private int ayh;
    private int ayi;
    private HashMap<String, a> ayj;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.ayc = 0;
        this.ayj = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayc = 0;
        this.ayj = new HashMap<>();
        init();
    }

    private void init() {
        this.ayh = getResources().getDimensionPixelSize(t.e.ds2);
        this.ayi = getResources().getDimensionPixelSize(t.e.ds12);
        this.ayg = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.ayg.setLayoutParams(layoutParams);
        this.ayg.setGravity(17);
        this.ayg.setDuplicateParentStateEnabled(true);
        addView(this.ayg);
    }

    public void setContentTvTopMargin(int i) {
        if (this.ayg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayg.getLayoutParams();
            layoutParams.topMargin = i;
            this.ayg.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.ayj.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.ayj.entrySet().iterator();
        while (it.hasNext() && this.ayg.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.ayg.getPaint().measureText(this.ayg.getText().toString());
            if (value.ayk) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uF;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uF) - (measureText / 2);
            }
            if (this.ayc == 1) {
                i5 = measuredWidth - this.ayi;
                measuredHeight = this.ayh;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.ayc = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.ayj.put(str, aVar);
        }
    }

    public a fO(String str) {
        return this.ayj.get(str);
    }

    public void setText(int i) {
        this.ayg.setText(i);
    }

    public void setText(String str) {
        this.ayg.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.ayg.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aye = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.ayf = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.ayg.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.ayg.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.ayg.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.ayd = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dk(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dk(int i) {
        ar.b(this.ayg, this.ayd, 1);
        if (this.ayg != null) {
            this.ayg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.c((Resources) null, this.aye), ar.getDrawable(this.ayf), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.ayj.entrySet()) {
            entry.getValue().dk(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ayl;
        public FragmentTabIndicator ayn;
        public int uF;
        public View view;
        public boolean ayk = true;
        public int aym = t.d.frs_slidebar_message_text;

        public void dk(int i) {
            if (this.ayl != 0) {
                ar.k(this.view, this.ayl);
            }
            if (this.view instanceof TextView) {
                if (this.aym != 0) {
                    ar.b((TextView) this.view, this.aym, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    ar.k((TextView) this.view, t.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    ar.k((TextView) this.view, t.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    ar.k((TextView) this.view, t.f.icon_news_head_prompt_more);
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

    public void Ez() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayg.getLayoutParams();
        layoutParams.width = -2;
        this.ayg.setLayoutParams(layoutParams);
    }
}
