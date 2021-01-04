package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bq;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes11.dex */
public class b implements a {
    private int fpX;
    private CountDownTimer gPY;
    private a.InterfaceC0691a hOY;
    private ViewGroup hOZ;
    private int hPa;
    private FrameLayout hPb;
    private TurnTableLuckyBubbleView hPc;
    private Handler hPd;
    private com.baidu.tieba.ala.liveroom.turntable.a hPe;
    private boolean hPf;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hOZ = viewGroup;
        this.fpX = i;
        this.hPa = i2;
    }

    public void a(String str, a.InterfaceC0691a interfaceC0691a) {
        Id();
        this.hPf = true;
        this.mLiveId = str;
        this.hOY = interfaceC0691a;
        cnA();
    }

    public void bX(int i, int i2) {
        if (i != this.fpX || i2 != this.hPa) {
            this.fpX = i;
            this.hPa = i2;
            if (this.hPb != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fpX * 2;
                    layoutParams.bottomMargin = this.hPa;
                }
                this.hPb.setLayoutParams(layoutParams);
            }
        }
    }

    public void oG(boolean z) {
        this.hPf = z;
        if (this.hPb != null && this.hPb.getParent() != null) {
            this.hPb.setVisibility(z ? 0 : 8);
        }
    }

    public void Id() {
        this.mLiveId = "";
        bWQ();
        this.hOY = null;
        if (this.hPd != null) {
            this.hPd.removeCallbacksAndMessages(null);
        }
        if (this.hPb != null) {
            this.hPb.removeAllViews();
            if (this.hOZ != null) {
                this.hOZ.removeView(this.hPb);
            }
            this.hPb = null;
            this.hPc = null;
        }
    }

    public void release() {
        Id();
        if (this.hPe != null) {
            this.hPe.release();
            this.hPe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar == null || bqVar.aRE == null || bqVar.aRE.aUh) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hPe == null) {
                    this.hPe = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hPe.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0690a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0690a
                        public void bm(int i, String str) {
                            super.bm(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hPe.IJ(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            cnB();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hPl == 1 && cVar.expiredTime - cVar.aKr > 0) {
                    a(cVar);
                    if (this.hPc != null && cVar.hPm != null) {
                        this.hPc.setContent(cVar.hPm.giftName, cVar.hPm.hPn);
                    }
                } else {
                    bWQ();
                    bUy();
                }
                cnB();
            }
        }
    }

    private void cnB() {
        if (this.hPd == null) {
            this.hPd = new Handler();
        }
        this.hPd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnA();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.expiredTime) {
            bWQ();
            this.mExpiredTime = cVar.expiredTime;
            long j = cVar.expiredTime - cVar.aKr;
            a(cVar.hPm, j);
            final long j2 = 100 + (j * 1000);
            this.gPY = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.cnC();
                }
            };
            this.gPY.start();
        }
    }

    private void bWQ() {
        this.mExpiredTime = 0L;
        if (this.gPY != null) {
            this.gPY.cancel();
            this.gPY = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hOZ != null && !TextUtils.isEmpty(str)) {
            if (this.hPc == null) {
                this.hPc = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hPb == null) {
                this.hPb = new FrameLayout(this.mContext);
                this.hPb.setBackgroundColor(0);
            }
            if (this.hPb.indexOfChild(this.hPc) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hPb.addView(this.hPc, layoutParams);
            }
            if (this.hOZ.indexOfChild(this.hPb) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fpX * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.hPa;
                this.hOZ.addView(this.hPb, layoutParams2);
            }
            this.hPb.setVisibility(this.hPf ? 0 : 8);
            this.hPc.setContent(str, aVar.hPn);
        }
        if (this.hOY != null) {
            this.hOY.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.hOY != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hOY.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                cnC();
            }
        }
    }

    private void bUy() {
        if (this.hPb != null) {
            this.hPb.removeAllViews();
            if (this.hOZ != null) {
                this.hOZ.removeView(this.hPb);
            }
            this.hPb = null;
            this.hPc = null;
        }
        if (this.hOY != null) {
            this.hOY.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnC() {
        bWQ();
        bUy();
        if (this.hPd != null) {
            this.hPd.removeCallbacksAndMessages(null);
        }
        cnA();
    }
}
