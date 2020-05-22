package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fWp;
    ViewPager.OnPageChangeListener fWq;
    private AlaLoopPagerAdapterWrapper fWr;
    private ViewPager.OnPageChangeListener fWs;

    public void setBoundaryCaching(boolean z) {
        this.fWp = z;
        if (this.fWr != null) {
            this.fWr.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fWr = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fWr.setBoundaryCaching(this.fWp);
        super.setAdapter(this.fWr);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fWr != null ? this.fWr.bCC() : this.fWr;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fWr != null) {
            return this.fWr.qY(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fWr.qZ(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fWq = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fWp = false;
        this.fWs = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fWt = -1.0f;
            private float fWu = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qY = AlaLoopViewPager.this.fWr.qY(i);
                if (this.fWu != qY) {
                    this.fWu = qY;
                    if (AlaLoopViewPager.this.fWq != null) {
                        AlaLoopViewPager.this.fWq.onPageSelected(qY);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fWr != null) {
                    int qY = AlaLoopViewPager.this.fWr.qY(i);
                    if (f == 0.0f && this.fWt == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fWr.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qY, false);
                    }
                    i = qY;
                }
                this.fWt = f;
                if (AlaLoopViewPager.this.fWq != null) {
                    if (AlaLoopViewPager.this.fWr != null && i != AlaLoopViewPager.this.fWr.bCB() - 1) {
                        AlaLoopViewPager.this.fWq.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fWq.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fWq.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fWr != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qY = AlaLoopViewPager.this.fWr.qY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fWr.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qY, false);
                    }
                }
                if (AlaLoopViewPager.this.fWq != null) {
                    AlaLoopViewPager.this.fWq.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWp = false;
        this.fWs = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fWt = -1.0f;
            private float fWu = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qY = AlaLoopViewPager.this.fWr.qY(i);
                if (this.fWu != qY) {
                    this.fWu = qY;
                    if (AlaLoopViewPager.this.fWq != null) {
                        AlaLoopViewPager.this.fWq.onPageSelected(qY);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fWr != null) {
                    int qY = AlaLoopViewPager.this.fWr.qY(i);
                    if (f == 0.0f && this.fWt == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fWr.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qY, false);
                    }
                    i = qY;
                }
                this.fWt = f;
                if (AlaLoopViewPager.this.fWq != null) {
                    if (AlaLoopViewPager.this.fWr != null && i != AlaLoopViewPager.this.fWr.bCB() - 1) {
                        AlaLoopViewPager.this.fWq.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fWq.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fWq.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fWr != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qY = AlaLoopViewPager.this.fWr.qY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fWr.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qY, false);
                    }
                }
                if (AlaLoopViewPager.this.fWq != null) {
                    AlaLoopViewPager.this.fWq.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fWs);
    }
}
