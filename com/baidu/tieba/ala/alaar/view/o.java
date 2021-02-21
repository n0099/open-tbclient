package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes11.dex */
public class o extends l {
    f gxW;
    int position;

    public void cj(View view) {
        this.view = view;
        this.gxu = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gxv = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gxv.setMax(100);
        this.gxw = new HListView(view.getContext());
        this.gxw.setVisibility(4);
        if (this.gxw != null) {
            this.gxW = new f(view.getContext());
            this.gxW.tw(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gxw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.gxw.setAdapter((ListAdapter) this.gxW);
            this.gxw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gxW.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.gxx != null) {
                        o.this.gxx.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.gxW.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.gxw, o.this.gxB);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.gxW.getItem(i);
                    if (o.this.gxx == null) {
                        return false;
                    }
                    return o.this.gxx.a(i, dVar, z);
                }
            });
        }
        this.gxw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.gxw != null) {
            this.gxw.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.gxw != null) {
            this.gxw.setSelection(i);
            if (i < this.gxW.getCount()) {
                this.gxW.tC(i);
            }
        }
    }
}
