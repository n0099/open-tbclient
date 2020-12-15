package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaActiveBannerView extends LinearLayout implements d {
    private AlaActiveBannerViewPager hdL;
    private AlaActiveBannerViewPagerAdapter hdM;
    private AlaActiveBannerDot hdN;
    private b.a hdO;
    private String hdP;
    private Set<Integer> hdQ;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hdP = "";
        this.isHost = false;
        this.hdQ = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.wl(i);
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
        this.hdP = "";
        this.isHost = false;
        this.hdQ = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.wl(i);
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
        this.hdP = "";
        this.isHost = false;
        this.hdQ = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.wl(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    public void setActivityContext(Activity activity) {
        if (this.hdM != null) {
            this.hdM.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hdM != null) {
            this.hdM.setIsHost(z);
        }
    }

    public void setLiveShowData(w wVar) {
        if (this.hdM != null) {
            this.hdM.setLiveShowData(wVar);
        }
    }

    public boolean HZ(String str) {
        return this.hdM != null && this.hdM.HZ(str);
    }

    public List<o> getOriginDatas() {
        if (this.hdM != null) {
            return this.hdM.getOriginDatas();
        }
        return null;
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.ala_active_banner, (ViewGroup) this, true);
        this.hdL = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.hdL.setSlideRatioToLeft(0.8f);
        this.hdL.setSlideRatioToRight(0.2f);
        this.hdN = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.hdM = new AlaActiveBannerViewPagerAdapter();
        this.hdL.setAdapter(this.hdM);
        this.hdL.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(int i) {
        int count = this.hdL.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.hdL.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.hdL.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                wm(this.mCurrentPosition);
            }
            this.hdN.vq(this.mCurrentPosition - 1);
        }
        wn(i);
    }

    private void wm(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void wn(int i) {
        o wq;
        if (!this.isHost && (wq = this.hdM.wq(i)) != null) {
            int i2 = wq.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hdQ.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hdP)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hdP);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hdQ.add(Integer.valueOf(i2));
            }
        }
    }

    public boolean cy(List<o> list) {
        List<o> originDatas = this.hdM.getOriginDatas();
        if (originDatas == null || list.size() != originDatas.size()) {
            return false;
        }
        for (int i = 0; i < originDatas.size(); i++) {
            o oVar = list.get(i);
            o oVar2 = originDatas.get(i);
            int i2 = oVar2.picType;
            if (oVar.activityId != oVar2.activityId || oVar.picType != i2 || !oVar.jump_url.equals(oVar2.jump_url) || oVar.aJO.width != oVar2.aJO.width || oVar.aJO.height != oVar2.aJO.height) {
                return false;
            }
            if (i2 == 0) {
                if (!oVar.pic_url.equals(oVar2.pic_url)) {
                    return false;
                }
            } else if (i2 == 3 && !oVar.webUrl.equals(oVar2.webUrl)) {
                return false;
            }
        }
        return true;
    }

    public void j(List<o> list, String str) {
        if (!TextUtils.equals(this.hdP, str)) {
            this.hdQ = new HashSet();
            this.hdP = str;
        }
        this.hdN.vr(ListUtils.getCount(list));
        this.hdM.setData(list);
        this.hdM.notifyDataSetChanged();
        this.hdL.bZU();
    }

    public void bP(int i, int i2) {
        if (this.hdL != null) {
            ViewGroup.LayoutParams layoutParams = this.hdL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hdL.setLayoutParams(layoutParams);
        }
    }

    public void wo(int i) {
        this.hdM.wp(i);
    }

    public void a(b.a aVar) {
        this.hdO = aVar;
        this.hdM.a(this.hdO);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStart() {
        if (this.hdM != null) {
            this.hdM.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStop() {
        if (this.hdM != null) {
            this.hdM.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
        if (this.hdM != null) {
            this.hdM.release();
        }
        if (this.hdL != null) {
            this.hdL.release();
        }
        this.hdP = "";
        this.hdQ.clear();
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
