package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes4.dex */
public class o extends l {
    f gbA;
    int position;

    public void bQ(View view) {
        this.view = view;
        this.gaX = (FrameLayout) this.view.findViewById(a.g.rl_beauty_progress);
        this.gaY = (TopTipSeekBar) this.view.findViewById(a.g.value_seekbar);
        this.gaY.setMax(100);
        this.gaZ = new HListView(view.getContext());
        this.gaZ.setVisibility(4);
        if (this.gaZ != null) {
            this.gbA = new f(view.getContext());
            this.gbA.ty(view.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gaZ.setDividerWidth(view.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.gaZ.setAdapter((ListAdapter) this.gbA);
            this.gaZ.setSelector(view.getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gbA.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.gba != null) {
                        o.this.gba.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.gbA.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.gaZ, o.this.gbf);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.gbA.getItem(i);
                    if (o.this.gba == null) {
                        return false;
                    }
                    return o.this.gba.a(i, dVar, z);
                }
            });
        }
        this.gaZ.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.tieba.ala.alaar.view.l
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.gaZ != null) {
            this.gaZ.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.gaZ != null) {
            this.gaZ.setSelection(i);
            if (i < this.gbA.getCount()) {
                this.gbA.tE(i);
            }
        }
    }
}
