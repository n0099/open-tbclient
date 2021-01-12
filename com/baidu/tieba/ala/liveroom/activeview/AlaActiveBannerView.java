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
/* loaded from: classes10.dex */
public class AlaActiveBannerView extends LinearLayout implements d {
    private AlaActiveBannerViewPager hkR;
    private AlaActiveBannerViewPagerAdapter hkS;
    private AlaActiveBannerDot hkT;
    private b.a hkU;
    private String hkV;
    private Set<Integer> hkW;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.uQ(i);
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
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.uQ(i);
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
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.uQ(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    public void setActivityContext(Activity activity) {
        if (this.hkS != null) {
            this.hkS.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hkS != null) {
            this.hkS.setIsHost(z);
        }
    }

    public void setLiveShowData(x xVar) {
        if (this.hkS != null) {
            this.hkS.setLiveShowData(xVar);
        }
    }

    public boolean GN(String str) {
        return this.hkS != null && this.hkS.GN(str);
    }

    public List<p> getOriginDatas() {
        if (this.hkS != null) {
            return this.hkS.getOriginDatas();
        }
        return null;
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.ala_active_banner, (ViewGroup) this, true);
        this.hkR = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.hkR.setSlideRatioToLeft(0.8f);
        this.hkR.setSlideRatioToRight(0.2f);
        this.hkT = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.hkS = new AlaActiveBannerViewPagerAdapter();
        this.hkR.setAdapter(this.hkS);
        this.hkR.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        int count = this.hkR.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.hkR.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.hkR.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                uR(this.mCurrentPosition);
            }
            this.hkT.tV(this.mCurrentPosition - 1);
        }
        uS(i);
    }

    private void uR(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void uS(int i) {
        p uV;
        if (!this.isHost && (uV = this.hkS.uV(i)) != null) {
            int i2 = uV.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hkW.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hkV)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hkV);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hkW.add(Integer.valueOf(i2));
            }
        }
    }

    public boolean cF(List<p> list) {
        List<p> originDatas = this.hkS.getOriginDatas();
        if (originDatas == null || list.size() != originDatas.size()) {
            return false;
        }
        for (int i = 0; i < originDatas.size(); i++) {
            p pVar = list.get(i);
            p pVar2 = originDatas.get(i);
            int i2 = pVar2.picType;
            if (pVar.activityId != pVar2.activityId || pVar.picType != i2 || !pVar.jump_url.equals(pVar2.jump_url) || pVar.aFA.width != pVar2.aFA.width || pVar.aFA.height != pVar2.aFA.height) {
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
        if (!TextUtils.equals(this.hkV, str)) {
            this.hkW = new HashSet();
            this.hkV = str;
        }
        this.hkT.tW(ListUtils.getCount(list));
        this.hkS.setData(list);
        this.hkS.notifyDataSetChanged();
        this.hkR.bYK();
    }

    public void bO(int i, int i2) {
        if (this.hkR != null) {
            ViewGroup.LayoutParams layoutParams = this.hkR.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hkR.setLayoutParams(layoutParams);
        }
    }

    public void uT(int i) {
        this.hkS.uU(i);
    }

    public void a(b.a aVar) {
        this.hkU = aVar;
        this.hkS.a(this.hkU);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStart() {
        if (this.hkS != null) {
            this.hkS.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStop() {
        if (this.hkS != null) {
            this.hkS.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
        if (this.hkS != null) {
            this.hkS.release();
        }
        if (this.hkR != null) {
            this.hkR.release();
        }
        this.hkV = "";
        this.hkW.clear();
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
