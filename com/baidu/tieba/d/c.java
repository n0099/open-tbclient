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
public class c {
    private boolean dfU;
    private String dfV;
    private int dgb;
    private int dgc;
    private int dgd;
    private int dge;
    private View.OnClickListener dgh;
    private boolean dgi;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yB;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dfT = null;
    private int dfW = d.f.pic_sign_tip;
    private int dfX = 0;
    private int dfY = 1;
    private int dfZ = 1000;
    private int dga = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int HY = 5;
    private int mYOffset = 0;
    private int dgf = 48;
    private int dgg = 4;
    private boolean aij = false;
    private Runnable dgj = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dfT == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.dgi || c.this.anh()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.aG(c.this.yB).cW(0).ak(true).al(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.c.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(c.this.mPageContext.getPageActivity());
                            textView.setText(c.this.mMessage);
                            textView.setGravity(17);
                            aj.r(textView, d.C0141d.cp_cont_i);
                            textView.setTextSize(0, c.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(c.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(c.this.dgb, c.this.dgc, c.this.dgd, c.this.dge);
                            textView.setSingleLine(true);
                            aj.s(textView, c.this.dfW);
                            if (c.this.dgh != null) {
                                textView.setOnClickListener(c.this.dgh);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return c.this.dgg;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mC() {
                            return c.this.dgf;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return c.this.HY;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return c.this.mYOffset;
                        }
                    });
                    c.this.dfT = dVar.mD();
                    c.this.dfT.ah(false);
                    c.this.dfT.ai(c.this.aij);
                    c.this.dfT.l(c.this.mPageContext.getPageActivity());
                    c.this.dfU = true;
                    c.this.anf();
                    c.this.mHandler.postDelayed(c.this.dgk, c.this.dga);
                }
            }
        }
    };
    private Runnable dgk = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dfT != null) {
                c.this.dfT.dismiss();
            }
        }
    };

    public void lR(int i) {
        this.dgf = i;
    }

    public c(TbPageContext tbPageContext, View view) {
        this.dgb = 0;
        this.dgc = 0;
        this.dgd = 0;
        this.dge = 0;
        this.mPageContext = tbPageContext;
        this.yB = view;
        this.dgb = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgc = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgd = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dge = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anf() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dfV, this.dfX + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.dfU && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yB != null && this.yB.getVisibility() == 0) {
            this.mMessage = str;
            this.dfV = str2;
            this.dfX = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dfX < this.dfY) {
                if (z) {
                    anf();
                    this.dfU = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dgj, this.dfZ);
            }
        }
    }

    public void kG(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dgj, this.dfZ);
        }
    }

    public void ang() {
        if (this.dfT != null) {
            this.dfT.dismiss();
            this.dfT = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dgj);
            this.mHandler.removeCallbacks(this.dgk);
        }
    }

    public void lS(int i) {
        if (i > 0) {
            this.dfW = i;
        }
    }

    public void lT(int i) {
        if (i > 0) {
            this.dga = i;
        }
    }

    public void lU(int i) {
        if (i > 0) {
            this.dfY = i;
        }
    }

    public void lV(int i) {
        this.HY = i;
    }

    public void lW(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.dgb = i;
        this.dgc = i2;
        this.dgd = i3;
        this.dge = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dgh = onClickListener;
    }

    public void fa(boolean z) {
        this.dgi = z;
    }

    public boolean anh() {
        return this.yB != null && this.yB.getVisibility() == 0 && ((double) this.yB.getAlpha()) >= 0.4d;
    }

    public void ai(boolean z) {
        this.aij = z;
    }
}
