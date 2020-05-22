package com.baidu.tieba.ala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes3.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> fWw = new SimpleArrayMap<>();
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
        if (this.fWw.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.fWw.get(Integer.valueOf(i)).getParent()).removeView(this.fWw.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.fWw.get(Integer.valueOf(i)));
        return this.fWw.get(Integer.valueOf(i));
    }

    public void bCD() {
        if (this.fWw == null) {
            this.fWw = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.e(this.mTbPageContext);
        this.fWw.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.e(this.mTbPageContext);
        this.fWw.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.e(this.mTbPageContext);
        this.fWw.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout ra(int i) {
        return this.fWw.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout rb(int i) {
        return this.fWw.get(Integer.valueOf(i));
    }

    private int rc(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int rd(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, q qVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fWw.get(Integer.valueOf(rc(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bGP();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (qVar != null && qVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bGP();
            alaLiveRoomBlurPageLayout.setBgImageUrl(qVar.mLiveInfo.cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, q qVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fWw.get(Integer.valueOf(rd(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.bGP();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.cover, null);
        } else if (qVar != null && qVar.mLiveInfo != null) {
            alaLiveRoomBlurPageLayout.bGP();
            alaLiveRoomBlurPageLayout.setBgImageUrl(qVar.mLiveInfo.cover, null);
        }
    }

    public void a(int i, q qVar) {
        if (qVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.fWw.get(Integer.valueOf(i));
            if (qVar.mLiveInfo != null && !TextUtils.isEmpty(qVar.mLiveInfo.cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(qVar.mLiveInfo.cover, null);
            } else if (qVar.avj != null) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(qVar.avj.portrait, null);
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fWw.size()) {
                this.fWw.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.fWw.clear();
                return;
            }
        }
    }
}
