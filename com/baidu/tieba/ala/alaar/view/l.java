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
    protected String gni;
    View gxA;
    protected int gxB = 300;
    protected boolean gxC;
    protected boolean gxD;
    public Object gxt;
    FrameLayout gxu;
    TopTipSeekBar gxv;
    public HListView gxw;
    a gxx;
    View gxy;
    TextView gxz;
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
        this.gxx = aVar;
    }

    public void setEnable(boolean z) {
        this.gxC = !z;
        if (this.gxy != null) {
            this.gxy.setVisibility(this.gxC ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.gxC;
    }

    public void mp(boolean z) {
        this.gxD = z;
        if (this.gxA != null) {
            this.gxA.setVisibility(this.gxD ? 0 : 8);
        }
    }

    public View c(View view, ViewGroup viewGroup) {
        if (this.gxy == null) {
            this.gxy = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.gxy != null) {
                this.gxy.setVisibility(this.gxC ? 8 : 0);
            }
            this.gxz = (TextView) this.gxy.findViewById(a.f.button_tv);
            this.gxA = this.gxy.findViewById(a.f.red_dot_iv);
        }
        this.gxA.setVisibility(this.gxD ? 0 : 8);
        this.gxz.setText(this.gni == null ? "" : this.gni);
        return this.gxy;
    }

    public View bQQ() {
        return this.gxw;
    }

    public void setSelected(boolean z) {
        if (this.gxy != null) {
            if (z) {
                this.gxz.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.gxz.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
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
        if (this.gxw != null && i >= 0) {
            this.gxw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.gxw;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.gxw.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
                    }
                }
            }, 0L);
        }
    }

    public void setTitle(String str) {
        this.gni = str;
    }

    public String getTitle() {
        return this.gni;
    }

    public void tE(int i) {
        this.gxB = i;
    }

    public void mq(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.gxu != null && this.gxu.getVisibility() != i) {
            this.gxu.setVisibility(i);
        }
    }

    public void D(int i, int i2, int i3, int i4) {
        this.gxv.a(i, i2, i3, i4, true);
    }
}
