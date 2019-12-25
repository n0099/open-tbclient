package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes2.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> eXO = new SimpleArrayMap<>();
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
        if (this.eXO.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.eXO.get(Integer.valueOf(i)).getParent()).removeView(this.eXO.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.eXO.get(Integer.valueOf(i)));
        return this.eXO.get(Integer.valueOf(i));
    }

    public void bkC() {
        if (this.eXO == null) {
            this.eXO = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.eXO.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.eXO.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.eXO.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout pR(int i) {
        return this.eXO.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout pS(int i) {
        return this.eXO.get(Integer.valueOf(i));
    }

    private int pT(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int pU(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, k kVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.eXO.get(Integer.valueOf(pT(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.boo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (kVar != null && kVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.boo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(kVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, k kVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.eXO.get(Integer.valueOf(pU(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.boo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (kVar != null && kVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.boo();
            alaLiveRoomBlurPageLayout.setBgImageUrl(kVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, k kVar) {
        if (kVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.eXO.get(Integer.valueOf(i));
            if (kVar.mLiveInfo != null && !TextUtils.isEmpty(kVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(kVar.mLiveInfo.cover, null);
            } else if (kVar.VP != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(kVar.VP.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eXO.size()) {
                this.eXO.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.eXO.clear();
                return;
            }
        }
    }
}
