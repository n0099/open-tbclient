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
    a gxO;
    private int gxP = -1;
    private int gxQ = -1;
    private TextView gxR;
    private TextView gxS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cj(View view) {
        this.view = view;
        this.gxw = new HListView(view.getContext());
        this.gxw.setVisibility(4);
        this.gxw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.gxw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gxw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.gxP = i;
                n.this.gxQ = i2;
            }
        });
        this.gxu = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.gxS = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.gxv = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.gxv.setMax(100);
        this.gxv.setTipView(this.gxS);
        this.gxR = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.gxv.setDefThumb(this.gxR);
        this.gxv.setDefThumbPos(100);
        this.gxv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.i iVar = n.this.gxO.getDatas().get(n.this.itemPosition);
                if (n.this.gxx != null) {
                    n.this.gxx.a(iVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.xc().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.gxx != null) {
                    n.this.gxx.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gxv.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.gxw != null) {
            this.gxO = aVar;
            this.gxO.tw(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.gxO.a(new a.InterfaceC0614a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0614a
                public void b(final int i, final int[] iArr, boolean z) {
                    n.this.itemPosition = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.gxQ > 0) {
                                n.this.gxw.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.gxP, n.this.gxQ, iArr, n.this.gxO.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.i iVar = n.this.gxO.getDatas().get(i);
                    if (n.this.gxx != null) {
                        n.this.gxx.b(i, iVar, z);
                    }
                }
            });
            this.gxw.setAdapter((ListAdapter) this.gxO);
        }
    }

    public void tF(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.gxv.setProgress(i, true);
        } else {
            this.gxv.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
