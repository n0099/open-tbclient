package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes7.dex */
public class b implements a {
    private int exg;
    private CountDownTimer fQx;
    private a.InterfaceC0641a gJF;
    private ViewGroup gJG;
    private int gJH;
    private FrameLayout gJI;
    private TurnTableLuckyBubbleView gJJ;
    private Handler gJK;
    private com.baidu.tieba.ala.liveroom.turntable.a gJL;
    private long gJM;
    private boolean gJN;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gJG = viewGroup;
        this.exg = i;
        this.gJH = i2;
    }

    public void a(String str, a.InterfaceC0641a interfaceC0641a) {
        Fb();
        this.gJN = true;
        this.mLiveId = str;
        this.gJF = interfaceC0641a;
        bWG();
    }

    public void bQ(int i, int i2) {
        if (i != this.exg || i2 != this.gJH) {
            this.exg = i;
            this.gJH = i2;
            if (this.gJI != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.exg * 2;
                    layoutParams.bottomMargin = this.gJH;
                }
                this.gJI.setLayoutParams(layoutParams);
            }
        }
    }

    public void mD(boolean z) {
        this.gJN = z;
        if (this.gJI != null && this.gJI.getParent() != null) {
            this.gJI.setVisibility(z ? 0 : 8);
        }
    }

    public void Fb() {
        this.mLiveId = "";
        bIn();
        this.gJF = null;
        if (this.gJK != null) {
            this.gJK.removeCallbacksAndMessages(null);
        }
        if (this.gJI != null) {
            this.gJI.removeAllViews();
            if (this.gJG != null) {
                this.gJG.removeView(this.gJI);
            }
            this.gJI = null;
            this.gJJ = null;
        }
    }

    public void release() {
        Fb();
        if (this.gJL != null) {
            this.gJL.release();
            this.gJL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWG() {
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar == null || beVar.aJB == null || beVar.aJB.aLr) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gJL == null) {
                    this.gJL = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gJL.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0640a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0640a
                        public void aW(int i, String str) {
                            super.aW(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gJL.Gz(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bWH();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gJT == 1 && cVar.gJU - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gJJ != null && cVar.gJV != null) {
                        this.gJJ.setContent(cVar.gJV.giftName, cVar.gJV.gJW);
                    }
                } else {
                    bIn();
                    bFM();
                }
                bWH();
            }
        }
    }

    private void bWH() {
        if (this.gJK == null) {
            this.gJK = new Handler();
        }
        this.gJK.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bWG();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gJM != cVar.gJU) {
            bIn();
            this.gJM = cVar.gJU;
            long j = cVar.gJU - cVar.currentTime;
            a(cVar.gJV, j);
            final long j2 = 100 + (j * 1000);
            this.fQx = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bWI();
                }
            };
            this.fQx.start();
        }
    }

    private void bIn() {
        this.gJM = 0L;
        if (this.fQx != null) {
            this.fQx.cancel();
            this.fQx = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gJG != null && !TextUtils.isEmpty(str)) {
            if (this.gJJ == null) {
                this.gJJ = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gJI == null) {
                this.gJI = new FrameLayout(this.mContext);
                this.gJI.setBackgroundColor(0);
            }
            if (this.gJI.indexOfChild(this.gJJ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gJI.addView(this.gJJ, layoutParams);
            }
            if (this.gJG.indexOfChild(this.gJI) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.exg * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gJH;
                this.gJG.addView(this.gJI, layoutParams2);
            }
            this.gJI.setVisibility(this.gJN ? 0 : 8);
            this.gJJ.setContent(str, aVar.gJW);
        }
        if (this.gJF != null) {
            this.gJF.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.gJF != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gJF.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bWI();
            }
        }
    }

    private void bFM() {
        if (this.gJI != null) {
            this.gJI.removeAllViews();
            if (this.gJG != null) {
                this.gJG.removeView(this.gJI);
            }
            this.gJI = null;
            this.gJJ = null;
        }
        if (this.gJF != null) {
            this.gJF.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWI() {
        bIn();
        bFM();
        if (this.gJK != null) {
            this.gJK.removeCallbacksAndMessages(null);
        }
        bWG();
    }
}
