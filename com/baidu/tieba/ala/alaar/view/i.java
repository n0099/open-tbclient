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
    f gxi;
    d gxj;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.gxw = (HListView) view.findViewById(a.f.feature_list_view);
        this.gxw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gxi = new f(view.getContext());
        this.gxi.tw(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gxi.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.gxw, z ? i.this.gxB : 0);
                if (i.this.gxx != null) {
                    i.this.gxx.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.gxx == null) {
                    return false;
                }
                return i.this.gxx.a(i, aVar.item, z);
            }
        });
        this.gxi.tC(dVar.getPosition());
        this.gxi.setData(dVar.bPp());
        this.gxw.setAdapter((ListAdapter) this.gxi);
        this.gxw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.gxw.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.gxw.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bA(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bPq = dVar.bPq();
        if (this.gxx != null && bPq != null) {
            this.gxx.a(dVar.getPosition(), bPq, false);
        }
    }

    public void ci(View view) {
        this.gxw = (HListView) view.findViewById(a.f.feature_list_view);
        this.gxw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gxj = new d(this.gxw);
        this.gxj.tw(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gxw.setAdapter((ListAdapter) this.gxj);
        this.gxj.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.gxw, i.this.gxB);
                com.baidu.live.ar.h hVar = i.this.gxj.getDatas().get(i);
                if (i.this.gxx != null) {
                    i.this.gxx.b(i, hVar, z);
                }
            }
        });
    }
}
