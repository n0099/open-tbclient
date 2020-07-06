package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private ViewPager.OnPageChangeListener gjA;
    private boolean gjx;
    ViewPager.OnPageChangeListener gjy;
    private AlaLoopPagerAdapterWrapper gjz;

    public void setBoundaryCaching(boolean z) {
        this.gjx = z;
        if (this.gjz != null) {
            this.gjz.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.gjz = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.gjz.setBoundaryCaching(this.gjx);
        super.setAdapter(this.gjz);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.gjz != null ? this.gjz.bFL() : this.gjz;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.gjz != null) {
            return this.gjz.rz(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.gjz.rA(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gjy = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gjx = false;
        this.gjA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gjB = -1.0f;
            private float gjC = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int rz = AlaLoopViewPager.this.gjz.rz(i);
                if (this.gjC != rz) {
                    this.gjC = rz;
                    if (AlaLoopViewPager.this.gjy != null) {
                        AlaLoopViewPager.this.gjy.onPageSelected(rz);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gjz != null) {
                    int rz = AlaLoopViewPager.this.gjz.rz(i);
                    if (f == 0.0f && this.gjB == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gjz.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rz, false);
                    }
                    i = rz;
                }
                this.gjB = f;
                if (AlaLoopViewPager.this.gjy != null) {
                    if (AlaLoopViewPager.this.gjz != null && i != AlaLoopViewPager.this.gjz.bFK() - 1) {
                        AlaLoopViewPager.this.gjy.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gjy.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gjy.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gjz != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int rz = AlaLoopViewPager.this.gjz.rz(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gjz.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rz, false);
                    }
                }
                if (AlaLoopViewPager.this.gjy != null) {
                    AlaLoopViewPager.this.gjy.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjx = false;
        this.gjA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gjB = -1.0f;
            private float gjC = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int rz = AlaLoopViewPager.this.gjz.rz(i);
                if (this.gjC != rz) {
                    this.gjC = rz;
                    if (AlaLoopViewPager.this.gjy != null) {
                        AlaLoopViewPager.this.gjy.onPageSelected(rz);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gjz != null) {
                    int rz = AlaLoopViewPager.this.gjz.rz(i);
                    if (f == 0.0f && this.gjB == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gjz.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rz, false);
                    }
                    i = rz;
                }
                this.gjB = f;
                if (AlaLoopViewPager.this.gjy != null) {
                    if (AlaLoopViewPager.this.gjz != null && i != AlaLoopViewPager.this.gjz.bFK() - 1) {
                        AlaLoopViewPager.this.gjy.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gjy.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gjy.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gjz != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int rz = AlaLoopViewPager.this.gjz.rz(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gjz.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rz, false);
                    }
                }
                if (AlaLoopViewPager.this.gjy != null) {
                    AlaLoopViewPager.this.gjy.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.gjA);
    }
}
