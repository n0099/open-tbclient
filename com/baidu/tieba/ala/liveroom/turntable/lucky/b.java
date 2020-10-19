package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bj;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes4.dex */
public class b implements a {
    private int eLy;
    private CountDownTimer gge;
    private a.InterfaceC0656a hbX;
    private ViewGroup hbY;
    private FrameLayout hbZ;
    private TurnTableLuckyBubbleView hca;
    private Handler hcb;
    private com.baidu.tieba.ala.liveroom.turntable.a hcc;
    private long hcd;
    private boolean hce;
    private int mBottomMargin;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hbY = viewGroup;
        this.eLy = i;
        this.mBottomMargin = i2;
    }

    public void a(String str, a.InterfaceC0656a interfaceC0656a) {
        Gx();
        this.hce = true;
        this.mLiveId = str;
        this.hbX = interfaceC0656a;
        cbO();
    }

    public void bQ(int i, int i2) {
        if (i != this.eLy || i2 != this.mBottomMargin) {
            this.eLy = i;
            this.mBottomMargin = i2;
            if (this.hbZ != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hbZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eLy * 2;
                    layoutParams.bottomMargin = this.mBottomMargin;
                }
                this.hbZ.setLayoutParams(layoutParams);
            }
        }
    }

    public void nm(boolean z) {
        this.hce = z;
        if (this.hbZ != null && this.hbZ.getParent() != null) {
            this.hbZ.setVisibility(z ? 0 : 8);
        }
    }

    public void Gx() {
        this.mLiveId = "";
        bMg();
        this.hbX = null;
        if (this.hcb != null) {
            this.hcb.removeCallbacksAndMessages(null);
        }
        if (this.hbZ != null) {
            this.hbZ.removeAllViews();
            if (this.hbY != null) {
                this.hbY.removeView(this.hbZ);
            }
            this.hbZ = null;
            this.hca = null;
        }
    }

    public void release() {
        Gx();
        if (this.hcc != null) {
            this.hcc.release();
            this.hcc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbO() {
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar == null || bjVar.aNY == null || bjVar.aNY.aQg) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hcc == null) {
                    this.hcc = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hcc.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0655a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0655a
                        public void bg(int i, String str) {
                            super.bg(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hcc.HH(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            cbP();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hck == 1 && cVar.hcl - cVar.currentTime > 0) {
                    a(cVar);
                    if (this.hca != null && cVar.hcm != null) {
                        this.hca.setContent(cVar.hcm.giftName, cVar.hcm.hcn);
                    }
                } else {
                    bMg();
                    bJP();
                }
                cbP();
            }
        }
    }

    private void cbP() {
        if (this.hcb == null) {
            this.hcb = new Handler();
        }
        this.hcb.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.cbO();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.hcd != cVar.hcl) {
            bMg();
            this.hcd = cVar.hcl;
            long j = cVar.hcl - cVar.currentTime;
            a(cVar.hcm, j);
            final long j2 = 100 + (j * 1000);
            this.gge = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.u(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.cbQ();
                }
            };
            this.gge.start();
        }
    }

    private void bMg() {
        this.hcd = 0L;
        if (this.gge != null) {
            this.gge.cancel();
            this.gge = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hbY != null && !TextUtils.isEmpty(str)) {
            if (this.hca == null) {
                this.hca = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hbZ == null) {
                this.hbZ = new FrameLayout(this.mContext);
                this.hbZ.setBackgroundColor(0);
            }
            if (this.hbZ.indexOfChild(this.hca) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hbZ.addView(this.hca, layoutParams);
            }
            if (this.hbY.indexOfChild(this.hbZ) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eLy * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.mBottomMargin;
                this.hbY.addView(this.hbZ, layoutParams2);
            }
            this.hbZ.setVisibility(this.hce ? 0 : 8);
            this.hca.setContent(str, aVar.hcn);
        }
        if (this.hbX != null) {
            this.hbX.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        if (this.hbX != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hbX.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                cbQ();
            }
        }
    }

    private void bJP() {
        if (this.hbZ != null) {
            this.hbZ.removeAllViews();
            if (this.hbY != null) {
                this.hbY.removeView(this.hbZ);
            }
            this.hbZ = null;
            this.hca = null;
        }
        if (this.hbX != null) {
            this.hbX.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        bMg();
        bJP();
        if (this.hcb != null) {
            this.hcb.removeCallbacksAndMessages(null);
        }
        cbO();
    }
}
