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
    private ViewPager aaw;
    private FrameLayout iaA;
    private ViewPager.OnPageChangeListener iaB;
    private LinearLayout iaC;
    private View iaz;

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
        this.iaz = findViewById(a.f.indicator);
        this.iaA = (FrameLayout) findViewById(a.f.indicator_wrapper);
        this.iaC = (LinearLayout) findViewById(a.f.tab_view_layout);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.iaz.setBackgroundResource(a.e.ala_person_indicator_bg_hk);
        } else {
            this.iaz.setBackgroundResource(a.e.ala_person_indicator_bg_qm);
        }
    }

    public void setIndicatorMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iaA.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.iaA.setLayoutParams(layoutParams);
    }

    public void Iv(String str) {
        if (!StringUtils.isNull(str)) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), a.d.sdk_fontsize24));
            textView.setText(str);
            this.iaC.addView(textView);
        }
    }

    public void setViewPager(ViewPager viewPager, final int i) {
        this.aaw = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.person.view.PersonPageIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                if (f <= 0.0f || i2 >= PersonPageIndicator.this.iaC.getChildCount() - 1) {
                    PersonPageIndicator.this.iaz.getLayoutParams().width = PersonPageIndicator.this.iaC.getChildAt(i2).getMeasuredWidth();
                } else {
                    View childAt = PersonPageIndicator.this.iaC.getChildAt(i2);
                    View childAt2 = PersonPageIndicator.this.iaC.getChildAt(i2 + 1);
                    PersonPageIndicator.this.iaz.getLayoutParams().width = (int) (((childAt2.getWidth() - childAt.getWidth()) * f) + childAt.getWidth());
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PersonPageIndicator.this.iaz.getLayoutParams();
                layoutParams.leftMargin = (int) ((((i * i2) + (i / 2)) - (PersonPageIndicator.this.iaz.getLayoutParams().width / 2)) + (i * f));
                PersonPageIndicator.this.iaz.setLayoutParams(layoutParams);
                if (PersonPageIndicator.this.iaB != null) {
                    PersonPageIndicator.this.iaB.onPageScrolled(i2, f, i3);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PersonPageIndicator.this.iaB != null) {
                    PersonPageIndicator.this.iaB.onPageSelected(i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (PersonPageIndicator.this.iaB != null) {
                    PersonPageIndicator.this.iaB.onPageScrollStateChanged(i2);
                }
            }
        });
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iaB = onPageChangeListener;
    }
}
