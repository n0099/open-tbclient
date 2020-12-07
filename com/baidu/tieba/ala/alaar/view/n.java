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
    a goY;
    private int goZ = -1;
    private int gpa = -1;
    private TextView gpb;
    private TextView gpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(View view) {
        this.view = view;
        this.goG = new HListView(view.getContext());
        this.goG.setVisibility(4);
        this.goG.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.goG.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.goG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.goZ = i;
                n.this.gpa = i2;
            }
        });
        this.goE = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.gpc = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.goF = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.goF.setMax(100);
        this.goF.setTipView(this.gpc);
        this.gpb = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.goF.setDefThumb(this.gpb);
        this.goF.setDefThumbPos(100);
        this.goF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.h hVar = n.this.goY.getDatas().get(n.this.bBF);
                if (n.this.goH != null) {
                    n.this.goH.a(hVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.BM().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.goH != null) {
                    n.this.goH.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.goF.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.goG != null) {
            this.goY = aVar;
            this.goY.uK(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.goY.a(new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0640a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.bBF = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gpa > 0) {
                                n.this.goG.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.goZ, n.this.gpa, iArr, n.this.goY.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.h hVar = n.this.goY.getDatas().get(i);
                    if (n.this.goH != null) {
                        n.this.goH.b(i, hVar, z);
                    }
                }
            });
            this.goG.setAdapter((ListAdapter) this.goY);
        }
    }

    public void uT(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.goF.setProgress(i, true);
        } else {
            this.goF.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
