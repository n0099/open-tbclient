package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean gEP;
    ViewPager.OnPageChangeListener gEQ;
    private AlaLoopPagerAdapterWrapper gER;
    private ViewPager.OnPageChangeListener gES;

    public void setBoundaryCaching(boolean z) {
        this.gEP = z;
        if (this.gER != null) {
            this.gER.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.gER = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.gER.setBoundaryCaching(this.gEP);
        super.setAdapter(this.gER);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.gER != null ? this.gER.bUF() : this.gER;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.gER != null) {
            return this.gER.uy(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.gER.uz(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gEQ = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gEP = false;
        this.gES = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gET = -1.0f;
            private float gEU = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uy = AlaLoopViewPager.this.gER.uy(i);
                if (this.gEU != uy) {
                    this.gEU = uy;
                    if (AlaLoopViewPager.this.gEQ != null) {
                        AlaLoopViewPager.this.gEQ.onPageSelected(uy);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gER != null) {
                    int uy = AlaLoopViewPager.this.gER.uy(i);
                    if (f == 0.0f && this.gET == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gER.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uy, false);
                    }
                    i = uy;
                }
                this.gET = f;
                if (AlaLoopViewPager.this.gEQ != null) {
                    if (AlaLoopViewPager.this.gER != null && i != AlaLoopViewPager.this.gER.bUE() - 1) {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gER != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uy = AlaLoopViewPager.this.gER.uy(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gER.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uy, false);
                    }
                }
                if (AlaLoopViewPager.this.gEQ != null) {
                    AlaLoopViewPager.this.gEQ.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gEP = false;
        this.gES = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gET = -1.0f;
            private float gEU = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uy = AlaLoopViewPager.this.gER.uy(i);
                if (this.gEU != uy) {
                    this.gEU = uy;
                    if (AlaLoopViewPager.this.gEQ != null) {
                        AlaLoopViewPager.this.gEQ.onPageSelected(uy);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gER != null) {
                    int uy = AlaLoopViewPager.this.gER.uy(i);
                    if (f == 0.0f && this.gET == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gER.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uy, false);
                    }
                    i = uy;
                }
                this.gET = f;
                if (AlaLoopViewPager.this.gEQ != null) {
                    if (AlaLoopViewPager.this.gER != null && i != AlaLoopViewPager.this.gER.bUE() - 1) {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gEQ.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gER != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uy = AlaLoopViewPager.this.gER.uy(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gER.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uy, false);
                    }
                }
                if (AlaLoopViewPager.this.gEQ != null) {
                    AlaLoopViewPager.this.gEQ.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.gES);
    }
}
