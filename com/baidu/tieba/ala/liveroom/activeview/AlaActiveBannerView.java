package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private AlaActiveBannerViewPager gkR;
    private AlaActiveBannerViewPagerAdapter gkS;
    private AlaActiveBannerDot gkT;
    private b.a gkU;
    private String gkV;
    private Set<Integer> gkW;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.gkV = "";
        this.isHost = false;
        this.gkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.tE(i);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.gkV = "";
        this.isHost = false;
        this.gkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.tE(i);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.gkV = "";
        this.isHost = false;
        this.gkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.tE(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.h.ala_active_banner, (ViewGroup) this, true);
        this.gkR = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.gkR.setSlideRatioToLeft(0.8f);
        this.gkR.setSlideRatioToRight(0.2f);
        this.gkT = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.gkS = new AlaActiveBannerViewPagerAdapter();
        this.gkR.setAdapter(this.gkS);
        this.gkR.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE(int i) {
        int count = this.gkR.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.gkR.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.gkR.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                tF(this.mCurrentPosition);
            }
            this.gkT.tC(this.mCurrentPosition - 1);
        }
        tG(i);
    }

    private void tF(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void tG(int i) {
        i tJ;
        if (!this.isHost && (tJ = this.gkS.tJ(i)) != null) {
            int i2 = tJ.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && !this.gkW.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.gkV)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.gkV);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.gkW.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<i> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.gkV, str)) {
            this.gkW = new HashSet();
            this.gkV = str;
        }
        List<i> bMK = this.gkS.bMK();
        if (bMK != null && bMK.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= bMK.size()) {
                    z = true;
                    break;
                }
                i iVar = arrayList.get(i);
                i iVar2 = bMK.get(i);
                if (iVar.activityId != iVar2.activityId || iVar.picType != iVar2.picType || !iVar.pic_url.equals(iVar2.pic_url) || !iVar.jump_url.equals(iVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.gkT.tD(ListUtils.getCount(arrayList));
        this.gkS.setData(arrayList);
        this.gkS.notifyDataSetChanged();
        this.gkR.bMJ();
    }

    public void tH(int i) {
        this.gkS.tI(i);
    }

    public void a(b.a aVar) {
        this.gkU = aVar;
        this.gkS.a(this.gkU);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        if (this.gkR != null) {
            this.gkR.release();
        }
        this.gkV = "";
        this.gkW.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
