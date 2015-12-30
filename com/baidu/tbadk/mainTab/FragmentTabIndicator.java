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
    private int axj;
    public int axk;
    private int axl;
    private int axm;
    private TextView axn;
    private int axo;
    private int axp;
    private HashMap<String, a> axq;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.axj = 0;
        this.axq = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axj = 0;
        this.axq = new HashMap<>();
        init();
    }

    private void init() {
        this.axo = getResources().getDimensionPixelSize(n.e.ds2);
        this.axp = getResources().getDimensionPixelSize(n.e.ds12);
        this.axn = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.axn.setLayoutParams(layoutParams);
        this.axn.setGravity(17);
        this.axn.setDuplicateParentStateEnabled(true);
        addView(this.axn);
    }

    public void setContentTvTopMargin(int i) {
        if (this.axn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axn.getLayoutParams();
            layoutParams.topMargin = i;
            this.axn.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.axq.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.axq.entrySet().iterator();
        while (it.hasNext() && this.axn.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.axn.getPaint().measureText(this.axn.getText().toString());
            if (value.axr) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uw;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uw) - (measureText / 2);
            }
            if (this.axj == 1) {
                i5 = measuredWidth - this.axp;
                measuredHeight = this.axo;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.axj = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.axq.put(str, aVar);
        }
    }

    public a fQ(String str) {
        return this.axq.get(str);
    }

    public void setText(int i) {
        this.axn.setText(i);
    }

    public void setText(String str) {
        this.axn.setText(str);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.axn.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.axl = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.axm = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.axn.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.axn.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.axn.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.axk = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cR(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cR(int i) {
        as.b(this.axn, this.axk, 1);
        if (this.axn != null) {
            this.axn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.c((Resources) null, this.axl), as.getDrawable(this.axm), (Drawable) null);
        }
        for (Map.Entry<String, a> entry : this.axq.entrySet()) {
            entry.getValue().cR(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int axs;
        public FragmentTabIndicator axu;
        public int uw;
        public View view;
        public boolean axr = true;
        public int axt = n.d.frs_slidebar_message_text;

        public void cR(int i) {
            if (this.axs != 0) {
                as.i(this.view, this.axs);
            }
            if (this.view instanceof TextView) {
                if (this.axt != 0) {
                    as.b((TextView) this.view, this.axt, 1);
                }
                int c = c((TextView) this.view);
                if (c > 0 && c < 10) {
                    as.i((View) ((TextView) this.view), n.f.icon_news_head_prompt_one);
                } else if (c >= 10 && c < 100) {
                    as.i((View) ((TextView) this.view), n.f.icon_news_head_prompt_two);
                } else if (c >= 100) {
                    as.i((View) ((TextView) this.view), n.f.icon_news_head_prompt_more);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axn.getLayoutParams();
        layoutParams.width = -2;
        this.axn.setLayoutParams(layoutParams);
    }
}
