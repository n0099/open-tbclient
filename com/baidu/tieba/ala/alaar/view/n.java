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
    a gxA;
    private int gxB = -1;
    private int gxC = -1;
    private TextView gxD;
    private TextView gxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cj(View view) {
        this.view = view;
        this.gxi = new HListView(view.getContext());
        this.gxi.setVisibility(4);
        this.gxi.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxi.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gxi.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.gxB = i;
                n.this.gxC = i2;
            }
        });
        this.gxg = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.gxE = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.gxh = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.gxh.setMax(100);
        this.gxh.setTipView(this.gxE);
        this.gxD = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.gxh.setDefThumb(this.gxD);
        this.gxh.setDefThumbPos(100);
        this.gxh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.i iVar = n.this.gxA.getDatas().get(n.this.itemPosition);
                if (n.this.gxj != null) {
                    n.this.gxj.a(iVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.xc().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.gxj != null) {
                    n.this.gxj.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gxh.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.gxi != null) {
            this.gxA = aVar;
            this.gxA.tw(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gxA.a(new a.InterfaceC0613a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0613a
                public void b(final int i, final int[] iArr, boolean z) {
                    n.this.itemPosition = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gxC > 0) {
                                n.this.gxi.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.gxB, n.this.gxC, iArr, n.this.gxA.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.i iVar = n.this.gxA.getDatas().get(i);
                    if (n.this.gxj != null) {
                        n.this.gxj.b(i, iVar, z);
                    }
                }
            });
            this.gxi.setAdapter((ListAdapter) this.gxA);
        }
    }

    public void tF(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.gxh.setProgress(i, true);
        } else {
            this.gxh.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
