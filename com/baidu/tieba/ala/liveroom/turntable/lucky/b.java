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
    private int eoE;
    private a.InterfaceC0503a fQm;
    private ViewGroup fQn;
    private int fQo;
    private FrameLayout fQp;
    private TurnTableLuckyBubbleView fQq;
    private Handler fQr;
    private com.baidu.tieba.ala.liveroom.turntable.a fQs;
    private long fQt;
    private boolean fQu;
    private CountDownTimer faV;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.fQn = viewGroup;
        this.eoE = i;
        this.fQo = i2;
    }

    public void a(String str, a.InterfaceC0503a interfaceC0503a) {
        xj();
        this.fQu = true;
        this.mLiveId = str;
        this.fQm = interfaceC0503a;
        bAi();
    }

    public void bx(int i, int i2) {
        if (i != this.eoE || i2 != this.fQo) {
            this.eoE = i;
            this.fQo = i2;
            if (this.fQp != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eoE * 2;
                    layoutParams.bottomMargin = this.fQo;
                }
                this.fQp.setLayoutParams(layoutParams);
            }
        }
    }

    public void kS(boolean z) {
        this.fQu = z;
        if (this.fQp != null && this.fQp.getParent() != null) {
            this.fQp.setVisibility(z ? 0 : 8);
        }
    }

    public void xj() {
        this.mLiveId = "";
        bnm();
        this.fQm = null;
        if (this.fQr != null) {
            this.fQr.removeCallbacksAndMessages(null);
        }
        if (this.fQp != null) {
            this.fQp.removeAllViews();
            if (this.fQn != null) {
                this.fQn.removeView(this.fQp);
            }
            this.fQp = null;
            this.fQq = null;
        }
    }

    public void release() {
        xj();
        if (this.fQs != null) {
            this.fQs.release();
            this.fQs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar == null || asVar.avx == null || asVar.avx.axb) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.fQs == null) {
                    this.fQs = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.fQs.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0502a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0502a
                        public void aN(int i, String str) {
                            super.aN(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.fQs.Bc(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bAj();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.fQz == 1 && cVar.fQA - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.fQq != null && cVar.fQB != null) {
                        this.fQq.setContent(cVar.fQB.giftName, cVar.fQB.fQC);
                    }
                } else {
                    bnm();
                    blk();
                }
                bAj();
            }
        }
    }

    private void bAj() {
        if (this.fQr == null) {
            this.fQr = new Handler();
        }
        this.fQr.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bAi();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.fQt != cVar.fQA) {
            bnm();
            this.fQt = cVar.fQA;
            long j = cVar.fQA - cVar.currentTime;
            a(cVar.fQB, j);
            final long j2 = 100 + (j * 1000);
            this.faV = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bAk();
                }
            };
            this.faV.start();
        }
    }

    private void bnm() {
        this.fQt = 0L;
        if (this.faV != null) {
            this.faV.cancel();
            this.faV = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.fQn != null && !TextUtils.isEmpty(str)) {
            if (this.fQq == null) {
                this.fQq = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.fQp == null) {
                this.fQp = new FrameLayout(this.mContext);
                this.fQp.setBackgroundColor(0);
            }
            if (this.fQp.indexOfChild(this.fQq) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.fQp.addView(this.fQq, layoutParams);
            }
            if (this.fQn.indexOfChild(this.fQp) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eoE * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.fQo;
                this.fQn.addView(this.fQp, layoutParams2);
            }
            this.fQp.setVisibility(this.fQu ? 0 : 8);
            this.fQq.setContent(str, aVar.fQC);
        }
        if (this.fQm != null) {
            this.fQm.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.fQm != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.fQm.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bAk();
            }
        }
    }

    private void blk() {
        if (this.fQp != null) {
            this.fQp.removeAllViews();
            if (this.fQn != null) {
                this.fQn.removeView(this.fQp);
            }
            this.fQp = null;
            this.fQq = null;
        }
        if (this.fQm != null) {
            this.fQm.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAk() {
        bnm();
        blk();
        if (this.fQr != null) {
            this.fQr.removeCallbacksAndMessages(null);
        }
        bAi();
    }
}
