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
    f ggj;
    d ggk;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.ggw = (HListView) view.findViewById(a.f.feature_list_view);
        this.ggw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggj = new f(view.getContext());
        this.ggj.ug(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.ggj.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.ggw, z ? i.this.ggB : 0);
                if (i.this.ggx != null) {
                    i.this.ggx.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.ggx == null) {
                    return false;
                }
                return i.this.ggx.a(i, aVar.item, z);
            }
        });
        this.ggj.um(dVar.getPosition());
        this.ggj.setData(dVar.bMj());
        this.ggw.setAdapter((ListAdapter) this.ggj);
        this.ggw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.ggw.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.ggw.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bC(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bMk = dVar.bMk();
        if (this.ggx != null && bMk != null) {
            this.ggx.a(dVar.getPosition(), bMk, false);
        }
    }

    public void bW(View view) {
        this.ggw = (HListView) view.findViewById(a.f.feature_list_view);
        this.ggw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggk = new d(this.ggw);
        this.ggk.ug(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.ggw.setAdapter((ListAdapter) this.ggk);
        this.ggk.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.ggw, i.this.ggB);
                com.baidu.live.ar.g gVar = i.this.ggk.getDatas().get(i);
                if (i.this.ggx != null) {
                    i.this.ggx.b(i, gVar, z);
                }
            }
        });
    }
}
