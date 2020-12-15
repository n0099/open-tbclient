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
    private CountDownTimer gEo;
    private a.InterfaceC0699a hCY;
    private ViewGroup hCZ;
    private FrameLayout hDa;
    private TurnTableLuckyBubbleView hDb;
    private Handler hDc;
    private com.baidu.tieba.ala.liveroom.turntable.a hDd;
    private boolean hDe;
    private int mBottomMargin;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hCZ = viewGroup;
        this.fgo = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0699a interfaceC0699a) {
        IB();
        this.hDe = true;
        this.mLiveId = str;
        this.hCY = interfaceC0699a;
        ckJ();
    }

    public void bY(int i, int i2) {
        if (i != this.fgo || i2 != this.mBottomMargin) {
            this.fgo = i;
            this.mBottomMargin = i2;
            if (this.hDa != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fgo * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.hDa.setLayoutParams(layoutParams);
            }
        }
    }

    public void oh(boolean z) {
        this.hDe = z;
        if (this.hDa != null && this.hDa.getParent() != null) {
            this.hDa.setVisibility(z ? 0 : 8);
        }
    }

    public void IB() {
        this.mLiveId = "";
        bUm();
        this.hCY = null;
        if (this.hDc != null) {
            this.hDc.removeCallbacksAndMessages(null);
        }
        if (this.hDa != null) {
            this.hDa.removeAllViews();
            if (this.hCZ != null) {
                this.hCZ.removeView(this.hDa);
            }
            this.hDa = null;
            this.hDb = null;
        }
    }

    public void release() {
        IB();
        if (this.hDd != null) {
            this.hDd.release();
            this.hDd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckJ() {
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar == null || boVar.aQP == null || boVar.aQP.aTj) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hDd == null) {
                    this.hDd = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hDd.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
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
                this.hDd.IN(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ckK();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hDk == 1 && cVar.hDl - cVar.aJS > 0) {
                    a(cVar);
                    if (this.hDb != null && cVar.hDm != null) {
                        this.hDb.setContent(cVar.hDm.giftName, cVar.hDm.hDn);
                    }
                } else {
                    bUm();
                    bRW();
                }
                ckK();
            }
        }
    }

    private void ckK() {
        if (this.hDc == null) {
            this.hDc = new Handler();
        }
        this.hDc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckJ();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.hDl) {
            bUm();
            this.mExpiredTime = cVar.hDl;
            long j = cVar.hDl - cVar.aJS;
            a(cVar.hDm, j);
            final long j2 = 100 + (j * 1000);
            this.gEo = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.v(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ckL();
                }
            };
            this.gEo.start();
        }
    }

    private void bUm() {
        this.mExpiredTime = 0L;
        if (this.gEo != null) {
            this.gEo.cancel();
            this.gEo = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hCZ != null && !TextUtils.isEmpty(str)) {
            if (this.hDb == null) {
                this.hDb = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hDa == null) {
                this.hDa = new FrameLayout(this.mContext);
                this.hDa.setBackgroundColor(0);
            }
            if (this.hDa.indexOfChild(this.hDb) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hDa.addView(this.hDb, layoutParams);
            }
            if (this.hCZ.indexOfChild(this.hDa) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fgo * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.hCZ.addView(this.hDa, layoutParams2);
            }
            this.hDa.setVisibility(this.hDe ? 0 : 8);
            this.hDb.setContent(str, aVar.hDn);
        }
        if (this.hCY != null) {
            this.hCY.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, long j2) {
        if (this.hCY != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hCY.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ckL();
            }
        }
    }

    private void bRW() {
        if (this.hDa != null) {
            this.hDa.removeAllViews();
            if (this.hCZ != null) {
                this.hCZ.removeView(this.hDa);
            }
            this.hDa = null;
            this.hDb = null;
        }
        if (this.hCY != null) {
            this.hCY.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckL() {
        bUm();
        bRW();
        if (this.hDc != null) {
            this.hDc.removeCallbacksAndMessages(null);
        }
        ckJ();
    }
}
