package com.baidu.tieba.frs.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.b.d.b;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.p bEb;
    private FrsActivity bGh;
    private NoPressedRelativeLayout bTB;
    public com.baidu.tieba.b.d.b bTJ;
    private b.a bTK;
    public com.baidu.tieba.b.d.f bTL;
    public com.baidu.tieba.b.d.f bTM;
    public com.baidu.tieba.b.d.f bTN;
    public com.baidu.tieba.b.d.f bTO;
    public com.baidu.tieba.b.d.f bTP;
    public com.baidu.tieba.b.d.f bTQ;
    public com.baidu.tieba.b.d.f bTR;
    public TextView bTS;
    private boolean bTT = false;
    private boolean bTU = false;
    private boolean bTV = false;
    private boolean bTW = false;
    private boolean bTX = true;
    private boolean bTY = false;
    private boolean bTZ = false;
    private Runnable bUa = new i(this);
    private Runnable bUb = new j(this);
    private View.OnClickListener bUc = new k(this);

    private boolean aaz() {
        return UtilHelper.detectOpenGLES20(this.bGh.getPageContext().getPageActivity());
    }

    public h(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bGh = frsActivity;
            this.bTB = noPressedRelativeLayout;
            if (aaz()) {
                au(this.bGh.getPageContext().getPageActivity());
            } else {
                av(this.bGh.getPageContext().getPageActivity());
            }
        }
    }

    private void au(Context context) {
        this.bTJ = aw(context);
        this.bTK = ax(context);
        this.bTJ.setShadeViewContainer(this.bTK);
    }

    public void av(Context context) {
        this.bTS = new TextView(context);
        int c = com.baidu.adp.lib.util.k.c(context, u.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, u.e.ds20), com.baidu.adp.lib.util.k.c(context, u.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bTS.setBackgroundResource(u.f.btn_frs_post_more);
        this.bTS.setLayoutParams(layoutParams);
        this.bTS.setOnClickListener(new l(this));
        this.bTB.addView(this.bTS);
        this.bTS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.bGh != null) {
            boolean z = (this.bGh.VU() == null || !TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bGh.VU().aGX() == null || this.bGh.VU().aGX().getAnchorPower() == null || this.bGh.VU().aGX().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            boolean Fk = this.bGh.VU().getUserData().canPostHi() ? com.baidu.tbadk.plugins.g.Fk() : false;
            this.bEb = new com.baidu.tieba.frs.view.p(this.bGh.getPageContext(), this.bTB, new m(this));
            this.bEb.d(z, showXiaoyingTool, Fk);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dh(boolean z) {
        if (this.bTS != null) {
            if (z) {
                this.bTS.setVisibility(0);
            } else {
                this.bTS.setVisibility(8);
            }
        } else if (!this.bTY) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bUb);
            com.baidu.adp.lib.h.h.dL().postDelayed(this.bUb, 100L);
            this.bTZ = z;
        } else if (this.bTJ != null && this.bTK != null && this.bTL != null) {
            if (z) {
                this.bTJ.setVisibility(0);
                this.bTK.setVisibility(0);
                this.bTL.setVisibility(0);
                return;
            }
            this.bTJ.setVisibility(8);
            this.bTK.setVisibility(8);
            this.bTL.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.b aw(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.b.d.b bVar = new com.baidu.tieba.b.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, u.e.ds20), com.baidu.adp.lib.util.k.c(context, u.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        bVar.setLayoutParams(layoutParams);
        bVar.setOrientation(1);
        bVar.setVisibility(8);
        return bVar;
    }

    private b.a ax(Context context) {
        if (context == null) {
            return null;
        }
        b.a aVar = new b.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, u.e.ds20), com.baidu.adp.lib.util.k.c(context, u.e.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaB() {
        aaD();
        b(true, true, true, true, true);
        aaC();
    }

    private void aaC() {
        if (this.bTJ != null) {
            n nVar = new n(this);
            this.bTM.setDispathEventAction(nVar);
            this.bTN.setDispathEventAction(nVar);
            this.bTO.setDispathEventAction(nVar);
            this.bTP.setDispathEventAction(nVar);
            this.bTQ.setDispathEventAction(nVar);
            this.bTR.setDispathEventAction(nVar);
            this.bTB.setDispathEventAction(new o(this));
            this.bTJ.setItemOnclickListener(this.bUc);
        }
    }

    private void aaD() {
        if (this.bTJ != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_post_th_activity);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.btn_frs_shop);
            Bitmap resBitmapPowerOf2Size9 = BitmapHelper.getResBitmapPowerOf2Size(this.bGh.getPageContext().getPageActivity(), u.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size7 == null || resBitmapPowerOf2Size9 == null) {
                TbadkCoreApplication.m10getInst().onAppMemoryLow();
                av(this.bGh.getPageContext().getPageActivity());
                this.bTJ = null;
                this.bTK = null;
                return;
            }
            int c = com.baidu.adp.lib.util.k.c(this.bGh.getPageContext().getPageActivity(), u.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            this.bTL = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTL.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size9, resBitmapPowerOf2Size2, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTL.setLayoutParams(layoutParams);
            this.bTM = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTM.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTM.setLayoutParams(layoutParams);
            this.bTN = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTN.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTN.setLayoutParams(layoutParams);
            this.bTO = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTO.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTO.setLayoutParams(layoutParams);
            this.bTP = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTP.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTP.setLayoutParams(layoutParams);
            this.bTQ = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTQ.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTQ.setLayoutParams(layoutParams);
            this.bTR = new com.baidu.tieba.b.d.f(this.bGh.getPageContext().getPageActivity());
            this.bTR.b(resBitmapPowerOf2Size8, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bTR.setLayoutParams(layoutParams);
            this.bTB.addView(this.bTK);
            this.bTB.addView(this.bTJ);
        }
    }

    public void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean Fr = EcommSwitchStatic.Fr() & z5;
        if (this.bTJ != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.bTL);
            arrayList.add(this.bTM);
            if (z) {
                arrayList.add(this.bTN);
            }
            if (z2) {
                arrayList.add(this.bTO);
            }
            if (z4) {
                arrayList.add(this.bTP);
            }
            if (z3) {
                arrayList.add(this.bTQ);
            }
            if (Fr) {
                arrayList.add(this.bTR);
            }
            if (this.bTT != z || this.bTU != z2 || this.bTV != z3 || this.bTW != z4 || this.bTX != Fr) {
                this.bTJ.setWriteViewList(arrayList);
                this.bTT = z;
                this.bTU = z2;
                this.bTV = z3;
                this.bTW = z4;
                this.bTX = Fr;
            }
            this.bTJ.KC();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Yx() {
        if (this.bTJ != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bUa);
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bUb);
            this.bTJ.Ky();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Yy() {
        if (this.bTJ != null && !this.bTJ.fC(1)) {
            com.baidu.adp.lib.h.h.dL().postDelayed(this.bUa, 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean WB() {
        if (this.bTJ == null || this.bTJ.fC(1)) {
            return false;
        }
        this.bTJ.KA();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.bTK != null) {
            this.bTK.onChangeSkinType(i);
        }
    }
}
