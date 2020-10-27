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
/* loaded from: classes4.dex */
public class l {
    public Object gaW;
    FrameLayout gaX;
    TopTipSeekBar gaY;
    public HListView gaZ;
    a gba;
    int gbb;
    View gbc;
    TextView gbd;
    View gbe;
    protected int gbf = 300;
    protected boolean gbg;
    protected boolean gbh;
    protected String mTitleText;
    View view;

    /* loaded from: classes4.dex */
    public interface a<D> {
        void a(D d, SeekBar seekBar, int i, boolean z);

        boolean a(int i, D d, boolean z);

        void b(int i, D d, boolean z);

        void onStartTrackingTouch(SeekBar seekBar);
    }

    public void a(a aVar) {
        this.gba = aVar;
    }

    public void setEnable(boolean z) {
        this.gbg = !z;
        if (this.gbc != null) {
            this.gbc.setVisibility(this.gbg ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.gbg;
    }

    public void ln(boolean z) {
        this.gbh = z;
        if (this.gbe != null) {
            this.gbe.setVisibility(this.gbh ? 0 : 8);
        }
    }

    public View b(View view, ViewGroup viewGroup) {
        if (this.gbc == null) {
            this.gbc = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.gbc != null) {
                this.gbc.setVisibility(this.gbg ? 8 : 0);
            }
            this.gbd = (TextView) this.gbc.findViewById(a.g.button_tv);
            this.gbe = this.gbc.findViewById(a.g.red_dot_iv);
        }
        this.gbe.setVisibility(this.gbh ? 0 : 8);
        this.gbd.setText(this.mTitleText == null ? "" : this.mTitleText);
        return this.gbc;
    }

    public View bLT() {
        return this.gaZ;
    }

    public void setSelected(boolean z) {
        if (this.gbc != null) {
            if (z) {
                this.gbd.setTextColor(this.view.getResources().getColor(a.d.sdk_cp_other_b));
            } else {
                this.gbd.setTextColor(this.view.getResources().getColor(a.d.sdk_cp_cont_g));
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
        if (this.gaZ != null && i >= 0) {
            this.gaZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.gaZ;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.gaZ.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
                    }
                }
            }, 0L);
        }
    }

    public void setTitle(String str) {
        this.mTitleText = str;
    }

    public String getTitle() {
        return this.mTitleText;
    }

    public void tG(int i) {
        this.gbf = i;
    }

    public void lo(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.gaX != null && this.gaX.getVisibility() != i) {
            this.gaX.setVisibility(i);
        }
    }

    public void x(int i, int i2, int i3, int i4) {
        this.gaY.a(i, i2, i3, i4, true);
    }
}
