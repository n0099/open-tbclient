package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.view.slideshow.SlideShowTwoPagerView;
/* loaded from: classes11.dex */
public class AlaActiveBannerTwoPagerView extends SlideShowTwoPagerView implements d {
    public AlaActiveBannerTwoPagerView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter instanceof AlaActiveBannerViewPagerAdapter) {
            AlaActiveBannerViewPagerAdapter alaActiveBannerViewPagerAdapter = (AlaActiveBannerViewPagerAdapter) pagerAdapter;
            if (alaActiveBannerViewPagerAdapter.getCount() == 2) {
                setChildView(alaActiveBannerViewPagerAdapter.instantiateItem(this, 0), alaActiveBannerViewPagerAdapter.instantiateItem(this, 1));
            }
        }
    }
}
