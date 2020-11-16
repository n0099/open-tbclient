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
    private w aDh;
    private Activity bMo;
    private SimpleArrayMap<Integer, ViewGroup> gUF = new SimpleArrayMap<>();
    private b.a gUz;
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
        ViewGroup viewGroup2 = this.gUF.get(Integer.valueOf(i));
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
                public void bWi() {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.c(viewGroup, oVar, i);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void Hi(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.Hi(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void Hj(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.Hj(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void Hk(String str) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.Hk(str);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void bK(int i2, int i3) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.bK(i2, i3);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.activeview.a
                public void mF(boolean z) {
                    if (AlaActiveBannerViewPagerAdapter.this.gUz != null) {
                        AlaActiveBannerViewPagerAdapter.this.gUz.mF(z);
                    }
                }
            });
            this.gUF.put(Integer.valueOf(i), relativeLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, oVar.aHe.width, viewGroup.getContext().getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, oVar.aHe.height, viewGroup.getContext().getResources().getDisplayMetrics()));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            relativeLayout.addView((View) activeWebBannerItemView, layoutParams);
            viewGroup.addView(relativeLayout, 0);
            viewGroup2 = relativeLayout;
        }
        vK(i);
        if (this.gUz != null) {
            this.gUz.b(viewGroup2, vL(i), i);
        }
        return viewGroup2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void setActivityContext(Activity activity) {
        this.bMo = activity;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    public void onStart() {
        if (this.gUF != null) {
            for (int i = 0; i < this.gUF.size(); i++) {
                ViewGroup viewGroup = this.gUF.get(Integer.valueOf(i));
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
        if (this.gUF != null) {
            for (int i = 0; i < this.gUF.size(); i++) {
                ViewGroup viewGroup = this.gUF.get(Integer.valueOf(i));
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
        if (this.gUF != null) {
            for (int i = 0; i < this.gUF.size(); i++) {
                ViewGroup viewGroup = this.gUF.get(Integer.valueOf(i));
                if (viewGroup != null) {
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        if (viewGroup.getChildAt(i2) instanceof c) {
                            ((c) viewGroup.getChildAt(i2)).release();
                        }
                    }
                }
            }
            this.gUF.clear();
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

    public void vK(int i) {
        int i2 = 0;
        o oVar = this.mDatas.get(i);
        if (this.gUz != null && oVar.aGO && this.gUz.vQ(oVar.aGX)) {
            oVar.aGO = false;
        }
        ViewGroup viewGroup = this.gUF.get(Integer.valueOf(i));
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof c) {
                    if (childAt instanceof ActiveWebBannerItemView) {
                        ((ActiveWebBannerItemView) childAt).setActivityContext(this.bMo);
                    }
                    ((c) viewGroup.getChildAt(i3)).setData(this.mIsHost, this.aDh, oVar);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public boolean Hl(String str) {
        if (this.gUF == null || this.gUF.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.gUF.size(); i++) {
            ViewGroup viewGroup = this.gUF.get(Integer.valueOf(i));
            if (viewGroup != null) {
                int i2 = 0;
                boolean z2 = z;
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof ActiveWebBannerItemView) && ((ActiveWebBannerItemView) childAt).bVl()) {
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

    public o vL(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.gUz = aVar;
    }
}
