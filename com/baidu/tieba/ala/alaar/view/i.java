package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.d;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes11.dex */
public class i extends l {
    f gwU;
    d gwV;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.gxi = (HListView) view.findViewById(a.f.feature_list_view);
        this.gxi.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxi.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gwU = new f(view.getContext());
        this.gwU.tw(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gwU.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.gxi, z ? i.this.gxn : 0);
                if (i.this.gxj != null) {
                    i.this.gxj.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.gxj == null) {
                    return false;
                }
                return i.this.gxj.a(i, aVar.item, z);
            }
        });
        this.gwU.tC(dVar.getPosition());
        this.gwU.setData(dVar.bPi());
        this.gxi.setAdapter((ListAdapter) this.gwU);
        this.gxi.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.gxi.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.gxi.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bz(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bPj = dVar.bPj();
        if (this.gxj != null && bPj != null) {
            this.gxj.a(dVar.getPosition(), bPj, false);
        }
    }

    public void ci(View view) {
        this.gxi = (HListView) view.findViewById(a.f.feature_list_view);
        this.gxi.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxi.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gwV = new d(this.gxi);
        this.gwV.tw(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gxi.setAdapter((ListAdapter) this.gwV);
        this.gwV.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.gxi, i.this.gxn);
                com.baidu.live.ar.h hVar = i.this.gwV.getDatas().get(i);
                if (i.this.gxj != null) {
                    i.this.gxj.b(i, hVar, z);
                }
            }
        });
    }
}
