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
    c gxt;
    int gxu = -1;
    int gxv = -1;
    TextView gxw;
    TextView gxx;
    View gxy;

    public void cj(View view) {
        this.view = view;
        this.gxi = new HListView(this.view.getContext());
        this.gxi.setVisibility(4);
        this.gxg = (FrameLayout) this.view.findViewById(a.f.rl_beauty_progress);
        this.gxw = (TextView) this.view.findViewById(a.f.progress_tv);
        this.gxx = (TextView) this.view.findViewById(a.f.def_thumb_tv);
        this.gxh = (TopTipSeekBar) this.view.findViewById(a.f.value_seekbar);
        this.gxy = this.view.findViewById(a.f.effect_diff_btn);
        this.gxh.setMax(100);
        this.gxh.setTipView(this.gxw);
        this.gxh.setDefThumb(this.gxx);
        if (this.gxi != null) {
            this.gxt = new c(this.gxi);
            this.gxt.tw(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gxi.setDividerWidth(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.gxi.setAdapter((ListAdapter) this.gxt);
            this.gxi.setSelector(this.view.getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.gxi.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.m.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                m.this.gxu = i;
                m.this.gxv = i2;
            }
        });
        this.gxt.a(new c.b() { // from class: com.baidu.tieba.ala.alaar.view.m.2
            @Override // com.baidu.tieba.ala.alaar.view.c.b
            public void b(int i, int[] iArr, boolean z) {
                m.this.gxi.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, m.this.gxu, m.this.gxv, iArr, m.this.gxt.getCount(), true), 300);
                c.a aVar = m.this.gxt.gwz[i];
                if (m.this.gxj != null) {
                    m.this.gxj.b(i, aVar, z);
                }
            }
        });
        this.gxh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.m.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (m.this.gxj != null) {
                    m.this.gxj.a(null, seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (m.this.gxj != null) {
                    m.this.gxj.onStartTrackingTouch(seekBar);
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
        if (this.gxi != null) {
            this.gxi.setVisibility(z ? 0 : 4);
            mq(z);
        }
    }
}
