package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fWA;
    ViewPager.OnPageChangeListener fWB;
    private AlaLoopPagerAdapterWrapper fWC;
    private ViewPager.OnPageChangeListener fWD;

    public void setBoundaryCaching(boolean z) {
        this.fWA = z;
        if (this.fWC != null) {
            this.fWC.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fWC = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fWC.setBoundaryCaching(this.fWA);
        super.setAdapter(this.fWC);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fWC != null ? this.fWC.bCE() : this.fWC;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fWC != null) {
            return this.fWC.ra(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fWC.rb(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fWB = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fWA = false;
        this.fWD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fWE = -1.0f;
            private float fWF = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int ra = AlaLoopViewPager.this.fWC.ra(i);
                if (this.fWF != ra) {
                    this.fWF = ra;
                    if (AlaLoopViewPager.this.fWB != null) {
                        AlaLoopViewPager.this.fWB.onPageSelected(ra);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fWC != null) {
                    int ra = AlaLoopViewPager.this.fWC.ra(i);
                    if (f == 0.0f && this.fWE == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fWC.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ra, false);
                    }
                    i = ra;
                }
                this.fWE = f;
                if (AlaLoopViewPager.this.fWB != null) {
                    if (AlaLoopViewPager.this.fWC != null && i != AlaLoopViewPager.this.fWC.bCD() - 1) {
                        AlaLoopViewPager.this.fWB.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fWB.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fWB.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fWC != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int ra = AlaLoopViewPager.this.fWC.ra(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fWC.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ra, false);
                    }
                }
                if (AlaLoopViewPager.this.fWB != null) {
                    AlaLoopViewPager.this.fWB.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWA = false;
        this.fWD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fWE = -1.0f;
            private float fWF = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int ra = AlaLoopViewPager.this.fWC.ra(i);
                if (this.fWF != ra) {
                    this.fWF = ra;
                    if (AlaLoopViewPager.this.fWB != null) {
                        AlaLoopViewPager.this.fWB.onPageSelected(ra);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fWC != null) {
                    int ra = AlaLoopViewPager.this.fWC.ra(i);
                    if (f == 0.0f && this.fWE == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fWC.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ra, false);
                    }
                    i = ra;
                }
                this.fWE = f;
                if (AlaLoopViewPager.this.fWB != null) {
                    if (AlaLoopViewPager.this.fWC != null && i != AlaLoopViewPager.this.fWC.bCD() - 1) {
                        AlaLoopViewPager.this.fWB.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fWB.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fWB.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fWC != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int ra = AlaLoopViewPager.this.fWC.ra(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fWC.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ra, false);
                    }
                }
                if (AlaLoopViewPager.this.fWB != null) {
                    AlaLoopViewPager.this.fWB.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fWD);
    }
}
