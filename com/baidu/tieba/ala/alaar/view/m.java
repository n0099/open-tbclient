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
/* loaded from: classes10.dex */
public class m extends l {
    c gzq;
    int gzr = -1;
    int gzs = -1;
    TextView gzt;
    TextView gzu;
    View gzv;

    public void cj(View view) {
        this.view = view;
        this.gzf = new HListView(this.view.getContext());
        this.gzf.setVisibility(4);
        this.gzd = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gzt = (TextView) this.view.findViewById(a.f.progress_tv);
        this.gzu = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.gze = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gzv = this.view.findViewById(a.f.effect_diff_btn);
        this.gze.setMax(100);
        this.gze.setTipView(this.gzt);
        this.gze.setDefThumb(this.gzu);
        if (this.gzf != null) {
            this.gzq = new c(this.gzf);
            this.gzq.ty(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gzf.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.gzf.setAdapter((ListAdapter) this.gzq);
            this.gzf.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.gzf.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.gzr = i;
                m.this.gzs = i2;
            }
        });
        this.gzq.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void b(int i, int[] iArr, boolean z) {
                m.this.gzf.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.gzr, m.this.gzs, iArr, m.this.gzq.getCount(), true), 300);
                c.a aVar = m.this.gzq.gyw[i];
                if (m.this.gzg != null) {
                    m.this.gzg.b(i, aVar, z);
                }
            }
        });
        this.gze.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.gzg != null) {
                    m.this.gzg.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.gzg != null) {
                    m.this.gzg.onStartTrackingTouch(seekBar);
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
        if (this.gzf != null) {
            this.gzf.setVisibility(z ? 0 : 4);
            mq(z);
        }
    }
}
