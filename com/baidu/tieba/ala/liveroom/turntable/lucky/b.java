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
    private int dOf;
    private CountDownTimer ewi;
    private a.InterfaceC0467a flb;
    private ViewGroup flc;
    private int fld;
    private FrameLayout fle;
    private TurnTableLuckyBubbleView flf;
    private Handler flg;
    private com.baidu.tieba.ala.liveroom.turntable.a flh;
    private long fli;
    private boolean flj;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.flc = viewGroup;
        this.dOf = i;
        this.fld = i2;
    }

    public void a(String str, a.InterfaceC0467a interfaceC0467a) {
        sL();
        this.flj = true;
        this.mLiveId = str;
        this.flb = interfaceC0467a;
        bqB();
    }

    public void br(int i, int i2) {
        if (i != this.dOf || i2 != this.fld) {
            this.dOf = i;
            this.fld = i2;
            if (this.fle != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fle.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dOf * 2;
                    layoutParams.bottomMargin = this.fld;
                }
                this.fle.setLayoutParams(layoutParams);
            }
        }
    }

    public void jM(boolean z) {
        this.flj = z;
        if (this.fle != null && this.fle.getParent() != null) {
            this.fle.setVisibility(z ? 0 : 8);
        }
    }

    public void sL() {
        this.mLiveId = "";
        bdS();
        this.flb = null;
        if (this.flg != null) {
            this.flg.removeCallbacksAndMessages(null);
        }
        if (this.fle != null) {
            this.fle.removeAllViews();
            if (this.flc != null) {
                this.flc.removeView(this.fle);
            }
            this.fle = null;
            this.flf = null;
        }
    }

    public void release() {
        sL();
        if (this.flh != null) {
            this.flh.release();
            this.flh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        ap apVar = com.baidu.live.v.a.zj().axB;
        if (apVar == null || apVar.acV == null || apVar.acV.aeB) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.flh == null) {
                    this.flh = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.flh.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
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
                this.flh.zv(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bqC();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.flo == 1 && cVar.flp - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.flf != null && cVar.flq != null) {
                        this.flf.setContent(cVar.flq.giftName, cVar.flq.flr);
                    }
                } else {
                    bdS();
                    bcm();
                }
                bqC();
            }
        }
    }

    private void bqC() {
        if (this.flg == null) {
            this.flg = new Handler();
        }
        this.flg.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bqB();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.fli != cVar.flp) {
            bdS();
            this.fli = cVar.flp;
            long j = cVar.flp - cVar.currentTime;
            a(cVar.flq, j);
            final long j2 = 100 + (j * 1000);
            this.ewi = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bqD();
                }
            };
            this.ewi.start();
        }
    }

    private void bdS() {
        this.fli = 0L;
        if (this.ewi != null) {
            this.ewi.cancel();
            this.ewi = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.flc != null && !TextUtils.isEmpty(str)) {
            if (this.flf == null) {
                this.flf = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.fle == null) {
                this.fle = new FrameLayout(this.mContext);
                this.fle.setBackgroundColor(0);
            }
            if (this.fle.indexOfChild(this.flf) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.fle.addView(this.flf, layoutParams);
            }
            if (this.flc.indexOfChild(this.fle) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dOf * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.fld;
                this.flc.addView(this.fle, layoutParams2);
            }
            this.fle.setVisibility(this.flj ? 0 : 8);
            this.flf.setContent(str, aVar.flr);
        }
        if (this.flb != null) {
            this.flb.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.flb != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.flb.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bqD();
            }
        }
    }

    private void bcm() {
        if (this.fle != null) {
            this.fle.removeAllViews();
            if (this.flc != null) {
                this.flc.removeView(this.fle);
            }
            this.fle = null;
            this.flf = null;
        }
        if (this.flb != null) {
            this.flb.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqD() {
        bdS();
        bcm();
        if (this.flg != null) {
            this.flg.removeCallbacksAndMessages(null);
        }
        bqB();
    }
}
