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
    private int dOt;
    private CountDownTimer eww;
    private a.InterfaceC0467a flp;
    private ViewGroup flq;
    private int flr;
    private FrameLayout fls;
    private TurnTableLuckyBubbleView flt;
    private Handler flu;
    private com.baidu.tieba.ala.liveroom.turntable.a flv;
    private long flw;
    private boolean flx;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.flq = viewGroup;
        this.dOt = i;
        this.flr = i2;
    }

    public void a(String str, a.InterfaceC0467a interfaceC0467a) {
        sL();
        this.flx = true;
        this.mLiveId = str;
        this.flp = interfaceC0467a;
        bqE();
    }

    public void br(int i, int i2) {
        if (i != this.dOt || i2 != this.flr) {
            this.dOt = i;
            this.flr = i2;
            if (this.fls != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fls.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dOt * 2;
                    layoutParams.bottomMargin = this.flr;
                }
                this.fls.setLayoutParams(layoutParams);
            }
        }
    }

    public void jM(boolean z) {
        this.flx = z;
        if (this.fls != null && this.fls.getParent() != null) {
            this.fls.setVisibility(z ? 0 : 8);
        }
    }

    public void sL() {
        this.mLiveId = "";
        bdV();
        this.flp = null;
        if (this.flu != null) {
            this.flu.removeCallbacksAndMessages(null);
        }
        if (this.fls != null) {
            this.fls.removeAllViews();
            if (this.flq != null) {
                this.flq.removeView(this.fls);
            }
            this.fls = null;
            this.flt = null;
        }
    }

    public void release() {
        sL();
        if (this.flv != null) {
            this.flv.release();
            this.flv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        ap apVar = com.baidu.live.v.a.zl().axD;
        if (apVar == null || apVar.acV == null || apVar.acV.aeB) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.flv == null) {
                    this.flv = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.flv.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
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
                this.flv.zw(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bqF();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.flC == 1 && cVar.flD - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.flt != null && cVar.flE != null) {
                        this.flt.setContent(cVar.flE.giftName, cVar.flE.flF);
                    }
                } else {
                    bdV();
                    bcp();
                }
                bqF();
            }
        }
    }

    private void bqF() {
        if (this.flu == null) {
            this.flu = new Handler();
        }
        this.flu.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bqE();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.flw != cVar.flD) {
            bdV();
            this.flw = cVar.flD;
            long j = cVar.flD - cVar.currentTime;
            a(cVar.flE, j);
            final long j2 = 100 + (j * 1000);
            this.eww = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bqG();
                }
            };
            this.eww.start();
        }
    }

    private void bdV() {
        this.flw = 0L;
        if (this.eww != null) {
            this.eww.cancel();
            this.eww = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.flq != null && !TextUtils.isEmpty(str)) {
            if (this.flt == null) {
                this.flt = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.fls == null) {
                this.fls = new FrameLayout(this.mContext);
                this.fls.setBackgroundColor(0);
            }
            if (this.fls.indexOfChild(this.flt) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.fls.addView(this.flt, layoutParams);
            }
            if (this.flq.indexOfChild(this.fls) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dOt * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.flr;
                this.flq.addView(this.fls, layoutParams2);
            }
            this.fls.setVisibility(this.flx ? 0 : 8);
            this.flt.setContent(str, aVar.flF);
        }
        if (this.flp != null) {
            this.flp.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.flp != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.flp.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bqG();
            }
        }
    }

    private void bcp() {
        if (this.fls != null) {
            this.fls.removeAllViews();
            if (this.flq != null) {
                this.flq.removeView(this.fls);
            }
            this.fls = null;
            this.flt = null;
        }
        if (this.flp != null) {
            this.flp.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        bdV();
        bcp();
        if (this.flu != null) {
            this.flu.removeCallbacksAndMessages(null);
        }
        bqE();
    }
}
