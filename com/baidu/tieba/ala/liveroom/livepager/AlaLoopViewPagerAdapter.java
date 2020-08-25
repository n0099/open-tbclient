package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes7.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> gBt = new SimpleArrayMap<>();
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
        if (this.gBt.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.gBt.get(Integer.valueOf(i)).getParent()).removeView(this.gBt.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.gBt.get(Integer.valueOf(i)));
        return this.gBt.get(Integer.valueOf(i));
    }

    public void bSV() {
        if (this.gBt == null) {
            this.gBt = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.gBt.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.gBt.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.gBt.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout uh(int i) {
        return this.gBt.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout ui(int i) {
        return this.gBt.get(Integer.valueOf(i));
    }

    private int uj(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int uk(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, r rVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gBt.get(Integer.valueOf(uj(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bXf();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (rVar != null && rVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bXf();
            alaLiveRoomBlurPageLayout.setBgImageUrl(rVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, r rVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gBt.get(Integer.valueOf(uk(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bXf();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (rVar != null && rVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bXf();
            alaLiveRoomBlurPageLayout.setBgImageUrl(rVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, r rVar) {
        if (rVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gBt.get(Integer.valueOf(i));
            if (rVar.mLiveInfo != null && !TextUtils.isEmpty(rVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(rVar.mLiveInfo.cover, null);
            } else if (rVar.aDE != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(rVar.aDE.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gBt.size()) {
                this.gBt.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.gBt.clear();
                return;
            }
        }
    }
}
