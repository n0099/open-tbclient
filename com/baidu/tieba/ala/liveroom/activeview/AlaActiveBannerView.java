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
    private d hpe;
    private AlaActiveBannerViewPagerAdapter hpf;
    private AlaActiveBannerDot hpg;
    private b.a hph;
    private Handler hpi;
    private String hpj;
    private Set<Integer> hpk;
    private boolean hpl;
    private boolean isHost;
    private float mDownX;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.hpj = "";
        this.isHost = false;
        this.hpk = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpj = "";
        this.isHost = false;
        this.hpk = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpj = "";
        this.isHost = false;
        this.hpk = new HashSet();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hpl = false;
            this.mDownX = motionEvent.getX();
            this.cEl = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            if (this.hpl || Math.abs(motionEvent.getX() - this.mDownX) >= Math.abs(motionEvent.getY() - this.cEl) * 0.5f) {
                this.hpl = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                this.hpl = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.hpl = false;
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setActivityContext(Activity activity) {
        if (this.hpf != null) {
            this.hpf.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hpf != null) {
            this.hpf.setIsHost(z);
        }
    }

    public void setLiveShowData(ab abVar) {
        if (this.hpf != null) {
            this.hpf.setLiveShowData(abVar);
        }
    }

    public void setData(List<t> list, String str) {
        if (!TextUtils.equals(this.hpj, str)) {
            this.hpk = new HashSet();
            this.hpj = str;
        }
        int count = ListUtils.getCount(list);
        if (count == 2) {
            this.hpe = new AlaActiveBannerTwoPagerView(getContext());
            ((AlaActiveBannerTwoPagerView) this.hpe).setOnPageChangeListener(new SlideShowTwoPagerView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
                @Override // com.baidu.live.view.slideshow.SlideShowTwoPagerView.a
                public void onPageSelected(int i) {
                    AlaActiveBannerView.this.vb(i);
                }
            });
        } else {
            this.hpe = new AlaActiveBannerViewPager(getContext());
            ((AlaActiveBannerViewPager) this.hpe).setSlideRatioToLeft(0.8f);
            ((AlaActiveBannerViewPager) this.hpe).setSlideRatioToRight(0.2f);
            ((AlaActiveBannerViewPager) this.hpe).addOnPageChangeListener(new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.2
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
        addView((View) this.hpe);
        this.hpg = new AlaActiveBannerDot(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        addView(this.hpg, layoutParams);
        this.hpf.setData(list);
        this.hpe.setAdapter(this.hpf);
        if (this.hpe instanceof AlaActiveBannerViewPager) {
            ((AlaActiveBannerViewPager) this.hpe).setCurrentItem(this.hpf.getCount() / 2);
        }
        this.hpg.uc(count);
        if (this.hpf.getCount() > 1) {
            this.hpi = new Handler();
            this.hpi.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaActiveBannerView.this.hpe != null) {
                        AlaActiveBannerView.this.hpe.XU();
                        AlaActiveBannerView.this.hpi.postDelayed(this, 10000L);
                    }
                }
            }, 10000L);
        }
    }

    public void setPagerSize(int i, int i2) {
        if (this.hpe instanceof View) {
            ViewGroup.LayoutParams layoutParams = ((View) this.hpe).getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            ((View) this.hpe).setLayoutParams(layoutParams);
        }
    }

    public boolean Hr(String str) {
        return this.hpf != null && this.hpf.Hr(str);
    }

    public List<t> getDatas() {
        if (this.hpf != null) {
            return this.hpf.getDatas();
        }
        return null;
    }

    private void init() {
        setOrientation(1);
        this.hpf = new AlaActiveBannerViewPagerAdapter();
    }

    public boolean cA(List<t> list) {
        List<t> datas = this.hpf.getDatas();
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
        this.hpf.vf(i);
    }

    public void a(b.a aVar) {
        this.hph = aVar;
        this.hpf.a(aVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStart() {
        if (this.hpf != null) {
            this.hpf.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStop() {
        if (this.hpf != null) {
            this.hpf.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void release() {
        if (this.hpi != null) {
            this.hpi.removeCallbacksAndMessages(null);
        }
        if (this.hpe != null) {
            this.hpe.release();
        }
        if (this.hpf != null) {
            this.hpf.release();
        }
        this.hpj = "";
        this.hpk.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(int i) {
        if (this.hpf != null) {
            this.hpg.ub(this.hpf.ve(i));
            if (this.hph != null) {
                this.hph.b(this.hpf.vg(i), i);
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
        if (!this.isHost && (vg = this.hpf.vg(i)) != null) {
            int i2 = vg.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hpk.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hpj)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hpj);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hpk.add(Integer.valueOf(i2));
            }
        }
    }
}
