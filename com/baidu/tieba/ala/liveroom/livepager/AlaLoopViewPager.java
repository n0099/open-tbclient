package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean huc;
    ViewPager.OnPageChangeListener hud;
    private AlaLoopPagerAdapterWrapper hue;
    private ViewPager.OnPageChangeListener huf;

    public void setBoundaryCaching(boolean z) {
        this.huc = z;
        if (this.hue != null) {
            this.hue.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hue = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hue.setBoundaryCaching(this.huc);
        super.setAdapter(this.hue);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hue != null ? this.hue.cgM() : this.hue;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hue != null) {
            return this.hue.wN(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hue.wO(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hud = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.huc = false;
        this.huf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hug = -1.0f;
            private float huh = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.hue.wN(i);
                if (this.huh != wN) {
                    this.huh = wN;
                    if (AlaLoopViewPager.this.hud != null) {
                        AlaLoopViewPager.this.hud.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hue != null) {
                    int wN = AlaLoopViewPager.this.hue.wN(i);
                    if (f == 0.0f && this.hug == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hue.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hug = f;
                if (AlaLoopViewPager.this.hud != null) {
                    if (AlaLoopViewPager.this.hue != null && i != AlaLoopViewPager.this.hue.cgL() - 1) {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hud.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hue != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.hue.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hue.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hud != null) {
                    AlaLoopViewPager.this.hud.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huc = false;
        this.huf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hug = -1.0f;
            private float huh = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.hue.wN(i);
                if (this.huh != wN) {
                    this.huh = wN;
                    if (AlaLoopViewPager.this.hud != null) {
                        AlaLoopViewPager.this.hud.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hue != null) {
                    int wN = AlaLoopViewPager.this.hue.wN(i);
                    if (f == 0.0f && this.hug == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hue.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hug = f;
                if (AlaLoopViewPager.this.hud != null) {
                    if (AlaLoopViewPager.this.hue != null && i != AlaLoopViewPager.this.hue.cgL() - 1) {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hud.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hue != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.hue.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hue.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hud != null) {
                    AlaLoopViewPager.this.hud.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.huf);
    }
}
