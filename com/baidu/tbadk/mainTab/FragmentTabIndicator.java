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
    private int atB;
    public int atC;
    private int atD;
    private int atE;
    private TextView atF;
    private int atG;
    private int atH;
    private HashMap<String, a> atI;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.atB = 0;
        this.atI = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atB = 0;
        this.atI = new HashMap<>();
        init();
    }

    private void init() {
        this.atG = getResources().getDimensionPixelSize(i.d.ds2);
        this.atH = getResources().getDimensionPixelSize(i.d.ds12);
        this.atF = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.atF.setLayoutParams(layoutParams);
        this.atF.setGravity(17);
        this.atF.setDuplicateParentStateEnabled(true);
        addView(this.atF);
    }

    public void setContentTvTopMargin(int i) {
        if (this.atF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.atF.getLayoutParams();
            layoutParams.topMargin = i;
            this.atF.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.atI.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.atI.entrySet().iterator();
        while (it.hasNext() && this.atF.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.atF.getPaint().measureText(this.atF.getText().toString());
            if (value.atJ) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uo;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uo) - (measureText / 2);
            }
            if (this.atB == 1) {
                i5 = measuredWidth - this.atH;
                measuredHeight = this.atG;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.atB = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.atI.put(str, aVar);
        }
    }

    public a fy(String str) {
        return this.atI.get(str);
    }

    public void setText(int i) {
        this.atF.setText(i);
    }

    public void setText(String str) {
        this.atF.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.atF.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.atD = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.atE = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.atF.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.atF.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.atF.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.atC = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        an.b(this.atF, this.atC, 1);
        if (this.atF != null) {
            this.atF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.c((Resources) null, this.atD), an.getDrawable(this.atE), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.atI.entrySet()) {
            entry.getValue().cP(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public boolean atJ = true;
        public int atK;
        public int atL;
        public FragmentTabIndicator atM;
        public int uo;
        public View view;

        public void cP(int i) {
            if (this.atK != 0) {
                an.i(this.view, this.atK);
            }
            if (this.view instanceof TextView) {
                if (this.atL != 0) {
                    an.b((TextView) this.view, this.atL, 1);
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

    public void Co() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.atF.getLayoutParams();
        layoutParams.width = -2;
        this.atF.setLayoutParams(layoutParams);
    }
}
