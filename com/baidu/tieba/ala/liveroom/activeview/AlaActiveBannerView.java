package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class AlaActiveBannerView extends LinearLayout implements d {
    private AlaActiveBannerDot hpA;
    private b.a hpB;
    private String hpC;
    private Set<Integer> hpD;
    private AlaActiveBannerViewPager hpy;
    private AlaActiveBannerViewPagerAdapter hpz;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hpC = "";
        this.isHost = false;
        this.hpD = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.ww(i);
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
        this.hpC = "";
        this.isHost = false;
        this.hpD = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.ww(i);
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
        this.hpC = "";
        this.isHost = false;
        this.hpD = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.ww(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    public void setActivityContext(Activity activity) {
        if (this.hpz != null) {
            this.hpz.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hpz != null) {
            this.hpz.setIsHost(z);
        }
    }

    public void setLiveShowData(x xVar) {
        if (this.hpz != null) {
            this.hpz.setLiveShowData(xVar);
        }
    }

    public boolean HY(String str) {
        return this.hpz != null && this.hpz.HY(str);
    }

    public List<p> getOriginDatas() {
        if (this.hpz != null) {
            return this.hpz.getOriginDatas();
        }
        return null;
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.ala_active_banner, (ViewGroup) this, true);
        this.hpy = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.hpy.setSlideRatioToLeft(0.8f);
        this.hpy.setSlideRatioToRight(0.2f);
        this.hpA = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.hpz = new AlaActiveBannerViewPagerAdapter();
        this.hpy.setAdapter(this.hpz);
        this.hpy.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww(int i) {
        int count = this.hpy.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.hpy.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.hpy.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                wx(this.mCurrentPosition);
            }
            this.hpA.vB(this.mCurrentPosition - 1);
        }
        wy(i);
    }

    private void wx(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void wy(int i) {
        p wB;
        if (!this.isHost && (wB = this.hpz.wB(i)) != null) {
            int i2 = wB.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hpD.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hpC)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hpC);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hpD.add(Integer.valueOf(i2));
            }
        }
    }

    public boolean cF(List<p> list) {
        List<p> originDatas = this.hpz.getOriginDatas();
        if (originDatas == null || list.size() != originDatas.size()) {
            return false;
        }
        for (int i = 0; i < originDatas.size(); i++) {
            p pVar = list.get(i);
            p pVar2 = originDatas.get(i);
            int i2 = pVar2.picType;
            if (pVar.activityId != pVar2.activityId || pVar.picType != i2 || !pVar.jump_url.equals(pVar2.jump_url) || pVar.aKn.width != pVar2.aKn.width || pVar.aKn.height != pVar2.aKn.height) {
                return false;
            }
            if (i2 == 0) {
                if (!pVar.pic_url.equals(pVar2.pic_url)) {
                    return false;
                }
            } else if (i2 == 3 && !pVar.webUrl.equals(pVar2.webUrl)) {
                return false;
            }
        }
        return true;
    }

    public void j(List<p> list, String str) {
        if (!TextUtils.equals(this.hpC, str)) {
            this.hpD = new HashSet();
            this.hpC = str;
        }
        this.hpA.vC(ListUtils.getCount(list));
        this.hpz.setData(list);
        this.hpz.notifyDataSetChanged();
        this.hpy.ccC();
    }

    public void bO(int i, int i2) {
        if (this.hpy != null) {
            ViewGroup.LayoutParams layoutParams = this.hpy.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hpy.setLayoutParams(layoutParams);
        }
    }

    public void wz(int i) {
        this.hpz.wA(i);
    }

    public void a(b.a aVar) {
        this.hpB = aVar;
        this.hpz.a(this.hpB);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStart() {
        if (this.hpz != null) {
            this.hpz.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStop() {
        if (this.hpz != null) {
            this.hpz.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
        if (this.hpz != null) {
            this.hpz.release();
        }
        if (this.hpy != null) {
            this.hpy.release();
        }
        this.hpC = "";
        this.hpD.clear();
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
