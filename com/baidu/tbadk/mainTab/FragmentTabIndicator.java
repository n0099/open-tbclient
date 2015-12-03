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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int avF;
    public int avG;
    private int avH;
    private int avI;
    private TextView avJ;
    private int avK;
    private int avL;
    private HashMap<String, a> avM;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.avF = 0;
        this.avM = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avF = 0;
        this.avM = new HashMap<>();
        init();
    }

    private void init() {
        this.avK = getResources().getDimensionPixelSize(n.d.ds2);
        this.avL = getResources().getDimensionPixelSize(n.d.ds12);
        this.avJ = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.avJ.setLayoutParams(layoutParams);
        this.avJ.setGravity(17);
        this.avJ.setDuplicateParentStateEnabled(true);
        addView(this.avJ);
    }

    public void setContentTvTopMargin(int i) {
        if (this.avJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avJ.getLayoutParams();
            layoutParams.topMargin = i;
            this.avJ.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.avM.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.avM.entrySet().iterator();
        while (it.hasNext() && this.avJ.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.avJ.getPaint().measureText(this.avJ.getText().toString());
            if (value.avN) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uu;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uu) - (measureText / 2);
            }
            if (this.avF == 1) {
                i5 = measuredWidth - this.avL;
                measuredHeight = this.avK;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.avF = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.avM.put(str, aVar);
        }
    }

    public a fM(String str) {
        return this.avM.get(str);
    }

    public void setText(int i) {
        this.avJ.setText(i);
    }

    public void setText(String str) {
        this.avJ.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.avJ.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.avH = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.avI = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.avJ.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.avJ.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.avJ.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.avG = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cX(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cX(int i) {
        as.b(this.avJ, this.avG, 1);
        if (this.avJ != null) {
            this.avJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.c((Resources) null, this.avH), as.getDrawable(this.avI), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.avM.entrySet()) {
            entry.getValue().cX(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int avO;
        public FragmentTabIndicator avQ;
        public int uu;
        public View view;
        public boolean avN = true;
        public int avP = n.c.frs_slidebar_message_text;

        public void cX(int i) {
            if (this.avO != 0) {
                as.i(this.view, this.avO);
            }
            if (this.view instanceof TextView) {
                if (this.avP != 0) {
                    as.b((TextView) this.view, this.avP, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    as.i((View) ((TextView) this.view), n.e.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    as.i((View) ((TextView) this.view), n.e.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    as.i((View) ((TextView) this.view), n.e.icon_news_head_prompt_more);
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

    public void Dp() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avJ.getLayoutParams();
        layoutParams.width = -2;
        this.avJ.setLayoutParams(layoutParams);
    }
}
