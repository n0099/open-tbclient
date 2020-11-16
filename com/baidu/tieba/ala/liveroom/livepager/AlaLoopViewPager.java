package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hkC;
    ViewPager.OnPageChangeListener hkD;
    private AlaLoopPagerAdapterWrapper hkE;
    private ViewPager.OnPageChangeListener hkF;

    public void setBoundaryCaching(boolean z) {
        this.hkC = z;
        if (this.hkE != null) {
            this.hkE.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hkE = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hkE.setBoundaryCaching(this.hkC);
        super.setAdapter(this.hkE);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hkE != null ? this.hkE.ccT() : this.hkE;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hkE != null) {
            return this.hkE.wi(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hkE.wj(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hkD = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hkC = false;
        this.hkF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hkG = -1.0f;
            private float hkH = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wi = AlaLoopViewPager.this.hkE.wi(i);
                if (this.hkH != wi) {
                    this.hkH = wi;
                    if (AlaLoopViewPager.this.hkD != null) {
                        AlaLoopViewPager.this.hkD.onPageSelected(wi);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hkE != null) {
                    int wi = AlaLoopViewPager.this.hkE.wi(i);
                    if (f == 0.0f && this.hkG == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hkE.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                    i = wi;
                }
                this.hkG = f;
                if (AlaLoopViewPager.this.hkD != null) {
                    if (AlaLoopViewPager.this.hkE != null && i != AlaLoopViewPager.this.hkE.ccS() - 1) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hkE != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wi = AlaLoopViewPager.this.hkE.wi(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hkE.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                }
                if (AlaLoopViewPager.this.hkD != null) {
                    AlaLoopViewPager.this.hkD.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkC = false;
        this.hkF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hkG = -1.0f;
            private float hkH = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wi = AlaLoopViewPager.this.hkE.wi(i);
                if (this.hkH != wi) {
                    this.hkH = wi;
                    if (AlaLoopViewPager.this.hkD != null) {
                        AlaLoopViewPager.this.hkD.onPageSelected(wi);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hkE != null) {
                    int wi = AlaLoopViewPager.this.hkE.wi(i);
                    if (f == 0.0f && this.hkG == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hkE.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                    i = wi;
                }
                this.hkG = f;
                if (AlaLoopViewPager.this.hkD != null) {
                    if (AlaLoopViewPager.this.hkE != null && i != AlaLoopViewPager.this.hkE.ccS() - 1) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hkE != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wi = AlaLoopViewPager.this.hkE.wi(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hkE.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                }
                if (AlaLoopViewPager.this.hkD != null) {
                    AlaLoopViewPager.this.hkD.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hkF);
    }
}
