package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fds;
    ViewPager.OnPageChangeListener fdt;
    private AlaLoopPagerAdapterWrapper fdu;
    private ViewPager.OnPageChangeListener fdv;

    public void setBoundaryCaching(boolean z) {
        this.fds = z;
        if (this.fdu != null) {
            this.fdu.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fdu = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fdu.setBoundaryCaching(this.fds);
        super.setAdapter(this.fdu);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fdu != null ? this.fdu.bnf() : this.fdu;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fdu != null) {
            return this.fdu.qc(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fdu.qd(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fdt = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fds = false;
        this.fdv = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdw = -1.0f;
            private float fdx = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdu.qc(i);
                if (this.fdx != qc) {
                    this.fdx = qc;
                    if (AlaLoopViewPager.this.fdt != null) {
                        AlaLoopViewPager.this.fdt.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdu != null) {
                    int qc = AlaLoopViewPager.this.fdu.qc(i);
                    if (f == 0.0f && this.fdw == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdu.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdw = f;
                if (AlaLoopViewPager.this.fdt != null) {
                    if (AlaLoopViewPager.this.fdu != null && i != AlaLoopViewPager.this.fdu.bne() - 1) {
                        AlaLoopViewPager.this.fdt.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdt.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdt.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdu != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdu.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdu.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdt != null) {
                    AlaLoopViewPager.this.fdt.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fds = false;
        this.fdv = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdw = -1.0f;
            private float fdx = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdu.qc(i);
                if (this.fdx != qc) {
                    this.fdx = qc;
                    if (AlaLoopViewPager.this.fdt != null) {
                        AlaLoopViewPager.this.fdt.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdu != null) {
                    int qc = AlaLoopViewPager.this.fdu.qc(i);
                    if (f == 0.0f && this.fdw == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdu.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdw = f;
                if (AlaLoopViewPager.this.fdt != null) {
                    if (AlaLoopViewPager.this.fdu != null && i != AlaLoopViewPager.this.fdu.bne() - 1) {
                        AlaLoopViewPager.this.fdt.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdt.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdt.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdu != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdu.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdu.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdt != null) {
                    AlaLoopViewPager.this.fdt.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fdv);
    }
}
