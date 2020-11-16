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
    int bwv;
    View ggA;
    protected int ggB = 300;
    protected boolean ggC;
    protected boolean ggD;
    public Object ggt;
    FrameLayout ggu;
    TopTipSeekBar ggv;
    public HListView ggw;
    a ggx;
    View ggy;
    TextView ggz;
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
        this.ggx = aVar;
    }

    public void setEnable(boolean z) {
        this.ggC = !z;
        if (this.ggy != null) {
            this.ggy.setVisibility(this.ggC ? 8 : 0);
        }
    }

    public boolean isEnable() {
        return !this.ggC;
    }

    public void lx(boolean z) {
        this.ggD = z;
        if (this.ggA != null) {
            this.ggA.setVisibility(this.ggD ? 0 : 8);
        }
    }

    public View b(View view, ViewGroup viewGroup) {
        if (this.ggy == null) {
            this.ggy = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_live_beauty_ar_tab_btn, viewGroup, false);
            if (this.ggy != null) {
                this.ggy.setVisibility(this.ggC ? 8 : 0);
            }
            this.ggz = (TextView) this.ggy.findViewById(a.f.button_tv);
            this.ggA = this.ggy.findViewById(a.f.red_dot_iv);
        }
        this.ggA.setVisibility(this.ggD ? 0 : 8);
        this.ggz.setText(this.mTitleText == null ? "" : this.mTitleText);
        return this.ggy;
    }

    public View bNM() {
        return this.ggw;
    }

    public void setSelected(boolean z) {
        if (this.ggy != null) {
            if (z) {
                this.ggz.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_other_b));
            } else {
                this.ggz.setTextColor(this.view.getResources().getColor(a.c.sdk_cp_cont_g));
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

    public void un(final int i) {
        if (this.ggw != null && i >= 0) {
            this.ggw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.l.2
                @Override // java.lang.Runnable
                public void run() {
                    View view = null;
                    HListView hListView = l.this.ggw;
                    if (i >= hListView.getFirstVisiblePosition() && i <= hListView.getLastVisiblePosition()) {
                        view = hListView.getChildAt(i - hListView.getFirstVisiblePosition());
                    }
                    if (view != null) {
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        hListView.getGlobalVisibleRect(rect2);
                        l.this.ggw.smoothScrollToPositionFromLeft(i, (rect2.width() - rect.width()) >> 1, 0);
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

    public void uo(int i) {
        this.ggB = i;
    }

    public void ly(boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "showSeekbar " + z);
        }
        int i = z ? 0 : 4;
        if (this.ggu != null && this.ggu.getVisibility() != i) {
            this.ggu.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        this.ggv.a(i, i2, i3, i4, true);
    }
}
