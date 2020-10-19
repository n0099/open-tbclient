package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean gTm;
    ViewPager.OnPageChangeListener gTn;
    private AlaLoopPagerAdapterWrapper gTo;
    private ViewPager.OnPageChangeListener gTp;

    public void setBoundaryCaching(boolean z) {
        this.gTm = z;
        if (this.gTo != null) {
            this.gTo.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.gTo = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.gTo.setBoundaryCaching(this.gTm);
        super.setAdapter(this.gTo);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.gTo != null ? this.gTo.bXY() : this.gTo;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.gTo != null) {
            return this.gTo.vd(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.gTo.ve(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gTn = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gTm = false;
        this.gTp = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gTq = -1.0f;
            private float gTr = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vd = AlaLoopViewPager.this.gTo.vd(i);
                if (this.gTr != vd) {
                    this.gTr = vd;
                    if (AlaLoopViewPager.this.gTn != null) {
                        AlaLoopViewPager.this.gTn.onPageSelected(vd);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gTo != null) {
                    int vd = AlaLoopViewPager.this.gTo.vd(i);
                    if (f == 0.0f && this.gTq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gTo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vd, false);
                    }
                    i = vd;
                }
                this.gTq = f;
                if (AlaLoopViewPager.this.gTn != null) {
                    if (AlaLoopViewPager.this.gTo != null && i != AlaLoopViewPager.this.gTo.bXX() - 1) {
                        AlaLoopViewPager.this.gTn.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gTn.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gTn.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gTo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vd = AlaLoopViewPager.this.gTo.vd(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gTo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vd, false);
                    }
                }
                if (AlaLoopViewPager.this.gTn != null) {
                    AlaLoopViewPager.this.gTn.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTm = false;
        this.gTp = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gTq = -1.0f;
            private float gTr = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vd = AlaLoopViewPager.this.gTo.vd(i);
                if (this.gTr != vd) {
                    this.gTr = vd;
                    if (AlaLoopViewPager.this.gTn != null) {
                        AlaLoopViewPager.this.gTn.onPageSelected(vd);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gTo != null) {
                    int vd = AlaLoopViewPager.this.gTo.vd(i);
                    if (f == 0.0f && this.gTq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gTo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vd, false);
                    }
                    i = vd;
                }
                this.gTq = f;
                if (AlaLoopViewPager.this.gTn != null) {
                    if (AlaLoopViewPager.this.gTo != null && i != AlaLoopViewPager.this.gTo.bXX() - 1) {
                        AlaLoopViewPager.this.gTn.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gTn.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gTn.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gTo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vd = AlaLoopViewPager.this.gTo.vd(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gTo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vd, false);
                    }
                }
                if (AlaLoopViewPager.this.gTn != null) {
                    AlaLoopViewPager.this.gTn.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.gTp);
    }
}
