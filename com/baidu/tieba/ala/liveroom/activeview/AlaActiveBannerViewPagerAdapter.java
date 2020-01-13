package com.baidu.tieba.ala.liveroom.activeview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private b.a eLc;
    private List<e> mOriginDatas;
    private List<e> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> eLk = new SimpleArrayMap<>();

    public void setData(List<e> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<e> bfE() {
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
        a aVar = this.eLk.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.eLk.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.eLc != null) {
                        AlaActiveBannerViewPagerAdapter.this.eLc.a(viewGroup, view.getTag(a.g.ala_active_view_data), ((Integer) view.getTag(a.g.ala_active_view_position)).intValue());
                    }
                }
            });
            viewGroup.addView(aVar.getRootView(), 0);
        }
        pA(i);
        return aVar.getRootView();
    }

    public void pA(int i) {
        e eVar = this.mDatas.get(i);
        if (this.eLc != null && eVar.VJ && this.eLc.pG(eVar.VS)) {
            eVar.VJ = false;
        }
        a aVar = this.eLk.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.a(eVar);
        }
    }

    public e pB(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.eLc = aVar;
    }
}
