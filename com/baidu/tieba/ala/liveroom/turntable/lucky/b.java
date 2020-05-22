package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.ax;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes3.dex */
public class b implements a {
    private int dYR;
    private CountDownTimer foC;
    private a.InterfaceC0574a gfc;
    private ViewGroup gfd;
    private int gfe;
    private FrameLayout gff;
    private TurnTableLuckyBubbleView gfg;
    private Handler gfh;
    private com.baidu.tieba.ala.liveroom.turntable.a gfi;
    private long gfj;
    private boolean gfk;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gfd = viewGroup;
        this.dYR = i;
        this.gfe = i2;
    }

    public void a(String str, a.InterfaceC0574a interfaceC0574a) {
        yw();
        this.gfk = true;
        this.mLiveId = str;
        this.gfc = interfaceC0574a;
        bGt();
    }

    public void bB(int i, int i2) {
        if (i != this.dYR || i2 != this.gfe) {
            this.dYR = i;
            this.gfe = i2;
            if (this.gff != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gff.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dYR * 2;
                    layoutParams.bottomMargin = this.gfe;
                }
                this.gff.setLayoutParams(layoutParams);
            }
        }
    }

    public void lp(boolean z) {
        this.gfk = z;
        if (this.gff != null && this.gff.getParent() != null) {
            this.gff.setVisibility(z ? 0 : 8);
        }
    }

    public void yw() {
        this.mLiveId = "";
        btc();
        this.gfc = null;
        if (this.gfh != null) {
            this.gfh.removeCallbacksAndMessages(null);
        }
        if (this.gff != null) {
            this.gff.removeAllViews();
            if (this.gfd != null) {
                this.gfd.removeView(this.gff);
            }
            this.gff = null;
            this.gfg = null;
        }
    }

    public void release() {
        yw();
        if (this.gfi != null) {
            this.gfi.release();
            this.gfi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGt() {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar == null || axVar.aAL == null || axVar.aAL.aCw) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gfi == null) {
                    this.gfi = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gfi.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0573a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0573a
                        public void aS(int i, String str) {
                            super.aS(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gfi.CN(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bGu();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gfp == 1 && cVar.gfq - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gfg != null && cVar.gfr != null) {
                        this.gfg.setContent(cVar.gfr.giftName, cVar.gfr.gfs);
                    }
                } else {
                    btc();
                    bqE();
                }
                bGu();
            }
        }
    }

    private void bGu() {
        if (this.gfh == null) {
            this.gfh = new Handler();
        }
        this.gfh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bGt();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gfj != cVar.gfq) {
            btc();
            this.gfj = cVar.gfq;
            long j = cVar.gfq - cVar.currentTime;
            a(cVar.gfr, j);
            final long j2 = 100 + (j * 1000);
            this.foC = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.A(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bGv();
                }
            };
            this.foC.start();
        }
    }

    private void btc() {
        this.gfj = 0L;
        if (this.foC != null) {
            this.foC.cancel();
            this.foC = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gfd != null && !TextUtils.isEmpty(str)) {
            if (this.gfg == null) {
                this.gfg = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gff == null) {
                this.gff = new FrameLayout(this.mContext);
                this.gff.setBackgroundColor(0);
            }
            if (this.gff.indexOfChild(this.gfg) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gff.addView(this.gfg, layoutParams);
            }
            if (this.gfd.indexOfChild(this.gff) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dYR * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gfe;
                this.gfd.addView(this.gff, layoutParams2);
            }
            this.gff.setVisibility(this.gfk ? 0 : 8);
            this.gfg.setContent(str, aVar.gfs);
        }
        if (this.gfc != null) {
            this.gfc.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(long j, long j2) {
        if (this.gfc != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gfc.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bGv();
            }
        }
    }

    private void bqE() {
        if (this.gff != null) {
            this.gff.removeAllViews();
            if (this.gfd != null) {
                this.gfd.removeView(this.gff);
            }
            this.gff = null;
            this.gfg = null;
        }
        if (this.gfc != null) {
            this.gfc.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGv() {
        btc();
        bqE();
        if (this.gfh != null) {
            this.gfh.removeCallbacksAndMessages(null);
        }
        bGt();
    }
}
