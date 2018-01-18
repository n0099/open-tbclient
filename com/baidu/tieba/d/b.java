package com.baidu.tieba.d;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class b {
    private boolean dcW;
    private String dcX;
    private int ddd;
    private int dde;
    private int ddf;
    private int ddg;
    private View.OnClickListener ddj;
    private boolean ddk;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yH;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dcV = null;
    private int dcY = d.f.pic_sign_tip;
    private int dcZ = 0;
    private int dda = 1;
    private int ddb = 1000;
    private int ddc = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int Ie = 5;
    private int mYOffset = 0;
    private int ddh = 48;
    private int ddi = 4;
    private Runnable ddl = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dcV == null && !StringUtils.isNull(b.this.mMessage)) {
                if (!b.this.ddk || b.this.ams()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.aG(b.this.yH).cW(0).ag(true).ah(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.b.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(b.this.mPageContext.getPageActivity());
                            textView.setText(b.this.mMessage);
                            textView.setGravity(17);
                            aj.r(textView, d.C0107d.cp_cont_i);
                            textView.setTextSize(0, b.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(b.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(b.this.ddd, b.this.dde, b.this.ddf, b.this.ddg);
                            textView.setSingleLine(true);
                            aj.s(textView, b.this.dcY);
                            if (b.this.ddj != null) {
                                textView.setOnClickListener(b.this.ddj);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mA() {
                            return b.this.ddi;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return b.this.ddh;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return b.this.Ie;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return b.this.mYOffset;
                        }
                    });
                    b.this.dcV = dVar.mC();
                    b.this.dcV.ae(false);
                    b.this.dcV.j(b.this.mPageContext.getPageActivity());
                    b.this.dcW = true;
                    b.this.amq();
                    b.this.mHandler.postDelayed(b.this.ddm, b.this.ddc);
                }
            }
        }
    };
    private Runnable ddm = new Runnable() { // from class: com.baidu.tieba.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dcV != null) {
                b.this.dcV.dismiss();
            }
        }
    };

    public void lU(int i) {
        this.ddh = i;
    }

    public b(TbPageContext tbPageContext, View view) {
        this.ddd = 0;
        this.dde = 0;
        this.ddf = 0;
        this.ddg = 0;
        this.mPageContext = tbPageContext;
        this.yH = view;
        this.ddd = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dde = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ddf = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.ddg = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amq() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dcX, this.dcZ + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.dcW && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yH != null && this.yH.getVisibility() == 0) {
            this.mMessage = str;
            this.dcX = str2;
            this.dcZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dcZ < this.dda) {
                if (z) {
                    amq();
                    this.dcW = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ddl, this.ddb);
            }
        }
    }

    public void kr(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.ddl, this.ddb);
        }
    }

    public void amr() {
        if (this.dcV != null) {
            this.dcV.dismiss();
            this.dcV = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ddl);
            this.mHandler.removeCallbacks(this.ddm);
        }
    }

    public void lV(int i) {
        if (i > 0) {
            this.dcY = i;
        }
    }

    public void lW(int i) {
        if (i > 0) {
            this.ddc = i;
        }
    }

    public void lX(int i) {
        if (i > 0) {
            this.dda = i;
        }
    }

    public void lY(int i) {
        this.Ie = i;
    }

    public void lZ(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.ddd = i;
        this.dde = i2;
        this.ddf = i3;
        this.ddg = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.ddj = onClickListener;
    }

    public void eR(boolean z) {
        this.ddk = z;
    }

    public boolean ams() {
        return this.yH != null && this.yH.getVisibility() == 0 && ((double) this.yH.getAlpha()) >= 0.4d;
    }
}
