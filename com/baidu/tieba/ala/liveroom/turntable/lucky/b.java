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
    private int eYR;
    private CountDownTimer gvC;
    private a.InterfaceC0686a hts;
    private ViewGroup htt;
    private FrameLayout htu;
    private TurnTableLuckyBubbleView htv;
    private Handler htw;
    private com.baidu.tieba.ala.liveroom.turntable.a htx;
    private long hty;
    private boolean htz;
    private int mBottomMargin;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.htt = viewGroup;
        this.eYR = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0686a interfaceC0686a) {
        GK();
        this.htz = true;
        this.mLiveId = str;
        this.hts = interfaceC0686a;
        cgO();
    }

    public void bU(int i, int i2) {
        if (i != this.eYR || i2 != this.mBottomMargin) {
            this.eYR = i;
            this.mBottomMargin = i2;
            if (this.htu != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.htu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eYR * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.htu.setLayoutParams(layoutParams);
            }
        }
    }

    public void nM(boolean z) {
        this.htz = z;
        if (this.htu != null && this.htu.getParent() != null) {
            this.htu.setVisibility(z ? 0 : 8);
        }
    }

    public void GK() {
        this.mLiveId = "";
        bQB();
        this.hts = null;
        if (this.htw != null) {
            this.htw.removeCallbacksAndMessages(null);
        }
        if (this.htu != null) {
            this.htu.removeAllViews();
            if (this.htt != null) {
                this.htt.removeView(this.htu);
            }
            this.htu = null;
            this.htv = null;
        }
    }

    public void release() {
        GK();
        if (this.htx != null) {
            this.htx.release();
            this.htx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgO() {
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar == null || bnVar.aNP == null || bnVar.aNP.aQh) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.htx == null) {
                    this.htx = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.htx.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0685a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0685a
                        public void bk(int i, String str) {
                            super.bk(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.htx.HY(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            cgP();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.htF == 1 && cVar.htG - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.htv != null && cVar.htH != null) {
                        this.htv.setContent(cVar.htH.giftName, cVar.htH.htI);
                    }
                } else {
                    bQB();
                    bOk();
                }
                cgP();
            }
        }
    }

    private void cgP() {
        if (this.htw == null) {
            this.htw = new Handler();
        }
        this.htw.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cgO();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.hty != cVar.htG) {
            bQB();
            this.hty = cVar.htG;
            long j = cVar.htG - cVar.currentTime;
            a(cVar.htH, j);
            final long j2 = 100 + (j * 1000);
            this.gvC = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.v(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.cgQ();
                }
            };
            this.gvC.start();
        }
    }

    private void bQB() {
        this.hty = 0L;
        if (this.gvC != null) {
            this.gvC.cancel();
            this.gvC = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.htt != null && !TextUtils.isEmpty(str)) {
            if (this.htv == null) {
                this.htv = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.htu == null) {
                this.htu = new FrameLayout(this.mContext);
                this.htu.setBackgroundColor(0);
            }
            if (this.htu.indexOfChild(this.htv) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.htu.addView(this.htv, layoutParams);
            }
            if (this.htt.indexOfChild(this.htu) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eYR * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.htt.addView(this.htu, layoutParams2);
            }
            this.htu.setVisibility(this.htz ? 0 : 8);
            this.htv.setContent(str, aVar.htI);
        }
        if (this.hts != null) {
            this.hts.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, long j2) {
        if (this.hts != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hts.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                cgQ();
            }
        }
    }

    private void bOk() {
        if (this.htu != null) {
            this.htu.removeAllViews();
            if (this.htt != null) {
                this.htt.removeView(this.htu);
            }
            this.htu = null;
            this.htv = null;
        }
        if (this.hts != null) {
            this.hts.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgQ() {
        bQB();
        bOk();
        if (this.htw != null) {
            this.htw.removeCallbacksAndMessages(null);
        }
        cgO();
    }
}
