package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes2.dex */
public class b implements a {
    private int dJT;
    private CountDownTimer eqL;
    private a.InterfaceC0455a feN;
    private ViewGroup feO;
    private int feP;
    private FrameLayout feQ;
    private TurnTableLuckyBubbleView feR;
    private Handler feS;
    private com.baidu.tieba.ala.liveroom.turntable.a feT;
    private long feU;
    private boolean feV;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.feO = viewGroup;
        this.dJT = i;
        this.feP = i2;
    }

    public void a(String str, a.InterfaceC0455a interfaceC0455a) {
        th();
        this.feV = true;
        this.mLiveId = str;
        this.feN = interfaceC0455a;
        bnV();
    }

    public void br(int i, int i2) {
        if (i != this.dJT || i2 != this.feP) {
            this.dJT = i;
            this.feP = i2;
            if (this.feQ != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feQ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dJT * 2;
                    layoutParams.bottomMargin = this.feP;
                }
                this.feQ.setLayoutParams(layoutParams);
            }
        }
    }

    public void jz(boolean z) {
        this.feV = z;
        if (this.feQ != null && this.feQ.getParent() != null) {
            this.feQ.setVisibility(z ? 0 : 8);
        }
    }

    public void th() {
        this.mLiveId = "";
        bbi();
        this.feN = null;
        if (this.feS != null) {
            this.feS.removeCallbacksAndMessages(null);
        }
        if (this.feQ != null) {
            this.feQ.removeAllViews();
            if (this.feO != null) {
                this.feO.removeView(this.feQ);
            }
            this.feQ = null;
            this.feR = null;
        }
    }

    public void release() {
        th();
        if (this.feT != null) {
            this.feT.release();
            this.feT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnV() {
        if (this.feT == null) {
            this.feT = new com.baidu.tieba.ala.liveroom.turntable.c();
            this.feT.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0454a
                public void a(String str, c cVar) {
                    super.a(str, cVar);
                    b.this.b(str, cVar);
                }
            });
        }
        this.feT.yU(this.mLiveId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, c cVar) {
        if (!TextUtils.isEmpty(this.mLiveId) && !TextUtils.isEmpty(str) && this.mLiveId.equals(str) && cVar != null) {
            if (cVar.ffa == 1 && cVar.ffb - cVar.VM > 0) {
                a(cVar);
            } else {
                bbi();
                aZB();
            }
            if (this.feS == null) {
                this.feS = new Handler();
            }
            this.feS.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bnV();
                }
            }, 5000L);
        }
    }

    private void a(c cVar) {
        if (this.feU != cVar.ffb) {
            bbi();
            this.feU = cVar.ffb;
            long j = cVar.ffb - cVar.VM;
            a(cVar.ffc, j);
            final long j2 = 100 + (j * 1000);
            this.eqL = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bnW();
                }
            };
            this.eqL.start();
        }
    }

    private void bbi() {
        this.feU = 0L;
        if (this.eqL != null) {
            this.eqL.cancel();
            this.eqL = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.feO != null && !TextUtils.isEmpty(str)) {
            if (this.feR == null) {
                this.feR = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.feQ == null) {
                this.feQ = new FrameLayout(this.mContext);
                this.feQ.setBackgroundColor(0);
            }
            if (this.feQ.indexOfChild(this.feR) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.feQ.addView(this.feR, layoutParams);
            }
            if (this.feO.indexOfChild(this.feQ) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dJT * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.feP;
                this.feO.addView(this.feQ, layoutParams2);
            }
            this.feQ.setVisibility(this.feV ? 0 : 8);
            this.feR.setContent(!TextUtils.isEmpty(aVar.ffd) ? str + Config.EVENT_HEAT_X + aVar.ffd : str);
        }
        if (this.feN != null) {
            this.feN.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.feN != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.feN.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bnW();
            }
        }
    }

    private void aZB() {
        if (this.feQ != null) {
            this.feQ.removeAllViews();
            if (this.feO != null) {
                this.feO.removeView(this.feQ);
            }
            this.feQ = null;
            this.feR = null;
        }
        if (this.feN != null) {
            this.feN.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnW() {
        bbi();
        aZB();
        if (this.feS != null) {
            this.feS.removeCallbacksAndMessages(null);
        }
        bnV();
    }
}
