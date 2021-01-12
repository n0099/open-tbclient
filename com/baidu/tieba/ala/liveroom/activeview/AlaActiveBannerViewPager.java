package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
/* loaded from: classes10.dex */
public class AlaActiveBannerViewPager extends SlideRatioViewPager {
    private View.OnTouchListener bPd;
    private float cBP;
    private boolean gJh;
    private float mDownX;
    private Handler mHandler;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private Runnable mRunnable;

    public AlaActiveBannerViewPager(Context context) {
        super(context);
        this.gJh = false;
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.gJh = true;
                } else {
                    AlaActiveBannerViewPager.this.gJh = false;
                }
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
                if (i == 1) {
                    AlaActiveBannerViewPager.this.gJh = true;
                } else {
                    AlaActiveBannerViewPager.this.gJh = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.gJh && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaActiveBannerViewPager.this.setCurrentItem(AlaActiveBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaActiveBannerViewPager.this.mHandler.postDelayed(AlaActiveBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    public AlaActiveBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJh = false;
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.gJh = true;
                } else {
                    AlaActiveBannerViewPager.this.gJh = false;
                }
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
                if (i == 1) {
                    AlaActiveBannerViewPager.this.gJh = true;
                } else {
                    AlaActiveBannerViewPager.this.gJh = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.gJh && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
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
        setOnTouchListener(this.bPd);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.cBP = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(motionEvent.getX() - this.mDownX) >= Math.abs(motionEvent.getY() - this.cBP) * 0.5f) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void bYK() {
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
