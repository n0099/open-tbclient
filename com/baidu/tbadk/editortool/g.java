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
    final /* synthetic */ EmotionTabContentView aiA;

    public g(EmotionTabContentView emotionTabContentView) {
        this.aiA = emotionTabContentView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        List list;
        List list2;
        list = this.aiA.air;
        if (list == null) {
            return 0;
        }
        list2 = this.aiA.air;
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
        bVar = this.aiA.aiz;
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
        bVar = this.aiA.aiz;
        GridView gridView2 = (GridView) bVar.hz();
        if (gridView2 == null) {
            context3 = this.aiA.mContext;
            gridView = new GridView(context3);
        } else {
            gridView = gridView2;
        }
        gridView.setScrollbarFadingEnabled(false);
        list = this.aiA.air;
        if (list != null) {
            list2 = this.aiA.air;
            if (i < list2.size()) {
                list3 = this.aiA.air;
                u uVar = (u) list3.get(i);
                gridView.setNumColumns(uVar.yI());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.s.transparent);
                context = this.aiA.mContext;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds28);
                context2 = this.aiA.mContext;
                gridView.setPadding(dimensionPixelSize, 0, context2.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds28), 0);
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this));
                gridView.setAdapter((ListAdapter) new e(this.aiA, uVar));
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
        list = this.aiA.air;
        if (list != null) {
            list2 = this.aiA.air;
            int size = list2.size();
            if (i == 0 && i < size) {
                i2 = this.aiA.currentPosition;
                if (i != i2) {
                    list3 = this.aiA.air;
                    u uVar = (u) list3.get(i);
                    if (uVar != null) {
                        this.aiA.currentPosition = i;
                        indicatorView = this.aiA.aif;
                        indicatorView.setVisibility(0);
                        indicatorView2 = this.aiA.aif;
                        indicatorView2.setCount(uVar.yJ());
                        indicatorView3 = this.aiA.aif;
                        indicatorView3.setPosition(uVar.yK());
                    }
                    if (uVar != null) {
                        int yN = uVar.yN();
                        i3 = this.aiA.ait;
                        if (yN != i3) {
                            this.aiA.ait = uVar.yN();
                            jVar = this.aiA.aiu;
                            if (jVar != null) {
                                jVar2 = this.aiA.aiu;
                                jVar2.dq(uVar.yN());
                            }
                        }
                    }
                }
            }
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
