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
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int ayZ;
    public int aza;
    private int azb;
    private int azc;
    private TextView azd;
    private int aze;
    private int azf;
    private HashMap<String, a> azg;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.ayZ = 0;
        this.azg = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayZ = 0;
        this.azg = new HashMap<>();
        init();
    }

    private void init() {
        this.aze = getResources().getDimensionPixelSize(r.e.ds2);
        this.azf = getResources().getDimensionPixelSize(r.e.ds12);
        this.azd = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.azd.setLayoutParams(layoutParams);
        this.azd.setGravity(17);
        this.azd.setDuplicateParentStateEnabled(true);
        addView(this.azd);
    }

    public void setContentTvTopMargin(int i) {
        if (this.azd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azd.getLayoutParams();
            layoutParams.topMargin = i;
            this.azd.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.azg.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.azg.entrySet().iterator();
        while (it.hasNext() && this.azd.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.azd.getPaint().measureText(this.azd.getText().toString());
            if (value.azh) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.nB;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.nB) - (measureText / 2);
            }
            if (this.ayZ == 1) {
                i5 = measuredWidth - this.azf;
                measuredHeight = this.aze;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.ayZ = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.azg.put(str, aVar);
        }
    }

    public a ge(String str) {
        return this.azg.get(str);
    }

    public void setText(int i) {
        this.azd.setText(i);
    }

    public void setText(String str) {
        this.azd.setText(str);
        this.azd.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.azd.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(r.j.talk_checked_tip)) + charSequence;
        }
        this.azd.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.azd.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.azb = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.azc = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.azd.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.azd.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.azd.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aza = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        av.c(this.azd, this.aza, 1);
        if (this.azd != null) {
            this.azd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.c((Resources) null, this.azb), av.getDrawable(this.azc), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.azg.entrySet()) {
            entry.getValue().dl(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int azi;
        public FragmentTabIndicator azk;
        public int nB;
        public View view;
        public boolean azh = true;
        public int azj = r.d.common_color_10225;

        public void dl(int i) {
            if (this.azi != 0) {
                av.k(this.view, this.azi);
            }
            if (this.view instanceof TextView) {
                if (this.azj != 0) {
                    av.c((TextView) this.view, this.azj, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    av.k((TextView) this.view, r.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    av.k((TextView) this.view, r.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    av.k((TextView) this.view, r.f.icon_news_head_prompt_more);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azd.getLayoutParams();
        layoutParams.width = -2;
        this.azd.setLayoutParams(layoutParams);
    }
}
