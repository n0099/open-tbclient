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
    private AlaActiveBannerViewPager gUP;
    private AlaActiveBannerViewPagerAdapter gUQ;
    private AlaActiveBannerDot gUR;
    private b.a gUS;
    private String gUT;
    private Set<Integer> gUU;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vi(i);
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
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vi(i);
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
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.vi(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    public void setActivityContext(Activity activity) {
        if (this.gUQ != null) {
            this.gUQ.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.gUQ != null) {
            this.gUQ.setIsHost(z);
        }
    }

    public void setLiveShowData(w wVar) {
        if (this.gUQ != null) {
            this.gUQ.setLiveShowData(wVar);
        }
    }

    public boolean HK(String str) {
        return this.gUQ != null && this.gUQ.HK(str);
    }

    public List<o> getOriginDatas() {
        if (this.gUQ != null) {
            return this.gUQ.getOriginDatas();
        }
        return null;
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.ala_active_banner, (ViewGroup) this, true);
        this.gUP = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.gUP.setSlideRatioToLeft(0.8f);
        this.gUP.setSlideRatioToRight(0.2f);
        this.gUR = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.gUQ = new AlaActiveBannerViewPagerAdapter();
        this.gUP.setAdapter(this.gUQ);
        this.gUP.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(int i) {
        int count = this.gUP.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.gUP.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.gUP.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                vj(this.mCurrentPosition);
            }
            this.gUR.vg(this.mCurrentPosition - 1);
        }
        vk(i);
    }

    private void vj(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void vk(int i) {
        o vn;
        if (!this.isHost && (vn = this.gUQ.vn(i)) != null) {
            int i2 = vn.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.gUU.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.gUT)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.gUT);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.gUU.add(Integer.valueOf(i2));
            }
        }
    }

    public boolean cu(List<o> list) {
        List<o> originDatas = this.gUQ.getOriginDatas();
        if (originDatas == null || list.size() != originDatas.size()) {
            return false;
        }
        for (int i = 0; i < originDatas.size(); i++) {
            o oVar = list.get(i);
            o oVar2 = originDatas.get(i);
            int i2 = oVar2.picType;
            if (oVar.activityId != oVar2.activityId || oVar.picType != i2 || !oVar.jump_url.equals(oVar2.jump_url) || oVar.aIP.width != oVar2.aIP.width || oVar.aIP.height != oVar2.aIP.height) {
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
        if (!TextUtils.equals(this.gUT, str)) {
            this.gUU = new HashSet();
            this.gUT = str;
        }
        this.gUR.vh(ListUtils.getCount(list));
        this.gUQ.setData(list);
        this.gUQ.notifyDataSetChanged();
        this.gUP.bWQ();
    }

    public void bL(int i, int i2) {
        if (this.gUP != null) {
            ViewGroup.LayoutParams layoutParams = this.gUP.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gUP.setLayoutParams(layoutParams);
        }
    }

    public void vl(int i) {
        this.gUQ.vm(i);
    }

    public void a(b.a aVar) {
        this.gUS = aVar;
        this.gUQ.a(this.gUS);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStart() {
        if (this.gUQ != null) {
            this.gUQ.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStop() {
        if (this.gUQ != null) {
            this.gUQ.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
        if (this.gUQ != null) {
            this.gUQ.release();
        }
        if (this.gUP != null) {
            this.gUP.release();
        }
        this.gUT = "";
        this.gUU.clear();
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
