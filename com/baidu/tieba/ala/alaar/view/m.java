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
    c ggH;
    int ggI = -1;
    int ggJ = -1;
    TextView ggK;
    TextView ggL;
    View ggM;

    public void bX(View view) {
        this.view = view;
        this.ggw = new HListView(this.view.getContext());
        this.ggw.setVisibility(4);
        this.ggu = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.ggK = (TextView) this.view.findViewById(a.f.progress_tv);
        this.ggL = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.ggv = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.ggM = this.view.findViewById(a.f.effect_diff_btn);
        this.ggv.setMax(100);
        this.ggv.setTipView(this.ggK);
        this.ggv.setDefThumb(this.ggL);
        if (this.ggw != null) {
            this.ggH = new c(this.ggw);
            this.ggH.ug(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ggw.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.ggw.setAdapter((ListAdapter) this.ggH);
            this.ggw.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.ggw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.ggI = i;
                m.this.ggJ = i2;
            }
        });
        this.ggH.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void a(int i, int[] iArr, boolean z) {
                m.this.ggw.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.ggI, m.this.ggJ, iArr, m.this.ggH.getCount(), true), 300);
                c.a aVar = m.this.ggH.gfP[i];
                if (m.this.ggx != null) {
                    m.this.ggx.b(i, aVar, z);
                }
            }
        });
        this.ggv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.ggx != null) {
                    m.this.ggx.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.ggx != null) {
                    m.this.ggx.onStartTrackingTouch(seekBar);
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
        if (this.ggw != null) {
            this.ggw.setVisibility(z ? 0 : 4);
            ly(z);
        }
    }
}
