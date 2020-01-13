package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes2.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fag;
    ViewPager.OnPageChangeListener fah;
    private AlaLoopPagerAdapterWrapper fai;
    private ViewPager.OnPageChangeListener faj;

    public void setBoundaryCaching(boolean z) {
        this.fag = z;
        if (this.fai != null) {
            this.fai.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fai = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fai.setBoundaryCaching(this.fag);
        super.setAdapter(this.fai);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fai != null ? this.fai.blx() : this.fai;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fai != null) {
            return this.fai.pU(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fai.pV(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fah = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fag = false;
        this.faj = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fak = -1.0f;
            private float fal = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int pU = AlaLoopViewPager.this.fai.pU(i);
                if (this.fal != pU) {
                    this.fal = pU;
                    if (AlaLoopViewPager.this.fah != null) {
                        AlaLoopViewPager.this.fah.onPageSelected(pU);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fai != null) {
                    int pU = AlaLoopViewPager.this.fai.pU(i);
                    if (f == 0.0f && this.fak == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fai.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pU, false);
                    }
                    i = pU;
                }
                this.fak = f;
                if (AlaLoopViewPager.this.fah != null) {
                    if (i != AlaLoopViewPager.this.fai.blw() - 1) {
                        AlaLoopViewPager.this.fah.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fah.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fah.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fai != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int pU = AlaLoopViewPager.this.fai.pU(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fai.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pU, false);
                    }
                }
                if (AlaLoopViewPager.this.fah != null) {
                    AlaLoopViewPager.this.fah.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fag = false;
        this.faj = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fak = -1.0f;
            private float fal = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int pU = AlaLoopViewPager.this.fai.pU(i);
                if (this.fal != pU) {
                    this.fal = pU;
                    if (AlaLoopViewPager.this.fah != null) {
                        AlaLoopViewPager.this.fah.onPageSelected(pU);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fai != null) {
                    int pU = AlaLoopViewPager.this.fai.pU(i);
                    if (f == 0.0f && this.fak == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fai.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pU, false);
                    }
                    i = pU;
                }
                this.fak = f;
                if (AlaLoopViewPager.this.fah != null) {
                    if (i != AlaLoopViewPager.this.fai.blw() - 1) {
                        AlaLoopViewPager.this.fah.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fah.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fah.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fai != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int pU = AlaLoopViewPager.this.fai.pU(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fai.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(pU, false);
                    }
                }
                if (AlaLoopViewPager.this.fah != null) {
                    AlaLoopViewPager.this.fah.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.faj);
    }
}
