package com.baidu.tieba.ala.alaar.view;

import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.a;
/* loaded from: classes4.dex */
public class n extends l {
    a gbs;
    private int gbt = -1;
    private int gbu = -1;
    private TextView gbv;
    private TextView gbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQ(View view) {
        this.view = view;
        this.gaZ = new HListView(view.getContext());
        this.gaZ.setVisibility(4);
        this.gaZ.setDividerWidth(view.getResources().getDimensionPixelSize(a.e.sdk_ds20));
        this.gaZ.setSelector(view.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gaZ.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.gbt = i;
                n.this.gbu = i2;
            }
        });
        this.gaX = (FrameLayout) view.findViewById(a.g.filter_rl_progress);
        this.gbw = (TextView) view.findViewById(a.g.filter_progress_tv);
        this.gaY = (TopTipSeekBar) view.findViewById(a.g.filter_value_seekbar);
        this.gaY.setMax(100);
        this.gaY.setTipView(this.gbw);
        this.gbv = (TextView) view.findViewById(a.g.filter_def_thumb_tv);
        this.gaY.setDefThumb(this.gbv);
        this.gaY.setDefThumbPos(100);
        this.gaY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.g gVar = n.this.gbs.getDatas().get(n.this.gbb);
                if (n.this.gba != null) {
                    n.this.gba.a(gVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.gba != null) {
                    n.this.gba.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gaY.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.gaZ != null) {
            this.gbs = aVar;
            this.gbs.ty(this.view.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gbs.a(new a.InterfaceC0616a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0616a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.gbb = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gbu > 0) {
                                n.this.gaZ.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.gbt, n.this.gbu, iArr, n.this.gbs.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.g gVar = n.this.gbs.getDatas().get(i);
                    if (n.this.gba != null) {
                        n.this.gba.b(i, gVar, z);
                    }
                }
            });
            this.gaZ.setAdapter((ListAdapter) this.gbs);
        }
    }

    public void tH(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.gaY.setProgress(i, true);
        } else {
            this.gaY.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
