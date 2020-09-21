package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes4.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> gEW = new SimpleArrayMap<>();
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
        if (this.gEW.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.gEW.get(Integer.valueOf(i)).getParent()).removeView(this.gEW.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.gEW.get(Integer.valueOf(i)));
        return this.gEW.get(Integer.valueOf(i));
    }

    public void bUG() {
        if (this.gEW == null) {
            this.gEW = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.gEW.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.gEW.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.gEW.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout uA(int i) {
        return this.gEW.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout uB(int i) {
        return this.gEW.get(Integer.valueOf(i));
    }

    private int uC(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int uD(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, u uVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gEW.get(Integer.valueOf(uC(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bYN();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (uVar != null && uVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bYN();
            alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, u uVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gEW.get(Integer.valueOf(uD(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bYN();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (uVar != null && uVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bYN();
            alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, u uVar) {
        if (uVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gEW.get(Integer.valueOf(i));
            if (uVar.mLiveInfo != null && !TextUtils.isEmpty(uVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
            } else if (uVar.aEz != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.aEz.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gEW.size()) {
                this.gEW.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.gEW.clear();
                return;
            }
        }
    }
}
