package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends LinearLayout {
    private int aDW;
    public int aDX;
    private int aDY;
    private int aDZ;
    private TextView aEa;
    private int aEb;
    private int aEc;
    private HashMap<String, a> aEd;
    private ImageView aav;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aDW = 0;
        this.aEd = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDW = 0;
        this.aEd = new HashMap<>();
        init();
    }

    private void init() {
        this.aEb = getResources().getDimensionPixelSize(w.f.ds2);
        this.aEc = getResources().getDimensionPixelSize(w.f.ds12);
        this.aEa = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aEa.setLayoutParams(layoutParams);
        this.aEa.setGravity(17);
        this.aEa.setDuplicateParentStateEnabled(true);
        addView(this.aEa);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aEa.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEa.getLayoutParams();
            layoutParams.topMargin = i;
            this.aEa.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aEd.entrySet()) {
            entry.getValue().view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, a>> it = this.aEd.entrySet().iterator();
        while (it.hasNext() && this.aEa.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aEa.getPaint().measureText(this.aEa.getText().toString());
            if (value.aEe) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uT;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uT) - (measureText / 2);
            }
            if (this.aDW == 1) {
                i5 = measuredWidth - this.aEc;
                measuredHeight = this.aEb;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aDW = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aEd.put(str, aVar);
        }
    }

    public a fS(String str) {
        return this.aEd.get(str);
    }

    public void setText(int i) {
        this.aEa.setText(i);
    }

    public void setText(String str) {
        this.aEa.setText(str);
        this.aEa.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aEa.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aEa.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aEa.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aDY = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aDZ = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aEa.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aEa.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aEa.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aDX = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dm(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dm(int i) {
        aq.c(this.aEa, this.aDX, 1);
        if (this.aEa != null) {
            if (this.aEa.getText() != null && au.isEmpty(this.aEa.getText().toString())) {
                this.aav.setImageDrawable(aq.c((Resources) null, this.aDY));
            } else {
                this.aEa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.c((Resources) null, this.aDY), aq.getDrawable(this.aDZ), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aEd.entrySet()) {
            entry.getValue().dm(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aEf;
        public FragmentTabIndicator aEh;
        public int uT;
        public View view;
        public boolean aEe = true;
        public int aEg = w.e.common_color_10225;

        public void dm(int i) {
            if (this.aEf != 0) {
                aq.j(this.view, this.aEf);
            }
            if (this.view instanceof TextView) {
                if (this.aEg != 0) {
                    aq.c((TextView) this.view, this.aEg, 1);
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

    public void N(int i, int i2) {
        setGravity(17);
        if (this.aEa != null) {
            this.aEa.setVisibility(8);
        }
        this.aav = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.aav.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(w.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.aav.setLayoutParams(layoutParams);
        addView(this.aav);
        this.aav.setImageDrawable(aq.c((Resources) null, this.aDY));
    }
}
