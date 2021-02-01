package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bv;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class b implements a {
    private int fnF;
    private CountDownTimer gNY;
    private a.InterfaceC0674a hOM;
    private ViewGroup hON;
    private int hOO;
    private FrameLayout hOP;
    private TurnTableLuckyBubbleView hOQ;
    private Handler hOR;
    private com.baidu.tieba.ala.liveroom.turntable.a hOS;
    private boolean hOT;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hON = viewGroup;
        this.fnF = i;
        this.hOO = i2;
    }

    public void a(String str, a.InterfaceC0674a interfaceC0674a) {
        Fy();
        this.hOT = true;
        this.mLiveId = str;
        this.hOM = interfaceC0674a;
        ckH();
    }

    public void bU(int i, int i2) {
        if (i != this.fnF || i2 != this.hOO) {
            this.fnF = i;
            this.hOO = i2;
            if (this.hOP != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hOP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fnF * 2;
                    layoutParams.bottomMargin = this.hOO;
                }
                this.hOP.setLayoutParams(layoutParams);
            }
        }
    }

    public void oM(boolean z) {
        this.hOT = z;
        if (this.hOP != null && this.hOP.getParent() != null) {
            this.hOP.setVisibility(z ? 0 : 8);
        }
    }

    public void Fy() {
        this.mLiveId = "";
        bTC();
        this.hOM = null;
        if (this.hOR != null) {
            this.hOR.removeCallbacksAndMessages(null);
        }
        if (this.hOP != null) {
            this.hOP.removeAllViews();
            if (this.hON != null) {
                this.hON.removeView(this.hOP);
            }
            this.hOP = null;
            this.hOQ = null;
        }
    }

    public void release() {
        Fy();
        if (this.hOS != null) {
            this.hOS.release();
            this.hOS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckH() {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar == null || bvVar.aPP == null || bvVar.aPP.aSw) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hOS == null) {
                    this.hOS = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hOS.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0673a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0673a
                        public void bs(int i, String str) {
                            super.bs(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hOS.Ib(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ckI();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hOZ == 1 && cVar.expiredTime - cVar.aIa > 0) {
                    a(cVar);
                    if (this.hOQ != null && cVar.hPa != null) {
                        this.hOQ.setContent(cVar.hPa.giftName, cVar.hPa.hPb);
                    }
                } else {
                    bTC();
                    bRl();
                }
                ckI();
            }
        }
    }

    private void ckI() {
        if (this.hOR == null) {
            this.hOR = new Handler();
        }
        this.hOR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckH();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.expiredTime) {
            bTC();
            this.mExpiredTime = cVar.expiredTime;
            long j = cVar.expiredTime - cVar.aIa;
            a(cVar.hPa, j);
            final long j2 = 100 + (j * 1000);
            this.gNY = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.C(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ckJ();
                }
            };
            this.gNY.start();
        }
    }

    private void bTC() {
        this.mExpiredTime = 0L;
        if (this.gNY != null) {
            this.gNY.cancel();
            this.gNY = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hON != null && !TextUtils.isEmpty(str)) {
            if (this.hOQ == null) {
                this.hOQ = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hOP == null) {
                this.hOP = new FrameLayout(this.mContext);
                this.hOP.setBackgroundColor(0);
            }
            if (this.hOP.indexOfChild(this.hOQ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hOP.addView(this.hOQ, layoutParams);
            }
            if (this.hON.indexOfChild(this.hOP) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fnF * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.hOO;
                this.hON.addView(this.hOP, layoutParams2);
            }
            this.hOP.setVisibility(this.hOT ? 0 : 8);
            this.hOQ.setContent(str, aVar.hPb);
        }
        if (this.hOM != null) {
            this.hOM.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(long j, long j2) {
        if (this.hOM != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hOM.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ckJ();
            }
        }
    }

    private void bRl() {
        if (this.hOP != null) {
            this.hOP.removeAllViews();
            if (this.hON != null) {
                this.hON.removeView(this.hOP);
            }
            this.hOP = null;
            this.hOQ = null;
        }
        if (this.hOM != null) {
            this.hOM.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckJ() {
        bTC();
        bRl();
        if (this.hOR != null) {
            this.hOR.removeCallbacksAndMessages(null);
        }
        ckH();
    }

    public String b(String str, long j, long j2, long j3) {
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(String.valueOf(j2));
        String encryptionUserId2 = ExtraParamsManager.getEncryptionUserId(String.valueOf(j3));
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(encryptionUserId);
        sb.append("&anchor_id=");
        sb.append(encryptionUserId2);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        sb.append("&scene_from=");
        sb.append(q.Vu());
        return sb.toString();
    }
}
