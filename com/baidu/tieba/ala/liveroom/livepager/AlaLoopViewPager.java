package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fdt;
    ViewPager.OnPageChangeListener fdu;
    private AlaLoopPagerAdapterWrapper fdv;
    private ViewPager.OnPageChangeListener fdw;

    public void setBoundaryCaching(boolean z) {
        this.fdt = z;
        if (this.fdv != null) {
            this.fdv.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fdv = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fdv.setBoundaryCaching(this.fdt);
        super.setAdapter(this.fdv);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fdv != null ? this.fdv.bnh() : this.fdv;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fdv != null) {
            return this.fdv.qc(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fdv.qd(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fdu = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fdt = false;
        this.fdw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdx = -1.0f;
            private float fdy = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdv.qc(i);
                if (this.fdy != qc) {
                    this.fdy = qc;
                    if (AlaLoopViewPager.this.fdu != null) {
                        AlaLoopViewPager.this.fdu.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdv != null) {
                    int qc = AlaLoopViewPager.this.fdv.qc(i);
                    if (f == 0.0f && this.fdx == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdx = f;
                if (AlaLoopViewPager.this.fdu != null) {
                    if (AlaLoopViewPager.this.fdv != null && i != AlaLoopViewPager.this.fdv.bng() - 1) {
                        AlaLoopViewPager.this.fdu.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdu.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdu.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdv != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdv.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdu != null) {
                    AlaLoopViewPager.this.fdu.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdt = false;
        this.fdw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdx = -1.0f;
            private float fdy = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdv.qc(i);
                if (this.fdy != qc) {
                    this.fdy = qc;
                    if (AlaLoopViewPager.this.fdu != null) {
                        AlaLoopViewPager.this.fdu.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdv != null) {
                    int qc = AlaLoopViewPager.this.fdv.qc(i);
                    if (f == 0.0f && this.fdx == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdx = f;
                if (AlaLoopViewPager.this.fdu != null) {
                    if (AlaLoopViewPager.this.fdv != null && i != AlaLoopViewPager.this.fdv.bng() - 1) {
                        AlaLoopViewPager.this.fdu.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdu.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdu.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdv != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdv.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdu != null) {
                    AlaLoopViewPager.this.fdu.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fdw);
    }
}
