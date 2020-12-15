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
    c goT;
    int goU = -1;
    int goV = -1;
    TextView goW;
    TextView goX;
    View goY;

    public void ce(View view) {
        this.view = view;
        this.goI = new HListView(this.view.getContext());
        this.goI.setVisibility(4);
        this.goG = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.goW = (TextView) this.view.findViewById(a.f.progress_tv);
        this.goX = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.goH = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.goY = this.view.findViewById(a.f.effect_diff_btn);
        this.goH.setMax(100);
        this.goH.setTipView(this.goW);
        this.goH.setDefThumb(this.goX);
        if (this.goI != null) {
            this.goT = new c(this.goI);
            this.goT.uK(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.goI.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.goI.setAdapter((ListAdapter) this.goT);
            this.goI.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.goI.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.goU = i;
                m.this.goV = i2;
            }
        });
        this.goT.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.goI.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.goU, m.this.goV, iArr, m.this.goT.getCount(), true), 300);
                c.a aVar = m.this.goT.gnZ[i];
                if (m.this.goJ != null) {
                    m.this.goJ.b(i, aVar, z);
                }
            }
        });
        this.goH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.goJ != null) {
                    m.this.goJ.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.goJ != null) {
                    m.this.goJ.onStartTrackingTouch(seekBar);
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
        if (this.goI != null) {
            this.goI.setVisibility(z ? 0 : 4);
            lT(z);
        }
    }
}
