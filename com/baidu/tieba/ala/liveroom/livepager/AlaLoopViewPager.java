package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fIt;
    ViewPager.OnPageChangeListener fIu;
    private AlaLoopPagerAdapterWrapper fIv;
    private ViewPager.OnPageChangeListener fIw;

    public void setBoundaryCaching(boolean z) {
        this.fIt = z;
        if (this.fIv != null) {
            this.fIv.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fIv = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fIv.setBoundaryCaching(this.fIt);
        super.setAdapter(this.fIv);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fIv != null ? this.fIv.bwC() : this.fIv;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fIv != null) {
            return this.fIv.qx(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fIv.qy(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fIu = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fIt = false;
        this.fIw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fIx = -1.0f;
            private float fIy = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qx = AlaLoopViewPager.this.fIv.qx(i);
                if (this.fIy != qx) {
                    this.fIy = qx;
                    if (AlaLoopViewPager.this.fIu != null) {
                        AlaLoopViewPager.this.fIu.onPageSelected(qx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fIv != null) {
                    int qx = AlaLoopViewPager.this.fIv.qx(i);
                    if (f == 0.0f && this.fIx == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fIv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                    i = qx;
                }
                this.fIx = f;
                if (AlaLoopViewPager.this.fIu != null) {
                    if (AlaLoopViewPager.this.fIv != null && i != AlaLoopViewPager.this.fIv.bwB() - 1) {
                        AlaLoopViewPager.this.fIu.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fIu.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fIu.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fIv != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qx = AlaLoopViewPager.this.fIv.qx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fIv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                }
                if (AlaLoopViewPager.this.fIu != null) {
                    AlaLoopViewPager.this.fIu.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIt = false;
        this.fIw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fIx = -1.0f;
            private float fIy = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qx = AlaLoopViewPager.this.fIv.qx(i);
                if (this.fIy != qx) {
                    this.fIy = qx;
                    if (AlaLoopViewPager.this.fIu != null) {
                        AlaLoopViewPager.this.fIu.onPageSelected(qx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fIv != null) {
                    int qx = AlaLoopViewPager.this.fIv.qx(i);
                    if (f == 0.0f && this.fIx == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fIv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                    i = qx;
                }
                this.fIx = f;
                if (AlaLoopViewPager.this.fIu != null) {
                    if (AlaLoopViewPager.this.fIv != null && i != AlaLoopViewPager.this.fIv.bwB() - 1) {
                        AlaLoopViewPager.this.fIu.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fIu.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fIu.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fIv != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qx = AlaLoopViewPager.this.fIv.qx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fIv.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                }
                if (AlaLoopViewPager.this.fIu != null) {
                    AlaLoopViewPager.this.fIu.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fIw);
    }
}
