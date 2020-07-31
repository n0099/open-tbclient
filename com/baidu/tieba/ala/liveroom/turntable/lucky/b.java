package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bc;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int enc;
    private CountDownTimer fFg;
    private a.InterfaceC0592a gxG;
    private ViewGroup gxH;
    private int gxI;
    private FrameLayout gxJ;
    private TurnTableLuckyBubbleView gxK;
    private Handler gxL;
    private com.baidu.tieba.ala.liveroom.turntable.a gxM;
    private long gxN;
    private boolean gxO;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gxH = viewGroup;
        this.enc = i;
        this.gxI = i2;
    }

    public void a(String str, a.InterfaceC0592a interfaceC0592a) {
        zy();
        this.gxO = true;
        this.mLiveId = str;
        this.gxG = interfaceC0592a;
        bMJ();
    }

    public void bI(int i, int i2) {
        if (i != this.enc || i2 != this.gxI) {
            this.enc = i;
            this.gxI = i2;
            if (this.gxJ != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gxJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.enc * 2;
                    layoutParams.bottomMargin = this.gxI;
                }
                this.gxJ.setLayoutParams(layoutParams);
            }
        }
    }

    public void mb(boolean z) {
        this.gxO = z;
        if (this.gxJ != null && this.gxJ.getParent() != null) {
            this.gxJ.setVisibility(z ? 0 : 8);
        }
    }

    public void zy() {
        this.mLiveId = "";
        bzk();
        this.gxG = null;
        if (this.gxL != null) {
            this.gxL.removeCallbacksAndMessages(null);
        }
        if (this.gxJ != null) {
            this.gxJ.removeAllViews();
            if (this.gxH != null) {
                this.gxH.removeView(this.gxJ);
            }
            this.gxJ = null;
            this.gxK = null;
        }
    }

    public void release() {
        zy();
        if (this.gxM != null) {
            this.gxM.release();
            this.gxM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMJ() {
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar == null || bcVar.aEr == null || bcVar.aEr.aGh) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gxM == null) {
                    this.gxM = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gxM.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0591a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0591a
                        public void aY(int i, String str) {
                            super.aY(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gxM.Ea(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bMK();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gxU == 1 && cVar.gxV - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gxK != null && cVar.gxW != null) {
                        this.gxK.setContent(cVar.gxW.giftName, cVar.gxW.gxX);
                    }
                } else {
                    bzk();
                    bwN();
                }
                bMK();
            }
        }
    }

    private void bMK() {
        if (this.gxL == null) {
            this.gxL = new Handler();
        }
        this.gxL.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bMJ();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gxN != cVar.gxV) {
            bzk();
            this.gxN = cVar.gxV;
            long j = cVar.gxV - cVar.currentTime;
            a(cVar.gxW, j);
            final long j2 = 100 + (j * 1000);
            this.fFg = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bML();
                }
            };
            this.fFg.start();
        }
    }

    private void bzk() {
        this.gxN = 0L;
        if (this.fFg != null) {
            this.fFg.cancel();
            this.fFg = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gxH != null && !TextUtils.isEmpty(str)) {
            if (this.gxK == null) {
                this.gxK = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gxJ == null) {
                this.gxJ = new FrameLayout(this.mContext);
                this.gxJ.setBackgroundColor(0);
            }
            if (this.gxJ.indexOfChild(this.gxK) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gxJ.addView(this.gxK, layoutParams);
            }
            if (this.gxH.indexOfChild(this.gxJ) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.enc * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gxI;
                this.gxH.addView(this.gxJ, layoutParams2);
            }
            this.gxJ.setVisibility(this.gxO ? 0 : 8);
            this.gxK.setContent(str, aVar.gxX);
        }
        if (this.gxG != null) {
            this.gxG.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.gxG != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gxG.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bML();
            }
        }
    }

    private void bwN() {
        if (this.gxJ != null) {
            this.gxJ.removeAllViews();
            if (this.gxH != null) {
                this.gxH.removeView(this.gxJ);
            }
            this.gxJ = null;
            this.gxK = null;
        }
        if (this.gxG != null) {
            this.gxG.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bML() {
        bzk();
        bwN();
        if (this.gxL != null) {
            this.gxL.removeCallbacksAndMessages(null);
        }
        bMJ();
    }
}
