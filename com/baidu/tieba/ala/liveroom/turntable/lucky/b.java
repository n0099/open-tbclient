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
    private CountDownTimer gOm;
    private a.InterfaceC0675a hPa;
    private ViewGroup hPb;
    private int hPc;
    private FrameLayout hPd;
    private TurnTableLuckyBubbleView hPe;
    private Handler hPf;
    private com.baidu.tieba.ala.liveroom.turntable.a hPg;
    private boolean hPh;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hPb = viewGroup;
        this.fnF = i;
        this.hPc = i2;
    }

    public void a(String str, a.InterfaceC0675a interfaceC0675a) {
        Fy();
        this.hPh = true;
        this.mLiveId = str;
        this.hPa = interfaceC0675a;
        ckO();
    }

    public void bV(int i, int i2) {
        if (i != this.fnF || i2 != this.hPc) {
            this.fnF = i;
            this.hPc = i2;
            if (this.hPd != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fnF * 2;
                    layoutParams.bottomMargin = this.hPc;
                }
                this.hPd.setLayoutParams(layoutParams);
            }
        }
    }

    public void oM(boolean z) {
        this.hPh = z;
        if (this.hPd != null && this.hPd.getParent() != null) {
            this.hPd.setVisibility(z ? 0 : 8);
        }
    }

    public void Fy() {
        this.mLiveId = "";
        bTJ();
        this.hPa = null;
        if (this.hPf != null) {
            this.hPf.removeCallbacksAndMessages(null);
        }
        if (this.hPd != null) {
            this.hPd.removeAllViews();
            if (this.hPb != null) {
                this.hPb.removeView(this.hPd);
            }
            this.hPd = null;
            this.hPe = null;
        }
    }

    public void release() {
        Fy();
        if (this.hPg != null) {
            this.hPg.release();
            this.hPg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckO() {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar == null || bvVar.aPP == null || bvVar.aPP.aSw) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hPg == null) {
                    this.hPg = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hPg.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0674a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0674a
                        public void bs(int i, String str) {
                            super.bs(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hPg.Ic(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ckP();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hPn == 1 && cVar.expiredTime - cVar.aIa > 0) {
                    a(cVar);
                    if (this.hPe != null && cVar.hPo != null) {
                        this.hPe.setContent(cVar.hPo.giftName, cVar.hPo.hPp);
                    }
                } else {
                    bTJ();
                    bRs();
                }
                ckP();
            }
        }
    }

    private void ckP() {
        if (this.hPf == null) {
            this.hPf = new Handler();
        }
        this.hPf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckO();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.expiredTime) {
            bTJ();
            this.mExpiredTime = cVar.expiredTime;
            long j = cVar.expiredTime - cVar.aIa;
            a(cVar.hPo, j);
            final long j2 = 100 + (j * 1000);
            this.gOm = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.C(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ckQ();
                }
            };
            this.gOm.start();
        }
    }

    private void bTJ() {
        this.mExpiredTime = 0L;
        if (this.gOm != null) {
            this.gOm.cancel();
            this.gOm = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hPb != null && !TextUtils.isEmpty(str)) {
            if (this.hPe == null) {
                this.hPe = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hPd == null) {
                this.hPd = new FrameLayout(this.mContext);
                this.hPd.setBackgroundColor(0);
            }
            if (this.hPd.indexOfChild(this.hPe) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hPd.addView(this.hPe, layoutParams);
            }
            if (this.hPb.indexOfChild(this.hPd) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fnF * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.hPc;
                this.hPb.addView(this.hPd, layoutParams2);
            }
            this.hPd.setVisibility(this.hPh ? 0 : 8);
            this.hPe.setContent(str, aVar.hPp);
        }
        if (this.hPa != null) {
            this.hPa.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(long j, long j2) {
        if (this.hPa != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hPa.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ckQ();
            }
        }
    }

    private void bRs() {
        if (this.hPd != null) {
            this.hPd.removeAllViews();
            if (this.hPb != null) {
                this.hPb.removeView(this.hPd);
            }
            this.hPd = null;
            this.hPe = null;
        }
        if (this.hPa != null) {
            this.hPa.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckQ() {
        bTJ();
        bRs();
        if (this.hPf != null) {
            this.hPf.removeCallbacksAndMessages(null);
        }
        ckO();
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
