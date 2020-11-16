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
    private String gUA;
    private Set<Integer> gUB;
    private AlaActiveBannerViewPager gUw;
    private AlaActiveBannerViewPagerAdapter gUx;
    private AlaActiveBannerDot gUy;
    private b.a gUz;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.gUA = "";
        this.isHost = false;
        this.gUB = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vG(i);
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
        this.gUA = "";
        this.isHost = false;
        this.gUB = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vG(i);
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
        this.gUA = "";
        this.isHost = false;
        this.gUB = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.vG(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    public void setActivityContext(Activity activity) {
        if (this.gUx != null) {
            this.gUx.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.gUx != null) {
            this.gUx.setIsHost(z);
        }
    }

    public void setLiveShowData(w wVar) {
        if (this.gUx != null) {
            this.gUx.setLiveShowData(wVar);
        }
    }

    public boolean Hl(String str) {
        return this.gUx != null && this.gUx.Hl(str);
    }

    public List<o> getOriginDatas() {
        if (this.gUx != null) {
            return this.gUx.getOriginDatas();
        }
        return null;
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.ala_active_banner, (ViewGroup) this, true);
        this.gUw = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.gUw.setSlideRatioToLeft(0.8f);
        this.gUw.setSlideRatioToRight(0.2f);
        this.gUy = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.gUx = new AlaActiveBannerViewPagerAdapter();
        this.gUw.setAdapter(this.gUx);
        this.gUw.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vG(int i) {
        int count = this.gUw.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.gUw.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.gUw.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                vH(this.mCurrentPosition);
            }
            this.gUy.vE(this.mCurrentPosition - 1);
        }
        vI(i);
    }

    private void vH(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void vI(int i) {
        o vL;
        if (!this.isHost && (vL = this.gUx.vL(i)) != null) {
            int i2 = vL.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.gUB.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.gUA)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.gUA);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.gUB.add(Integer.valueOf(i2));
            }
        }
    }

    public boolean cu(List<o> list) {
        List<o> originDatas = this.gUx.getOriginDatas();
        if (originDatas == null || list.size() != originDatas.size()) {
            return false;
        }
        for (int i = 0; i < originDatas.size(); i++) {
            o oVar = list.get(i);
            o oVar2 = originDatas.get(i);
            int i2 = oVar2.picType;
            if (oVar.activityId != oVar2.activityId || oVar.picType != i2 || !oVar.jump_url.equals(oVar2.jump_url) || oVar.aHe.width != oVar2.aHe.width || oVar.aHe.height != oVar2.aHe.height) {
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

    public void i(List<o> list, String str) {
        if (!TextUtils.equals(this.gUA, str)) {
            this.gUB = new HashSet();
            this.gUA = str;
        }
        this.gUy.vF(ListUtils.getCount(list));
        this.gUx.setData(list);
        this.gUx.notifyDataSetChanged();
        this.gUw.bWj();
    }

    public void bL(int i, int i2) {
        if (this.gUw != null) {
            ViewGroup.LayoutParams layoutParams = this.gUw.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gUw.setLayoutParams(layoutParams);
        }
    }

    public void vJ(int i) {
        this.gUx.vK(i);
    }

    public void a(b.a aVar) {
        this.gUz = aVar;
        this.gUx.a(this.gUz);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStart() {
        if (this.gUx != null) {
            this.gUx.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void onStop() {
        if (this.gUx != null) {
            this.gUx.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.d
    public void release() {
        if (this.gUx != null) {
            this.gUx.release();
        }
        if (this.gUw != null) {
            this.gUw.release();
        }
        this.gUA = "";
        this.gUB.clear();
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
