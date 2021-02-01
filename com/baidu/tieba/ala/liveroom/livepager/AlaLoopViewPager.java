package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hFB;
    ViewPager.OnPageChangeListener hFC;
    private AlaLoopPagerAdapterWrapper hFD;
    private ViewPager.OnPageChangeListener hFE;

    public void setBoundaryCaching(boolean z) {
        this.hFB = z;
        if (this.hFD != null) {
            this.hFD.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hFD = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hFD.setBoundaryCaching(this.hFB);
        super.setAdapter(this.hFD);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hFD != null ? this.hFD.cgC() : this.hFD;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hFD != null) {
            return this.hFD.vD(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hFD.vE(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hFC = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hFB = false;
        this.hFE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hFF = -1.0f;
            private float hFG = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.hFD.vD(i);
                if (this.hFG != vD) {
                    this.hFG = vD;
                    if (AlaLoopViewPager.this.hFC != null) {
                        AlaLoopViewPager.this.hFC.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hFD != null) {
                    int vD = AlaLoopViewPager.this.hFD.vD(i);
                    if (f == 0.0f && this.hFF == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hFD.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFF = f;
                if (AlaLoopViewPager.this.hFC != null) {
                    if (AlaLoopViewPager.this.hFD != null && i != AlaLoopViewPager.this.hFD.cgB() - 1) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hFD != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.hFD.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hFD.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFC != null) {
                    AlaLoopViewPager.this.hFC.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFB = false;
        this.hFE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hFF = -1.0f;
            private float hFG = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.hFD.vD(i);
                if (this.hFG != vD) {
                    this.hFG = vD;
                    if (AlaLoopViewPager.this.hFC != null) {
                        AlaLoopViewPager.this.hFC.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hFD != null) {
                    int vD = AlaLoopViewPager.this.hFD.vD(i);
                    if (f == 0.0f && this.hFF == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hFD.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFF = f;
                if (AlaLoopViewPager.this.hFC != null) {
                    if (AlaLoopViewPager.this.hFD != null && i != AlaLoopViewPager.this.hFD.cgB() - 1) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hFD != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.hFD.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hFD.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFC != null) {
                    AlaLoopViewPager.this.hFC.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hFE);
    }
}
