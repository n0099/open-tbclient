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
/* loaded from: classes11.dex */
public class l {
    protected String gmU;
    public Object gxf;
    FrameLayout gxg;
    TopTipSeekBar gxh;
    public HListView gxi;
    a gxj;
    View gxk;
    TextView gxl;
    View gxm;
    protected int gxn = 300;
    protected boolean gxo;
    protected boolean gxp;
    int itemPosition;
    View view;

    /* loaded from: classes11.dex */
    public interface a<D> {
        void a(D d, SeekBar seekBar, int i, boolean z);

        boolean a(int i, D d, boolean z);

        void b(int i, D d, boolean z);

        void onStartTrackingTouch(SeekBar seekBar);
    }

    public void a(a aVar) {
        this.gxj = aVar;
    }

    public void setEnable(boolean z) {
        this.gxo = !z;
        if (this.gxk != null) {
            this.gxk.setVisibility(this.gxo ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.gxo;
    }

    public void mp(boolean z) {
        this.gxp = z;
        if (this.gxm != null) {
            this.gxm.setVisibility(this.gxp ? 0 : 8);
        }
    }

    public View c(View view, ViewGroup viewGroup) {
        if (this.gxk == null) {
            this.gxk = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.gxk != null) {
                this.gxk.setVisibility(this.gxo ? 8 : 0);
            }
            this.gxl = (TextView) this.gxk.findViewById(a.f.button_tv);
            this.gxm = this.gxk.findViewById(a.f.red_dot_iv);
        }
        this.gxm.setVisibility(this.gxp ? 0 : 8);
        this.gxl.setText(this.gmU == null ? "" : this.gmU);
        return this.gxk;
    }

    public View bQJ() {
        return this.gxi;
    }

    public void setSelected(boolean z) {
        if (this.gxk != null) {
            if (z) {
                this.gxl.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.gxl.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
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

    public void tD(final int i) {
        if (this.gxi != null && i >= 0) {
            this.gxi.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.gxi;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.gxi.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
                    }
                }
            }, 0L);
        }
    }

    public void setTitle(String str) {
        this.gmU = str;
    }

    public String getTitle() {
        return this.gmU;
    }

    public void tE(int i) {
        this.gxn = i;
    }

    public void mq(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.gxg != null && this.gxg.getVisibility() != i) {
            this.gxg.setVisibility(i);
        }
    }

    public void D(int i, int i2, int i3, int i4) {
        this.gxh.a(i, i2, i3, i4, true);
    }
}
