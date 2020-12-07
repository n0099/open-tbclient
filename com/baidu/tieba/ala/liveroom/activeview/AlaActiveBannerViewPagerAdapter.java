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
    private w aFN;
    private Activity beD;
    private b.a hdM;
    private SimpleArrayMap<Integer, ViewGroup> hdR = new SimpleArrayMap<>();
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
        ViewGroup viewGroup2 = this.hdR.get(Integer.valueOf(i));
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
                public void bZS() {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.c(viewGroup, oVar, i);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HW(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.HW(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HX(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.HX(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void HY(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.HY(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void bO(int i2, int i3) {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.bO(i2, i3);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void na(boolean z) {
                    if (AlaActiveBannerViewPagerAdapter.this.hdM != null) {
                        AlaActiveBannerViewPagerAdapter.this.hdM.na(z);
                    }
                }
            });
            this.hdR.put(Integer.valueOf(i), relativeLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, oVar.aJO.width, viewGroup.getContext().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, oVar.aJO.height, viewGroup.getContext().getResources().getDisplayMetrics()));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
            viewGroup.addView(relativeLayout, 0);
            viewGroup2 = relativeLayout;
        }
        wp(i);
        if (this.hdM != null) {
            this.hdM.b(viewGroup2, wq(i), i);
        }
        return viewGroup2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void setActivityContext(Activity activity) {
        this.beD = activity;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    public void onStart() {
        if (this.hdR != null) {
            for (int i = 0; i < this.hdR.size(); i++) {
                ViewGroup viewGroup = this.hdR.get(Integer.valueOf(i));
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
        if (this.hdR != null) {
            for (int i = 0; i < this.hdR.size(); i++) {
                ViewGroup viewGroup = this.hdR.get(Integer.valueOf(i));
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
        if (this.hdR != null) {
            for (int i = 0; i < this.hdR.size(); i++) {
                ViewGroup viewGroup = this.hdR.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.hdR.clear();
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

    public void wp(int i) {
        int i2 = 0;
        o oVar = this.mDatas.get(i);
        if (this.hdM != null && oVar.aJy && this.hdM.wv(oVar.aJH)) {
            oVar.aJy = false;
        }
        ViewGroup viewGroup = this.hdR.get(Integer.valueOf(i));
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof c) {
                    if (childAt instanceof ActiveWebBannerItemView) {
                        ((ActiveWebBannerItemView) childAt).setActivityContext(this.beD);
                    }
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aFN, oVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean HZ(String str) {
        if (this.hdR == null || this.hdR.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.hdR.size(); i++) {
            ViewGroup viewGroup = this.hdR.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).bYV()) {
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

    public o wq(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.hdM = aVar;
    }
}
