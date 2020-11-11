package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bn;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int eZJ;
    private CountDownTimer gvV;
    private a.InterfaceC0686a htL;
    private ViewGroup htM;
    private FrameLayout htN;
    private TurnTableLuckyBubbleView htO;
    private Handler htP;
    private com.baidu.tieba.ala.liveroom.turntable.a htQ;
    private long htR;
    private boolean htS;
    private int mBottomMargin;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.htM = viewGroup;
        this.eZJ = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0686a interfaceC0686a) {
        Ht();
        this.htS = true;
        this.mLiveId = str;
        this.htL = interfaceC0686a;
        chv();
    }

    public void bU(int i, int i2) {
        if (i != this.eZJ || i2 != this.mBottomMargin) {
            this.eZJ = i;
            this.mBottomMargin = i2;
            if (this.htN != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.htN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eZJ * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.htN.setLayoutParams(layoutParams);
            }
        }
    }

    public void nL(boolean z) {
        this.htS = z;
        if (this.htN != null && this.htN.getParent() != null) {
            this.htN.setVisibility(z ? 0 : 8);
        }
    }

    public void Ht() {
        this.mLiveId = "";
        bRi();
        this.htL = null;
        if (this.htP != null) {
            this.htP.removeCallbacksAndMessages(null);
        }
        if (this.htN != null) {
            this.htN.removeAllViews();
            if (this.htM != null) {
                this.htM.removeView(this.htN);
            }
            this.htN = null;
            this.htO = null;
        }
    }

    public void release() {
        Ht();
        if (this.htQ != null) {
            this.htQ.release();
            this.htQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chv() {
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar == null || bnVar.aPA == null || bnVar.aPA.aRS) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.htQ == null) {
                    this.htQ = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.htQ.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0685a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0685a
                        public void bm(int i, String str) {
                            super.bm(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.htQ.Ix(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            chw();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.htY == 1 && cVar.htZ - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.htO != null && cVar.hua != null) {
                        this.htO.setContent(cVar.hua.giftName, cVar.hua.hub);
                    }
                } else {
                    bRi();
                    bOR();
                }
                chw();
            }
        }
    }

    private void chw() {
        if (this.htP == null) {
            this.htP = new Handler();
        }
        this.htP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.chv();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.htR != cVar.htZ) {
            bRi();
            this.htR = cVar.htZ;
            long j = cVar.htZ - cVar.currentTime;
            a(cVar.hua, j);
            final long j2 = 100 + (j * 1000);
            this.gvV = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.v(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.chx();
                }
            };
            this.gvV.start();
        }
    }

    private void bRi() {
        this.htR = 0L;
        if (this.gvV != null) {
            this.gvV.cancel();
            this.gvV = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.htM != null && !TextUtils.isEmpty(str)) {
            if (this.htO == null) {
                this.htO = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.htN == null) {
                this.htN = new FrameLayout(this.mContext);
                this.htN.setBackgroundColor(0);
            }
            if (this.htN.indexOfChild(this.htO) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.htN.addView(this.htO, layoutParams);
            }
            if (this.htM.indexOfChild(this.htN) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eZJ * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.htM.addView(this.htN, layoutParams2);
            }
            this.htN.setVisibility(this.htS ? 0 : 8);
            this.htO.setContent(str, aVar.hub);
        }
        if (this.htL != null) {
            this.htL.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, long j2) {
        if (this.htL != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.htL.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                chx();
            }
        }
    }

    private void bOR() {
        if (this.htN != null) {
            this.htN.removeAllViews();
            if (this.htM != null) {
                this.htM.removeView(this.htN);
            }
            this.htN = null;
            this.htO = null;
        }
        if (this.htL != null) {
            this.htL.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chx() {
        bRi();
        bOR();
        if (this.htP != null) {
            this.htP.removeCallbacksAndMessages(null);
        }
        chv();
    }
}
