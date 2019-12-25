package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean eXH;
    ViewPager.OnPageChangeListener eXI;
    private AlaLoopPagerAdapterWrapper eXJ;
    private ViewPager.OnPageChangeListener eXK;

    public void setBoundaryCaching(boolean z) {
        this.eXH = z;
        if (this.eXJ != null) {
            this.eXJ.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.eXJ = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.eXJ.setBoundaryCaching(this.eXH);
        super.setAdapter(this.eXJ);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.eXJ != null ? this.eXJ.bkB() : this.eXJ;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.eXJ != null) {
            return this.eXJ.pP(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.eXJ.pQ(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eXI = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.eXH = false;
        this.eXK = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float eXL = -1.0f;
            private float eXM = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int pP = AlaLoopViewPager.this.eXJ.pP(i);
                if (this.eXM != pP) {
                    this.eXM = pP;
                    if (AlaLoopViewPager.this.eXI != null) {
                        AlaLoopViewPager.this.eXI.onPageSelected(pP);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.eXJ != null) {
                    int pP = AlaLoopViewPager.this.eXJ.pP(i);
                    if (f == 0.0f && this.eXL == 0.0f && (i == 0 || i == AlaLoopViewPager.this.eXJ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pP, false);
                    }
                    i = pP;
                }
                this.eXL = f;
                if (AlaLoopViewPager.this.eXI != null) {
                    if (i != AlaLoopViewPager.this.eXJ.bkA() - 1) {
                        AlaLoopViewPager.this.eXI.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.eXI.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.eXI.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.eXJ != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int pP = AlaLoopViewPager.this.eXJ.pP(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.eXJ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pP, false);
                    }
                }
                if (AlaLoopViewPager.this.eXI != null) {
                    AlaLoopViewPager.this.eXI.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXH = false;
        this.eXK = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float eXL = -1.0f;
            private float eXM = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int pP = AlaLoopViewPager.this.eXJ.pP(i);
                if (this.eXM != pP) {
                    this.eXM = pP;
                    if (AlaLoopViewPager.this.eXI != null) {
                        AlaLoopViewPager.this.eXI.onPageSelected(pP);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.eXJ != null) {
                    int pP = AlaLoopViewPager.this.eXJ.pP(i);
                    if (f == 0.0f && this.eXL == 0.0f && (i == 0 || i == AlaLoopViewPager.this.eXJ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pP, false);
                    }
                    i = pP;
                }
                this.eXL = f;
                if (AlaLoopViewPager.this.eXI != null) {
                    if (i != AlaLoopViewPager.this.eXJ.bkA() - 1) {
                        AlaLoopViewPager.this.eXI.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.eXI.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.eXI.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.eXJ != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int pP = AlaLoopViewPager.this.eXJ.pP(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.eXJ.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pP, false);
                    }
                }
                if (AlaLoopViewPager.this.eXI != null) {
                    AlaLoopViewPager.this.eXI.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.eXK);
    }
}
