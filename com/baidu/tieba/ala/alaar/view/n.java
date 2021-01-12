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
/* loaded from: classes10.dex */
public class n extends l {
    a guQ;
    private int guR = -1;
    private int guS = -1;
    private TextView guT;
    private TextView guU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cn(View view) {
        this.view = view;
        this.guy = new HListView(view.getContext());
        this.guy.setVisibility(4);
        this.guy.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.guy.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.guy.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.guR = i;
                n.this.guS = i2;
            }
        });
        this.guw = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.guU = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.gux = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.gux.setMax(100);
        this.gux.setTipView(this.guU);
        this.guT = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.gux.setDefThumb(this.guT);
        this.gux.setDefThumbPos(100);
        this.gux.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.i iVar = n.this.guQ.getDatas().get(n.this.itemPosition);
                if (n.this.guz != null) {
                    n.this.guz.a(iVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.xf().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.guz != null) {
                    n.this.guz.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gux.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.guy != null) {
            this.guQ = aVar;
            this.guQ.tq(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.guQ.a(new a.InterfaceC0614a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0614a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.itemPosition = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.guS > 0) {
                                n.this.guy.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.guR, n.this.guS, iArr, n.this.guQ.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.i iVar = n.this.guQ.getDatas().get(i);
                    if (n.this.guz != null) {
                        n.this.guz.b(i, iVar, z);
                    }
                }
            });
            this.guy.setAdapter((ListAdapter) this.guQ);
        }
    }

    public void tz(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.gux.setProgress(i, true);
        } else {
            this.gux.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
