package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int auF;
    public int auG;
    private int auH;
    private int auI;
    private TextView auJ;
    private int auK;
    private int auL;
    private HashMap<String, a> auM;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.auF = 0;
        this.auM = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auF = 0;
        this.auM = new HashMap<>();
        init();
    }

    private void init() {
        this.auK = getResources().getDimensionPixelSize(i.d.ds2);
        this.auL = getResources().getDimensionPixelSize(i.d.ds12);
        this.auJ = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.auJ.setLayoutParams(layoutParams);
        this.auJ.setGravity(17);
        this.auJ.setDuplicateParentStateEnabled(true);
        addView(this.auJ);
    }

    public void setContentTvTopMargin(int i) {
        if (this.auJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auJ.getLayoutParams();
            layoutParams.topMargin = i;
            this.auJ.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.auM.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.auM.entrySet().iterator();
        while (it.hasNext() && this.auJ.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.auJ.getPaint().measureText(this.auJ.getText().toString());
            if (value.auN) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uq;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uq) - (measureText / 2);
            }
            if (this.auF == 1) {
                i5 = measuredWidth - this.auL;
                measuredHeight = this.auK;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.auF = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.auM.put(str, aVar);
        }
    }

    public a fj(String str) {
        return this.auM.get(str);
    }

    public void setText(int i) {
        this.auJ.setText(i);
    }

    public void setText(String str) {
        this.auJ.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.auJ.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.auH = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.auI = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.auJ.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.auJ.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.auJ.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.auG = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cI(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cI(int i) {
        al.b(this.auJ, this.auG, 1);
        if (this.auJ != null) {
            this.auJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(this.auH), al.getDrawable(this.auI), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.auM.entrySet()) {
            entry.getValue().cI(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public boolean auN = true;
        public int auO;
        public int auP;
        public FragmentTabIndicator auQ;
        public int uq;
        public View view;

        public void cI(int i) {
            if (this.auO != 0) {
                al.i(this.view, this.auO);
            }
            if (this.view instanceof TextView) {
                if (this.auP != 0) {
                    al.b((TextView) this.view, this.auP, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    al.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    al.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    al.i((View) ((TextView) this.view), i.e.icon_news_head_prompt_more);
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
}
