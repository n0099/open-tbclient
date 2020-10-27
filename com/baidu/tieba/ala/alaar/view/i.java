package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.d;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes4.dex */
public class i extends l {
    f gaM;
    d gaN;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.gaZ = (HListView) view.findViewById(a.g.feature_list_view);
        this.gaZ.setDividerWidth(view.getResources().getDimensionPixelSize(a.e.sdk_ds20));
        this.gaZ.setSelector(view.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gaM = new f(view.getContext());
        this.gaM.ty(view.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gaM.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.gaZ, z ? i.this.gbf : 0);
                if (i.this.gba != null) {
                    i.this.gba.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.gba == null) {
                    return false;
                }
                return i.this.gba.a(i, aVar.item, z);
            }
        });
        this.gaM.tE(dVar.getPosition());
        this.gaM.setData(dVar.bKr());
        this.gaZ.setAdapter((ListAdapter) this.gaM);
        this.gaZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.gaZ.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.gaZ.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bC(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bKs = dVar.bKs();
        if (this.gba != null && bKs != null) {
            this.gba.a(dVar.getPosition(), bKs, false);
        }
    }

    public void bP(View view) {
        this.gaZ = (HListView) view.findViewById(a.g.feature_list_view);
        this.gaZ.setDividerWidth(view.getResources().getDimensionPixelSize(a.e.sdk_ds20));
        this.gaZ.setSelector(view.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gaN = new d(this.gaZ);
        this.gaN.ty(view.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gaZ.setAdapter((ListAdapter) this.gaN);
        this.gaN.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.gaZ, i.this.gbf);
                com.baidu.live.ar.f fVar = i.this.gaN.getDatas().get(i);
                if (i.this.gba != null) {
                    i.this.gba.b(i, fVar, z);
                }
            }
        });
    }
}
