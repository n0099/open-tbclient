package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.c;
/* loaded from: classes4.dex */
public class m extends l {
    c gbl;
    int gbm = -1;
    int gbn = -1;
    TextView gbo;
    TextView gbp;
    View gbq;

    public void bQ(View view) {
        this.view = view;
        this.gaZ = new HListView(this.view.getContext());
        this.gaZ.setVisibility(4);
        this.gaX = (FrameLayout) this.view.findViewById(a.g.rl_beauty_progress);
        this.gbo = (TextView) this.view.findViewById(a.g.progress_tv);
        this.gbp = (TextView) this.view.findViewById(a.g.def_thumb_tv);
        this.gaY = (TopTipSeekBar) this.view.findViewById(a.g.value_seekbar);
        this.gbq = this.view.findViewById(a.g.effect_diff_btn);
        this.gaY.setMax(100);
        this.gaY.setTipView(this.gbo);
        this.gaY.setDefThumb(this.gbp);
        if (this.gaZ != null) {
            this.gbl = new c(this.gaZ);
            this.gbl.ty(this.view.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gaZ.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.gaZ.setAdapter((ListAdapter) this.gbl);
            this.gaZ.setSelector(this.view.getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gaZ.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.gbm = i;
                m.this.gbn = i2;
            }
        });
        this.gbl.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.gaZ.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.gbm, m.this.gbn, iArr, m.this.gbl.getCount(), true), 300);
                c.a aVar = m.this.gbl.gas[i];
                if (m.this.gba != null) {
                    m.this.gba.b(i, aVar, z);
                }
            }
        });
        this.gaY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.gba != null) {
                    m.this.gba.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.gba != null) {
                    m.this.gba.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override // com.baidu.tieba.ala.alaar.view.l
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.gaZ != null) {
            this.gaZ.setVisibility(z ? 0 : 4);
            lo(z);
        }
    }
}
