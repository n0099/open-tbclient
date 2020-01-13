package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.ao;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes2.dex */
public class b implements a {
    private int dKa;
    private CountDownTimer erY;
    private a.InterfaceC0459a fhV;
    private ViewGroup fhW;
    private int fhX;
    private FrameLayout fhY;
    private TurnTableLuckyBubbleView fhZ;
    private Handler fia;
    private com.baidu.tieba.ala.liveroom.turntable.a fib;
    private long fic;
    private boolean fie;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.fhW = viewGroup;
        this.dKa = i;
        this.fhX = i2;
    }

    public void a(String str, a.InterfaceC0459a interfaceC0459a) {
        tz();
        this.fie = true;
        this.mLiveId = str;
        this.fhV = interfaceC0459a;
        boV();
    }

    public void bq(int i, int i2) {
        if (i != this.dKa || i2 != this.fhX) {
            this.dKa = i;
            this.fhX = i2;
            if (this.fhY != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.dKa * 2;
                    layoutParams.bottomMargin = this.fhX;
                }
                this.fhY.setLayoutParams(layoutParams);
            }
        }
    }

    public void jK(boolean z) {
        this.fie = z;
        if (this.fhY != null && this.fhY.getParent() != null) {
            this.fhY.setVisibility(z ? 0 : 8);
        }
    }

    public void tz() {
        this.mLiveId = "";
        bbD();
        this.fhV = null;
        if (this.fia != null) {
            this.fia.removeCallbacksAndMessages(null);
        }
        if (this.fhY != null) {
            this.fhY.removeAllViews();
            if (this.fhW != null) {
                this.fhW.removeView(this.fhY);
            }
            this.fhY = null;
            this.fhZ = null;
        }
    }

    public void release() {
        tz();
        if (this.fib != null) {
            this.fib.release();
            this.fib = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boV() {
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar == null || aoVar.aaX == null || aoVar.aaX.acA) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.fib == null) {
                    this.fib = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.fib.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0458a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0458a
                        public void ax(int i, String str) {
                            super.ax(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.fib.zd(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            boW();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.fij == 1 && cVar.fik - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.fhZ != null && cVar.fil != null) {
                        this.fhZ.setContent(cVar.fil.giftName, cVar.fil.fim);
                    }
                } else {
                    bbD();
                    aZW();
                }
                boW();
            }
        }
    }

    private void boW() {
        if (this.fia == null) {
            this.fia = new Handler();
        }
        this.fia.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.boV();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.fic != cVar.fik) {
            bbD();
            this.fic = cVar.fik;
            long j = cVar.fik - cVar.currentTime;
            a(cVar.fil, j);
            final long j2 = 100 + (j * 1000);
            this.erY = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.y(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.boX();
                }
            };
            this.erY.start();
        }
    }

    private void bbD() {
        this.fic = 0L;
        if (this.erY != null) {
            this.erY.cancel();
            this.erY = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.fhW != null && !TextUtils.isEmpty(str)) {
            if (this.fhZ == null) {
                this.fhZ = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.fhY == null) {
                this.fhY = new FrameLayout(this.mContext);
                this.fhY.setBackgroundColor(0);
            }
            if (this.fhY.indexOfChild(this.fhZ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.fhY.addView(this.fhZ, layoutParams);
            }
            if (this.fhW.indexOfChild(this.fhY) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.dKa * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.fhX;
                this.fhW.addView(this.fhY, layoutParams2);
            }
            this.fhY.setVisibility(this.fie ? 0 : 8);
            this.fhZ.setContent(str, aVar.fim);
        }
        if (this.fhV != null) {
            this.fhV.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, long j2) {
        if (this.fhV != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.fhV.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                boX();
            }
        }
    }

    private void aZW() {
        if (this.fhY != null) {
            this.fhY.removeAllViews();
            if (this.fhW != null) {
                this.fhW.removeView(this.fhY);
            }
            this.fhY = null;
            this.fhZ = null;
        }
        if (this.fhV != null) {
            this.fhV.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boX() {
        bbD();
        aZW();
        if (this.fia != null) {
            this.fia.removeCallbacksAndMessages(null);
        }
        boV();
    }
}
