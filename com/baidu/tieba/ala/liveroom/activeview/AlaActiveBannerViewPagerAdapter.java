package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private x aGe;
    private b.a hpB;
    private SimpleArrayMap<Integer, ViewGroup> hpG = new SimpleArrayMap<>();
    private Activity mContext;
    private List<p> mDatas;
    private boolean mIsHost;
    private List<p> mOriginDatas;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mDatas);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        c activeWebBannerItemView;
        ViewGroup viewGroup2 = this.hpG.get(Integer.valueOf(i));
        final p pVar = this.mDatas.get(i);
        if (viewGroup2 == null) {
            ViewGroup relativeLayout = new RelativeLayout(viewGroup.getContext());
            switch (pVar.picType) {
                case 0:
                    activeWebBannerItemView = new ActiveStaticBannerItemView(viewGroup.getContext());
                    break;
                case 1:
                case 2:
                default:
                    activeWebBannerItemView = new ActiveStaticBannerItemView(viewGroup.getContext());
                    break;
                case 3:
                    activeWebBannerItemView = new ActiveWebBannerItemView(viewGroup.getContext());
                    break;
            }
            activeWebBannerItemView.setCallback(new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void ccB() {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.c(viewGroup, pVar, i);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HV(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.HV(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HW(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.HW(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HX(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.HX(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void bN(int i2, int i3) {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.bN(i2, i3);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void nz(boolean z) {
                    if (AlaActiveBannerViewPagerAdapter.this.hpB != null) {
                        AlaActiveBannerViewPagerAdapter.this.hpB.nz(z);
                    }
                }
            });
            this.hpG.put(Integer.valueOf(i), relativeLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, pVar.aKn.width, viewGroup.getContext().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, pVar.aKn.height, viewGroup.getContext().getResources().getDisplayMetrics()));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
            viewGroup.addView(relativeLayout, 0);
            viewGroup2 = relativeLayout;
        }
        wA(i);
        if (this.hpB != null) {
            this.hpB.b(viewGroup2, wB(i), i);
        }
        return viewGroup2;
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

    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    public void onStart() {
        if (this.hpG != null) {
            for (int i = 0; i < this.hpG.size(); i++) {
                ViewGroup viewGroup = this.hpG.get(Integer.valueOf(i));
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
        if (this.hpG != null) {
            for (int i = 0; i < this.hpG.size(); i++) {
                ViewGroup viewGroup = this.hpG.get(Integer.valueOf(i));
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
        if (this.hpG != null) {
            for (int i = 0; i < this.hpG.size(); i++) {
                ViewGroup viewGroup = this.hpG.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.hpG.clear();
        }
    }

    public List<p> getOriginDatas() {
        return this.mOriginDatas;
    }

    public void setData(List<p> list) {
        this.mOriginDatas = list;
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public void wA(int i) {
        int i2 = 0;
        p pVar = this.mDatas.get(i);
        if (this.hpB != null && pVar.aJX && this.hpB.wG(pVar.aKg)) {
            pVar.aJX = false;
        }
        ViewGroup viewGroup = this.hpG.get(Integer.valueOf(i));
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
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aGe, pVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean HY(String str) {
        if (this.hpG == null || this.hpG.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.hpG.size(); i++) {
            ViewGroup viewGroup = this.hpG.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).cbE()) {
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

    public p wB(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.hpB = aVar;
    }
}
