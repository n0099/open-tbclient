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
    f gzF;
    int position;

    public void cn(View view) {
        this.view = view;
        this.gzd = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gze = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gze.setMax(100);
        this.gzf = new HListView(view.getContext());
        this.gzf.setVisibility(4);
        if (this.gzf != null) {
            this.gzF = new f(view.getContext());
            this.gzF.uW(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gzf.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.gzf.setAdapter((ListAdapter) this.gzF);
            this.gzf.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gzF.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.gzg != null) {
                        o.this.gzg.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.gzF.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.gzf, o.this.gzk);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.gzF.getItem(i);
                    if (o.this.gzg == null) {
                        return false;
                    }
                    return o.this.gzg.a(i, dVar, z);
                }
            });
        }
        this.gzf.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.gzf != null) {
            this.gzf.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.gzf != null) {
            this.gzf.setSelection(i);
            if (i < this.gzF.getCount()) {
                this.gzF.vc(i);
            }
        }
    }
}
