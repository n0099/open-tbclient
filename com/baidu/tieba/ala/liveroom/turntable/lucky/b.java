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
    private int dOg;
    private CountDownTimer ewj;
    private a.InterfaceC0467a flc;
    private ViewGroup fld;
    private int fle;
    private FrameLayout flf;
    private TurnTableLuckyBubbleView flg;
    private Handler flh;
    private com.baidu.tieba.ala.liveroom.turntable.a fli;
    private long flj;
    private boolean flk;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.fld = viewGroup;
        this.dOg = i;
        this.fle = i2;
    }

    public void a(String str, a.InterfaceC0467a interfaceC0467a) {
        sL();
        this.flk = true;
        this.mLiveId = str;
        this.flc = interfaceC0467a;
        bqD();
    }

    public void br(int i, int i2) {
        if (i != this.dOg || i2 != this.fle) {
            this.dOg = i;
            this.fle = i2;
            if (this.flf != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.flf.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dOg * 2;
                    layoutParams.bottomMargin = this.fle;
                }
                this.flf.setLayoutParams(layoutParams);
            }
        }
    }

    public void jM(boolean z) {
        this.flk = z;
        if (this.flf != null && this.flf.getParent() != null) {
            this.flf.setVisibility(z ? 0 : 8);
        }
    }

    public void sL() {
        this.mLiveId = "";
        bdU();
        this.flc = null;
        if (this.flh != null) {
            this.flh.removeCallbacksAndMessages(null);
        }
        if (this.flf != null) {
            this.flf.removeAllViews();
            if (this.fld != null) {
                this.fld.removeView(this.flf);
            }
            this.flf = null;
            this.flg = null;
        }
    }

    public void release() {
        sL();
        if (this.fli != null) {
            this.fli.release();
            this.fli = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqD() {
        ap apVar = com.baidu.live.v.a.zl().axC;
        if (apVar == null || apVar.acV == null || apVar.acV.aeB) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.fli == null) {
                    this.fli = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.fli.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
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
                this.fli.zv(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bqE();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.flp == 1 && cVar.flq - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.flg != null && cVar.flr != null) {
                        this.flg.setContent(cVar.flr.giftName, cVar.flr.fls);
                    }
                } else {
                    bdU();
                    bco();
                }
                bqE();
            }
        }
    }

    private void bqE() {
        if (this.flh == null) {
            this.flh = new Handler();
        }
        this.flh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bqD();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.flj != cVar.flq) {
            bdU();
            this.flj = cVar.flq;
            long j = cVar.flq - cVar.currentTime;
            a(cVar.flr, j);
            final long j2 = 100 + (j * 1000);
            this.ewj = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bqF();
                }
            };
            this.ewj.start();
        }
    }

    private void bdU() {
        this.flj = 0L;
        if (this.ewj != null) {
            this.ewj.cancel();
            this.ewj = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.fld != null && !TextUtils.isEmpty(str)) {
            if (this.flg == null) {
                this.flg = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.flf == null) {
                this.flf = new FrameLayout(this.mContext);
                this.flf.setBackgroundColor(0);
            }
            if (this.flf.indexOfChild(this.flg) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.flf.addView(this.flg, layoutParams);
            }
            if (this.fld.indexOfChild(this.flf) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dOg * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.fle;
                this.fld.addView(this.flf, layoutParams2);
            }
            this.flf.setVisibility(this.flk ? 0 : 8);
            this.flg.setContent(str, aVar.fls);
        }
        if (this.flc != null) {
            this.flc.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.flc != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.flc.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bqF();
            }
        }
    }

    private void bco() {
        if (this.flf != null) {
            this.flf.removeAllViews();
            if (this.fld != null) {
                this.fld.removeView(this.flf);
            }
            this.flf = null;
            this.flg = null;
        }
        if (this.flc != null) {
            this.flc.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        bdU();
        bco();
        if (this.flh != null) {
            this.flh.removeCallbacksAndMessages(null);
        }
        bqD();
    }
}
