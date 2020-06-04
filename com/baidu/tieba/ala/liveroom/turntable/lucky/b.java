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
    private CountDownTimer foN;
    private a.InterfaceC0574a gfn;
    private ViewGroup gfo;
    private int gfp;
    private FrameLayout gfq;
    private TurnTableLuckyBubbleView gfr;
    private Handler gfs;
    private com.baidu.tieba.ala.liveroom.turntable.a gft;
    private long gfu;
    private boolean gfv;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gfo = viewGroup;
        this.dYR = i;
        this.gfp = i2;
    }

    public void a(String str, a.InterfaceC0574a interfaceC0574a) {
        yw();
        this.gfv = true;
        this.mLiveId = str;
        this.gfn = interfaceC0574a;
        bGv();
    }

    public void bB(int i, int i2) {
        if (i != this.dYR || i2 != this.gfp) {
            this.dYR = i;
            this.gfp = i2;
            if (this.gfq != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dYR * 2;
                    layoutParams.bottomMargin = this.gfp;
                }
                this.gfq.setLayoutParams(layoutParams);
            }
        }
    }

    public void lp(boolean z) {
        this.gfv = z;
        if (this.gfq != null && this.gfq.getParent() != null) {
            this.gfq.setVisibility(z ? 0 : 8);
        }
    }

    public void yw() {
        this.mLiveId = "";
        bte();
        this.gfn = null;
        if (this.gfs != null) {
            this.gfs.removeCallbacksAndMessages(null);
        }
        if (this.gfq != null) {
            this.gfq.removeAllViews();
            if (this.gfo != null) {
                this.gfo.removeView(this.gfq);
            }
            this.gfq = null;
            this.gfr = null;
        }
    }

    public void release() {
        yw();
        if (this.gft != null) {
            this.gft.release();
            this.gft = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGv() {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar == null || axVar.aAL == null || axVar.aAL.aCw) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gft == null) {
                    this.gft = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gft.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
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
                this.gft.CN(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bGw();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gfA == 1 && cVar.gfB - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gfr != null && cVar.gfC != null) {
                        this.gfr.setContent(cVar.gfC.giftName, cVar.gfC.gfD);
                    }
                } else {
                    bte();
                    bqG();
                }
                bGw();
            }
        }
    }

    private void bGw() {
        if (this.gfs == null) {
            this.gfs = new Handler();
        }
        this.gfs.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bGv();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gfu != cVar.gfB) {
            bte();
            this.gfu = cVar.gfB;
            long j = cVar.gfB - cVar.currentTime;
            a(cVar.gfC, j);
            final long j2 = 100 + (j * 1000);
            this.foN = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.A(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bGx();
                }
            };
            this.foN.start();
        }
    }

    private void bte() {
        this.gfu = 0L;
        if (this.foN != null) {
            this.foN.cancel();
            this.foN = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gfo != null && !TextUtils.isEmpty(str)) {
            if (this.gfr == null) {
                this.gfr = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gfq == null) {
                this.gfq = new FrameLayout(this.mContext);
                this.gfq.setBackgroundColor(0);
            }
            if (this.gfq.indexOfChild(this.gfr) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gfq.addView(this.gfr, layoutParams);
            }
            if (this.gfo.indexOfChild(this.gfq) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dYR * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gfp;
                this.gfo.addView(this.gfq, layoutParams2);
            }
            this.gfq.setVisibility(this.gfv ? 0 : 8);
            this.gfr.setContent(str, aVar.gfD);
        }
        if (this.gfn != null) {
            this.gfn.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(long j, long j2) {
        if (this.gfn != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gfn.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bGx();
            }
        }
    }

    private void bqG() {
        if (this.gfq != null) {
            this.gfq.removeAllViews();
            if (this.gfo != null) {
                this.gfo.removeView(this.gfq);
            }
            this.gfq = null;
            this.gfr = null;
        }
        if (this.gfn != null) {
            this.gfn.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGx() {
        bte();
        bqG();
        if (this.gfs != null) {
            this.gfs.removeCallbacksAndMessages(null);
        }
        bGv();
    }
}
