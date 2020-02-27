package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes3.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> fdz = new SimpleArrayMap<>();
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
        if (this.fdz.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.fdz.get(Integer.valueOf(i)).getParent()).removeView(this.fdz.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.fdz.get(Integer.valueOf(i)));
        return this.fdz.get(Integer.valueOf(i));
    }

    public void bng() {
        if (this.fdz == null) {
            this.fdz = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.fdz.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.fdz.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.fdz.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout qe(int i) {
        return this.fdz.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout qf(int i) {
        return this.fdz.get(Integer.valueOf(i));
    }

    private int qg(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int qh(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, m mVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fdz.get(Integer.valueOf(qg(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bqU();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (mVar != null && mVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bqU();
            alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, m mVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fdz.get(Integer.valueOf(qh(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bqU();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (mVar != null && mVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bqU();
            alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, m mVar) {
        if (mVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fdz.get(Integer.valueOf(i));
            if (mVar.mLiveInfo != null && !TextUtils.isEmpty(mVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
            } else if (mVar.XQ != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.XQ.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fdz.size()) {
                this.fdz.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.fdz.clear();
                return;
            }
        }
    }
}
