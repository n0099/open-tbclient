package com.baidu.tbadk.editortool;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import java.util.List;
/* loaded from: classes.dex */
public class g extends PagerAdapter {
    final /* synthetic */ EmotionTabContentView ajA;

    public g(EmotionTabContentView emotionTabContentView) {
        this.ajA = emotionTabContentView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        List list;
        List list2;
        list = this.ajA.ajr;
        if (list == null) {
            return 0;
        }
        list2 = this.ajA.ajr;
        return list2.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        com.baidu.adp.lib.e.b bVar;
        GridView gridView = (GridView) obj;
        viewGroup.removeView(gridView);
        bVar = this.ajA.ajz;
        bVar.j(gridView);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.adp.lib.e.b bVar;
        GridView gridView;
        List list;
        List list2;
        List list3;
        Context context;
        Context context2;
        Context context3;
        bVar = this.ajA.ajz;
        GridView gridView2 = (GridView) bVar.hj();
        if (gridView2 == null) {
            context3 = this.ajA.mContext;
            gridView = new GridView(context3);
        } else {
            gridView = gridView2;
        }
        gridView.setScrollbarFadingEnabled(false);
        list = this.ajA.ajr;
        if (list != null) {
            list2 = this.ajA.ajr;
            if (i < list2.size()) {
                list3 = this.ajA.ajr;
                u uVar = (u) list3.get(i);
                gridView.setNumColumns(uVar.zv());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.n.transparent);
                context = this.ajA.mContext;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds28);
                context2 = this.ajA.mContext;
                gridView.setPadding(dimensionPixelSize, 0, context2.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds28), 0);
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this));
                gridView.setAdapter((ListAdapter) new e(this.ajA, uVar));
            }
        }
        viewGroup.addView(gridView);
        return gridView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        List list;
        List list2;
        int i2;
        List list3;
        int i3;
        j jVar;
        j jVar2;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        IndicatorView indicatorView3;
        list = this.ajA.ajr;
        if (list != null) {
            list2 = this.ajA.ajr;
            int size = list2.size();
            if (i == 0 && i < size) {
                i2 = this.ajA.currentPosition;
                if (i != i2) {
                    list3 = this.ajA.ajr;
                    u uVar = (u) list3.get(i);
                    if (uVar != null) {
                        this.ajA.currentPosition = i;
                        indicatorView = this.ajA.ajf;
                        indicatorView.setVisibility(0);
                        indicatorView2 = this.ajA.ajf;
                        indicatorView2.setCount(uVar.zw());
                        indicatorView3 = this.ajA.ajf;
                        indicatorView3.setPosition(uVar.zx());
                    }
                    if (uVar != null) {
                        int zA = uVar.zA();
                        i3 = this.ajA.ajt;
                        if (zA != i3) {
                            this.ajA.ajt = uVar.zA();
                            jVar = this.ajA.aju;
                            if (jVar != null) {
                                jVar2 = this.ajA.aju;
                                jVar2.dz(uVar.zA());
                            }
                        }
                    }
                }
            }
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
