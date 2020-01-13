package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private AlaActiveBannerViewPager eKZ;
    private AlaActiveBannerViewPagerAdapter eLa;
    private AlaActiveBannerDot eLb;
    private b.a eLc;
    private String eLd;
    private Set<Integer> eLe;
    private boolean isHost;
    private int mCurrentPosition;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.eLd = "";
        this.isHost = false;
        this.eLe = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.pw(i);
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
        this.eLd = "";
        this.isHost = false;
        this.eLe = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.pw(i);
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
        this.eLd = "";
        this.isHost = false;
        this.eLe = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.pw(i2);
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
        this.eKZ = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.eLb = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.eLa = new AlaActiveBannerViewPagerAdapter();
        this.eKZ.setAdapter(this.eLa);
        this.eKZ.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw(int i) {
        int count = this.eKZ.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.eKZ.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.eKZ.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                px(this.mCurrentPosition);
            }
            this.eLb.pu(this.mCurrentPosition - 1);
        }
        py(i);
    }

    private void px(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void py(int i) {
        e pB;
        if (!this.isHost && (pB = this.eLa.pB(i)) != null) {
            int i2 = pB.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && !this.eLe.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.eLd)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.eLd);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.eLe.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<e> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.eLd, str)) {
            this.eLe = new HashSet();
            this.eLd = str;
        }
        List<e> bfE = this.eLa.bfE();
        if (bfE != null && bfE.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= bfE.size()) {
                    z = true;
                    break;
                }
                e eVar = arrayList.get(i);
                e eVar2 = bfE.get(i);
                if (eVar.activityId != eVar2.activityId || eVar.picType != eVar2.picType || !eVar.pic_url.equals(eVar2.pic_url) || !eVar.jump_url.equals(eVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.eLb.pv(ListUtils.getCount(arrayList));
        this.eLa.setData(arrayList);
        this.eLa.notifyDataSetChanged();
        this.eKZ.bfD();
    }

    public void pz(int i) {
        this.eLa.pA(i);
    }

    public void a(b.a aVar) {
        this.eLc = aVar;
        this.eLa.a(this.eLc);
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
        if (this.eKZ != null) {
            this.eKZ.release();
        }
        this.eLd = "";
        this.eLe.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
