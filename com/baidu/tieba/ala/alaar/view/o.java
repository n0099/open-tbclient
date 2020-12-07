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
    f gpg;
    int position;

    public void ce(View view) {
        this.view = view;
        this.goE = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.goF = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.goF.setMax(100);
        this.goG = new HListView(view.getContext());
        this.goG.setVisibility(4);
        if (this.goG != null) {
            this.gpg = new f(view.getContext());
            this.gpg.uK(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.goG.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.goG.setAdapter((ListAdapter) this.gpg);
            this.goG.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gpg.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.goH != null) {
                        o.this.goH.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.gpg.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.goG, o.this.goL);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.gpg.getItem(i);
                    if (o.this.goH == null) {
                        return false;
                    }
                    return o.this.goH.a(i, dVar, z);
                }
            });
        }
        this.goG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.goG != null) {
            this.goG.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.goG != null) {
            this.goG.setSelection(i);
            if (i < this.gpg.getCount()) {
                this.gpg.uQ(i);
            }
        }
    }
}
