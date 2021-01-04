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
/* loaded from: classes11.dex */
public class n extends l {
    private TextView gzA;
    private TextView gzB;
    a gzx;
    private int gzy = -1;
    private int gzz = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cn(View view) {
        this.view = view;
        this.gzf = new HListView(view.getContext());
        this.gzf.setVisibility(4);
        this.gzf.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gzf.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gzf.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.gzy = i;
                n.this.gzz = i2;
            }
        });
        this.gzd = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.gzB = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.gze = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.gze.setMax(100);
        this.gze.setTipView(this.gzB);
        this.gzA = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.gze.setDefThumb(this.gzA);
        this.gze.setDefThumbPos(100);
        this.gze.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.i iVar = n.this.gzx.getDatas().get(n.this.itemPosition);
                if (n.this.gzg != null) {
                    n.this.gzg.a(iVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.Ba().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.gzg != null) {
                    n.this.gzg.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gze.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.gzf != null) {
            this.gzx = aVar;
            this.gzx.uW(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gzx.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0631a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.itemPosition = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gzz > 0) {
                                n.this.gzf.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.gzy, n.this.gzz, iArr, n.this.gzx.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.i iVar = n.this.gzx.getDatas().get(i);
                    if (n.this.gzg != null) {
                        n.this.gzg.b(i, iVar, z);
                    }
                }
            });
            this.gzf.setAdapter((ListAdapter) this.gzx);
        }
    }

    public void vf(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.gze.setProgress(i, true);
        } else {
            this.gze.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
    }

    @Override // com.baidu.tieba.ala.alaar.view.l
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.gzf != null) {
            this.gzf.setVisibility(z ? 0 : 4);
            mq(z);
        }
    }
}
