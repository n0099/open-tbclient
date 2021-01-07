package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hFX;
    ViewPager.OnPageChangeListener hFY;
    private AlaLoopPagerAdapterWrapper hFZ;
    private ViewPager.OnPageChangeListener hGa;

    public void setBoundaryCaching(boolean z) {
        this.hFX = z;
        if (this.hFZ != null) {
            this.hFZ.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hFZ = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hFZ.setBoundaryCaching(this.hFX);
        super.setAdapter(this.hFZ);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hFZ != null ? this.hFZ.cjB() : this.hFZ;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hFZ != null) {
            return this.hFZ.wY(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hFZ.wZ(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hFY = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hFX = false;
        this.hGa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hGb = -1.0f;
            private float hGc = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wY = AlaLoopViewPager.this.hFZ.wY(i);
                if (this.hGc != wY) {
                    this.hGc = wY;
                    if (AlaLoopViewPager.this.hFY != null) {
                        AlaLoopViewPager.this.hFY.onPageSelected(wY);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hFZ != null) {
                    int wY = AlaLoopViewPager.this.hFZ.wY(i);
                    if (f == 0.0f && this.hGb == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hFZ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                    i = wY;
                }
                this.hGb = f;
                if (AlaLoopViewPager.this.hFY != null) {
                    if (AlaLoopViewPager.this.hFZ != null && i != AlaLoopViewPager.this.hFZ.cjA() - 1) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hFZ != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wY = AlaLoopViewPager.this.hFZ.wY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hFZ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                }
                if (AlaLoopViewPager.this.hFY != null) {
                    AlaLoopViewPager.this.hFY.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFX = false;
        this.hGa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hGb = -1.0f;
            private float hGc = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wY = AlaLoopViewPager.this.hFZ.wY(i);
                if (this.hGc != wY) {
                    this.hGc = wY;
                    if (AlaLoopViewPager.this.hFY != null) {
                        AlaLoopViewPager.this.hFY.onPageSelected(wY);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hFZ != null) {
                    int wY = AlaLoopViewPager.this.hFZ.wY(i);
                    if (f == 0.0f && this.hGb == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hFZ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                    i = wY;
                }
                this.hGb = f;
                if (AlaLoopViewPager.this.hFY != null) {
                    if (AlaLoopViewPager.this.hFZ != null && i != AlaLoopViewPager.this.hFZ.cjA() - 1) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hFZ != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wY = AlaLoopViewPager.this.hFZ.wY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hFZ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                }
                if (AlaLoopViewPager.this.hFY != null) {
                    AlaLoopViewPager.this.hFY.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hGa);
    }
}
