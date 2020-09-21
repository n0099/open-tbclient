package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bj;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int ezr;
    private CountDownTimer fTL;
    private a.InterfaceC0638a gNa;
    private ViewGroup gNb;
    private FrameLayout gNc;
    private TurnTableLuckyBubbleView gNd;
    private Handler gNe;
    private com.baidu.tieba.ala.liveroom.turntable.a gNf;
    private long gNg;
    private boolean gNh;
    private int mBottomMargin;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gNb = viewGroup;
        this.ezr = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0638a interfaceC0638a) {
        FB();
        this.gNh = true;
        this.mLiveId = str;
        this.gNa = interfaceC0638a;
        bYo();
    }

    public void bQ(int i, int i2) {
        if (i != this.ezr || i2 != this.mBottomMargin) {
            this.ezr = i;
            this.mBottomMargin = i2;
            if (this.gNc != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gNc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.ezr * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.gNc.setLayoutParams(layoutParams);
            }
        }
    }

    public void mJ(boolean z) {
        this.gNh = z;
        if (this.gNc != null && this.gNc.getParent() != null) {
            this.gNc.setVisibility(z ? 0 : 8);
        }
    }

    public void FB() {
        this.mLiveId = "";
        bJw();
        this.gNa = null;
        if (this.gNe != null) {
            this.gNe.removeCallbacksAndMessages(null);
        }
        if (this.gNc != null) {
            this.gNc.removeAllViews();
            if (this.gNb != null) {
                this.gNb.removeView(this.gNc);
            }
            this.gNc = null;
            this.gNd = null;
        }
    }

    public void release() {
        FB();
        if (this.gNf != null) {
            this.gNf.release();
            this.gNf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYo() {
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar == null || bjVar.aKT == null || bjVar.aKT.aNb) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gNf == null) {
                    this.gNf = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gNf.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0637a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0637a
                        public void aW(int i, String str) {
                            super.aW(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gNf.GT(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bYp();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gNn == 1 && cVar.gNo - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gNd != null && cVar.gNp != null) {
                        this.gNd.setContent(cVar.gNp.giftName, cVar.gNp.gNq);
                    }
                } else {
                    bJw();
                    bHd();
                }
                bYp();
            }
        }
    }

    private void bYp() {
        if (this.gNe == null) {
            this.gNe = new Handler();
        }
        this.gNe.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bYo();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gNg != cVar.gNo) {
            bJw();
            this.gNg = cVar.gNo;
            long j = cVar.gNo - cVar.currentTime;
            a(cVar.gNp, j);
            final long j2 = 100 + (j * 1000);
            this.fTL = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.u(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bYq();
                }
            };
            this.fTL.start();
        }
    }

    private void bJw() {
        this.gNg = 0L;
        if (this.fTL != null) {
            this.fTL.cancel();
            this.fTL = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gNb != null && !TextUtils.isEmpty(str)) {
            if (this.gNd == null) {
                this.gNd = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gNc == null) {
                this.gNc = new FrameLayout(this.mContext);
                this.gNc.setBackgroundColor(0);
            }
            if (this.gNc.indexOfChild(this.gNd) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gNc.addView(this.gNd, layoutParams);
            }
            if (this.gNb.indexOfChild(this.gNc) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.ezr * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.gNb.addView(this.gNc, layoutParams2);
            }
            this.gNc.setVisibility(this.gNh ? 0 : 8);
            this.gNd.setContent(str, aVar.gNq);
        }
        if (this.gNa != null) {
            this.gNa.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        if (this.gNa != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gNa.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bYq();
            }
        }
    }

    private void bHd() {
        if (this.gNc != null) {
            this.gNc.removeAllViews();
            if (this.gNb != null) {
                this.gNb.removeView(this.gNc);
            }
            this.gNc = null;
            this.gNd = null;
        }
        if (this.gNa != null) {
            this.gNa.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYq() {
        bJw();
        bHd();
        if (this.gNe != null) {
            this.gNe.removeCallbacksAndMessages(null);
        }
        bYo();
    }
}
