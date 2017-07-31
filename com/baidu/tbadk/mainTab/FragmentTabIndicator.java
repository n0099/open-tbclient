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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends FrameLayout {
    private int aHA;
    private HashMap<String, a> aHB;
    private int aHu;
    public int aHv;
    private int aHw;
    private int aHx;
    private TextView aHy;
    private int aHz;
    private ImageView acr;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    private void init() {
        this.aHz = getResources().getDimensionPixelSize(d.f.ds2);
        this.aHA = getResources().getDimensionPixelSize(d.f.ds12);
        this.aHy = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHy.setLayoutParams(layoutParams);
        this.aHy.setGravity(17);
        this.aHy.setDuplicateParentStateEnabled(true);
        addView(this.aHy);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aHy.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHy.getLayoutParams();
            layoutParams.topMargin = i;
            this.aHy.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aHB.entrySet()) {
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
        Iterator<Map.Entry<String, a>> it = this.aHB.entrySet().iterator();
        while (it.hasNext() && this.aHy.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aHy.getPaint().measureText(this.aHy.getText().toString());
            if (value.aHC) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.ww;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.ww) - (measureText / 2);
            }
            if (this.aHu == 1) {
                i5 = measuredWidth - this.aHA;
                measuredHeight = this.aHz;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aHu = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aHB.put(str, aVar);
        }
    }

    public a gx(String str) {
        return this.aHB.get(str);
    }

    public void setText(int i) {
        this.aHy.setText(i);
    }

    public void setText(String str) {
        this.aHy.setText(str);
        this.aHy.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aHy.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aHy.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aHy.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aHw = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aHx = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aHy.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aHy.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aHy.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aHv = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dt(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dt(int i) {
        ai.c(this.aHy, this.aHv, 1);
        if (this.aHy != null) {
            if (this.aHy.getText() != null && al.isEmpty(this.aHy.getText().toString())) {
                this.acr.setImageDrawable(ai.c((Resources) null, this.aHw));
            } else {
                this.aHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.c((Resources) null, this.aHw), ai.getDrawable(this.aHx), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aHB.entrySet()) {
            entry.getValue().dt(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aHD;
        public FragmentTabIndicator aHF;
        public View view;
        public int ww;
        public boolean aHC = true;
        public int aHE = d.e.common_color_10225;

        public void dt(int i) {
            if (this.aHD != 0) {
                ai.j(this.view, this.aHD);
            }
            if (this.view instanceof TextView) {
                if (this.aHE != 0) {
                    ai.c((TextView) this.view, this.aHE, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    ai.j((TextView) this.view, d.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    ai.j((TextView) this.view, d.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    ai.j((TextView) this.view, d.g.icon_news_head_prompt_more);
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

    public void EY() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHy.getLayoutParams();
        layoutParams.width = -2;
        this.aHy.setLayoutParams(layoutParams);
    }

    public TextView getContentTv() {
        return this.aHy;
    }

    public void N(int i, int i2) {
        if (this.aHy != null) {
            this.aHy.setVisibility(8);
        }
        this.acr = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.acr.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.acr.setLayoutParams(layoutParams);
        addView(this.acr);
        this.acr.setImageDrawable(ai.c((Resources) null, this.aHw));
    }
}
