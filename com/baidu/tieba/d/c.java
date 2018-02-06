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
    private boolean dgg;
    private String dgh;
    private int dgn;
    private int dgo;
    private int dgp;
    private int dgq;
    private View.OnClickListener dgt;
    private boolean dgu;
    private String mMessage;
    private TbPageContext mPageContext;
    private View yG;
    private Handler mHandler = null;
    private com.baidu.adp.lib.guide.c dgf = null;
    private int dgi = d.f.pic_sign_tip;
    private int dgj = 0;
    private int dgk = 1;
    private int dgl = 1000;
    private int dgm = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int Id = 5;
    private int mYOffset = 0;
    private int dgr = 48;
    private int dgs = 4;
    private boolean aip = false;
    private Runnable dgv = new Runnable() { // from class: com.baidu.tieba.d.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dgf == null && !StringUtils.isNull(c.this.mMessage)) {
                if (!c.this.dgu || c.this.ani()) {
                    com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                    dVar.aG(c.this.yG).cW(0).ak(true).al(true);
                    dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.d.c.1.1
                        @Override // com.baidu.adp.lib.guide.b
                        public View a(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(c.this.mPageContext.getPageActivity());
                            textView.setText(c.this.mMessage);
                            textView.setGravity(17);
                            aj.r(textView, d.C0140d.cp_cont_i);
                            textView.setTextSize(0, c.this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            textView.setHeight(c.this.mPageContext.getResources().getDimensionPixelSize(d.e.ds76));
                            textView.setPadding(c.this.dgn, c.this.dgo, c.this.dgp, c.this.dgq);
                            textView.setSingleLine(true);
                            aj.s(textView, c.this.dgi);
                            if (c.this.dgt != null) {
                                textView.setOnClickListener(c.this.dgt);
                            }
                            return textView;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mB() {
                            return c.this.dgs;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int mC() {
                            return c.this.dgr;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getXOffset() {
                            return c.this.Id;
                        }

                        @Override // com.baidu.adp.lib.guide.b
                        public int getYOffset() {
                            return c.this.mYOffset;
                        }
                    });
                    c.this.dgf = dVar.mD();
                    c.this.dgf.ah(false);
                    c.this.dgf.ai(c.this.aip);
                    c.this.dgf.l(c.this.mPageContext.getPageActivity());
                    c.this.dgg = true;
                    c.this.ang();
                    c.this.mHandler.postDelayed(c.this.dgw, c.this.dgm);
                }
            }
        }
    };
    private Runnable dgw = new Runnable() { // from class: com.baidu.tieba.d.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dgf != null) {
                c.this.dgf.dismiss();
            }
        }
    };

    public void lR(int i) {
        this.dgr = i;
    }

    public c(TbPageContext tbPageContext, View view) {
        this.dgn = 0;
        this.dgo = 0;
        this.dgp = 0;
        this.dgq = 0;
        this.mPageContext = tbPageContext;
        this.yG = view;
        this.dgn = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgo = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgp = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds24);
        this.dgq = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ang() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(this.dgh, this.dgj + 1);
    }

    public void aK(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.dgg && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.yG != null && this.yG.getVisibility() == 0) {
            this.mMessage = str;
            this.dgh = str2;
            this.dgj = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(str2, 0);
            if (this.dgj < this.dgk) {
                if (z) {
                    ang();
                    this.dgg = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.dgv, this.dgl);
            }
        }
    }

    public void kG(String str) {
        if (!StringUtils.isNull(str)) {
            this.mMessage = str;
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.dgv, this.dgl);
        }
    }

    public void anh() {
        if (this.dgf != null) {
            this.dgf.dismiss();
            this.dgf = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dgv);
            this.mHandler.removeCallbacks(this.dgw);
        }
    }

    public void lS(int i) {
        if (i > 0) {
            this.dgi = i;
        }
    }

    public void lT(int i) {
        if (i > 0) {
            this.dgm = i;
        }
    }

    public void lU(int i) {
        if (i > 0) {
            this.dgk = i;
        }
    }

    public void lV(int i) {
        this.Id = i;
    }

    public void lW(int i) {
        this.mYOffset = i;
    }

    public void v(int i, int i2, int i3, int i4) {
        this.dgn = i;
        this.dgo = i2;
        this.dgp = i3;
        this.dgq = i4;
    }

    public void j(View.OnClickListener onClickListener) {
        this.dgt = onClickListener;
    }

    public void fa(boolean z) {
        this.dgu = z;
    }

    public boolean ani() {
        return this.yG != null && this.yG.getVisibility() == 0 && ((double) this.yG.getAlpha()) >= 0.4d;
    }

    public void ai(boolean z) {
        this.aip = z;
    }
}
