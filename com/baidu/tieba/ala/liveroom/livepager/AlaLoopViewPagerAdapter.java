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
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> hkJ = new SimpleArrayMap<>();
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
        if (this.hkJ.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.hkJ.get(Integer.valueOf(i)).getParent()).removeView(this.hkJ.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.hkJ.get(Integer.valueOf(i)));
        return this.hkJ.get(Integer.valueOf(i));
    }

    public void ccU() {
        if (this.hkJ == null) {
            this.hkJ = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.hkJ.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.hkJ.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.hkJ.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout wk(int i) {
        return this.hkJ.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout wl(int i) {
        return this.hkJ.get(Integer.valueOf(i));
    }

    private int wm(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int wn(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hkJ.get(Integer.valueOf(wm(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.chl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (wVar != null && wVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.chl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hkJ.get(Integer.valueOf(wn(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.chl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (wVar != null && wVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.chl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, w wVar) {
        if (wVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hkJ.get(Integer.valueOf(i));
            if (wVar.mLiveInfo != null && !TextUtils.isEmpty(wVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.mLiveInfo.cover, null);
            } else if (wVar.aHk != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.aHk.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hkJ.size()) {
                this.hkJ.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.hkJ.clear();
                return;
            }
        }
    }
}
