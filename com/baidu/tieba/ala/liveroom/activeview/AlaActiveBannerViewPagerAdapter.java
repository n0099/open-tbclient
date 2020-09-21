package com.baidu.tieba.ala.liveroom.activeview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private b.a gof;
    private List<l> mOriginDatas;
    private List<l> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> gon = new SimpleArrayMap<>();

    public void setData(List<l> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<l> bNV() {
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
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, int i) {
        a aVar = this.gon.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.gon.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.gof != null) {
                        AlaActiveBannerViewPagerAdapter.this.gof.b(viewGroup, view.getTag(a.g.ala_active_view_data), ((Integer) view.getTag(a.g.ala_active_view_position)).intValue());
                    }
                }
            });
            viewGroup.addView(aVar.getRootView(), 0);
        }
        ub(i);
        if (this.gof != null) {
            this.gof.a(aVar.getRootView(), uc(i), i);
        }
        return aVar.getRootView();
    }

    public void ub(int i) {
        l lVar = this.mDatas.get(i);
        if (this.gof != null && lVar.aEc && this.gof.uh(lVar.aEl)) {
            lVar.aEc = false;
        }
        a aVar = this.gon.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.a(lVar);
        }
    }

    public l uc(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.gof = aVar;
    }
}
