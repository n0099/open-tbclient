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
    private boolean dfX;
    private String dfY;
    private int dge;
    private int dgf;
    private int dgg;
    private int dgh;
    private View.OnClickListener dgk;
    private boolean dgl;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yB;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dfW = null;
    private int dfZ = d.f.pic_sign_tip;
    private int dga = 0;
    private int dgb = 1;
    private int dgc = 1000;
    private int dgd = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int HY = 5;
    private int mYOffset = 0;
    private int dgi = 48;
    private int dgj = 4;
    private boolean aij = false;
    private Runnable dgm = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dfW == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.dgl || c.this.ani()) {
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
                            textView.setPadding(c.this.dge, c.this.dgf, c.this.dgg, c.this.dgh);
                            textView.setSingleLine(true);
                            aj.s(textView, c.this.dfZ);
                            if (c.this.dgk != null) {
                                textView.setOnClickListener(c.this.dgk);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return c.this.dgj;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mC() {
                            return c.this.dgi;
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
                    c.this.dfW = dVar.mD();
                    c.this.dfW.ah(false);
                    c.this.dfW.ai(c.this.aij);
                    c.this.dfW.l(c.this.mPageContext.getPageActivity());
                    c.this.dfX = true;
                    c.this.ang();
                    c.this.mHandler.postDelayed(c.this.dgn, c.this.dgd);
                }
            }
        }
    };
    private Runnable dgn = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dfW != null) {
                c.this.dfW.dismiss();
            }
        }
    };

    public void lR(int i) {
        this.dgi = i;
    }

    public c(TbPageContext tbPageContext, View view) {
        this.dge = 0;
        this.dgf = 0;
        this.dgg = 0;
        this.dgh = 0;
        this.mPageContext = tbPageContext;
        this.yB = view;
        this.dge = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgf = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgg = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgh = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ang() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dfY, this.dga + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.dfX && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yB != null && this.yB.getVisibility() == 0) {
            this.mMessage = str;
            this.dfY = str2;
            this.dga = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dga < this.dgb) {
                if (z) {
                    ang();
                    this.dfX = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dgm, this.dgc);
            }
        }
    }

    public void kG(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dgm, this.dgc);
        }
    }

    public void anh() {
        if (this.dfW != null) {
            this.dfW.dismiss();
            this.dfW = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dgm);
            this.mHandler.removeCallbacks(this.dgn);
        }
    }

    public void lS(int i) {
        if (i > 0) {
            this.dfZ = i;
        }
    }

    public void lT(int i) {
        if (i > 0) {
            this.dgd = i;
        }
    }

    public void lU(int i) {
        if (i > 0) {
            this.dgb = i;
        }
    }

    public void lV(int i) {
        this.HY = i;
    }

    public void lW(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.dge = i;
        this.dgf = i2;
        this.dgg = i3;
        this.dgh = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dgk = onClickListener;
    }

    public void fa(boolean z) {
        this.dgl = z;
    }

    public boolean ani() {
        return this.yB != null && this.yB.getVisibility() == 0 && ((double) this.yB.getAlpha()) >= 0.4d;
    }

    public void ai(boolean z) {
        this.aij = z;
    }
}
