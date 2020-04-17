package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean fIo;
    ViewPager.OnPageChangeListener fIp;
    private AlaLoopPagerAdapterWrapper fIq;
    private ViewPager.OnPageChangeListener fIr;

    public void setBoundaryCaching(boolean z) {
        this.fIo = z;
        if (this.fIq != null) {
            this.fIq.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.fIq = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.fIq.setBoundaryCaching(this.fIo);
        super.setAdapter(this.fIq);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.fIq != null ? this.fIq.bwE() : this.fIq;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.fIq != null) {
            return this.fIq.qx(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.fIq.qy(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fIp = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.fIo = false;
        this.fIr = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fIs = -1.0f;
            private float fIt = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qx = AlaLoopViewPager.this.fIq.qx(i);
                if (this.fIt != qx) {
                    this.fIt = qx;
                    if (AlaLoopViewPager.this.fIp != null) {
                        AlaLoopViewPager.this.fIp.onPageSelected(qx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fIq != null) {
                    int qx = AlaLoopViewPager.this.fIq.qx(i);
                    if (f == 0.0f && this.fIs == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fIq.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                    i = qx;
                }
                this.fIs = f;
                if (AlaLoopViewPager.this.fIp != null) {
                    if (AlaLoopViewPager.this.fIq != null && i != AlaLoopViewPager.this.fIq.bwD() - 1) {
                        AlaLoopViewPager.this.fIp.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fIp.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fIp.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fIq != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qx = AlaLoopViewPager.this.fIq.qx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fIq.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                }
                if (AlaLoopViewPager.this.fIp != null) {
                    AlaLoopViewPager.this.fIp.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIo = false;
        this.fIr = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float fIs = -1.0f;
            private float fIt = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int qx = AlaLoopViewPager.this.fIq.qx(i);
                if (this.fIt != qx) {
                    this.fIt = qx;
                    if (AlaLoopViewPager.this.fIp != null) {
                        AlaLoopViewPager.this.fIp.onPageSelected(qx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.fIq != null) {
                    int qx = AlaLoopViewPager.this.fIq.qx(i);
                    if (f == 0.0f && this.fIs == 0.0f && (i == 0 || i == AlaLoopViewPager.this.fIq.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                    i = qx;
                }
                this.fIs = f;
                if (AlaLoopViewPager.this.fIp != null) {
                    if (AlaLoopViewPager.this.fIq != null && i != AlaLoopViewPager.this.fIq.bwD() - 1) {
                        AlaLoopViewPager.this.fIp.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.fIp.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.fIp.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.fIq != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int qx = AlaLoopViewPager.this.fIq.qx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.fIq.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(qx, false);
                    }
                }
                if (AlaLoopViewPager.this.fIp != null) {
                    AlaLoopViewPager.this.fIp.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.fIr);
    }
}
