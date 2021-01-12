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
/* loaded from: classes10.dex */
public class b implements a {
    private int fln;
    private CountDownTimer gLs;
    private a.InterfaceC0674a hKs;
    private ViewGroup hKt;
    private int hKu;
    private FrameLayout hKv;
    private TurnTableLuckyBubbleView hKw;
    private Handler hKx;
    private com.baidu.tieba.ala.liveroom.turntable.a hKy;
    private boolean hKz;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hKt = viewGroup;
        this.fln = i;
        this.hKu = i2;
    }

    public void a(String str, a.InterfaceC0674a interfaceC0674a) {
        Ei();
        this.hKz = true;
        this.mLiveId = str;
        this.hKs = interfaceC0674a;
        cjJ();
    }

    public void bX(int i, int i2) {
        if (i != this.fln || i2 != this.hKu) {
            this.fln = i;
            this.hKu = i2;
            if (this.hKv != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fln * 2;
                    layoutParams.bottomMargin = this.hKu;
                }
                this.hKv.setLayoutParams(layoutParams);
            }
        }
    }

    public void oC(boolean z) {
        this.hKz = z;
        if (this.hKv != null && this.hKv.getParent() != null) {
            this.hKv.setVisibility(z ? 0 : 8);
        }
    }

    public void Ei() {
        this.mLiveId = "";
        bSZ();
        this.hKs = null;
        if (this.hKx != null) {
            this.hKx.removeCallbacksAndMessages(null);
        }
        if (this.hKv != null) {
            this.hKv.removeAllViews();
            if (this.hKt != null) {
                this.hKt.removeView(this.hKv);
            }
            this.hKv = null;
            this.hKw = null;
        }
    }

    public void release() {
        Ei();
        if (this.hKy != null) {
            this.hKy.release();
            this.hKy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjJ() {
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar == null || bqVar.aMR == null || bqVar.aMR.aPu) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hKy == null) {
                    this.hKy = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hKy.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0673a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0673a
                        public void bn(int i, String str) {
                            super.bn(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hKy.Hx(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            cjK();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hKF == 1 && cVar.expiredTime - cVar.aFE > 0) {
                    a(cVar);
                    if (this.hKw != null && cVar.hKG != null) {
                        this.hKw.setContent(cVar.hKG.giftName, cVar.hKG.hKH);
                    }
                } else {
                    bSZ();
                    bQH();
                }
                cjK();
            }
        }
    }

    private void cjK() {
        if (this.hKx == null) {
            this.hKx = new Handler();
        }
        this.hKx.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjJ();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.expiredTime) {
            bSZ();
            this.mExpiredTime = cVar.expiredTime;
            long j = cVar.expiredTime - cVar.aFE;
            a(cVar.hKG, j);
            final long j2 = 100 + (j * 1000);
            this.gLs = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.cjL();
                }
            };
            this.gLs.start();
        }
    }

    private void bSZ() {
        this.mExpiredTime = 0L;
        if (this.gLs != null) {
            this.gLs.cancel();
            this.gLs = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hKt != null && !TextUtils.isEmpty(str)) {
            if (this.hKw == null) {
                this.hKw = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hKv == null) {
                this.hKv = new FrameLayout(this.mContext);
                this.hKv.setBackgroundColor(0);
            }
            if (this.hKv.indexOfChild(this.hKw) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hKv.addView(this.hKw, layoutParams);
            }
            if (this.hKt.indexOfChild(this.hKv) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fln * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.hKu;
                this.hKt.addView(this.hKv, layoutParams2);
            }
            this.hKv.setVisibility(this.hKz ? 0 : 8);
            this.hKw.setContent(str, aVar.hKH);
        }
        if (this.hKs != null) {
            this.hKs.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.hKs != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hKs.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                cjL();
            }
        }
    }

    private void bQH() {
        if (this.hKv != null) {
            this.hKv.removeAllViews();
            if (this.hKt != null) {
                this.hKt.removeView(this.hKv);
            }
            this.hKv = null;
            this.hKw = null;
        }
        if (this.hKs != null) {
            this.hKs.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjL() {
        bSZ();
        bQH();
        if (this.hKx != null) {
            this.hKx.removeCallbacksAndMessages(null);
        }
        cjJ();
    }
}
