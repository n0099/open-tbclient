package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fdG;
    ViewPager.OnPageChangeListener fdH;
    private AlaLoopPagerAdapterWrapper fdI;
    private ViewPager.OnPageChangeListener fdJ;

    public void setBoundaryCaching(boolean z) {
        this.fdG = z;
        if (this.fdI != null) {
            this.fdI.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fdI = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fdI.setBoundaryCaching(this.fdG);
        super.setAdapter(this.fdI);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fdI != null ? this.fdI.bni() : this.fdI;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fdI != null) {
            return this.fdI.qc(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fdI.qd(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fdH = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fdG = false;
        this.fdJ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdK = -1.0f;
            private float fdL = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdI.qc(i);
                if (this.fdL != qc) {
                    this.fdL = qc;
                    if (AlaLoopViewPager.this.fdH != null) {
                        AlaLoopViewPager.this.fdH.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdI != null) {
                    int qc = AlaLoopViewPager.this.fdI.qc(i);
                    if (f == 0.0f && this.fdK == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdI.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdK = f;
                if (AlaLoopViewPager.this.fdH != null) {
                    if (AlaLoopViewPager.this.fdI != null && i != AlaLoopViewPager.this.fdI.bnh() - 1) {
                        AlaLoopViewPager.this.fdH.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdH.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdH.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdI != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdI.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdI.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdH != null) {
                    AlaLoopViewPager.this.fdH.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdG = false;
        this.fdJ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fdK = -1.0f;
            private float fdL = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qc = AlaLoopViewPager.this.fdI.qc(i);
                if (this.fdL != qc) {
                    this.fdL = qc;
                    if (AlaLoopViewPager.this.fdH != null) {
                        AlaLoopViewPager.this.fdH.onPageSelected(qc);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fdI != null) {
                    int qc = AlaLoopViewPager.this.fdI.qc(i);
                    if (f == 0.0f && this.fdK == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fdI.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                    i = qc;
                }
                this.fdK = f;
                if (AlaLoopViewPager.this.fdH != null) {
                    if (AlaLoopViewPager.this.fdI != null && i != AlaLoopViewPager.this.fdI.bnh() - 1) {
                        AlaLoopViewPager.this.fdH.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fdH.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fdH.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fdI != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qc = AlaLoopViewPager.this.fdI.qc(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fdI.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qc, false);
                    }
                }
                if (AlaLoopViewPager.this.fdH != null) {
                    AlaLoopViewPager.this.fdH.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fdJ);
    }
}
