package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes2.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> fan = new SimpleArrayMap<>();
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
        if (this.fan.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.fan.get(Integer.valueOf(i)).getParent()).removeView(this.fan.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.fan.get(Integer.valueOf(i)));
        return this.fan.get(Integer.valueOf(i));
    }

    public void bly() {
        if (this.fan == null) {
            this.fan = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.fan.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.fan.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.fan.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout pW(int i) {
        return this.fan.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout pX(int i) {
        return this.fan.get(Integer.valueOf(i));
    }

    private int pY(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int pZ(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, l lVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fan.get(Integer.valueOf(pY(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bpo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (lVar != null && lVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bpo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(lVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, l lVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fan.get(Integer.valueOf(pZ(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bpo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (lVar != null && lVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bpo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(lVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, l lVar) {
        if (lVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fan.get(Integer.valueOf(i));
            if (lVar.mLiveInfo != null && !TextUtils.isEmpty(lVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(lVar.mLiveInfo.cover, null);
            } else if (lVar.Wf != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(lVar.Wf.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fan.size()) {
                this.fan.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.fan.clear();
                return;
            }
        }
    }
}
