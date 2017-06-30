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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends FrameLayout {
    private int aEX;
    public int aEY;
    private int aEZ;
    private int aFa;
    private TextView aFb;
    private int aFc;
    private int aFd;
    private HashMap<String, a> aFe;
    private ImageView aav;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aEX = 0;
        this.aFe = new HashMap<>();
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEX = 0;
        this.aFe = new HashMap<>();
        init();
    }

    private void init() {
        this.aFc = getResources().getDimensionPixelSize(w.f.ds2);
        this.aFd = getResources().getDimensionPixelSize(w.f.ds12);
        this.aFb = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aFb.setLayoutParams(layoutParams);
        this.aFb.setGravity(17);
        this.aFb.setDuplicateParentStateEnabled(true);
        addView(this.aFb);
    }

    public void setContentTvTopMargin(int i) {
        if (this.aFb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aFb.getLayoutParams();
            layoutParams.topMargin = i;
            this.aFb.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, a> entry : this.aFe.entrySet()) {
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
        Iterator<Map.Entry<String, a>> it = this.aFe.entrySet().iterator();
        while (it.hasNext() && this.aFb.getText() != null) {
            a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aFb.getPaint().measureText(this.aFb.getText().toString());
            if (value.aFf) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.uS;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.uS) - (measureText / 2);
            }
            if (this.aEX == 1) {
                i5 = measuredWidth - this.aFd;
                measuredHeight = this.aFc;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipPosType(int i) {
        this.aEX = i;
    }

    public void a(String str, a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aFe.put(str, aVar);
        }
    }

    public a gm(String str) {
        return this.aFe.get(str);
    }

    public void setText(int i) {
        this.aFb.setText(i);
    }

    public void setText(String str) {
        this.aFb.setText(str);
        this.aFb.setContentDescription(str);
    }

    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aFb.getText().toString();
        if (z) {
            charSequence = String.valueOf(getContext().getString(w.l.talk_checked_tip)) + charSequence;
        }
        this.aFb.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aFb.setText(spannableString);
    }

    public void setCompoundDrawablesTopResId(int i) {
        this.aEZ = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aFa = i;
    }

    public void setCompoundDrawablePadding(int i) {
        this.aFb.setCompoundDrawablePadding(i);
    }

    public void setTextSize(float f) {
        this.aFb.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.aFb.setTextSize(i, f);
    }

    public void setTextColorResId(int i) {
        this.aEY = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dp(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dp(int i) {
        as.c(this.aFb, this.aEY, 1);
        if (this.aFb != null) {
            if (this.aFb.getText() != null && aw.isEmpty(this.aFb.getText().toString())) {
                this.aav.setImageDrawable(as.c((Resources) null, this.aEZ));
            } else {
                this.aFb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.c((Resources) null, this.aEZ), as.getDrawable(this.aFa), (Drawable) null);
            }
        }
        for (Map.Entry<String, a> entry : this.aFe.entrySet()) {
            entry.getValue().dp(i);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aFg;
        public FragmentTabIndicator aFi;
        public int uS;
        public View view;
        public boolean aFf = true;
        public int aFh = w.e.common_color_10225;

        public void dp(int i) {
            if (this.aFg != 0) {
                as.j(this.view, this.aFg);
            }
            if (this.view instanceof TextView) {
                if (this.aFh != 0) {
                    as.c((TextView) this.view, this.aFh, 1);
                }
                int b = b((TextView) this.view);
                if (b > 0 && b < 10) {
                    as.j((TextView) this.view, w.g.icon_news_head_prompt_one);
                } else if (b >= 10 && b < 100) {
                    as.j((TextView) this.view, w.g.icon_news_head_prompt_two);
                } else if (b >= 100) {
                    as.j((TextView) this.view, w.g.icon_news_head_prompt_more);
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
        if (this.aFb != null) {
            this.aFb.setVisibility(8);
        }
        this.aav = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
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
        this.aav.setImageDrawable(as.c((Resources) null, this.aEZ));
    }
}
