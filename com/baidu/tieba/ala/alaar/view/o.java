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
    f gpi;
    int position;

    public void ce(View view) {
        this.view = view;
        this.goG = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.goH = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.goH.setMax(100);
        this.goI = new HListView(view.getContext());
        this.goI.setVisibility(4);
        if (this.goI != null) {
            this.gpi = new f(view.getContext());
            this.gpi.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.goI.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.goI.setAdapter((ListAdapter) this.gpi);
            this.goI.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gpi.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.goJ != null) {
                        o.this.goJ.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.gpi.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.goI, o.this.goN);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.gpi.getItem(i);
                    if (o.this.goJ == null) {
                        return false;
                    }
                    return o.this.goJ.a(i, dVar, z);
                }
            });
        }
        this.goI.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.goI != null) {
            this.goI.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.goI != null) {
            this.goI.setSelection(i);
            if (i < this.gpi.getCount()) {
                this.gpi.uQ(i);
            }
        }
    }
}
