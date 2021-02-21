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
/* loaded from: classes11.dex */
public class m extends l {
    c gxH;
    int gxI = -1;
    int gxJ = -1;
    TextView gxK;
    TextView gxL;
    View gxM;

    public void cj(View view) {
        this.view = view;
        this.gxw = new HListView(this.view.getContext());
        this.gxw.setVisibility(4);
        this.gxu = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gxK = (TextView) this.view.findViewById(a.f.progress_tv);
        this.gxL = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.gxv = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gxM = this.view.findViewById(a.f.effect_diff_btn);
        this.gxv.setMax(100);
        this.gxv.setTipView(this.gxK);
        this.gxv.setDefThumb(this.gxL);
        if (this.gxw != null) {
            this.gxH = new c(this.gxw);
            this.gxH.tw(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gxw.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.gxw.setAdapter((ListAdapter) this.gxH);
            this.gxw.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.gxw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.gxI = i;
                m.this.gxJ = i2;
            }
        });
        this.gxH.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void b(int i, int[] iArr, boolean z) {
                m.this.gxw.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.gxI, m.this.gxJ, iArr, m.this.gxH.getCount(), true), 300);
                c.a aVar = m.this.gxH.gwN[i];
                if (m.this.gxx != null) {
                    m.this.gxx.b(i, aVar, z);
                }
            }
        });
        this.gxv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.gxx != null) {
                    m.this.gxx.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.gxx != null) {
                    m.this.gxx.onStartTrackingTouch(seekBar);
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
        if (this.gxw != null) {
            this.gxw.setVisibility(z ? 0 : 4);
            mq(z);
        }
    }
}
