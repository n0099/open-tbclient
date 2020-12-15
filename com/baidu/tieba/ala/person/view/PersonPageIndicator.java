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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class PersonPageIndicator extends LinearLayout {
    private View hMr;
    private FrameLayout hMs;
    private ViewPager.OnPageChangeListener hMt;
    private LinearLayout hMu;
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
        LayoutInflater.from(getContext()).inflate(a.g.ala_person_page_indicator, this);
        this.hMr = findViewById(a.f.indicator);
        this.hMs = (FrameLayout) findViewById(a.f.indicator_wrapper);
        this.hMu = (LinearLayout) findViewById(a.f.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hMr.setBackgroundResource(a.e.ala_person_indicator_bg_hk);
        } else {
            this.hMr.setBackgroundResource(a.e.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hMs.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.hMs.setLayoutParams(layoutParams);
    }

    public void IV(String str) {
        if (!StringUtils.isNull(str)) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), a.d.sdk_fontsize24));
            textView.setText(str);
            this.hMu.addView(textView);
        }
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.person.view.PersonPageIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.hMu.getChildCount() - 1) {
                    PersonPageIndicator.this.hMr.getLayoutParams().width = PersonPageIndicator.this.hMu.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.hMu.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.hMu.getChildAt(i2 + 1);
                    PersonPageIndicator.this.hMr.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.hMr.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.hMr.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.hMr.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.hMt != null) {
                    PersonPageIndicator.this.hMt.onPageScrolled(i2, f, i3);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.hMt != null) {
                    PersonPageIndicator.this.hMt.onPageSelected(i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.hMt != null) {
                    PersonPageIndicator.this.hMt.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hMt = onPageChangeListener;
    }
}
