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
    private int aGf;
    public int aGg;
    private int aGh;
    private int aGi;
    private TextView aGj;
    private int aGk;
    private int aGl;
    private HashMap<String, a> aGm;
    private ImageView aaU;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aGf = 0;
        this.aGm = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGf = 0;
        this.aGm = new HashMap<>();
        init();
    }

    private void init() {
        this.aGk = getResources().getDimensionPixelSize(d.f.ds2);
        this.aGl = getResources().getDimensionPixelSize(d.f.ds12);
        this.aGj = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGj.setLayoutParams(layoutParams);
        this.aGj.setGravity(17);
        this.aGj.setDuplicateParentStateEnabled(true);
        addView(this.aGj);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aGj.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGj.getLayoutParams();
            layoutParams.topMargin = i;
            this.aGj.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aGm.entrySet()) {
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
        Iterator<Map.Entry<String, a>> it = this.aGm.entrySet().iterator();
        while (it.hasNext() && this.aGj.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aGj.getPaint().measureText(this.aGj.getText().toString());
            if (value.aGn) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uT;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uT) - (measureText / 2);
            }
            if (this.aGf == 1) {
                i5 = measuredWidth - this.aGl;
                measuredHeight = this.aGk;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aGf = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aGm.put(str, aVar);
        }
    }

    public a gs(String str) {
        return this.aGm.get(str);
    }

    public void setText(int i) {
        this.aGj.setText(i);
    }

    public void setText(String str) {
        this.aGj.setText(str);
        this.aGj.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aGj.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.l.talk_checked_tip) + charSequence;
        }
        this.aGj.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aGj.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aGh = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aGi = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aGj.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aGj.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aGj.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aGg = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dr(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dr(int i) {
        ai.c(this.aGj, this.aGg, 1);
        if (this.aGj != null) {
            if (this.aGj.getText() != null && al.isEmpty(this.aGj.getText().toString())) {
                this.aaU.setImageDrawable(ai.c((Resources) null, this.aGh));
            } else {
                this.aGj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.c((Resources) null, this.aGh), ai.getDrawable(this.aGi), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aGm.entrySet()) {
            entry.getValue().dr(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aGo;
        public FragmentTabIndicator aGq;
        public int uT;
        public View view;
        public boolean aGn = true;
        public int aGp = d.e.common_color_10225;

        public void dr(int i) {
            if (this.aGo != 0) {
                ai.j(this.view, this.aGo);
            }
            if (this.view instanceof TextView) {
                if (this.aGp != 0) {
                    ai.c((TextView) this.view, this.aGp, 1);
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

    public void EQ() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGj.getLayoutParams();
        layoutParams.width = -2;
        this.aGj.setLayoutParams(layoutParams);
    }

    public TextView getContentTv() {
        return this.aGj;
    }

    public void M(int i, int i2) {
        if (this.aGj != null) {
            this.aGj.setVisibility(8);
        }
        this.aaU = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i == 9) {
            this.aaU.setTranslationY(i2);
            setClipToPadding(false);
            setClipChildren(false);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds96);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.aaU.setLayoutParams(layoutParams);
        addView(this.aaU);
        this.aaU.setImageDrawable(ai.c((Resources) null, this.aGh));
    }
}
