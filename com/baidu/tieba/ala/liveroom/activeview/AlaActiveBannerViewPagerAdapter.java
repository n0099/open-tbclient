package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.ab;
import com.baidu.live.data.t;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private ab aDd;
    private SimpleArrayMap<Integer, ViewGroup> hpC = new SimpleArrayMap<>();
    private b.a hpv;
    private Activity mContext;
    private List<t> mDatas;
    private boolean mIsHost;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.mDatas == null || this.mDatas.isEmpty()) {
            return 0;
        }
        if (this.mDatas.size() <= 2) {
            return this.mDatas.size();
        }
        return this.mDatas.size() * 500;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: v */
    public View instantiateItem(ViewGroup viewGroup, int i) {
        int ve = ve(i);
        ViewGroup viewGroup2 = this.hpC.get(Integer.valueOf(ve));
        ViewGroup b2 = viewGroup2 == null ? b(viewGroup.getContext(), viewGroup, ve) : viewGroup2;
        if (b2.getParent() != null) {
            ((ViewGroup) b2.getParent()).removeView(b2);
        }
        viewGroup.addView(b2);
        vf(ve);
        return b2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void setActivityContext(Activity activity) {
        this.mContext = activity;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    public int ve(int i) {
        return i % this.mDatas.size();
    }

    public ViewGroup b(Context context, final ViewGroup viewGroup, final int i) {
        c activeWebBannerItemView;
        final t tVar = this.mDatas.get(i);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        switch (tVar.picType) {
            case 0:
                activeWebBannerItemView = new ActiveStaticBannerItemView(context);
                break;
            case 1:
            case 2:
            default:
                activeWebBannerItemView = new ActiveStaticBannerItemView(context);
                break;
            case 3:
                activeWebBannerItemView = new ActiveWebBannerItemView(context);
                break;
        }
        activeWebBannerItemView.setCallback(new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void bZN() {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.a(viewGroup, tVar, i);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void Hp(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.Hp(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void Hq(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.Hq(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void Hr(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.Hr(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void bM(int i2, int i3) {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.bM(i2, i3);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void nG(boolean z) {
                if (AlaActiveBannerViewPagerAdapter.this.hpv != null) {
                    AlaActiveBannerViewPagerAdapter.this.hpv.nG(z);
                }
            }
        });
        this.hpC.put(Integer.valueOf(i), relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, tVar.aHW.width, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, tVar.aHW.height, context.getResources().getDisplayMetrics()));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
        return relativeLayout;
    }

    public void onStart() {
        if (this.hpC != null) {
            for (int i = 0; i < this.hpC.size(); i++) {
                ViewGroup viewGroup = this.hpC.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).onStart();
                        }
                    }
                }
            }
        }
    }

    public void onStop() {
        if (this.hpC != null) {
            for (int i = 0; i < this.hpC.size(); i++) {
                ViewGroup viewGroup = this.hpC.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).onStop();
                        }
                    }
                }
            }
        }
    }

    public void release() {
        if (this.hpC != null) {
            for (int i = 0; i < this.hpC.size(); i++) {
                ViewGroup viewGroup = this.hpC.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.hpC.clear();
        }
    }

    public List<t> getDatas() {
        return this.mDatas;
    }

    public void setData(List<t> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        this.mDatas.addAll(list);
    }

    public void vf(int i) {
        int i2 = 0;
        t tVar = this.mDatas.get(i);
        if (this.hpv != null && tVar.aHG && this.hpv.vl(tVar.aHP)) {
            tVar.aHG = false;
        }
        ViewGroup viewGroup = this.hpC.get(Integer.valueOf(i));
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof c) {
                    if (childAt instanceof ActiveWebBannerItemView) {
                        ((ActiveWebBannerItemView) childAt).setActivityContext(this.mContext);
                    }
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aDd, tVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean Hs(String str) {
        if (this.hpC == null || this.hpC.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.hpC.size(); i++) {
            ViewGroup viewGroup = this.hpC.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).bYR()) {
                        z2 = true;
                        if (!TextUtils.isEmpty(str)) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                ((ActiveWebBannerItemView) childAt).evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                            } else {
                                ((ActiveWebBannerItemView) childAt).loadUrl("javascript:getClientInfo(" + str + ")");
                            }
                        }
                    }
                    i2++;
                    z2 = z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public t vg(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.hpv = aVar;
    }
}
