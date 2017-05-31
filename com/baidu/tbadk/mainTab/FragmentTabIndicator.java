package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends FrameLayout {
    private int aDJ;
    public int aDK;
    private int aDL;
    private int aDM;
    private TextView aDN;
    private int aDO;
    private int aDP;
    private HashMap<String, a> aDQ;
    private ImageView aau;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aDJ = 0;
        this.aDQ = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDJ = 0;
        this.aDQ = new HashMap<>();
        init();
    }

    private void init() {
        this.aDO = getResources().getDimensionPixelSize(w.f.ds2);
        this.aDP = getResources().getDimensionPixelSize(w.f.ds12);
        this.aDN = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aDN.setLayoutParams(layoutParams);
        this.aDN.setGravity(17);
        this.aDN.setDuplicateParentStateEnabled(true);
        addView(this.aDN);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aDN.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aDN.getLayoutParams();
            layoutParams.topMargin = i;
            this.aDN.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aDQ.entrySet()) {
            a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
            } else {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aDQ.entrySet().iterator();
        while (it.hasNext() && this.aDN.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aDN.getPaint().measureText(this.aDN.getText().toString());
            if (value.aDR) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uT;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uT) - (measureText / 2);
            }
            if (this.aDJ == 1) {
                i5 = measuredWidth - this.aDP;
                measuredHeight = this.aDO;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aDJ = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aDQ.put(str, aVar);
        }
    }

    public a fR(String str) {
        return this.aDQ.get(str);
    }

    public void setText(int i) {
        this.aDN.setText(i);
    }

    public void setText(String str) {
        this.aDN.setText(str);
        this.aDN.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aDN.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aDN.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aDN.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aDL = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aDM = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aDN.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aDN.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aDN.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aDK = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dn(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dn(int i) {
        aq.c(this.aDN, this.aDK, 1);
        if (this.aDN != null) {
            if (this.aDN.getText() != null && au.isEmpty(this.aDN.getText().toString())) {
                this.aau.setImageDrawable(aq.c((Resources) null, this.aDL));
            } else {
                this.aDN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.c((Resources) null, this.aDL), aq.getDrawable(this.aDM), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aDQ.entrySet()) {
            entry.getValue().dn(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aDS;
        public FragmentTabIndicator aDU;
        public int uT;
        public View view;
        public boolean aDR = true;
        public int aDT = w.e.common_color_10225;

        public void dn(int i) {
            if (this.aDS != 0) {
                aq.j(this.view, this.aDS);
            }
            if (this.view instanceof TextView) {
                if (this.aDT != 0) {
                    aq.c((TextView) this.view, this.aDT, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    aq.j((TextView) this.view, w.g.icon_news_head_prompt_more);
                }
            }
        }

        private int b(TextView textView) {
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

    public void M(int i, int i2) {
        if (this.aDN != null) {
            this.aDN.setVisibility(8);
        }
        this.aau = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.aau.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(w.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.aau.setLayoutParams(layoutParams);
        addView(this.aau);
        this.aau.setImageDrawable(aq.c((Resources) null, this.aDL));
    }
}
