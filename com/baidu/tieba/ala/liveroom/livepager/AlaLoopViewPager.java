package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean gow;
    ViewPager.OnPageChangeListener gox;
    private AlaLoopPagerAdapterWrapper goy;
    private ViewPager.OnPageChangeListener goz;

    public void setBoundaryCaching(boolean z) {
        this.gow = z;
        if (this.goy != null) {
            this.goy.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.goy = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.goy.setBoundaryCaching(this.gow);
        super.setAdapter(this.goy);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.goy != null ? this.goy.bIT() : this.goy;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.goy != null) {
            return this.goy.rP(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.goy.rQ(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gox = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gow = false;
        this.goz = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float goA = -1.0f;
            private float goB = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int rP = AlaLoopViewPager.this.goy.rP(i);
                if (this.goB != rP) {
                    this.goB = rP;
                    if (AlaLoopViewPager.this.gox != null) {
                        AlaLoopViewPager.this.gox.onPageSelected(rP);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.goy != null) {
                    int rP = AlaLoopViewPager.this.goy.rP(i);
                    if (f == 0.0f && this.goA == 0.0f && (i == 0 || i == AlaLoopViewPager.this.goy.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rP, false);
                    }
                    i = rP;
                }
                this.goA = f;
                if (AlaLoopViewPager.this.gox != null) {
                    if (AlaLoopViewPager.this.goy != null && i != AlaLoopViewPager.this.goy.bIS() - 1) {
                        AlaLoopViewPager.this.gox.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gox.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gox.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.goy != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int rP = AlaLoopViewPager.this.goy.rP(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.goy.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rP, false);
                    }
                }
                if (AlaLoopViewPager.this.gox != null) {
                    AlaLoopViewPager.this.gox.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gow = false;
        this.goz = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float goA = -1.0f;
            private float goB = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int rP = AlaLoopViewPager.this.goy.rP(i);
                if (this.goB != rP) {
                    this.goB = rP;
                    if (AlaLoopViewPager.this.gox != null) {
                        AlaLoopViewPager.this.gox.onPageSelected(rP);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.goy != null) {
                    int rP = AlaLoopViewPager.this.goy.rP(i);
                    if (f == 0.0f && this.goA == 0.0f && (i == 0 || i == AlaLoopViewPager.this.goy.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rP, false);
                    }
                    i = rP;
                }
                this.goA = f;
                if (AlaLoopViewPager.this.gox != null) {
                    if (AlaLoopViewPager.this.goy != null && i != AlaLoopViewPager.this.goy.bIS() - 1) {
                        AlaLoopViewPager.this.gox.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gox.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gox.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.goy != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int rP = AlaLoopViewPager.this.goy.rP(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.goy.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(rP, false);
                    }
                }
                if (AlaLoopViewPager.this.gox != null) {
                    AlaLoopViewPager.this.gox.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.goz);
    }
}
