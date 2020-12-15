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
    f gou;
    d gov;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.goI = (HListView) view.findViewById(a.f.feature_list_view);
        this.goI.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goI.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gou = new f(view.getContext());
        this.gou.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gou.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.goI, z ? i.this.goN : 0);
                if (i.this.goJ != null) {
                    i.this.goJ.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.goJ == null) {
                    return false;
                }
                return i.this.goJ.a(i, aVar.item, z);
            }
        });
        this.gou.uQ(dVar.getPosition());
        this.gou.setData(dVar.bPV());
        this.goI.setAdapter((ListAdapter) this.gou);
        this.goI.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.goI.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.goI.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bE(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bPW = dVar.bPW();
        if (this.goJ != null && bPW != null) {
            this.goJ.a(dVar.getPosition(), bPW, false);
        }
    }

    public void cd(View view) {
        this.goI = (HListView) view.findViewById(a.f.feature_list_view);
        this.goI.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goI.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gov = new d(this.goI);
        this.gov.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.goI.setAdapter((ListAdapter) this.gov);
        this.gov.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.goI, i.this.goN);
                com.baidu.live.ar.g gVar = i.this.gov.getDatas().get(i);
                if (i.this.goJ != null) {
                    i.this.goJ.b(i, gVar, z);
                }
            }
        });
    }
}
