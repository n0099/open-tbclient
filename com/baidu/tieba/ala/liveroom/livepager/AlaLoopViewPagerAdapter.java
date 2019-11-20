package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes6.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> ehC = new SimpleArrayMap<>();
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
        if (this.ehC.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.ehC.get(Integer.valueOf(i)).getParent()).removeView(this.ehC.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.ehC.get(Integer.valueOf(i)));
        return this.ehC.get(Integer.valueOf(i));
    }

    public void aSP() {
        if (this.ehC == null) {
            this.ehC = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.ehC.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.ehC.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.ehC.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout nA(int i) {
        return this.ehC.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout nB(int i) {
        return this.ehC.get(Integer.valueOf(i));
    }

    private int nC(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int nD(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, i iVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.ehC.get(Integer.valueOf(nC(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.aWA();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (iVar != null && iVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.aWA();
            alaLiveRoomBlurPageLayout.setBgImageUrl(iVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, i iVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.ehC.get(Integer.valueOf(nD(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.aWA();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (iVar != null && iVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.aWA();
            alaLiveRoomBlurPageLayout.setBgImageUrl(iVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, i iVar) {
        if (iVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.ehC.get(Integer.valueOf(i));
            if (iVar.mLiveInfo != null && !TextUtils.isEmpty(iVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(iVar.mLiveInfo.cover, null);
            } else if (iVar.OR != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(iVar.OR.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ehC.size()) {
                this.ehC.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.ehC.clear();
                return;
            }
        }
    }
}
