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
    c gha;
    int ghb = -1;
    int ghc = -1;
    TextView ghd;
    TextView ghe;
    View ghf;

    public void bU(View view) {
        this.view = view;
        this.ggP = new HListView(this.view.getContext());
        this.ggP.setVisibility(4);
        this.ggN = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.ghd = (TextView) this.view.findViewById(a.f.progress_tv);
        this.ghe = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.ggO = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.ghf = this.view.findViewById(a.f.effect_diff_btn);
        this.ggO.setMax(100);
        this.ggO.setTipView(this.ghd);
        this.ggO.setDefThumb(this.ghe);
        if (this.ggP != null) {
            this.gha = new c(this.ggP);
            this.gha.tI(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ggP.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.ggP.setAdapter((ListAdapter) this.gha);
            this.ggP.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.ggP.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.ghb = i;
                m.this.ghc = i2;
            }
        });
        this.gha.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.ggP.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.ghb, m.this.ghc, iArr, m.this.gha.getCount(), true), 300);
                c.a aVar = m.this.gha.ggi[i];
                if (m.this.ggQ != null) {
                    m.this.ggQ.b(i, aVar, z);
                }
            }
        });
        this.ggO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.ggQ != null) {
                    m.this.ggQ.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.ggQ != null) {
                    m.this.ggQ.onStartTrackingTouch(seekBar);
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
        if (this.ggP != null) {
            this.ggP.setVisibility(z ? 0 : 4);
            lx(z);
        }
    }
}
