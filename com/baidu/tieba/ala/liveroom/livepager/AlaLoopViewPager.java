package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes7.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean gBm;
    ViewPager.OnPageChangeListener gBn;
    private AlaLoopPagerAdapterWrapper gBo;
    private ViewPager.OnPageChangeListener gBp;

    public void setBoundaryCaching(boolean z) {
        this.gBm = z;
        if (this.gBo != null) {
            this.gBo.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.gBo = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.gBo.setBoundaryCaching(this.gBm);
        super.setAdapter(this.gBo);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.gBo != null ? this.gBo.bSU() : this.gBo;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.gBo != null) {
            return this.gBo.uf(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.gBo.ug(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.gBn = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.gBm = false;
        this.gBp = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gBq = -1.0f;
            private float gBr = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uf = AlaLoopViewPager.this.gBo.uf(i);
                if (this.gBr != uf) {
                    this.gBr = uf;
                    if (AlaLoopViewPager.this.gBn != null) {
                        AlaLoopViewPager.this.gBn.onPageSelected(uf);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gBo != null) {
                    int uf = AlaLoopViewPager.this.gBo.uf(i);
                    if (f == 0.0f && this.gBq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gBo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                    i = uf;
                }
                this.gBq = f;
                if (AlaLoopViewPager.this.gBn != null) {
                    if (AlaLoopViewPager.this.gBo != null && i != AlaLoopViewPager.this.gBo.bST() - 1) {
                        AlaLoopViewPager.this.gBn.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gBn.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gBn.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gBo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uf = AlaLoopViewPager.this.gBo.uf(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gBo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                }
                if (AlaLoopViewPager.this.gBn != null) {
                    AlaLoopViewPager.this.gBn.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBm = false;
        this.gBp = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float gBq = -1.0f;
            private float gBr = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int uf = AlaLoopViewPager.this.gBo.uf(i);
                if (this.gBr != uf) {
                    this.gBr = uf;
                    if (AlaLoopViewPager.this.gBn != null) {
                        AlaLoopViewPager.this.gBn.onPageSelected(uf);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.gBo != null) {
                    int uf = AlaLoopViewPager.this.gBo.uf(i);
                    if (f == 0.0f && this.gBq == 0.0f && (i == 0 || i == AlaLoopViewPager.this.gBo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                    i = uf;
                }
                this.gBq = f;
                if (AlaLoopViewPager.this.gBn != null) {
                    if (AlaLoopViewPager.this.gBo != null && i != AlaLoopViewPager.this.gBo.bST() - 1) {
                        AlaLoopViewPager.this.gBn.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.gBn.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.gBn.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.gBo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int uf = AlaLoopViewPager.this.gBo.uf(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.gBo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(uf, false);
                    }
                }
                if (AlaLoopViewPager.this.gBn != null) {
                    AlaLoopViewPager.this.gBn.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.gBp);
    }
}
