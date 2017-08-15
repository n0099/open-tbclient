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
    private int aHB;
    private HashMap<String, a> aHC;
    private int aHv;
    public int aHw;
    private int aHx;
    private int aHy;
    private TextView aHz;
    private ImageView act;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aHv = 0;
        this.aHC = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHv = 0;
        this.aHC = new HashMap<>();
        init();
    }

    private void init() {
        this.aHA = getResources().getDimensionPixelSize(d.f.ds2);
        this.aHB = getResources().getDimensionPixelSize(d.f.ds12);
        this.aHz = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHz.setLayoutParams(layoutParams);
        this.aHz.setGravity(17);
        this.aHz.setDuplicateParentStateEnabled(true);
        addView(this.aHz);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aHz.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHz.getLayoutParams();
            layoutParams.topMargin = i;
            this.aHz.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aHC.entrySet()) {
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
        Iterator<Map.Entry<String, a>> it = this.aHC.entrySet().iterator();
        while (it.hasNext() && this.aHz.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aHz.getPaint().measureText(this.aHz.getText().toString());
            if (value.aHD) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.wy;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.wy) - (measureText / 2);
            }
            if (this.aHv == 1) {
                i5 = measuredWidth - this.aHB;
                measuredHeight = this.aHA;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aHv = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aHC.put(str, aVar);
        }
    }

    public a gx(String str) {
        return this.aHC.get(str);
    }

    public void setText(int i) {
        this.aHz.setText(i);
    }

    public void setText(String str) {
        this.aHz.setText(str);
        this.aHz.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aHz.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aHz.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aHz.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aHx = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aHy = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aHz.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aHz.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aHz.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aHw = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dt(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dt(int i) {
        ai.c(this.aHz, this.aHw, 1);
        if (this.aHz != null) {
            if (this.aHz.getText() != null && al.isEmpty(this.aHz.getText().toString())) {
                this.act.setImageDrawable(ai.c((Resources) null, this.aHx));
            } else {
                this.aHz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.c((Resources) null, this.aHx), ai.getDrawable(this.aHy), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aHC.entrySet()) {
            entry.getValue().dt(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aHE;
        public FragmentTabIndicator aHG;
        public View view;
        public int wy;
        public boolean aHD = true;
        public int aHF = d.e.common_color_10225;

        public void dt(int i) {
            if (this.aHE != 0) {
                ai.j(this.view, this.aHE);
            }
            if (this.view instanceof TextView) {
                if (this.aHF != 0) {
                    ai.c((TextView) this.view, this.aHF, 1);
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
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aHz.getLayoutParams();
        layoutParams.width = -2;
        this.aHz.setLayoutParams(layoutParams);
    }

    public TextView getContentTv() {
        return this.aHz;
    }

    public void N(int i, int i2) {
        if (this.aHz != null) {
            this.aHz.setVisibility(8);
        }
        this.act = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.act.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.act.setLayoutParams(layoutParams);
        addView(this.act);
        this.act.setImageDrawable(ai.c((Resources) null, this.aHx));
    }
}
