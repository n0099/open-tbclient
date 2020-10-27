package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean heZ;
    ViewPager.OnPageChangeListener hfa;
    private AlaLoopPagerAdapterWrapper hfb;
    private ViewPager.OnPageChangeListener hfc;

    public void setBoundaryCaching(boolean z) {
        this.heZ = z;
        if (this.hfb != null) {
            this.hfb.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hfb = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hfb.setBoundaryCaching(this.heZ);
        super.setAdapter(this.hfb);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hfb != null ? this.hfb.caZ() : this.hfb;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hfb != null) {
            return this.hfb.vx(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hfb.vy(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hfa = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.heZ = false;
        this.hfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hfd = -1.0f;
            private float hfe = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vx = AlaLoopViewPager.this.hfb.vx(i);
                if (this.hfe != vx) {
                    this.hfe = vx;
                    if (AlaLoopViewPager.this.hfa != null) {
                        AlaLoopViewPager.this.hfa.onPageSelected(vx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hfb != null) {
                    int vx = AlaLoopViewPager.this.hfb.vx(i);
                    if (f == 0.0f && this.hfd == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hfb.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                    i = vx;
                }
                this.hfd = f;
                if (AlaLoopViewPager.this.hfa != null) {
                    if (AlaLoopViewPager.this.hfb != null && i != AlaLoopViewPager.this.hfb.caY() - 1) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hfb != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vx = AlaLoopViewPager.this.hfb.vx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hfb.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                }
                if (AlaLoopViewPager.this.hfa != null) {
                    AlaLoopViewPager.this.hfa.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heZ = false;
        this.hfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hfd = -1.0f;
            private float hfe = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vx = AlaLoopViewPager.this.hfb.vx(i);
                if (this.hfe != vx) {
                    this.hfe = vx;
                    if (AlaLoopViewPager.this.hfa != null) {
                        AlaLoopViewPager.this.hfa.onPageSelected(vx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hfb != null) {
                    int vx = AlaLoopViewPager.this.hfb.vx(i);
                    if (f == 0.0f && this.hfd == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hfb.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                    i = vx;
                }
                this.hfd = f;
                if (AlaLoopViewPager.this.hfa != null) {
                    if (AlaLoopViewPager.this.hfb != null && i != AlaLoopViewPager.this.hfb.caY() - 1) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hfb != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vx = AlaLoopViewPager.this.hfb.vx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hfb.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                }
                if (AlaLoopViewPager.this.hfa != null) {
                    AlaLoopViewPager.this.hfa.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hfc);
    }
}
