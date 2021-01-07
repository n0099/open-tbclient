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
    f gyR;
    d gyS;

    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar, final View view) {
        this.gzf = (HListView) view.findViewById(a.f.feature_list_view);
        this.gzf.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gzf.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gyR = new f(view.getContext());
        this.gyR.uW(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gyR.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public void a(f.a aVar, int i, boolean z) {
                l.a(i, aVar.itemView, i.this.gzf, z ? i.this.gzk : 0);
                if (i.this.gzg != null) {
                    i.this.gzg.b(i, aVar.item, z);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.h.a
            public boolean a(f.a aVar, int i, int i2, boolean z) {
                if (i.this.gzg == null) {
                    return false;
                }
                return i.this.gzg.a(i, aVar.item, z);
            }
        });
        this.gyR.vc(dVar.getPosition());
        this.gyR.setData(dVar.bSw());
        this.gzf.setAdapter((ListAdapter) this.gyR);
        this.gzf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.i.2
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = i.this.gzf.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = view.getMeasuredWidth();
                }
                i.this.gzf.setSelectionFromLeft(dVar.getPosition(), AlaLiveMultiBeautyArView.bC(measuredWidth, dVar.getPosition()));
            }
        }, 0L);
        com.baidu.tieba.ala.alaar.makeup.c bSx = dVar.bSx();
        if (this.gzg != null && bSx != null) {
            this.gzg.a(dVar.getPosition(), bSx, false);
        }
    }

    public void cm(View view) {
        this.gzf = (HListView) view.findViewById(a.f.feature_list_view);
        this.gzf.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gzf.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gyS = new d(this.gzf);
        this.gyS.uW(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.gzf.setAdapter((ListAdapter) this.gyS);
        this.gyS.a(new d.a() { // from class: com.baidu.tieba.ala.alaar.view.i.3
            @Override // com.baidu.tieba.ala.alaar.view.d.a
            public void i(int i, View view2, boolean z) {
                l.a(i, view2, i.this.gzf, i.this.gzk);
                com.baidu.live.ar.h hVar = i.this.gyS.getDatas().get(i);
                if (i.this.gzg != null) {
                    i.this.gzg.b(i, hVar, z);
                }
            }
        });
    }
}
