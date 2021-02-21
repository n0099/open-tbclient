package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.data.ab;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.live.view.slideshow.SlideShowTwoPagerView;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public class AlaActiveBannerView extends LinearLayout implements e {
    private float cEl;
    private d hps;
    private AlaActiveBannerViewPagerAdapter hpt;
    private AlaActiveBannerDot hpu;
    private b.a hpv;
    private Handler hpw;
    private String hpx;
    private Set<Integer> hpy;
    private boolean hpz;
    private boolean isHost;
    private float mDownX;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.hpx = "";
        this.isHost = false;
        this.hpy = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpx = "";
        this.isHost = false;
        this.hpy = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpx = "";
        this.isHost = false;
        this.hpy = new HashSet();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hpz = false;
            this.mDownX = motionEvent.getX();
            this.cEl = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            if (this.hpz || Math.abs(motionEvent.getX() - this.mDownX) >= Math.abs(motionEvent.getY() - this.cEl) * 0.5f) {
                this.hpz = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                this.hpz = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.hpz = false;
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setActivityContext(Activity activity) {
        if (this.hpt != null) {
            this.hpt.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hpt != null) {
            this.hpt.setIsHost(z);
        }
    }

    public void setLiveShowData(ab abVar) {
        if (this.hpt != null) {
            this.hpt.setLiveShowData(abVar);
        }
    }

    public void setData(List<t> list, String str) {
        if (!TextUtils.equals(this.hpx, str)) {
            this.hpy = new HashSet();
            this.hpx = str;
        }
        int count = ListUtils.getCount(list);
        if (count == 2) {
            this.hps = new AlaActiveBannerTwoPagerView(getContext());
            ((AlaActiveBannerTwoPagerView) this.hps).setOnPageChangeListener(new SlideShowTwoPagerView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
                @Override // com.baidu.live.view.slideshow.SlideShowTwoPagerView.a
                public void onPageSelected(int i) {
                    AlaActiveBannerView.this.vb(i);
                }
            });
        } else {
            this.hps = new AlaActiveBannerViewPager(getContext());
            ((AlaActiveBannerViewPager) this.hps).setSlideRatioToLeft(0.8f);
            ((AlaActiveBannerViewPager) this.hps).setSlideRatioToRight(0.2f);
            ((AlaActiveBannerViewPager) this.hps).addOnPageChangeListener(new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.2
                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    AlaActiveBannerView.this.vb(i);
                }

                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }
            });
        }
        addView((View) this.hps);
        this.hpu = new AlaActiveBannerDot(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        addView(this.hpu, layoutParams);
        this.hpt.setData(list);
        this.hps.setAdapter(this.hpt);
        if (this.hps instanceof AlaActiveBannerViewPager) {
            ((AlaActiveBannerViewPager) this.hps).setCurrentItem(this.hpt.getCount() / 2);
        }
        this.hpu.uc(count);
        if (this.hpt.getCount() > 1) {
            this.hpw = new Handler();
            this.hpw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaActiveBannerView.this.hps != null) {
                        AlaActiveBannerView.this.hps.XU();
                        AlaActiveBannerView.this.hpw.postDelayed(this, 10000L);
                    }
                }
            }, 10000L);
        }
    }

    public void setPagerSize(int i, int i2) {
        if (this.hps instanceof View) {
            ViewGroup.LayoutParams layoutParams = ((View) this.hps).getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            ((View) this.hps).setLayoutParams(layoutParams);
        }
    }

    public boolean Hs(String str) {
        return this.hpt != null && this.hpt.Hs(str);
    }

    public List<t> getDatas() {
        if (this.hpt != null) {
            return this.hpt.getDatas();
        }
        return null;
    }

    private void init() {
        setOrientation(1);
        this.hpt = new AlaActiveBannerViewPagerAdapter();
    }

    public boolean cA(List<t> list) {
        List<t> datas = this.hpt.getDatas();
        if (datas == null || list.size() != datas.size()) {
            return false;
        }
        for (int i = 0; i < datas.size(); i++) {
            t tVar = list.get(i);
            t tVar2 = datas.get(i);
            int i2 = tVar2.picType;
            if (tVar.activityId != tVar2.activityId || tVar.picType != i2 || !tVar.jump_url.equals(tVar2.jump_url) || tVar.aHW.width != tVar2.aHW.width || tVar.aHW.height != tVar2.aHW.height) {
                return false;
            }
            if (i2 == 0) {
                if (!tVar.pic_url.equals(tVar2.pic_url)) {
                    return false;
                }
            } else if (i2 == 3 && !tVar.webUrl.equals(tVar2.webUrl)) {
                return false;
            }
        }
        return true;
    }

    public void va(int i) {
        this.hpt.vf(i);
    }

    public void a(b.a aVar) {
        this.hpv = aVar;
        this.hpt.a(aVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStart() {
        if (this.hpt != null) {
            this.hpt.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStop() {
        if (this.hpt != null) {
            this.hpt.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void release() {
        if (this.hpw != null) {
            this.hpw.removeCallbacksAndMessages(null);
        }
        if (this.hps != null) {
            this.hps.release();
        }
        if (this.hpt != null) {
            this.hpt.release();
        }
        this.hpx = "";
        this.hpy.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(int i) {
        if (this.hpt != null) {
            this.hpu.ub(this.hpt.ve(i));
            if (this.hpv != null) {
                this.hpv.b(this.hpt.vg(i), i);
            }
            vc(i);
            vd(i);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void vc(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void vd(int i) {
        t vg;
        if (!this.isHost && (vg = this.hpt.vg(i)) != null) {
            int i2 = vg.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hpy.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hpx)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hpx);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hpy.add(Integer.valueOf(i2));
            }
        }
    }
}
