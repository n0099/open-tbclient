package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private AlaActiveBannerViewPager dUo;
    private AlaActiveBannerViewPagerAdapter dUp;
    private AlaActiveBannerDot dUq;
    private b.a dUr;
    private String dUs;
    private Set<Integer> dUt;
    private boolean isHost;
    private int mCurrentPosition;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.dUs = "";
        this.isHost = false;
        this.dUt = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.ne(i);
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
        this.dUs = "";
        this.isHost = false;
        this.dUt = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.ne(i);
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
        this.dUs = "";
        this.isHost = false;
        this.dUt = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.ne(i2);
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
        this.dUo = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.dUq = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.dUp = new AlaActiveBannerViewPagerAdapter();
        this.dUo.setAdapter(this.dUp);
        this.dUo.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(int i) {
        int count = this.dUo.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.dUo.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.dUo.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                nf(this.mCurrentPosition);
            }
            this.dUq.nc(this.mCurrentPosition - 1);
        }
        ng(i);
    }

    private void nf(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void ng(int i) {
        com.baidu.live.data.c nj;
        if (!this.isHost && (nj = this.dUp.nj(i)) != null) {
            int i2 = nj.activityId;
            if (!this.dUt.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.dUs)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.dUs);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.dUt.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<com.baidu.live.data.c> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.dUs, str)) {
            this.dUt = new HashSet();
            this.dUs = str;
        }
        List<com.baidu.live.data.c> aNK = this.dUp.aNK();
        if (aNK != null && aNK.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= aNK.size()) {
                    z = true;
                    break;
                }
                com.baidu.live.data.c cVar = arrayList.get(i);
                com.baidu.live.data.c cVar2 = aNK.get(i);
                if (cVar.activityId != cVar2.activityId || cVar.picType != cVar2.picType || !cVar.pic_url.equals(cVar2.pic_url) || !cVar.jump_url.equals(cVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.dUq.nd(ListUtils.getCount(arrayList));
        this.dUp.setData(arrayList);
        this.dUp.notifyDataSetChanged();
        this.dUo.aNJ();
    }

    public void nh(int i) {
        this.dUp.ni(i);
    }

    public void a(b.a aVar) {
        this.dUr = aVar;
        this.dUp.a(this.dUr);
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
        if (this.dUo != null) {
            this.dUo.release();
        }
        this.dUs = "";
        this.dUt.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
