package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fee;
    ViewPager.OnPageChangeListener fef;
    private AlaLoopPagerAdapterWrapper feg;
    private ViewPager.OnPageChangeListener feh;

    public void setBoundaryCaching(boolean z) {
        this.fee = z;
        if (this.feg != null) {
            this.feg.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.feg = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.feg.setBoundaryCaching(this.fee);
        super.setAdapter(this.feg);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.feg != null ? this.feg.bnn() : this.feg;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.feg != null) {
            return this.feg.qe(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.feg.qf(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fef = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fee = false;
        this.feh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fei = -1.0f;
            private float fej = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qe = AlaLoopViewPager.this.feg.qe(i);
                if (this.fej != qe) {
                    this.fej = qe;
                    if (AlaLoopViewPager.this.fef != null) {
                        AlaLoopViewPager.this.fef.onPageSelected(qe);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.feg != null) {
                    int qe = AlaLoopViewPager.this.feg.qe(i);
                    if (f == 0.0f && this.fei == 0.0f && (i == 0 || i == AlaLoopViewPager.this.feg.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qe, false);
                    }
                    i = qe;
                }
                this.fei = f;
                if (AlaLoopViewPager.this.fef != null) {
                    if (AlaLoopViewPager.this.feg != null && i != AlaLoopViewPager.this.feg.bnm() - 1) {
                        AlaLoopViewPager.this.fef.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fef.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fef.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.feg != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qe = AlaLoopViewPager.this.feg.qe(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.feg.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qe, false);
                    }
                }
                if (AlaLoopViewPager.this.fef != null) {
                    AlaLoopViewPager.this.fef.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fee = false;
        this.feh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fei = -1.0f;
            private float fej = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qe = AlaLoopViewPager.this.feg.qe(i);
                if (this.fej != qe) {
                    this.fej = qe;
                    if (AlaLoopViewPager.this.fef != null) {
                        AlaLoopViewPager.this.fef.onPageSelected(qe);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.feg != null) {
                    int qe = AlaLoopViewPager.this.feg.qe(i);
                    if (f == 0.0f && this.fei == 0.0f && (i == 0 || i == AlaLoopViewPager.this.feg.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qe, false);
                    }
                    i = qe;
                }
                this.fei = f;
                if (AlaLoopViewPager.this.fef != null) {
                    if (AlaLoopViewPager.this.feg != null && i != AlaLoopViewPager.this.feg.bnm() - 1) {
                        AlaLoopViewPager.this.fef.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fef.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fef.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.feg != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qe = AlaLoopViewPager.this.feg.qe(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.feg.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qe, false);
                    }
                }
                if (AlaLoopViewPager.this.fef != null) {
                    AlaLoopViewPager.this.fef.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.feh);
    }
}
