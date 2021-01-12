package com.baidu.tieba.ala.anchortask.viewpager;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
/* loaded from: classes10.dex */
public class AlaAnchorBannerViewPager extends SlideRatioViewPager {
    private View.OnTouchListener bPd;
    private boolean gJh;
    private Handler mHandler;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private Runnable mRunnable;

    public AlaAnchorBannerViewPager(Context context) {
        super(context);
        this.gJh = false;
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaAnchorBannerViewPager.this.gJh = true;
                } else {
                    AlaAnchorBannerViewPager.this.gJh = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaAnchorBannerViewPager.this.gJh = true;
                } else {
                    AlaAnchorBannerViewPager.this.gJh = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaAnchorBannerViewPager.this.gJh && AlaAnchorBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaAnchorBannerViewPager.this.setCurrentItem(AlaAnchorBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaAnchorBannerViewPager.this.mHandler.postDelayed(AlaAnchorBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    public AlaAnchorBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJh = false;
        this.bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaAnchorBannerViewPager.this.gJh = true;
                } else {
                    AlaAnchorBannerViewPager.this.gJh = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaAnchorBannerViewPager.this.gJh = true;
                } else {
                    AlaAnchorBannerViewPager.this.gJh = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaAnchorBannerViewPager.this.gJh && AlaAnchorBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaAnchorBannerViewPager.this.setCurrentItem(AlaAnchorBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaAnchorBannerViewPager.this.mHandler.postDelayed(AlaAnchorBannerViewPager.this.mRunnable, 10000L);
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
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
