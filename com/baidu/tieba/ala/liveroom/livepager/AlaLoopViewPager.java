package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes7.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean gBq;
    ViewPager.OnPageChangeListener gBr;
    private AlaLoopPagerAdapterWrapper gBs;
    private ViewPager.OnPageChangeListener gBt;

    public void setBoundaryCaching(boolean z) {
        this.gBq = z;
        if (this.gBs != null) {
            this.gBs.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.gBs = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.gBs.setBoundaryCaching(this.gBq);
        super.setAdapter(this.gBs);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.gBs != null ? this.gBs.bSV() : this.gBs;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.gBs != null) {
            return this.gBs.uf(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.gBs.ug(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gBr = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gBq = false;
        this.gBt = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gBu = -1.0f;
            private float gBv = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uf = AlaLoopViewPager.this.gBs.uf(i);
                if (this.gBv != uf) {
                    this.gBv = uf;
                    if (AlaLoopViewPager.this.gBr != null) {
                        AlaLoopViewPager.this.gBr.onPageSelected(uf);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gBs != null) {
                    int uf = AlaLoopViewPager.this.gBs.uf(i);
                    if (f == 0.0f && this.gBu == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gBs.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                    i = uf;
                }
                this.gBu = f;
                if (AlaLoopViewPager.this.gBr != null) {
                    if (AlaLoopViewPager.this.gBs != null && i != AlaLoopViewPager.this.gBs.bSU() - 1) {
                        AlaLoopViewPager.this.gBr.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gBr.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gBr.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gBs != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uf = AlaLoopViewPager.this.gBs.uf(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gBs.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                }
                if (AlaLoopViewPager.this.gBr != null) {
                    AlaLoopViewPager.this.gBr.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBq = false;
        this.gBt = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gBu = -1.0f;
            private float gBv = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uf = AlaLoopViewPager.this.gBs.uf(i);
                if (this.gBv != uf) {
                    this.gBv = uf;
                    if (AlaLoopViewPager.this.gBr != null) {
                        AlaLoopViewPager.this.gBr.onPageSelected(uf);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gBs != null) {
                    int uf = AlaLoopViewPager.this.gBs.uf(i);
                    if (f == 0.0f && this.gBu == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gBs.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                    i = uf;
                }
                this.gBu = f;
                if (AlaLoopViewPager.this.gBr != null) {
                    if (AlaLoopViewPager.this.gBs != null && i != AlaLoopViewPager.this.gBs.bSU() - 1) {
                        AlaLoopViewPager.this.gBr.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gBr.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gBr.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gBs != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uf = AlaLoopViewPager.this.gBs.uf(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gBs.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                }
                if (AlaLoopViewPager.this.gBr != null) {
                    AlaLoopViewPager.this.gBr.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.gBt);
    }
}
