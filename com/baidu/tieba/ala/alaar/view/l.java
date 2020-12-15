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
    int bBF;
    public Object goF;
    FrameLayout goG;
    TopTipSeekBar goH;
    public HListView goI;
    a goJ;
    View goK;
    TextView goL;
    View goM;
    protected int goN = 300;
    protected boolean goO;
    protected boolean goP;
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
        this.goJ = aVar;
    }

    public void setEnable(boolean z) {
        this.goO = !z;
        if (this.goK != null) {
            this.goK.setVisibility(this.goO ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.goO;
    }

    public void lS(boolean z) {
        this.goP = z;
        if (this.goM != null) {
            this.goM.setVisibility(this.goP ? 0 : 8);
        }
    }

    public View b(View view, ViewGroup viewGroup) {
        if (this.goK == null) {
            this.goK = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.goK != null) {
                this.goK.setVisibility(this.goO ? 8 : 0);
            }
            this.goL = (TextView) this.goK.findViewById(a.f.button_tv);
            this.goM = this.goK.findViewById(a.f.red_dot_iv);
        }
        this.goM.setVisibility(this.goP ? 0 : 8);
        this.goL.setText(this.mTitleText == null ? "" : this.mTitleText);
        return this.goK;
    }

    public View bRy() {
        return this.goI;
    }

    public void setSelected(boolean z) {
        if (this.goK != null) {
            if (z) {
                this.goL.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.goL.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
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

    public void uR(final int i) {
        if (this.goI != null && i >= 0) {
            this.goI.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.goI;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.goI.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
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

    public void uS(int i) {
        this.goN = i;
    }

    public void lT(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.goG != null && this.goG.getVisibility() != i) {
            this.goG.setVisibility(i);
        }
    }

    public void C(int i, int i2, int i3, int i4) {
        this.goH.a(i, i2, i3, i4, true);
    }
}
