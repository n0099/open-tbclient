package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class PersonPageIndicator extends LinearLayout {
    private ViewPager Zi;
    private View hUh;
    private FrameLayout hUi;
    private ViewPager.OnPageChangeListener hUj;
    private LinearLayout hUk;

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
        this.hUh = findViewById(a.f.indicator);
        this.hUi = (FrameLayout) findViewById(a.f.indicator_wrapper);
        this.hUk = (LinearLayout) findViewById(a.f.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hUh.setBackgroundResource(a.e.ala_person_indicator_bg_hk);
        } else {
            this.hUh.setBackgroundResource(a.e.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hUi.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.hUi.setLayoutParams(layoutParams);
    }

    public void HH(String str) {
        if (!StringUtils.isNull(str)) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), a.d.sdk_fontsize24));
            textView.setText(str);
            this.hUk.addView(textView);
        }
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.Zi = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.person.view.PersonPageIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.hUk.getChildCount() - 1) {
                    PersonPageIndicator.this.hUh.getLayoutParams().width = PersonPageIndicator.this.hUk.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.hUk.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.hUk.getChildAt(i2 + 1);
                    PersonPageIndicator.this.hUh.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.hUh.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.hUh.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.hUh.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.hUj != null) {
                    PersonPageIndicator.this.hUj.onPageScrolled(i2, f, i3);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.hUj != null) {
                    PersonPageIndicator.this.hUj.onPageSelected(i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.hUj != null) {
                    PersonPageIndicator.this.hUj.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hUj = onPageChangeListener;
    }
}
