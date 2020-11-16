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
    f ggW;
    int position;

    public void bX(View view) {
        this.view = view;
        this.ggu = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.ggv = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.ggv.setMax(100);
        this.ggw = new HListView(view.getContext());
        this.ggw.setVisibility(4);
        if (this.ggw != null) {
            this.ggW = new f(view.getContext());
            this.ggW.ug(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ggw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.ggw.setAdapter((ListAdapter) this.ggW);
            this.ggw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.ggW.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.ggx != null) {
                        o.this.ggx.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.ggW.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.ggw, o.this.ggB);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.ggW.getItem(i);
                    if (o.this.ggx == null) {
                        return false;
                    }
                    return o.this.ggx.a(i, dVar, z);
                }
            });
        }
        this.ggw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.ggw != null) {
            this.ggw.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.ggw != null) {
            this.ggw.setSelection(i);
            if (i < this.ggW.getCount()) {
                this.ggW.um(i);
            }
        }
    }
}
