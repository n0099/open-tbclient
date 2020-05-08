package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.as;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes3.dex */
public class b implements a {
    private int eoJ;
    private a.InterfaceC0524a fQr;
    private ViewGroup fQs;
    private int fQt;
    private FrameLayout fQu;
    private TurnTableLuckyBubbleView fQv;
    private Handler fQw;
    private com.baidu.tieba.ala.liveroom.turntable.a fQx;
    private long fQy;
    private boolean fQz;
    private CountDownTimer fba;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.fQs = viewGroup;
        this.eoJ = i;
        this.fQt = i2;
    }

    public void a(String str, a.InterfaceC0524a interfaceC0524a) {
        xi();
        this.fQz = true;
        this.mLiveId = str;
        this.fQr = interfaceC0524a;
        bAg();
    }

    public void bx(int i, int i2) {
        if (i != this.eoJ || i2 != this.fQt) {
            this.eoJ = i;
            this.fQt = i2;
            if (this.fQu != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eoJ * 2;
                    layoutParams.bottomMargin = this.fQt;
                }
                this.fQu.setLayoutParams(layoutParams);
            }
        }
    }

    public void kS(boolean z) {
        this.fQz = z;
        if (this.fQu != null && this.fQu.getParent() != null) {
            this.fQu.setVisibility(z ? 0 : 8);
        }
    }

    public void xi() {
        this.mLiveId = "";
        bnk();
        this.fQr = null;
        if (this.fQw != null) {
            this.fQw.removeCallbacksAndMessages(null);
        }
        if (this.fQu != null) {
            this.fQu.removeAllViews();
            if (this.fQs != null) {
                this.fQs.removeView(this.fQu);
            }
            this.fQu = null;
            this.fQv = null;
        }
    }

    public void release() {
        xi();
        if (this.fQx != null) {
            this.fQx.release();
            this.fQx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAg() {
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar == null || asVar.avD == null || asVar.avD.axh) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.fQx == null) {
                    this.fQx = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.fQx.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0523a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0523a
                        public void aN(int i, String str) {
                            super.aN(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.fQx.Bf(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bAh();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.fQE == 1 && cVar.fQF - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.fQv != null && cVar.fQG != null) {
                        this.fQv.setContent(cVar.fQG.giftName, cVar.fQG.fQH);
                    }
                } else {
                    bnk();
                    bli();
                }
                bAh();
            }
        }
    }

    private void bAh() {
        if (this.fQw == null) {
            this.fQw = new Handler();
        }
        this.fQw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bAg();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.fQy != cVar.fQF) {
            bnk();
            this.fQy = cVar.fQF;
            long j = cVar.fQF - cVar.currentTime;
            a(cVar.fQG, j);
            final long j2 = 100 + (j * 1000);
            this.fba = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bAi();
                }
            };
            this.fba.start();
        }
    }

    private void bnk() {
        this.fQy = 0L;
        if (this.fba != null) {
            this.fba.cancel();
            this.fba = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.fQs != null && !TextUtils.isEmpty(str)) {
            if (this.fQv == null) {
                this.fQv = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.fQu == null) {
                this.fQu = new FrameLayout(this.mContext);
                this.fQu.setBackgroundColor(0);
            }
            if (this.fQu.indexOfChild(this.fQv) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.fQu.addView(this.fQv, layoutParams);
            }
            if (this.fQs.indexOfChild(this.fQu) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eoJ * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.fQt;
                this.fQs.addView(this.fQu, layoutParams2);
            }
            this.fQu.setVisibility(this.fQz ? 0 : 8);
            this.fQv.setContent(str, aVar.fQH);
        }
        if (this.fQr != null) {
            this.fQr.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.fQr != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.fQr.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bAi();
            }
        }
    }

    private void bli() {
        if (this.fQu != null) {
            this.fQu.removeAllViews();
            if (this.fQs != null) {
                this.fQs.removeView(this.fQu);
            }
            this.fQu = null;
            this.fQv = null;
        }
        if (this.fQr != null) {
            this.fQr.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        bnk();
        bli();
        if (this.fQw != null) {
            this.fQw.removeCallbacksAndMessages(null);
        }
        bAg();
    }
}
