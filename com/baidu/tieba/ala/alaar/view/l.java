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
    protected String goR;
    public Object gzc;
    FrameLayout gzd;
    TopTipSeekBar gze;
    public HListView gzf;
    a gzg;
    View gzh;
    TextView gzi;
    View gzj;
    protected int gzk = 300;
    protected boolean gzl;
    protected boolean gzm;
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
        this.gzg = aVar;
    }

    public void setEnable(boolean z) {
        this.gzl = !z;
        if (this.gzh != null) {
            this.gzh.setVisibility(this.gzl ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.gzl;
    }

    public void mp(boolean z) {
        this.gzm = z;
        if (this.gzj != null) {
            this.gzj.setVisibility(this.gzm ? 0 : 8);
        }
    }

    public View c(View view, ViewGroup viewGroup) {
        if (this.gzh == null) {
            this.gzh = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.gzh != null) {
                this.gzh.setVisibility(this.gzl ? 8 : 0);
            }
            this.gzi = (TextView) this.gzh.findViewById(a.f.button_tv);
            this.gzj = this.gzh.findViewById(a.f.red_dot_iv);
        }
        this.gzj.setVisibility(this.gzm ? 0 : 8);
        this.gzi.setText(this.goR == null ? "" : this.goR);
        return this.gzh;
    }

    public View bQW() {
        return this.gzf;
    }

    public void setSelected(boolean z) {
        if (this.gzh != null) {
            if (z) {
                this.gzi.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.gzi.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
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

    public void tF(final int i) {
        if (this.gzf != null && i >= 0) {
            this.gzf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.gzf;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.gzf.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
                    }
                }
            }, 0L);
        }
    }

    public void setTitle(String str) {
        this.goR = str;
    }

    public String getTitle() {
        return this.goR;
    }

    public void tG(int i) {
        this.gzk = i;
    }

    public void mq(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.gzd != null && this.gzd.getVisibility() != i) {
            this.gzd.setVisibility(i);
        }
    }

    public void D(int i, int i2, int i3, int i4) {
        this.gze.a(i, i2, i3, i4, true);
    }
}
