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
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> fel = new SimpleArrayMap<>();
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
        if (this.fel.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.fel.get(Integer.valueOf(i)).getParent()).removeView(this.fel.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.fel.get(Integer.valueOf(i)));
        return this.fel.get(Integer.valueOf(i));
    }

    public void bno() {
        if (this.fel == null) {
            this.fel = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.fel.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.fel.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.fel.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout qg(int i) {
        return this.fel.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout qh(int i) {
        return this.fel.get(Integer.valueOf(i));
    }

    private int qi(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int qj(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, m mVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fel.get(Integer.valueOf(qi(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.brc();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (mVar != null && mVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.brc();
            alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, m mVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fel.get(Integer.valueOf(qj(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.brc();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (mVar != null && mVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.brc();
            alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, m mVar) {
        if (mVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fel.get(Integer.valueOf(i));
            if (mVar.mLiveInfo != null && !TextUtils.isEmpty(mVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.mLiveInfo.cover, null);
            } else if (mVar.Ya != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(mVar.Ya.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fel.size()) {
                this.fel.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.fel.clear();
                return;
            }
        }
    }
}
