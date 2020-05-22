package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.i;
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
    private AlaActiveBannerViewPager fIh;
    private AlaActiveBannerViewPagerAdapter fIi;
    private AlaActiveBannerDot fIj;
    private b.a fIk;
    private String fIl;
    private Set<Integer> fIm;
    private boolean isHost;
    private int mCurrentPosition;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.fIl = "";
        this.isHost = false;
        this.fIm = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.qB(i);
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
        this.fIl = "";
        this.isHost = false;
        this.fIm = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.qB(i);
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
        this.fIl = "";
        this.isHost = false;
        this.fIm = new HashSet();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.qB(i2);
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
        this.fIh = (AlaActiveBannerViewPager) findViewById(a.g.active_view_pager);
        this.fIj = (AlaActiveBannerDot) findViewById(a.g.dot_container);
        this.fIi = new AlaActiveBannerViewPagerAdapter();
        this.fIh.setAdapter(this.fIi);
        this.fIh.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(int i) {
        int count = this.fIh.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.fIh.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.fIh.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                qC(this.mCurrentPosition);
            }
            this.fIj.qz(this.mCurrentPosition - 1);
        }
        qD(i);
    }

    private void qC(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void qD(int i) {
        i qG;
        if (!this.isHost && (qG = this.fIi.qG(i)) != null) {
            int i2 = qG.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && !this.fIm.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.fIl)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.fIl);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.fIm.add(Integer.valueOf(i2));
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
        if (!TextUtils.equals(this.fIl, str)) {
            this.fIm = new HashSet();
            this.fIl = str;
        }
        List<i> bxf = this.fIi.bxf();
        if (bxf != null && bxf.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= bxf.size()) {
                    z = true;
                    break;
                }
                i iVar = arrayList.get(i);
                i iVar2 = bxf.get(i);
                if (iVar.activityId != iVar2.activityId || iVar.picType != iVar2.picType || !iVar.pic_url.equals(iVar2.pic_url) || !iVar.jump_url.equals(iVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.fIj.qA(ListUtils.getCount(arrayList));
        this.fIi.setData(arrayList);
        this.fIi.notifyDataSetChanged();
        this.fIh.bxe();
    }

    public void qE(int i) {
        this.fIi.qF(i);
    }

    public void a(b.a aVar) {
        this.fIk = aVar;
        this.fIi.a(this.fIk);
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
        if (this.fIh != null) {
            this.fIh.release();
        }
        this.fIl = "";
        this.fIm.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
