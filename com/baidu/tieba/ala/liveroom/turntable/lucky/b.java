package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int fgo;
    private CountDownTimer gEm;
    private a.InterfaceC0699a hCW;
    private ViewGroup hCX;
    private FrameLayout hCY;
    private TurnTableLuckyBubbleView hCZ;
    private Handler hDa;
    private com.baidu.tieba.ala.liveroom.turntable.a hDb;
    private boolean hDc;
    private int mBottomMargin;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hCX = viewGroup;
        this.fgo = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0699a interfaceC0699a) {
        IB();
        this.hDc = true;
        this.mLiveId = str;
        this.hCW = interfaceC0699a;
        ckI();
    }

    public void bY(int i, int i2) {
        if (i != this.fgo || i2 != this.mBottomMargin) {
            this.fgo = i;
            this.mBottomMargin = i2;
            if (this.hCY != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hCY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fgo * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.hCY.setLayoutParams(layoutParams);
            }
        }
    }

    public void oh(boolean z) {
        this.hDc = z;
        if (this.hCY != null && this.hCY.getParent() != null) {
            this.hCY.setVisibility(z ? 0 : 8);
        }
    }

    public void IB() {
        this.mLiveId = "";
        bUl();
        this.hCW = null;
        if (this.hDa != null) {
            this.hDa.removeCallbacksAndMessages(null);
        }
        if (this.hCY != null) {
            this.hCY.removeAllViews();
            if (this.hCX != null) {
                this.hCX.removeView(this.hCY);
            }
            this.hCY = null;
            this.hCZ = null;
        }
    }

    public void release() {
        IB();
        if (this.hDb != null) {
            this.hDb.release();
            this.hDb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckI() {
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar == null || boVar.aQP == null || boVar.aQP.aTj) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hDb == null) {
                    this.hDb = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hDb.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0698a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0698a
                        public void bk(int i, String str) {
                            super.bk(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hDb.IN(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ckJ();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hDi == 1 && cVar.hDj - cVar.aJS > 0) {
                    a(cVar);
                    if (this.hCZ != null && cVar.hDk != null) {
                        this.hCZ.setContent(cVar.hDk.giftName, cVar.hDk.hDl);
                    }
                } else {
                    bUl();
                    bRV();
                }
                ckJ();
            }
        }
    }

    private void ckJ() {
        if (this.hDa == null) {
            this.hDa = new Handler();
        }
        this.hDa.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckI();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.hDj) {
            bUl();
            this.mExpiredTime = cVar.hDj;
            long j = cVar.hDj - cVar.aJS;
            a(cVar.hDk, j);
            final long j2 = 100 + (j * 1000);
            this.gEm = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.v(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ckK();
                }
            };
            this.gEm.start();
        }
    }

    private void bUl() {
        this.mExpiredTime = 0L;
        if (this.gEm != null) {
            this.gEm.cancel();
            this.gEm = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hCX != null && !TextUtils.isEmpty(str)) {
            if (this.hCZ == null) {
                this.hCZ = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hCY == null) {
                this.hCY = new FrameLayout(this.mContext);
                this.hCY.setBackgroundColor(0);
            }
            if (this.hCY.indexOfChild(this.hCZ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hCY.addView(this.hCZ, layoutParams);
            }
            if (this.hCX.indexOfChild(this.hCY) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fgo * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.hCX.addView(this.hCY, layoutParams2);
            }
            this.hCY.setVisibility(this.hDc ? 0 : 8);
            this.hCZ.setContent(str, aVar.hDl);
        }
        if (this.hCW != null) {
            this.hCW.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, long j2) {
        if (this.hCW != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hCW.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ckK();
            }
        }
    }

    private void bRV() {
        if (this.hCY != null) {
            this.hCY.removeAllViews();
            if (this.hCX != null) {
                this.hCX.removeView(this.hCY);
            }
            this.hCY = null;
            this.hCZ = null;
        }
        if (this.hCW != null) {
            this.hCW.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckK() {
        bUl();
        bRV();
        if (this.hDa != null) {
            this.hDa.removeCallbacksAndMessages(null);
        }
        ckI();
    }
}
