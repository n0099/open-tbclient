package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes3.dex */
public class b implements a {
    private int dOK;
    private CountDownTimer ewS;
    private a.InterfaceC0467a flO;
    private ViewGroup flP;
    private int flQ;
    private FrameLayout flR;
    private TurnTableLuckyBubbleView flS;
    private Handler flT;
    private com.baidu.tieba.ala.liveroom.turntable.a flU;
    private long flV;
    private boolean flW;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.flP = viewGroup;
        this.dOK = i;
        this.flQ = i2;
    }

    public void a(String str, a.InterfaceC0467a interfaceC0467a) {
        sQ();
        this.flW = true;
        this.mLiveId = str;
        this.flO = interfaceC0467a;
        bqJ();
    }

    public void bs(int i, int i2) {
        if (i != this.dOK || i2 != this.flQ) {
            this.dOK = i;
            this.flQ = i2;
            if (this.flR != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.flR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dOK * 2;
                    layoutParams.bottomMargin = this.flQ;
                }
                this.flR.setLayoutParams(layoutParams);
            }
        }
    }

    public void jO(boolean z) {
        this.flW = z;
        if (this.flR != null && this.flR.getParent() != null) {
            this.flR.setVisibility(z ? 0 : 8);
        }
    }

    public void sQ() {
        this.mLiveId = "";
        bea();
        this.flO = null;
        if (this.flT != null) {
            this.flT.removeCallbacksAndMessages(null);
        }
        if (this.flR != null) {
            this.flR.removeAllViews();
            if (this.flP != null) {
                this.flP.removeView(this.flR);
            }
            this.flR = null;
            this.flS = null;
        }
    }

    public void release() {
        sQ();
        if (this.flU != null) {
            this.flU.release();
            this.flU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar == null || apVar.adg == null || apVar.adg.aeL) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.flU == null) {
                    this.flU = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.flU.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0466a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0466a
                        public void ay(int i, String str) {
                            super.ay(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.flU.zw(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bqK();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.fmb == 1 && cVar.fmc - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.flS != null && cVar.fmd != null) {
                        this.flS.setContent(cVar.fmd.giftName, cVar.fmd.fme);
                    }
                } else {
                    bea();
                    bct();
                }
                bqK();
            }
        }
    }

    private void bqK() {
        if (this.flT == null) {
            this.flT = new Handler();
        }
        this.flT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bqJ();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.flV != cVar.fmc) {
            bea();
            this.flV = cVar.fmc;
            long j = cVar.fmc - cVar.currentTime;
            a(cVar.fmd, j);
            final long j2 = 100 + (j * 1000);
            this.ewS = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bqL();
                }
            };
            this.ewS.start();
        }
    }

    private void bea() {
        this.flV = 0L;
        if (this.ewS != null) {
            this.ewS.cancel();
            this.ewS = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.flP != null && !TextUtils.isEmpty(str)) {
            if (this.flS == null) {
                this.flS = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.flR == null) {
                this.flR = new FrameLayout(this.mContext);
                this.flR.setBackgroundColor(0);
            }
            if (this.flR.indexOfChild(this.flS) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.flR.addView(this.flS, layoutParams);
            }
            if (this.flP.indexOfChild(this.flR) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dOK * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.flQ;
                this.flP.addView(this.flR, layoutParams2);
            }
            this.flR.setVisibility(this.flW ? 0 : 8);
            this.flS.setContent(str, aVar.fme);
        }
        if (this.flO != null) {
            this.flO.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.flO != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.flO.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bqL();
            }
        }
    }

    private void bct() {
        if (this.flR != null) {
            this.flR.removeAllViews();
            if (this.flP != null) {
                this.flP.removeView(this.flR);
            }
            this.flR = null;
            this.flS = null;
        }
        if (this.flO != null) {
            this.flO.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqL() {
        bea();
        bct();
        if (this.flT != null) {
            this.flT.removeCallbacksAndMessages(null);
        }
        bqJ();
    }
}
