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
    f ghp;
    int position;

    public void bU(View view) {
        this.view = view;
        this.ggN = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.ggO = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.ggO.setMax(100);
        this.ggP = new HListView(view.getContext());
        this.ggP.setVisibility(4);
        if (this.ggP != null) {
            this.ghp = new f(view.getContext());
            this.ghp.tI(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ggP.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.ggP.setAdapter((ListAdapter) this.ghp);
            this.ggP.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.ghp.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.ggQ != null) {
                        o.this.ggQ.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.ghp.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.ggP, o.this.ggU);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.ghp.getItem(i);
                    if (o.this.ggQ == null) {
                        return false;
                    }
                    return o.this.ggQ.a(i, dVar, z);
                }
            });
        }
        this.ggP.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.ggP != null) {
            this.ggP.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.ggP != null) {
            this.ggP.setSelection(i);
            if (i < this.ghp.getCount()) {
                this.ghp.tO(i);
            }
        }
    }
}
