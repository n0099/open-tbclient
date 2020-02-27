package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class AlaActiveBannerViewPager extends ViewPager {
    private View.OnTouchListener drz;
    private boolean ePi;
    private Handler mHandler;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private Runnable mRunnable;

    public AlaActiveBannerViewPager(Context context) {
        super(context);
        this.ePi = false;
        this.drz = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.ePi = true;
                } else {
                    AlaActiveBannerViewPager.this.ePi = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaActiveBannerViewPager.this.ePi = true;
                } else {
                    AlaActiveBannerViewPager.this.ePi = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.ePi && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaActiveBannerViewPager.this.setCurrentItem(AlaActiveBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaActiveBannerViewPager.this.mHandler.postDelayed(AlaActiveBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    public AlaActiveBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePi = false;
        this.drz = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.ePi = true;
                } else {
                    AlaActiveBannerViewPager.this.ePi = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaActiveBannerViewPager.this.ePi = true;
                } else {
                    AlaActiveBannerViewPager.this.ePi = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.ePi && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaActiveBannerViewPager.this.setCurrentItem(AlaActiveBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaActiveBannerViewPager.this.mHandler.postDelayed(AlaActiveBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        addOnPageChangeListener(this.mOnPageChangeListener);
        setOnTouchListener(this.drz);
    }

    public void bhM() {
        if (getAdapter().getCount() > 1) {
            setCurrentItem(1);
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, 10000L);
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
