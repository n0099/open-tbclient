package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean ehv;
    ViewPager.OnPageChangeListener ehw;
    private AlaLoopPagerAdapterWrapper ehx;
    private ViewPager.OnPageChangeListener ehy;

    public void setBoundaryCaching(boolean z) {
        this.ehv = z;
        if (this.ehx != null) {
            this.ehx.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.ehx = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.ehx.setBoundaryCaching(this.ehv);
        super.setAdapter(this.ehx);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.ehx != null ? this.ehx.aSO() : this.ehx;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.ehx != null) {
            return this.ehx.ny(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.ehx.nz(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ehw = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.ehv = false;
        this.ehy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float ehz = -1.0f;
            private float ehA = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int ny = AlaLoopViewPager.this.ehx.ny(i);
                if (this.ehA != ny) {
                    this.ehA = ny;
                    if (AlaLoopViewPager.this.ehw != null) {
                        AlaLoopViewPager.this.ehw.onPageSelected(ny);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.ehx != null) {
                    int ny = AlaLoopViewPager.this.ehx.ny(i);
                    if (f == 0.0f && this.ehz == 0.0f && (i == 0 || i == AlaLoopViewPager.this.ehx.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ny, false);
                    }
                    i = ny;
                }
                this.ehz = f;
                if (AlaLoopViewPager.this.ehw != null) {
                    if (i != AlaLoopViewPager.this.ehx.aSN() - 1) {
                        AlaLoopViewPager.this.ehw.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.ehw.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.ehw.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.ehx != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int ny = AlaLoopViewPager.this.ehx.ny(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.ehx.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ny, false);
                    }
                }
                if (AlaLoopViewPager.this.ehw != null) {
                    AlaLoopViewPager.this.ehw.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehv = false;
        this.ehy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float ehz = -1.0f;
            private float ehA = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int ny = AlaLoopViewPager.this.ehx.ny(i);
                if (this.ehA != ny) {
                    this.ehA = ny;
                    if (AlaLoopViewPager.this.ehw != null) {
                        AlaLoopViewPager.this.ehw.onPageSelected(ny);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.ehx != null) {
                    int ny = AlaLoopViewPager.this.ehx.ny(i);
                    if (f == 0.0f && this.ehz == 0.0f && (i == 0 || i == AlaLoopViewPager.this.ehx.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ny, false);
                    }
                    i = ny;
                }
                this.ehz = f;
                if (AlaLoopViewPager.this.ehw != null) {
                    if (i != AlaLoopViewPager.this.ehx.aSN() - 1) {
                        AlaLoopViewPager.this.ehw.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.ehw.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.ehw.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.ehx != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int ny = AlaLoopViewPager.this.ehx.ny(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.ehx.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(ny, false);
                    }
                }
                if (AlaLoopViewPager.this.ehw != null) {
                    AlaLoopViewPager.this.ehw.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.ehy);
    }
}
