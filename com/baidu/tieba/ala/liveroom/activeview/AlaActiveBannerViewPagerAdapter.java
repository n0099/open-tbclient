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
/* loaded from: classes10.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private ab aED;
    private b.a hre;
    private SimpleArrayMap<Integer, ViewGroup> hrl = new SimpleArrayMap<>();
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
        int vg = vg(i);
        ViewGroup viewGroup2 = this.hrl.get(Integer.valueOf(vg));
        ViewGroup b = viewGroup2 == null ? b(viewGroup.getContext(), viewGroup, vg) : viewGroup2;
        if (b.getParent() != null) {
            ((ViewGroup) b.getParent()).removeView(b);
        }
        viewGroup.addView(b);
        vh(vg);
        return b;
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
        this.aED = abVar;
    }

    public int vg(int i) {
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
            public void bZT() {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.a(viewGroup, tVar, i);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void Hy(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.Hy(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void Hz(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.Hz(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void HA(String str) {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.HA(str);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void bM(int i2, int i3) {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.bM(i2, i3);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.activeview.a
            public void nG(boolean z) {
                if (AlaActiveBannerViewPagerAdapter.this.hre != null) {
                    AlaActiveBannerViewPagerAdapter.this.hre.nG(z);
                }
            }
        });
        this.hrl.put(Integer.valueOf(i), relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, tVar.aJw.width, context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, tVar.aJw.height, context.getResources().getDisplayMetrics()));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
        return relativeLayout;
    }

    public void onStart() {
        if (this.hrl != null) {
            for (int i = 0; i < this.hrl.size(); i++) {
                ViewGroup viewGroup = this.hrl.get(Integer.valueOf(i));
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
        if (this.hrl != null) {
            for (int i = 0; i < this.hrl.size(); i++) {
                ViewGroup viewGroup = this.hrl.get(Integer.valueOf(i));
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
        if (this.hrl != null) {
            for (int i = 0; i < this.hrl.size(); i++) {
                ViewGroup viewGroup = this.hrl.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.hrl.clear();
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

    public void vh(int i) {
        int i2 = 0;
        t tVar = this.mDatas.get(i);
        if (this.hre != null && tVar.aJg && this.hre.vn(tVar.aJp)) {
            tVar.aJg = false;
        }
        ViewGroup viewGroup = this.hrl.get(Integer.valueOf(i));
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
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aED, tVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean HB(String str) {
        if (this.hrl == null || this.hrl.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.hrl.size(); i++) {
            ViewGroup viewGroup = this.hrl.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).bYX()) {
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

    public t vi(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.hre = aVar;
    }
}
