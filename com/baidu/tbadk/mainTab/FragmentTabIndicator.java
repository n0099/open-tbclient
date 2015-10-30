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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int auN;
    public int auO;
    private int auP;
    private int auQ;
    private TextView auR;
    private int auS;
    private int auT;
    private HashMap<String, a> auU;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.auN = 0;
        this.auU = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auN = 0;
        this.auU = new HashMap<>();
        init();
    }

    private void init() {
        this.auS = getResources().getDimensionPixelSize(i.d.ds2);
        this.auT = getResources().getDimensionPixelSize(i.d.ds12);
        this.auR = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.auR.setLayoutParams(layoutParams);
        this.auR.setGravity(17);
        this.auR.setDuplicateParentStateEnabled(true);
        addView(this.auR);
    }

    public void setContentTvTopMargin(int i) {
        if (this.auR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auR.getLayoutParams();
            layoutParams.topMargin = i;
            this.auR.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.auU.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.auU.entrySet().iterator();
        while (it.hasNext() && this.auR.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.auR.getPaint().measureText(this.auR.getText().toString());
            if (value.auV) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.auN == 1) {
                i5 = measuredWidth - this.auT;
                measuredHeight = this.auS;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.auN = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.auU.put(str, aVar);
        }
    }

    public a fw(String str) {
        return this.auU.get(str);
    }

    public void setText(int i) {
        this.auR.setText(i);
    }

    public void setText(String str) {
        this.auR.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.auR.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.auP = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.auQ = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.auR.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.auR.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.auR.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.auO = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        an.b(this.auR, this.auO, 1);
        if (this.auR != null) {
            this.auR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.c((Resources) null, this.auP), an.getDrawable(this.auQ), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.auU.entrySet()) {
            entry.getValue().cP(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public boolean auV = true;
        public int auW;
        public int auX;
        public FragmentTabIndicator auY;
        public int uo;
        public View view;

        public void cP(int i) {
            if (this.auW != 0) {
                an.i(this.view, this.auW);
            }
            if (this.view instanceof TextView) {
                if (this.auX != 0) {
                    an.b((TextView) this.view, this.auX, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    an.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    an.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    an.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_more);
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

    public void Cv() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auR.getLayoutParams();
        layoutParams.width = -2;
        this.auR.setLayoutParams(layoutParams);
    }
}
