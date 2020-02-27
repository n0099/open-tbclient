package com.baidu.tieba.ala.liveroom.activeview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private b.a ePc;
    private List<f> mOriginDatas;
    private List<f> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> ePk = new SimpleArrayMap<>();

    public void setData(List<f> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<f> bhN() {
        return this.mOriginDatas;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mDatas);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        a aVar;
        if (this.ePk != null && this.ePk.get(Integer.valueOf(i)) != null && (aVar = this.ePk.get(Integer.valueOf(i))) != null && aVar.getRootView() != null && aVar.getRootView().getParent() == viewGroup) {
            viewGroup.removeView(aVar.getRootView());
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, int i) {
        a aVar = this.ePk.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.ePk.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.ePc != null) {
                        AlaActiveBannerViewPagerAdapter.this.ePc.a(viewGroup, view.getTag(a.g.ala_active_view_data), ((Integer) view.getTag(a.g.ala_active_view_position)).intValue());
                    }
                }
            });
        }
        if (aVar.getRootView().getParent() == null) {
            viewGroup.addView(aVar.getRootView(), 0);
        }
        pI(i);
        return aVar.getRootView();
    }

    public void pI(int i) {
        f fVar = this.mDatas.get(i);
        if (this.ePc != null && fVar.Xt && this.ePc.pO(fVar.XC)) {
            fVar.Xt = false;
        }
        a aVar = this.ePk.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.a(fVar);
        }
    }

    public f pJ(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.ePc = aVar;
    }
}
