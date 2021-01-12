package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.f;
import com.baidu.tieba.ala.alaar.view.h;
/* loaded from: classes10.dex */
public class o extends l {
    f guY;
    int position;

    public void cn(View view) {
        this.view = view;
        this.guw = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gux = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gux.setMax(100);
        this.guy = new HListView(view.getContext());
        this.guy.setVisibility(4);
        if (this.guy != null) {
            this.guY = new f(view.getContext());
            this.guY.tq(view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.guy.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.guy.setAdapter((ListAdapter) this.guY);
            this.guy.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
            this.guY.a(new h.a<f.a>() { // from class: com.baidu.tieba.ala.alaar.view.o.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public void a(f.a aVar, int i, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemSelected pos= " + i);
                    }
                    if (o.this.guz != null) {
                        o.this.guz.b(i, (com.baidu.tieba.ala.alaar.makeup.d) o.this.guY.getItem(i), z);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.view.h.a
                public boolean a(f.a aVar, int i, int i2, boolean z) {
                    if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                        com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MKGroupHolder onItemClick pos= " + i + " last " + i2);
                    }
                    l.a(i, aVar.itemView, o.this.guy, o.this.guD);
                    com.baidu.tieba.ala.alaar.makeup.d dVar = (com.baidu.tieba.ala.alaar.makeup.d) o.this.guY.getItem(i);
                    if (o.this.guz == null) {
                        return false;
                    }
                    return o.this.guz.a(i, dVar, z);
                }
            });
        }
        this.guy.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.o.2
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
        if (this.guy != null) {
            this.guy.setVisibility(z ? 0 : 4);
        }
    }

    public void setPosition(int i) {
        this.position = i;
        if (this.guy != null) {
            this.guy.setSelection(i);
            if (i < this.guY.getCount()) {
                this.guY.tw(i);
            }
        }
    }
}
