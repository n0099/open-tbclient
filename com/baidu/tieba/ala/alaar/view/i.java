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
    f gos;
    d got;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.goG = (HListView) view.findViewById(a.f.feature_list_view);
        this.goG.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goG.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gos = new f(view.getContext());
        this.gos.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gos.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.goG, z ? i.this.goL : 0);
                if (i.this.goH != null) {
                    i.this.goH.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.goH == null) {
                    return false;
                }
                return i.this.goH.a(i, aVar.item, z);
            }
        });
        this.gos.uQ(dVar.getPosition());
        this.gos.setData(dVar.bPU());
        this.goG.setAdapter((ListAdapter) this.gos);
        this.goG.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.goG.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.goG.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bE(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bPV = dVar.bPV();
        if (this.goH != null && bPV != null) {
            this.goH.a(dVar.getPosition(), bPV, false);
        }
    }

    public void cd(View view) {
        this.goG = (HListView) view.findViewById(a.f.feature_list_view);
        this.goG.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goG.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.got = new d(this.goG);
        this.got.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.goG.setAdapter((ListAdapter) this.got);
        this.got.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.goG, i.this.goL);
                com.baidu.live.ar.g gVar = i.this.got.getDatas().get(i);
                if (i.this.goH != null) {
                    i.this.goH.b(i, gVar, z);
                }
            }
        });
    }
}
