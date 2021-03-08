package com.baidu.tieba.ala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes10.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private AlaLoopPagerAdapterWrapper hHA;
    private ViewPager.OnPageChangeListener hHB;
    private boolean hHy;
    ViewPager.OnPageChangeListener hHz;

    public void setBoundaryCaching(boolean z) {
        this.hHy = z;
        if (this.hHA != null) {
            this.hHA.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.hHA = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.hHA.setBoundaryCaching(this.hHy);
        super.setAdapter(this.hHA);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.hHA != null ? this.hHA.cgP() : this.hHA;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.hHA != null) {
            return this.hHA.vF(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.hHA.vG(i), z);
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hHz = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hHy = false;
        this.hHB = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hHC = -1.0f;
            private float hHD = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vF = AlaLoopViewPager.this.hHA.vF(i);
                if (this.hHD != vF) {
                    this.hHD = vF;
                    if (AlaLoopViewPager.this.hHz != null) {
                        AlaLoopViewPager.this.hHz.onPageSelected(vF);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hHA != null) {
                    int vF = AlaLoopViewPager.this.hHA.vF(i);
                    if (f == 0.0f && this.hHC == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hHA.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vF, false);
                    }
                    i = vF;
                }
                this.hHC = f;
                if (AlaLoopViewPager.this.hHz != null) {
                    if (AlaLoopViewPager.this.hHA != null && i != AlaLoopViewPager.this.hHA.cgO() - 1) {
                        AlaLoopViewPager.this.hHz.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hHz.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hHz.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hHA != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vF = AlaLoopViewPager.this.hHA.vF(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hHA.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vF, false);
                    }
                }
                if (AlaLoopViewPager.this.hHz != null) {
                    AlaLoopViewPager.this.hHz.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHy = false;
        this.hHB = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager.1
            private float hHC = -1.0f;
            private float hHD = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vF = AlaLoopViewPager.this.hHA.vF(i);
                if (this.hHD != vF) {
                    this.hHD = vF;
                    if (AlaLoopViewPager.this.hHz != null) {
                        AlaLoopViewPager.this.hHz.onPageSelected(vF);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.hHA != null) {
                    int vF = AlaLoopViewPager.this.hHA.vF(i);
                    if (f == 0.0f && this.hHC == 0.0f && (i == 0 || i == AlaLoopViewPager.this.hHA.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vF, false);
                    }
                    i = vF;
                }
                this.hHC = f;
                if (AlaLoopViewPager.this.hHz != null) {
                    if (AlaLoopViewPager.this.hHA != null && i != AlaLoopViewPager.this.hHA.cgO() - 1) {
                        AlaLoopViewPager.this.hHz.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hHz.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hHz.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.hHA != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vF = AlaLoopViewPager.this.hHA.vF(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.hHA.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vF, false);
                    }
                }
                if (AlaLoopViewPager.this.hHz != null) {
                    AlaLoopViewPager.this.hHz.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hHB);
    }
}
