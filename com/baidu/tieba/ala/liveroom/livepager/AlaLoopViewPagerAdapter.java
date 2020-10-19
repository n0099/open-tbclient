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
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> gTt = new SimpleArrayMap<>();
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
        if (this.gTt.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.gTt.get(Integer.valueOf(i)).getParent()).removeView(this.gTt.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.gTt.get(Integer.valueOf(i)));
        return this.gTt.get(Integer.valueOf(i));
    }

    public void bXZ() {
        if (this.gTt == null) {
            this.gTt = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.gTt.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.gTt.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.gTt.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout vf(int i) {
        return this.gTt.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout vg(int i) {
        return this.gTt.get(Integer.valueOf(i));
    }

    private int vh(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int vi(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, u uVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gTt.get(Integer.valueOf(vh(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.ccl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (uVar != null && uVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.ccl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, u uVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gTt.get(Integer.valueOf(vi(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.ccl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (uVar != null && uVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.ccl();
            alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, u uVar) {
        if (uVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.gTt.get(Integer.valueOf(i));
            if (uVar.mLiveInfo != null && !TextUtils.isEmpty(uVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.mLiveInfo.cover, null);
            } else if (uVar.aHD != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(uVar.aHD.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gTt.size()) {
                this.gTt.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.gTt.clear();
                return;
            }
        }
    }
}
