package com.baidu.tieba.ala.alaar.view;

import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes10.dex */
public class l {
    protected String gkn;
    View guA;
    TextView guB;
    View guC;
    protected int guD = 300;
    protected boolean guE;
    protected boolean guF;
    public Object guv;
    FrameLayout guw;
    TopTipSeekBar gux;
    public HListView guy;
    a guz;
    int itemPosition;
    View view;

    /* loaded from: classes10.dex */
    public interface a<D> {
        void a(D d, SeekBar seekBar, int i, boolean z);

        boolean a(int i, D d, boolean z);

        void b(int i, D d, boolean z);

        void onStartTrackingTouch(SeekBar seekBar);
    }

    public void a(a aVar) {
        this.guz = aVar;
    }

    public void setEnable(boolean z) {
        this.guE = !z;
        if (this.guA != null) {
            this.guA.setVisibility(this.guE ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.guE;
    }

    public void ml(boolean z) {
        this.guF = z;
        if (this.guC != null) {
            this.guC.setVisibility(this.guF ? 0 : 8);
        }
    }

    public View c(View view, ViewGroup viewGroup) {
        if (this.guA == null) {
            this.guA = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.guA != null) {
                this.guA.setVisibility(this.guE ? 8 : 0);
            }
            this.guB = (TextView) this.guA.findViewById(a.f.button_tv);
            this.guC = this.guA.findViewById(a.f.red_dot_iv);
        }
        this.guC.setVisibility(this.guF ? 0 : 8);
        this.guB.setText(this.gkn == null ? "" : this.gkn);
        return this.guA;
    }

    public View bQf() {
        return this.guy;
    }

    public void setSelected(boolean z) {
        if (this.guA != null) {
            if (z) {
                this.guB.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.guB.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
            }
        }
    }

    public static void a(final int i, final View view, final HListView hListView, final int i2) {
        new Handler().post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.1
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int a2 = AlaLiveMultiBeautyArView.a(i, hListView.getFirstVisiblePosition(), hListView.getLastVisiblePosition() - hListView.getFirstVisiblePosition(), iArr, hListView.getAdapter().getCount(), false);
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "smoothItemToMiddle pos" + i + " lx=" + iArr[0] + ", diff=" + a2 + ", listW=" + hListView.getMeasuredWidth());
                }
                if (a2 != 0) {
                    if (i == 0) {
                        hListView.smoothScrollBy(a2, 0);
                    } else {
                        hListView.smoothScrollBy(a2, i2);
                    }
                }
            }
        });
    }

    public void tx(final int i) {
        if (this.guy != null && i >= 0) {
            this.guy.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.guy;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.guy.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
                    }
                }
            }, 0L);
        }
    }

    public void setTitle(String str) {
        this.gkn = str;
    }

    public String getTitle() {
        return this.gkn;
    }

    public void ty(int i) {
        this.guD = i;
    }

    public void mm(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.guw != null && this.guw.getVisibility() != i) {
            this.guw.setVisibility(i);
        }
    }

    public void D(int i, int i2, int i3, int i4) {
        this.gux.a(i, i2, i3, i4, true);
    }
}
