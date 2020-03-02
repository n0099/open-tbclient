package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private AlaActiveBannerViewPager ePa;
    private AlaActiveBannerViewPagerAdapter ePb;
    private AlaActiveBannerDot ePc;
    private b.a ePd;
    private String ePe;
    private Set<Integer> ePf;
    private boolean isHost;
    private int mCurrentPosition;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.ePe = "";
        this.isHost = false;
        this.ePf = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.pE(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.ePe = "";
        this.isHost = false;
        this.ePf = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.pE(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.ePe = "";
        this.isHost = false;
        this.ePf = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.pE(i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.h.ala_active_banner, (ViewGroup) this, true);
        this.ePa = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.ePc = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.ePb = new AlaActiveBannerViewPagerAdapter();
        this.ePa.setAdapter(this.ePb);
        this.ePa.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pE(int i) {
        int count = this.ePa.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.ePa.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.ePa.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                pF(this.mCurrentPosition);
            }
            this.ePc.pC(this.mCurrentPosition - 1);
        }
        pG(i);
    }

    private void pF(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void pG(int i) {
        f pJ;
        if (!this.isHost && (pJ = this.ePb.pJ(i)) != null) {
            int i2 = pJ.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && !this.ePf.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.ePe)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.ePe);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.ePf.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<f> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.ePe, str)) {
            this.ePf = new HashSet();
            this.ePe = str;
        }
        List<f> bhP = this.ePb.bhP();
        if (bhP != null && bhP.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= bhP.size()) {
                    z = true;
                    break;
                }
                f fVar = arrayList.get(i);
                f fVar2 = bhP.get(i);
                if (fVar.activityId != fVar2.activityId || fVar.picType != fVar2.picType || !fVar.pic_url.equals(fVar2.pic_url) || !fVar.jump_url.equals(fVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.ePc.pD(ListUtils.getCount(arrayList));
        this.ePb.setData(arrayList);
        this.ePb.notifyDataSetChanged();
        this.ePa.bhO();
    }

    public void pH(int i) {
        this.ePb.pI(i);
    }

    public void a(b.a aVar) {
        this.ePd = aVar;
        this.ePb.a(this.ePd);
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
        if (this.ePa != null) {
            this.ePa.release();
        }
        this.ePe = "";
        this.ePf.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
