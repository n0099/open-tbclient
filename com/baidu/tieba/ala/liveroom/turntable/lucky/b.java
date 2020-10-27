package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bm;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int eTU;
    private CountDownTimer gqh;
    private a.InterfaceC0672a hnN;
    private ViewGroup hnO;
    private FrameLayout hnP;
    private TurnTableLuckyBubbleView hnQ;
    private Handler hnR;
    private com.baidu.tieba.ala.liveroom.turntable.a hnS;
    private long hnT;
    private boolean hnU;
    private int mBottomMargin;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hnO = viewGroup;
        this.eTU = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0672a interfaceC0672a) {
        GS();
        this.hnU = true;
        this.mLiveId = str;
        this.hnN = interfaceC0672a;
        ceS();
    }

    public void bS(int i, int i2) {
        if (i != this.eTU || i2 != this.mBottomMargin) {
            this.eTU = i;
            this.mBottomMargin = i2;
            if (this.hnP != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hnP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eTU * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.hnP.setLayoutParams(layoutParams);
            }
        }
    }

    public void nC(boolean z) {
        this.hnU = z;
        if (this.hnP != null && this.hnP.getParent() != null) {
            this.hnP.setVisibility(z ? 0 : 8);
        }
    }

    public void GS() {
        this.mLiveId = "";
        bOI();
        this.hnN = null;
        if (this.hnR != null) {
            this.hnR.removeCallbacksAndMessages(null);
        }
        if (this.hnP != null) {
            this.hnP.removeAllViews();
            if (this.hnO != null) {
                this.hnO.removeView(this.hnP);
            }
            this.hnP = null;
            this.hnQ = null;
        }
    }

    public void release() {
        GS();
        if (this.hnS != null) {
            this.hnS.release();
            this.hnS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceS() {
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar == null || bmVar.aOD == null || bmVar.aOD.aQQ) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hnS == null) {
                    this.hnS = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hnS.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0671a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0671a
                        public void bi(int i, String str) {
                            super.bi(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hnS.Ig(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ceT();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hoa == 1 && cVar.hob - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.hnQ != null && cVar.hoc != null) {
                        this.hnQ.setContent(cVar.hoc.giftName, cVar.hoc.hod);
                    }
                } else {
                    bOI();
                    bMr();
                }
                ceT();
            }
        }
    }

    private void ceT() {
        if (this.hnR == null) {
            this.hnR = new Handler();
        }
        this.hnR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ceS();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.hnT != cVar.hob) {
            bOI();
            this.hnT = cVar.hob;
            long j = cVar.hob - cVar.currentTime;
            a(cVar.hoc, j);
            final long j2 = 100 + (j * 1000);
            this.gqh = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.u(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ceU();
                }
            };
            this.gqh.start();
        }
    }

    private void bOI() {
        this.hnT = 0L;
        if (this.gqh != null) {
            this.gqh.cancel();
            this.gqh = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hnO != null && !TextUtils.isEmpty(str)) {
            if (this.hnQ == null) {
                this.hnQ = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hnP == null) {
                this.hnP = new FrameLayout(this.mContext);
                this.hnP.setBackgroundColor(0);
            }
            if (this.hnP.indexOfChild(this.hnQ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hnP.addView(this.hnQ, layoutParams);
            }
            if (this.hnO.indexOfChild(this.hnP) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eTU * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.hnO.addView(this.hnP, layoutParams2);
            }
            this.hnP.setVisibility(this.hnU ? 0 : 8);
            this.hnQ.setContent(str, aVar.hod);
        }
        if (this.hnN != null) {
            this.hnN.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        if (this.hnN != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hnN.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ceU();
            }
        }
    }

    private void bMr() {
        if (this.hnP != null) {
            this.hnP.removeAllViews();
            if (this.hnO != null) {
                this.hnO.removeView(this.hnP);
            }
            this.hnP = null;
            this.hnQ = null;
        }
        if (this.hnN != null) {
            this.hnN.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        bOI();
        bMr();
        if (this.hnR != null) {
            this.hnR.removeCallbacksAndMessages(null);
        }
        ceS();
    }
}
