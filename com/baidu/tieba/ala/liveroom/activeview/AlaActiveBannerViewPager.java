package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
/* loaded from: classes11.dex */
public class AlaActiveBannerViewPager extends SlideRatioViewPager implements d {
    private final View.OnTouchListener bST;
    private boolean gMb;
    private final SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;

    public AlaActiveBannerViewPager(Context context) {
        super(context);
        this.gMb = false;
        this.bST = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AlaActiveBannerViewPager.this.gMb = motionEvent.getAction() == 0 || motionEvent.getAction() == 2;
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                AlaActiveBannerViewPager.this.gMb = i == 1;
            }
        };
        init();
    }

    public AlaActiveBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gMb = false;
        this.bST = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AlaActiveBannerViewPager.this.gMb = motionEvent.getAction() == 0 || motionEvent.getAction() == 2;
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                AlaActiveBannerViewPager.this.gMb = i == 1;
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void XU() {
        if (!this.gMb) {
            setCurrentItem(getCurrentItem() + 1, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
    }

    private void init() {
        addOnPageChangeListener(this.mOnPageChangeListener);
        setOnTouchListener(this.bST);
    }
}
