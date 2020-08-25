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
/* loaded from: classes7.dex */
public class PersonPageIndicator extends LinearLayout {
    private View gSA;
    private FrameLayout gSB;
    private ViewPager.OnPageChangeListener gSC;
    private LinearLayout gSD;
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
        this.gSA = findViewById(a.g.indicator);
        this.gSB = (FrameLayout) findViewById(a.g.indicator_wrapper);
        this.gSD = (LinearLayout) findViewById(a.g.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gSA.setBackgroundResource(a.f.ala_person_indicator_bg_hk);
        } else {
            this.gSA.setBackgroundResource(a.f.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSB.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.gSB.setLayoutParams(layoutParams);
    }

    public void GH(String str) {
        if (!StringUtils.isNull(str)) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), a.e.sdk_fontsize24));
            textView.setText(str);
            this.gSD.addView(textView);
        }
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.person.view.PersonPageIndicator.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.gSD.getChildCount() - 1) {
                    PersonPageIndicator.this.gSA.getLayoutParams().width = PersonPageIndicator.this.gSD.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.gSD.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.gSD.getChildAt(i2 + 1);
                    PersonPageIndicator.this.gSA.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.gSA.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.gSA.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.gSA.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.gSC != null) {
                    PersonPageIndicator.this.gSC.onPageScrolled(i2, f, i3);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.gSC != null) {
                    PersonPageIndicator.this.gSC.onPageSelected(i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.gSC != null) {
                    PersonPageIndicator.this.gSC.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gSC = onPageChangeListener;
    }
}
