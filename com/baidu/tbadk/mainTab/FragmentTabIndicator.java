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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int auM;
    public int auN;
    private int auO;
    private int auP;
    private TextView auQ;
    private int auR;
    private int auS;
    private HashMap<String, a> auT;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.auM = 0;
        this.auT = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auM = 0;
        this.auT = new HashMap<>();
        init();
    }

    private void init() {
        this.auR = getResources().getDimensionPixelSize(i.d.ds2);
        this.auS = getResources().getDimensionPixelSize(i.d.ds12);
        this.auQ = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.auQ.setLayoutParams(layoutParams);
        this.auQ.setGravity(17);
        this.auQ.setDuplicateParentStateEnabled(true);
        addView(this.auQ);
    }

    public void setContentTvTopMargin(int i) {
        if (this.auQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auQ.getLayoutParams();
            layoutParams.topMargin = i;
            this.auQ.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.auT.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.auT.entrySet().iterator();
        while (it.hasNext() && this.auQ.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.auQ.getPaint().measureText(this.auQ.getText().toString());
            if (value.auU) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.auM == 1) {
                i5 = measuredWidth - this.auS;
                measuredHeight = this.auR;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.auM = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.auT.put(str, aVar);
        }
    }

    public a fw(String str) {
        return this.auT.get(str);
    }

    public void setText(int i) {
        this.auQ.setText(i);
    }

    public void setText(String str) {
        this.auQ.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.auQ.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.auO = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.auP = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.auQ.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.auQ.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.auQ.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.auN = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        am.b(this.auQ, this.auN, 1);
        if (this.auQ != null) {
            this.auQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.c((Resources) null, this.auO), am.getDrawable(this.auP), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.auT.entrySet()) {
            entry.getValue().cP(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public boolean auU = true;
        public int auV;
        public int auW;
        public FragmentTabIndicator auX;
        public int uo;
        public View view;

        public void cP(int i) {
            if (this.auV != 0) {
                am.i(this.view, this.auV);
            }
            if (this.view instanceof TextView) {
                if (this.auW != 0) {
                    am.b((TextView) this.view, this.auW, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    am.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    am.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    am.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_more);
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
            return com.baidu.adp.lib.g.b.g(charSequence, -1);
        }
    }

    public void Cy() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auQ.getLayoutParams();
        layoutParams.width = -2;
        this.auQ.setLayoutParams(layoutParams);
    }
}
