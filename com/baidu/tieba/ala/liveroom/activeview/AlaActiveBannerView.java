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
    private AlaActiveBannerViewPager dVf;
    private AlaActiveBannerViewPagerAdapter dVg;
    private AlaActiveBannerDot dVh;
    private b.a dVi;
    private String dVj;
    private Set<Integer> dVk;
    private boolean isHost;
    private int mCurrentPosition;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.dVj = "";
        this.isHost = false;
        this.dVk = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.nf(i);
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
        this.dVj = "";
        this.isHost = false;
        this.dVk = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.nf(i);
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
        this.dVj = "";
        this.isHost = false;
        this.dVk = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.nf(i2);
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
        this.dVf = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.dVh = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.dVg = new AlaActiveBannerViewPagerAdapter();
        this.dVf.setAdapter(this.dVg);
        this.dVf.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(int i) {
        int count = this.dVf.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.dVf.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.dVf.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                ng(this.mCurrentPosition);
            }
            this.dVh.nd(this.mCurrentPosition - 1);
        }
        nh(i);
    }

    private void ng(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void nh(int i) {
        com.baidu.live.data.c nk;
        if (!this.isHost && (nk = this.dVg.nk(i)) != null) {
            int i2 = nk.activityId;
            if (!this.dVk.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.dVj)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.dVj);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.dVk.add(Integer.valueOf(i2));
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
        if (!TextUtils.equals(this.dVj, str)) {
            this.dVk = new HashSet();
            this.dVj = str;
        }
        List<com.baidu.live.data.c> aNM = this.dVg.aNM();
        if (aNM != null && aNM.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= aNM.size()) {
                    z = true;
                    break;
                }
                com.baidu.live.data.c cVar = arrayList.get(i);
                com.baidu.live.data.c cVar2 = aNM.get(i);
                if (cVar.activityId != cVar2.activityId || cVar.picType != cVar2.picType || !cVar.pic_url.equals(cVar2.pic_url) || !cVar.jump_url.equals(cVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.dVh.ne(ListUtils.getCount(arrayList));
        this.dVg.setData(arrayList);
        this.dVg.notifyDataSetChanged();
        this.dVf.aNL();
    }

    public void ni(int i) {
        this.dVg.nj(i);
    }

    public void a(b.a aVar) {
        this.dVi = aVar;
        this.dVg.a(this.dVi);
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
        if (this.dVf != null) {
            this.dVf.release();
        }
        this.dVj = "";
        this.dVk.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
