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
    c goR;
    int goS = -1;
    int goT = -1;
    TextView goU;
    TextView goV;
    View goW;

    public void ce(View view) {
        this.view = view;
        this.goG = new HListView(this.view.getContext());
        this.goG.setVisibility(4);
        this.goE = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.goU = (TextView) this.view.findViewById(a.f.progress_tv);
        this.goV = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.goF = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.goW = this.view.findViewById(a.f.effect_diff_btn);
        this.goF.setMax(100);
        this.goF.setTipView(this.goU);
        this.goF.setDefThumb(this.goV);
        if (this.goG != null) {
            this.goR = new c(this.goG);
            this.goR.uK(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.goG.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.goG.setAdapter((ListAdapter) this.goR);
            this.goG.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.goG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.goS = i;
                m.this.goT = i2;
            }
        });
        this.goR.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.goG.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.goS, m.this.goT, iArr, m.this.goR.getCount(), true), 300);
                c.a aVar = m.this.goR.gnX[i];
                if (m.this.goH != null) {
                    m.this.goH.b(i, aVar, z);
                }
            }
        });
        this.goF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.goH != null) {
                    m.this.goH.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.goH != null) {
                    m.this.goH.onStartTrackingTouch(seekBar);
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
        if (this.goG != null) {
            this.goG.setVisibility(z ? 0 : 4);
            lT(z);
        }
    }
}
