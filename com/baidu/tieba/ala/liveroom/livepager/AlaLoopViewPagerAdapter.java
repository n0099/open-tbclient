package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes4.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> huj = new SimpleArrayMap<>();
    private TbPageContext mTbPageContext;

    public AlaLoopViewPagerAdapter(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.huj.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.huj.get(Integer.valueOf(i)).getParent()).removeView(this.huj.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.huj.get(Integer.valueOf(i)));
        return this.huj.get(Integer.valueOf(i));
    }

    public void cgN() {
        if (this.huj == null) {
            this.huj = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.huj.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.huj.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.huj.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout wP(int i) {
        return this.huj.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout wQ(int i) {
        return this.huj.get(Integer.valueOf(i));
    }

    private int wR(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int wS(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.huj.get(Integer.valueOf(wR(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.clg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (wVar != null && wVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.clg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.huj.get(Integer.valueOf(wS(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.clg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (wVar != null && wVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.clg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, w wVar) {
        if (wVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.huj.get(Integer.valueOf(i));
            if (wVar.mLiveInfo != null && !TextUtils.isEmpty(wVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
            } else if (wVar.aJV != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.aJV.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.huj.size()) {
                this.huj.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.huj.clear();
                return;
            }
        }
    }
}
