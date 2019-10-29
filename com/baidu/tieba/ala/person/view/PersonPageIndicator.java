package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class PersonPageIndicator extends LinearLayout {
    private View ewV;
    private FrameLayout ewW;
    private ViewPager.OnPageChangeListener ewX;
    private LinearLayout ewY;
    private ViewPager mViewPager;

    public PersonPageIndicator(Context context) {
        super(context);
        init();
    }

    public PersonPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PersonPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.ala_person_page_indicator, this);
        this.ewV = findViewById(a.g.indicator);
        this.ewW = (FrameLayout) findViewById(a.g.indicator_wrapper);
        this.ewY = (LinearLayout) findViewById(a.g.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ewV.setBackgroundResource(a.f.ala_person_indicator_bg_hk);
        } else {
            this.ewV.setBackgroundResource(a.f.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ewW.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.ewW.setLayoutParams(layoutParams);
    }

    public void uk(String str) {
        if (!StringUtils.isNull(str)) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), a.e.sdk_fontsize24));
            textView.setText(str);
            this.ewY.addView(textView);
        }
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.person.view.PersonPageIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.ewY.getChildCount() - 1) {
                    PersonPageIndicator.this.ewV.getLayoutParams().width = PersonPageIndicator.this.ewY.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.ewY.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.ewY.getChildAt(i2 + 1);
                    PersonPageIndicator.this.ewV.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.ewV.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.ewV.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.ewV.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.ewX != null) {
                    PersonPageIndicator.this.ewX.onPageScrolled(i2, f, i3);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.ewX != null) {
                    PersonPageIndicator.this.ewX.onPageSelected(i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.ewX != null) {
                    PersonPageIndicator.this.ewX.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ewX = onPageChangeListener;
    }
}
