package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes7.dex */
public class b implements a {
    private int exk;
    private CountDownTimer fQB;
    private a.InterfaceC0641a gJJ;
    private ViewGroup gJK;
    private int gJL;
    private FrameLayout gJM;
    private TurnTableLuckyBubbleView gJN;
    private Handler gJO;
    private com.baidu.tieba.ala.liveroom.turntable.a gJP;
    private long gJQ;
    private boolean gJR;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gJK = viewGroup;
        this.exk = i;
        this.gJL = i2;
    }

    public void a(String str, a.InterfaceC0641a interfaceC0641a) {
        Fb();
        this.gJR = true;
        this.mLiveId = str;
        this.gJJ = interfaceC0641a;
        bWH();
    }

    public void bQ(int i, int i2) {
        if (i != this.exk || i2 != this.gJL) {
            this.exk = i;
            this.gJL = i2;
            if (this.gJM != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.exk * 2;
                    layoutParams.bottomMargin = this.gJL;
                }
                this.gJM.setLayoutParams(layoutParams);
            }
        }
    }

    public void mF(boolean z) {
        this.gJR = z;
        if (this.gJM != null && this.gJM.getParent() != null) {
            this.gJM.setVisibility(z ? 0 : 8);
        }
    }

    public void Fb() {
        this.mLiveId = "";
        bIo();
        this.gJJ = null;
        if (this.gJO != null) {
            this.gJO.removeCallbacksAndMessages(null);
        }
        if (this.gJM != null) {
            this.gJM.removeAllViews();
            if (this.gJK != null) {
                this.gJK.removeView(this.gJM);
            }
            this.gJM = null;
            this.gJN = null;
        }
    }

    public void release() {
        Fb();
        if (this.gJP != null) {
            this.gJP.release();
            this.gJP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWH() {
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar == null || beVar.aJD == null || beVar.aJD.aLt) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gJP == null) {
                    this.gJP = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gJP.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0640a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0640a
                        public void aV(int i, String str) {
                            super.aV(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gJP.GA(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bWI();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gJX == 1 && cVar.gJY - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gJN != null && cVar.gJZ != null) {
                        this.gJN.setContent(cVar.gJZ.giftName, cVar.gJZ.gKa);
                    }
                } else {
                    bIo();
                    bFN();
                }
                bWI();
            }
        }
    }

    private void bWI() {
        if (this.gJO == null) {
            this.gJO = new Handler();
        }
        this.gJO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bWH();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gJQ != cVar.gJY) {
            bIo();
            this.gJQ = cVar.gJY;
            long j = cVar.gJY - cVar.currentTime;
            a(cVar.gJZ, j);
            final long j2 = 100 + (j * 1000);
            this.fQB = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bWJ();
                }
            };
            this.fQB.start();
        }
    }

    private void bIo() {
        this.gJQ = 0L;
        if (this.fQB != null) {
            this.fQB.cancel();
            this.fQB = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gJK != null && !TextUtils.isEmpty(str)) {
            if (this.gJN == null) {
                this.gJN = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gJM == null) {
                this.gJM = new FrameLayout(this.mContext);
                this.gJM.setBackgroundColor(0);
            }
            if (this.gJM.indexOfChild(this.gJN) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gJM.addView(this.gJN, layoutParams);
            }
            if (this.gJK.indexOfChild(this.gJM) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.exk * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gJL;
                this.gJK.addView(this.gJM, layoutParams2);
            }
            this.gJM.setVisibility(this.gJR ? 0 : 8);
            this.gJN.setContent(str, aVar.gKa);
        }
        if (this.gJJ != null) {
            this.gJJ.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.gJJ != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gJJ.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bWJ();
            }
        }
    }

    private void bFN() {
        if (this.gJM != null) {
            this.gJM.removeAllViews();
            if (this.gJK != null) {
                this.gJK.removeView(this.gJM);
            }
            this.gJM = null;
            this.gJN = null;
        }
        if (this.gJJ != null) {
            this.gJJ.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWJ() {
        bIo();
        bFN();
        if (this.gJO != null) {
            this.gJO.removeCallbacksAndMessages(null);
        }
        bWH();
    }
}
