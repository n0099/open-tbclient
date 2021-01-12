package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.d;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes10.dex */
public class i extends l {
    f guk;
    d gul;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.guy = (HListView) view.findViewById(a.f.feature_list_view);
        this.guy.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.guy.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.guk = new f(view.getContext());
        this.guk.tq(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.guk.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.guy, z ? i.this.guD : 0);
                if (i.this.guz != null) {
                    i.this.guz.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.guz == null) {
                    return false;
                }
                return i.this.guz.a(i, aVar.item, z);
            }
        });
        this.guk.tw(dVar.getPosition());
        this.guk.setData(dVar.bOE());
        this.guy.setAdapter((ListAdapter) this.guk);
        this.guy.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.guy.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.guy.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bC(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bOF = dVar.bOF();
        if (this.guz != null && bOF != null) {
            this.guz.a(dVar.getPosition(), bOF, false);
        }
    }

    public void cm(View view) {
        this.guy = (HListView) view.findViewById(a.f.feature_list_view);
        this.guy.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.guy.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gul = new d(this.guy);
        this.gul.tq(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.guy.setAdapter((ListAdapter) this.gul);
        this.gul.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.guy, i.this.guD);
                com.baidu.live.ar.h hVar = i.this.gul.getDatas().get(i);
                if (i.this.guz != null) {
                    i.this.guz.b(i, hVar, z);
                }
            }
        });
    }
}
