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
    f ggC;
    d ggD;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.ggP = (HListView) view.findViewById(a.f.feature_list_view);
        this.ggP.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggP.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggC = new f(view.getContext());
        this.ggC.tI(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.ggC.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.ggP, z ? i.this.ggU : 0);
                if (i.this.ggQ != null) {
                    i.this.ggQ.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.ggQ == null) {
                    return false;
                }
                return i.this.ggQ.a(i, aVar.item, z);
            }
        });
        this.ggC.tO(dVar.getPosition());
        this.ggC.setData(dVar.bMQ());
        this.ggP.setAdapter((ListAdapter) this.ggC);
        this.ggP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.ggP.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.ggP.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bC(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bMR = dVar.bMR();
        if (this.ggQ != null && bMR != null) {
            this.ggQ.a(dVar.getPosition(), bMR, false);
        }
    }

    public void bT(View view) {
        this.ggP = (HListView) view.findViewById(a.f.feature_list_view);
        this.ggP.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggP.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggD = new d(this.ggP);
        this.ggD.tI(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.ggP.setAdapter((ListAdapter) this.ggD);
        this.ggD.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.ggP, i.this.ggU);
                com.baidu.live.ar.g gVar = i.this.ggD.getDatas().get(i);
                if (i.this.ggQ != null) {
                    i.this.ggQ.b(i, gVar, z);
                }
            }
        });
    }
}
