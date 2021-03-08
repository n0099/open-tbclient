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
/* loaded from: classes10.dex */
public class AlaActiveBannerView extends LinearLayout implements e {
    private float cFL;
    private d hrb;
    private AlaActiveBannerViewPagerAdapter hrc;
    private AlaActiveBannerDot hrd;
    private b.a hre;
    private Handler hrf;
    private String hrg;
    private Set<Integer> hrh;
    private boolean hri;
    private boolean isHost;
    private float mDownX;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.hrg = "";
        this.isHost = false;
        this.hrh = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrg = "";
        this.isHost = false;
        this.hrh = new HashSet();
        init();
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrg = "";
        this.isHost = false;
        this.hrh = new HashSet();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hri = false;
            this.mDownX = motionEvent.getX();
            this.cFL = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            if (this.hri || Math.abs(motionEvent.getX() - this.mDownX) >= Math.abs(motionEvent.getY() - this.cFL) * 0.5f) {
                this.hri = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                this.hri = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.hri = false;
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setActivityContext(Activity activity) {
        if (this.hrc != null) {
            this.hrc.setActivityContext(activity);
        }
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.hrc != null) {
            this.hrc.setIsHost(z);
        }
    }

    public void setLiveShowData(ab abVar) {
        if (this.hrc != null) {
            this.hrc.setLiveShowData(abVar);
        }
    }

    public void setData(List<t> list, String str) {
        if (!TextUtils.equals(this.hrg, str)) {
            this.hrh = new HashSet();
            this.hrg = str;
        }
        int count = ListUtils.getCount(list);
        if (count == 2) {
            this.hrb = new AlaActiveBannerTwoPagerView(getContext());
            ((AlaActiveBannerTwoPagerView) this.hrb).setOnPageChangeListener(new SlideShowTwoPagerView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.1
                @Override // com.baidu.live.view.slideshow.SlideShowTwoPagerView.a
                public void onPageSelected(int i) {
                    AlaActiveBannerView.this.vd(i);
                }
            });
        } else {
            this.hrb = new AlaActiveBannerViewPager(getContext());
            ((AlaActiveBannerViewPager) this.hrb).setSlideRatioToLeft(0.8f);
            ((AlaActiveBannerViewPager) this.hrb).setSlideRatioToRight(0.2f);
            ((AlaActiveBannerViewPager) this.hrb).addOnPageChangeListener(new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.2
                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    AlaActiveBannerView.this.vd(i);
                }

                @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }
            });
        }
        addView((View) this.hrb);
        this.hrd = new AlaActiveBannerDot(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds12);
        addView(this.hrd, layoutParams);
        this.hrc.setData(list);
        this.hrb.setAdapter(this.hrc);
        if (this.hrb instanceof AlaActiveBannerViewPager) {
            ((AlaActiveBannerViewPager) this.hrb).setCurrentItem(this.hrc.getCount() / 2);
        }
        this.hrd.ue(count);
        if (this.hrc.getCount() > 1) {
            this.hrf = new Handler();
            this.hrf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaActiveBannerView.this.hrb != null) {
                        AlaActiveBannerView.this.hrb.XX();
                        AlaActiveBannerView.this.hrf.postDelayed(this, 10000L);
                    }
                }
            }, 10000L);
        }
    }

    public void setPagerSize(int i, int i2) {
        if (this.hrb instanceof View) {
            ViewGroup.LayoutParams layoutParams = ((View) this.hrb).getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            ((View) this.hrb).setLayoutParams(layoutParams);
        }
    }

    public boolean HB(String str) {
        return this.hrc != null && this.hrc.HB(str);
    }

    public List<t> getDatas() {
        if (this.hrc != null) {
            return this.hrc.getDatas();
        }
        return null;
    }

    private void init() {
        setOrientation(1);
        this.hrc = new AlaActiveBannerViewPagerAdapter();
    }

    public boolean cA(List<t> list) {
        List<t> datas = this.hrc.getDatas();
        if (datas == null || list.size() != datas.size()) {
            return false;
        }
        for (int i = 0; i < datas.size(); i++) {
            t tVar = list.get(i);
            t tVar2 = datas.get(i);
            int i2 = tVar2.picType;
            if (tVar.activityId != tVar2.activityId || tVar.picType != i2 || !tVar.jump_url.equals(tVar2.jump_url) || tVar.aJw.width != tVar2.aJw.width || tVar.aJw.height != tVar2.aJw.height) {
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

    public void vc(int i) {
        this.hrc.vh(i);
    }

    public void a(b.a aVar) {
        this.hre = aVar;
        this.hrc.a(aVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStart() {
        if (this.hrc != null) {
            this.hrc.onStart();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void onStop() {
        if (this.hrc != null) {
            this.hrc.onStop();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.e
    public void release() {
        if (this.hrf != null) {
            this.hrf.removeCallbacksAndMessages(null);
        }
        if (this.hrb != null) {
            this.hrb.release();
        }
        if (this.hrc != null) {
            this.hrc.release();
        }
        this.hrg = "";
        this.hrh.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vd(int i) {
        if (this.hrc != null) {
            this.hrd.ud(this.hrc.vg(i));
            if (this.hre != null) {
                this.hre.b(this.hrc.vi(i), i);
            }
            ve(i);
            vf(i);
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void ve(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void vf(int i) {
        t vi;
        if (!this.isHost && (vi = this.hrc.vi(i)) != null) {
            int i2 = vi.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hrh.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hrg)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hrg);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hrh.add(Integer.valueOf(i2));
            }
        }
    }
}
