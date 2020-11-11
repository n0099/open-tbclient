package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.os.Build;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private w aES;
    private Activity bNY;
    private b.a gUS;
    private SimpleArrayMap<Integer, ViewGroup> gUY = new SimpleArrayMap<>();
    private List<o> mDatas;
    private boolean mIsHost;
    private List<o> mOriginDatas;

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mDatas);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        c activeWebBannerItemView;
        ViewGroup viewGroup2 = this.gUY.get(Integer.valueOf(i));
        final o oVar = this.mDatas.get(i);
        if (viewGroup2 == null) {
            ViewGroup relativeLayout = new RelativeLayout(viewGroup.getContext());
            switch (oVar.picType) {
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
                public void bWP() {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.c(viewGroup, oVar, i);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HH(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.HH(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HI(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.HI(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HJ(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.HJ(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void bK(int i2, int i3) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.bK(i2, i3);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void mE(boolean z) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUS != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUS.mE(z);
                    }
                }
            });
            this.gUY.put(Integer.valueOf(i), relativeLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, oVar.aIP.width, viewGroup.getContext().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, oVar.aIP.height, viewGroup.getContext().getResources().getDisplayMetrics()));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
            viewGroup.addView(relativeLayout, 0);
            viewGroup2 = relativeLayout;
        }
        vm(i);
        if (this.gUS != null) {
            this.gUS.b(viewGroup2, vn(i), i);
        }
        return viewGroup2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void setActivityContext(Activity activity) {
        this.bNY = activity;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    public void onStart() {
        if (this.gUY != null) {
            for (int i = 0; i < this.gUY.size(); i++) {
                ViewGroup viewGroup = this.gUY.get(Integer.valueOf(i));
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
        if (this.gUY != null) {
            for (int i = 0; i < this.gUY.size(); i++) {
                ViewGroup viewGroup = this.gUY.get(Integer.valueOf(i));
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
        if (this.gUY != null) {
            for (int i = 0; i < this.gUY.size(); i++) {
                ViewGroup viewGroup = this.gUY.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.gUY.clear();
        }
    }

    public List<o> getOriginDatas() {
        return this.mOriginDatas;
    }

    public void setData(List<o> list) {
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

    public void vm(int i) {
        int i2 = 0;
        o oVar = this.mDatas.get(i);
        if (this.gUS != null && oVar.aIz && this.gUS.vs(oVar.aII)) {
            oVar.aIz = false;
        }
        ViewGroup viewGroup = this.gUY.get(Integer.valueOf(i));
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof c) {
                    if (childAt instanceof ActiveWebBannerItemView) {
                        ((ActiveWebBannerItemView) childAt).setActivityContext(this.bNY);
                    }
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aES, oVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean HK(String str) {
        if (this.gUY == null || this.gUY.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.gUY.size(); i++) {
            ViewGroup viewGroup = this.gUY.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).bVS()) {
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

    public o vn(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.gUS = aVar;
    }
}
