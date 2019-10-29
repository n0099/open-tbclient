package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean eim;
    ViewPager.OnPageChangeListener ein;
    private AlaLoopPagerAdapterWrapper eio;
    private ViewPager.OnPageChangeListener eip;

    public void setBoundaryCaching(boolean z) {
        this.eim = z;
        if (this.eio != null) {
            this.eio.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.eio = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.eio.setBoundaryCaching(this.eim);
        super.setAdapter(this.eio);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.eio != null ? this.eio.aSQ() : this.eio;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.eio != null) {
            return this.eio.nz(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.eio.nA(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ein = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.eim = false;
        this.eip = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float eiq = -1.0f;
            private float eir = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int nz = AlaLoopViewPager.this.eio.nz(i);
                if (this.eir != nz) {
                    this.eir = nz;
                    if (AlaLoopViewPager.this.ein != null) {
                        AlaLoopViewPager.this.ein.onPageSelected(nz);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.eio != null) {
                    int nz = AlaLoopViewPager.this.eio.nz(i);
                    if (f == 0.0f && this.eiq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.eio.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(nz, false);
                    }
                    i = nz;
                }
                this.eiq = f;
                if (AlaLoopViewPager.this.ein != null) {
                    if (i != AlaLoopViewPager.this.eio.aSP() - 1) {
                        AlaLoopViewPager.this.ein.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.ein.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.ein.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.eio != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int nz = AlaLoopViewPager.this.eio.nz(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.eio.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(nz, false);
                    }
                }
                if (AlaLoopViewPager.this.ein != null) {
                    AlaLoopViewPager.this.ein.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eim = false;
        this.eip = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float eiq = -1.0f;
            private float eir = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int nz = AlaLoopViewPager.this.eio.nz(i);
                if (this.eir != nz) {
                    this.eir = nz;
                    if (AlaLoopViewPager.this.ein != null) {
                        AlaLoopViewPager.this.ein.onPageSelected(nz);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.eio != null) {
                    int nz = AlaLoopViewPager.this.eio.nz(i);
                    if (f == 0.0f && this.eiq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.eio.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(nz, false);
                    }
                    i = nz;
                }
                this.eiq = f;
                if (AlaLoopViewPager.this.ein != null) {
                    if (i != AlaLoopViewPager.this.eio.aSP() - 1) {
                        AlaLoopViewPager.this.ein.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.ein.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.ein.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.eio != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int nz = AlaLoopViewPager.this.eio.nz(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.eio.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(nz, false);
                    }
                }
                if (AlaLoopViewPager.this.ein != null) {
                    AlaLoopViewPager.this.ein.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.eip);
    }
}
