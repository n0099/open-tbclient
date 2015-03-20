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
    final /* synthetic */ EmotionTabContentView ais;

    public g(EmotionTabContentView emotionTabContentView) {
        this.ais = emotionTabContentView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        List list;
        List list2;
        list = this.ais.aij;
        if (list == null) {
            return 0;
        }
        list2 = this.ais.aij;
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
        bVar = this.ais.air;
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
        bVar = this.ais.air;
        GridView gridView2 = (GridView) bVar.hz();
        if (gridView2 == null) {
            context3 = this.ais.mContext;
            gridView = new GridView(context3);
        } else {
            gridView = gridView2;
        }
        gridView.setScrollbarFadingEnabled(false);
        list = this.ais.aij;
        if (list != null) {
            list2 = this.ais.aij;
            if (i < list2.size()) {
                list3 = this.ais.aij;
                u uVar = (u) list3.get(i);
                gridView.setNumColumns(uVar.yC());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.s.transparent);
                context = this.ais.mContext;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds28);
                context2 = this.ais.mContext;
                gridView.setPadding(dimensionPixelSize, 0, context2.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds28), 0);
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this));
                gridView.setAdapter((ListAdapter) new e(this.ais, uVar));
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
        list = this.ais.aij;
        if (list != null) {
            list2 = this.ais.aij;
            int size = list2.size();
            if (i == 0 && i < size) {
                i2 = this.ais.currentPosition;
                if (i != i2) {
                    list3 = this.ais.aij;
                    u uVar = (u) list3.get(i);
                    if (uVar != null) {
                        this.ais.currentPosition = i;
                        indicatorView = this.ais.ahX;
                        indicatorView.setVisibility(0);
                        indicatorView2 = this.ais.ahX;
                        indicatorView2.setCount(uVar.yD());
                        indicatorView3 = this.ais.ahX;
                        indicatorView3.setPosition(uVar.yE());
                    }
                    if (uVar != null) {
                        int yH = uVar.yH();
                        i3 = this.ais.ail;
                        if (yH != i3) {
                            this.ais.ail = uVar.yH();
                            jVar = this.ais.aim;
                            if (jVar != null) {
                                jVar2 = this.ais.aim;
                                jVar2.dq(uVar.yH());
                            }
                        }
                    }
                }
            }
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
