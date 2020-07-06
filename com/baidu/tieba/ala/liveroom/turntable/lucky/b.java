package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bb;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes3.dex */
public class b implements a {
    private int egT;
    private CountDownTimer fzZ;
    private a.InterfaceC0583a gsj;
    private ViewGroup gsk;
    private int gsl;
    private FrameLayout gsm;
    private TurnTableLuckyBubbleView gsn;
    private Handler gso;
    private com.baidu.tieba.ala.liveroom.turntable.a gsp;
    private long gsq;
    private boolean gsr;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.gsk = viewGroup;
        this.egT = i;
        this.gsl = i2;
    }

    public void a(String str, a.InterfaceC0583a interfaceC0583a) {
        yW();
        this.gsr = true;
        this.mLiveId = str;
        this.gsj = interfaceC0583a;
        bJD();
    }

    public void bF(int i, int i2) {
        if (i != this.egT || i2 != this.gsl) {
            this.egT = i;
            this.gsl = i2;
            if (this.gsm != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.egT * 2;
                    layoutParams.bottomMargin = this.gsl;
                }
                this.gsm.setLayoutParams(layoutParams);
            }
        }
    }

    public void lx(boolean z) {
        this.gsr = z;
        if (this.gsm != null && this.gsm.getParent() != null) {
            this.gsm.setVisibility(z ? 0 : 8);
        }
    }

    public void yW() {
        this.mLiveId = "";
        bvZ();
        this.gsj = null;
        if (this.gso != null) {
            this.gso.removeCallbacksAndMessages(null);
        }
        if (this.gsm != null) {
            this.gsm.removeAllViews();
            if (this.gsk != null) {
                this.gsk.removeView(this.gsm);
            }
            this.gsm = null;
            this.gsn = null;
        }
    }

    public void release() {
        yW();
        if (this.gsp != null) {
            this.gsp.release();
            this.gsp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar == null || bbVar.aCW == null || bbVar.aCW.aEN) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.gsp == null) {
                    this.gsp = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.gsp.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0582a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0582a
                        public void aW(int i, String str) {
                            super.aW(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.gsp.Do(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            bJE();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.gsx == 1 && cVar.gsy - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.gsn != null && cVar.gsz != null) {
                        this.gsn.setContent(cVar.gsz.giftName, cVar.gsz.gsA);
                    }
                } else {
                    bvZ();
                    btE();
                }
                bJE();
            }
        }
    }

    private void bJE() {
        if (this.gso == null) {
            this.gso = new Handler();
        }
        this.gso.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.bJD();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.gsq != cVar.gsy) {
            bvZ();
            this.gsq = cVar.gsy;
            long j = cVar.gsy - cVar.currentTime;
            a(cVar.gsz, j);
            final long j2 = 100 + (j * 1000);
            this.fzZ = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.z(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bJF();
                }
            };
            this.fzZ.start();
        }
    }

    private void bvZ() {
        this.gsq = 0L;
        if (this.fzZ != null) {
            this.fzZ.cancel();
            this.fzZ = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.gsk != null && !TextUtils.isEmpty(str)) {
            if (this.gsn == null) {
                this.gsn = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.gsm == null) {
                this.gsm = new FrameLayout(this.mContext);
                this.gsm.setBackgroundColor(0);
            }
            if (this.gsm.indexOfChild(this.gsn) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.gsm.addView(this.gsn, layoutParams);
            }
            if (this.gsk.indexOfChild(this.gsm) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.egT * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.gsl;
                this.gsk.addView(this.gsm, layoutParams2);
            }
            this.gsm.setVisibility(this.gsr ? 0 : 8);
            this.gsn.setContent(str, aVar.gsA);
        }
        if (this.gsj != null) {
            this.gsj.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        if (this.gsj != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.gsj.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                bJF();
            }
        }
    }

    private void btE() {
        if (this.gsm != null) {
            this.gsm.removeAllViews();
            if (this.gsk != null) {
                this.gsk.removeView(this.gsm);
            }
            this.gsm = null;
            this.gsn = null;
        }
        if (this.gsj != null) {
            this.gsj.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJF() {
        bvZ();
        btE();
        if (this.gso != null) {
            this.gso.removeCallbacksAndMessages(null);
        }
        bJD();
    }
}
