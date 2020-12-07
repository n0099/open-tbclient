package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hua;
    ViewPager.OnPageChangeListener hub;
    private AlaLoopPagerAdapterWrapper huc;
    private ViewPager.OnPageChangeListener hud;

    public void setBoundaryCaching(boolean z) {
        this.hua = z;
        if (this.huc != null) {
            this.huc.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.huc = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.huc.setBoundaryCaching(this.hua);
        super.setAdapter(this.huc);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.huc != null ? this.huc.cgL() : this.huc;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.huc != null) {
            return this.huc.wN(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.huc.wO(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hub = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hua = false;
        this.hud = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hue = -1.0f;
            private float huf = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.huc.wN(i);
                if (this.huf != wN) {
                    this.huf = wN;
                    if (AlaLoopViewPager.this.hub != null) {
                        AlaLoopViewPager.this.hub.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.huc != null) {
                    int wN = AlaLoopViewPager.this.huc.wN(i);
                    if (f == 0.0f && this.hue == 0.0f && (i == 0 || i == AlaLoopViewPager.this.huc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hue = f;
                if (AlaLoopViewPager.this.hub != null) {
                    if (AlaLoopViewPager.this.huc != null && i != AlaLoopViewPager.this.huc.cgK() - 1) {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hub.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.huc != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.huc.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.huc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hub != null) {
                    AlaLoopViewPager.this.hub.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hua = false;
        this.hud = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hue = -1.0f;
            private float huf = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.huc.wN(i);
                if (this.huf != wN) {
                    this.huf = wN;
                    if (AlaLoopViewPager.this.hub != null) {
                        AlaLoopViewPager.this.hub.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.huc != null) {
                    int wN = AlaLoopViewPager.this.huc.wN(i);
                    if (f == 0.0f && this.hue == 0.0f && (i == 0 || i == AlaLoopViewPager.this.huc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hue = f;
                if (AlaLoopViewPager.this.hub != null) {
                    if (AlaLoopViewPager.this.huc != null && i != AlaLoopViewPager.this.huc.cgK() - 1) {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hub.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.huc != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.huc.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.huc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hub != null) {
                    AlaLoopViewPager.this.hub.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hud);
    }
}
