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
    a ghh;
    private int ghi = -1;
    private int ghj = -1;
    private TextView ghk;
    private TextView ghl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bU(View view) {
        this.view = view;
        this.ggP = new HListView(view.getContext());
        this.ggP.setVisibility(4);
        this.ggP.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggP.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggP.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.ghi = i;
                n.this.ghj = i2;
            }
        });
        this.ggN = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.ghl = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.ggO = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.ggO.setMax(100);
        this.ggO.setTipView(this.ghl);
        this.ghk = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.ggO.setDefThumb(this.ghk);
        this.ggO.setDefThumbPos(100);
        this.ggO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.h hVar = n.this.ghh.getDatas().get(n.this.byg);
                if (n.this.ggQ != null) {
                    n.this.ggQ.a(hVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.ggQ != null) {
                    n.this.ggQ.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggO.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.ggP != null) {
            this.ghh = aVar;
            this.ghh.tI(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ghh.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0628a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.byg = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.ghj > 0) {
                                n.this.ggP.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.ghi, n.this.ghj, iArr, n.this.ghh.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.h hVar = n.this.ghh.getDatas().get(i);
                    if (n.this.ggQ != null) {
                        n.this.ggQ.b(i, hVar, z);
                    }
                }
            });
            this.ggP.setAdapter((ListAdapter) this.ghh);
        }
    }

    public void tR(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.ggO.setProgress(i, true);
        } else {
            this.ggO.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
