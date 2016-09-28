package com.baidu.tieba.frs;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class dj {
    private Animation bTr;
    private Animation bTs;
    private View bTt;
    private bm bTu;
    private com.baidu.tieba.frs.i.p bTv;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private int aRr = 0;
    private int bTw = 0;
    private boolean bJz = true;
    private boolean bJy = false;
    private final Handler.Callback bJA = new dk(this);
    private final Handler mHandler = new Handler(this.bJA);
    private boolean bJx = UtilHelper.canUseStyleImmersiveSticky();

    public void dq(boolean z) {
        this.bJy = z;
    }

    public void dP(boolean z) {
        this.bJz = z;
    }

    public dj(Context context, bm bmVar, com.baidu.tieba.frs.i.p pVar) {
        this.mContext = context;
        this.bTu = bmVar;
        this.mNavigationBar = bmVar.abZ();
        this.bTt = bmVar.aby();
        this.bTv = pVar;
        Ze();
        dr(false);
    }

    private void YT() {
        this.bTr = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_out);
        this.bTr.setAnimationListener(new dl(this));
    }

    private void YU() {
        this.bTs = AnimationUtils.loadAnimation(this.mContext, r.a.bavigationbar_slide_in);
        this.bTs.setAnimationListener(new dm(this));
    }

    public void YV() {
        m(false, false);
    }

    public void YW() {
        m(false, true);
    }

    public void m(boolean z, boolean z2) {
        if (this.bTt != null && this.bTt.getVisibility() == 0 && !Zb()) {
            if (z2) {
                this.bTt.setVisibility(8);
                return;
            }
            if (this.bTr == null) {
                YT();
            }
            this.bTt.startAnimation(this.bTr);
            n(false, true);
        }
    }

    public void YX() {
        if (this.bTt != null && this.bTt.getVisibility() != 0 && !Zb()) {
            this.bTt.setVisibility(0);
            if (this.bTs == null) {
                YU();
            }
            this.bTt.startAnimation(this.bTs);
            n(true, true);
        }
    }

    public void YY() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void YZ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Za() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean Zb() {
        return ab(this.bTt);
    }

    private boolean ab(View view) {
        Animation animation;
        return (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(boolean z, boolean z2) {
        if (this.bTu != null) {
            this.bTu.n(z, z2);
        }
    }

    public void Zc() {
        if (this.bJz && this.bTt != null && this.aRr >= this.bTw && this.bTt.getVisibility() != 8) {
            YZ();
        }
    }

    public void Zd() {
        if (this.bJz && this.bTt != null && this.bTt.getVisibility() != 0) {
            YY();
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bJz) {
            if (i > this.aRr && i > i4 && this.bTt.getVisibility() != 8) {
                Zc();
            } else if (i < this.aRr && this.bTt.getVisibility() != 0) {
                Zd();
            }
            a(i, eVar);
            this.aRr = i;
            this.bTw = i4;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.bJz && absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0 && firstVisiblePosition > this.aRr && firstVisiblePosition > this.bTw) {
                YZ();
            } else if (firstVisiblePosition < this.aRr) {
                YY();
            } else if (firstVisiblePosition == this.aRr) {
                if (!this.bJy || firstVisiblePosition <= this.bTw || b(absListView)) {
                    YY();
                } else {
                    YZ();
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void a(int i, com.baidu.tbadk.util.e<Boolean> eVar) {
        if (this.bJz && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.mContext != null && this.bTv != null && this.bTv.afD() != null && this.bTv.afD().getView() != null) {
            int measuredHeight = this.bTv.afD().getView().getMeasuredHeight();
            int measuredHeight2 = this.mNavigationBar.getMeasuredHeight();
            int i2 = measuredHeight - (-this.bTv.afD().getView().getTop());
            if (i2 < measuredHeight2) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    if (eVar != null) {
                        eVar.F(false);
                    }
                }
            } else if (i2 >= measuredHeight2 && i2 <= measuredHeight2 * 2) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - (((i2 - measuredHeight2) * 1.0f) / measuredHeight2));
                if (eVar != null) {
                    eVar.F(false);
                }
            } else if (i2 > measuredHeight2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                if (eVar != null) {
                    eVar.F(true);
                }
            }
            if (i > this.bTw && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                if (eVar != null) {
                    eVar.F(true);
                }
            }
            if (this.mNavigationBar.getBarBgView().getAlpha() == 1.0f) {
                this.mNavigationBar.showBottomLine(true);
            } else {
                this.mNavigationBar.showBottomLine(false);
            }
        }
    }

    private void Ze() {
        if (this.bTu != null && this.bTu.abz() != null) {
            View abz = this.bTu.abz();
            if (this.bJx && abz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = abz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                abz.setLayoutParams(layoutParams);
                dr(true);
                return;
            }
            dr(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bTu != null && this.bTu.abz() != null) {
            View abz = this.bTu.abz();
            if (this.bJx && z && abz.getVisibility() != 0) {
                abz.setVisibility(0);
            } else if (!z && abz.getVisibility() != 8) {
                abz.setVisibility(8);
            }
        }
    }
}
