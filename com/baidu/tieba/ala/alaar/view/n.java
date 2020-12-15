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
    a gpa;
    private int gpb = -1;
    private int gpc = -1;
    private TextView gpd;
    private TextView gpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(View view) {
        this.view = view;
        this.goI = new HListView(view.getContext());
        this.goI.setVisibility(4);
        this.goI.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goI.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.goI.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.gpb = i;
                n.this.gpc = i2;
            }
        });
        this.goG = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.gpe = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.goH = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.goH.setMax(100);
        this.goH.setTipView(this.gpe);
        this.gpd = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.goH.setDefThumb(this.gpd);
        this.goH.setDefThumbPos(100);
        this.goH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.h hVar = n.this.gpa.getDatas().get(n.this.bBF);
                if (n.this.goJ != null) {
                    n.this.goJ.a(hVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.BM().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.goJ != null) {
                    n.this.goJ.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.goH.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.goI != null) {
            this.gpa = aVar;
            this.gpa.uK(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gpa.a(new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0640a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.bBF = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gpc > 0) {
                                n.this.goI.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.gpb, n.this.gpc, iArr, n.this.gpa.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.h hVar = n.this.gpa.getDatas().get(i);
                    if (n.this.goJ != null) {
                        n.this.goJ.b(i, hVar, z);
                    }
                }
            });
            this.goI.setAdapter((ListAdapter) this.gpa);
        }
    }

    public void uT(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.goH.setProgress(i, true);
        } else {
            this.goH.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
