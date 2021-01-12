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
    c guJ;
    int guK = -1;
    int guL = -1;
    TextView guM;
    TextView guN;
    View guO;

    public void cn(View view) {
        this.view = view;
        this.guy = new HListView(this.view.getContext());
        this.guy.setVisibility(4);
        this.guw = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.guM = (TextView) this.view.findViewById(a.f.progress_tv);
        this.guN = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.gux = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.guO = this.view.findViewById(a.f.effect_diff_btn);
        this.gux.setMax(100);
        this.gux.setTipView(this.guM);
        this.gux.setDefThumb(this.guN);
        if (this.guy != null) {
            this.guJ = new c(this.guy);
            this.guJ.tq(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.guy.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.guy.setAdapter((ListAdapter) this.guJ);
            this.guy.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.guy.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.guK = i;
                m.this.guL = i2;
            }
        });
        this.guJ.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.guy.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.guK, m.this.guL, iArr, m.this.guJ.getCount(), true), 300);
                c.a aVar = m.this.guJ.gtP[i];
                if (m.this.guz != null) {
                    m.this.guz.b(i, aVar, z);
                }
            }
        });
        this.gux.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.guz != null) {
                    m.this.guz.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.guz != null) {
                    m.this.guz.onStartTrackingTouch(seekBar);
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
        if (this.guy != null) {
            this.guy.setVisibility(z ? 0 : 4);
            mm(z);
        }
    }
}
