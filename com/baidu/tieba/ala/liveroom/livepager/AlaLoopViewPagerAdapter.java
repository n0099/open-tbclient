package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes3.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> fIv = new SimpleArrayMap<>();
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
        if (this.fIv.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.fIv.get(Integer.valueOf(i)).getParent()).removeView(this.fIv.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.fIv.get(Integer.valueOf(i)));
        return this.fIv.get(Integer.valueOf(i));
    }

    public void bwF() {
        if (this.fIv == null) {
            this.fIv = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.fIv.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.fIv.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.fIv.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout qz(int i) {
        return this.fIv.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout qA(int i) {
        return this.fIv.get(Integer.valueOf(i));
    }

    private int qB(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int qC(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, n nVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fIv.get(Integer.valueOf(qB(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bAC();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (nVar != null && nVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bAC();
            alaLiveRoomBlurPageLayout.setBgImageUrl(nVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, n nVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fIv.get(Integer.valueOf(qC(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bAC();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (nVar != null && nVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bAC();
            alaLiveRoomBlurPageLayout.setBgImageUrl(nVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, n nVar) {
        if (nVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fIv.get(Integer.valueOf(i));
            if (nVar.mLiveInfo != null && !TextUtils.isEmpty(nVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(nVar.mLiveInfo.cover, null);
            } else if (nVar.aqe != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(nVar.aqe.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fIv.size()) {
                this.fIv.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.fIv.clear();
                return;
            }
        }
    }
}
