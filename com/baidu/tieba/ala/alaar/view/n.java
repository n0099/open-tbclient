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
    a ggO;
    private int ggP = -1;
    private int ggQ = -1;
    private TextView ggR;
    private TextView ggS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bX(View view) {
        this.view = view;
        this.ggw = new HListView(view.getContext());
        this.ggw.setVisibility(4);
        this.ggw.setDividerWidth(view.getResources().getDimensionPixelSize(a.d.sdk_ds20));
        this.ggw.setSelector(view.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ggw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.n.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                n.this.ggP = i;
                n.this.ggQ = i2;
            }
        });
        this.ggu = (FrameLayout) view.findViewById(a.f.filter_rl_progress);
        this.ggS = (TextView) view.findViewById(a.f.filter_progress_tv);
        this.ggv = (TopTipSeekBar) view.findViewById(a.f.filter_value_seekbar);
        this.ggv.setMax(100);
        this.ggv.setTipView(this.ggS);
        this.ggR = (TextView) view.findViewById(a.f.filter_def_thumb_tv);
        this.ggv.setDefThumb(this.ggR);
        this.ggv.setDefThumbPos(100);
        this.ggv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.n.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                com.baidu.live.ar.h hVar = n.this.ggO.getDatas().get(n.this.bwv);
                if (n.this.ggx != null) {
                    n.this.ggx.a(hVar, seekBar, i, z);
                }
                if (z) {
                    com.baidu.live.d.Aq().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (n.this.ggx != null) {
                    n.this.ggx.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggv.setDefThumbPos(100);
    }

    public void c(a aVar) {
        if (this.ggw != null) {
            this.ggO = aVar;
            this.ggO.ug(this.view.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.ggO.a(new a.InterfaceC0628a() { // from class: com.baidu.tieba.ala.alaar.view.n.3
                @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0628a
                public void a(final int i, final int[] iArr, boolean z) {
                    n.this.bwv = i;
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.this.ggQ > 0) {
                                n.this.ggw.smoothScrollBy(AlaLiveMultiBeautyArView.a(i, n.this.ggP, n.this.ggQ, iArr, n.this.ggO.getCount(), false), 300);
                            }
                        }
                    }, iArr == null ? 300 : 0);
                    com.baidu.live.ar.h hVar = n.this.ggO.getDatas().get(i);
                    if (n.this.ggx != null) {
                        n.this.ggx.b(i, hVar, z);
                    }
                }
            });
            this.ggw.setAdapter((ListAdapter) this.ggO);
        }
    }

    public void up(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.ggv.setProgress(i, true);
        } else {
            this.ggv.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
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
