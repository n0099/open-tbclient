package com.baidu.tieba.frs.i;

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
    public com.baidu.tieba.frs.view.p bCU;
    private FrsActivity bET;
    private NoPressedRelativeLayout bRB;
    public com.baidu.tieba.b.d.b bRJ;
    private b.a bRK;
    public com.baidu.tieba.b.d.f bRL;
    public com.baidu.tieba.b.d.f bRM;
    public com.baidu.tieba.b.d.f bRN;
    public com.baidu.tieba.b.d.f bRO;
    public com.baidu.tieba.b.d.f bRP;
    public com.baidu.tieba.b.d.f bRQ;
    public com.baidu.tieba.b.d.f bRR;
    public TextView bRS;
    private boolean bRT = false;
    private boolean bRU = false;
    private boolean bRV = false;
    private boolean bRW = false;
    private boolean bRX = true;
    private boolean bRY = false;
    private boolean bRZ = false;
    private Runnable bSa = new i(this);
    private Runnable bSb = new j(this);
    private View.OnClickListener bSc = new k(this);

    private boolean ZX() {
        return UtilHelper.detectOpenGLES20(this.bET.getPageContext().getPageActivity());
    }

    public h(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bET = frsActivity;
            this.bRB = noPressedRelativeLayout;
            if (ZX()) {
                au(this.bET.getPageContext().getPageActivity());
            } else {
                av(this.bET.getPageContext().getPageActivity());
            }
        }
    }

    private void au(Context context) {
        this.bRJ = aw(context);
        this.bRK = ax(context);
        this.bRJ.setShadeViewContainer(this.bRK);
    }

    public void av(Context context) {
        this.bRS = new TextView(context);
        int c = com.baidu.adp.lib.util.k.c(context, u.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, u.e.ds20), com.baidu.adp.lib.util.k.c(context, u.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bRS.setBackgroundResource(u.f.btn_frs_post_more);
        this.bRS.setLayoutParams(layoutParams);
        this.bRS.setOnClickListener(new l(this));
        this.bRB.addView(this.bRS);
        this.bRS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZY() {
        if (this.bET != null) {
            boolean z = (this.bET.VC() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bET.VC().aDN() == null || this.bET.VC().aDN().getAnchorPower() == null || this.bET.VC().aDN().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            boolean Fj = this.bET.VC().getUserData().canPostHi() ? com.baidu.tbadk.plugins.d.Fj() : false;
            this.bCU = new com.baidu.tieba.frs.view.p(this.bET.getPageContext(), this.bRB, new m(this));
            this.bCU.d(z, showXiaoyingTool, Fj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dk(boolean z) {
        if (this.bRS != null) {
            if (z) {
                this.bRS.setVisibility(0);
            } else {
                this.bRS.setVisibility(8);
            }
        } else if (!this.bRY) {
            com.baidu.adp.lib.h.h.dM().removeCallbacks(this.bSb);
            com.baidu.adp.lib.h.h.dM().postDelayed(this.bSb, 100L);
            this.bRZ = z;
        } else if (this.bRJ != null && this.bRK != null && this.bRL != null) {
            if (z) {
                this.bRJ.setVisibility(0);
                this.bRK.setVisibility(0);
                this.bRL.setVisibility(0);
                return;
            }
            this.bRJ.setVisibility(8);
            this.bRK.setVisibility(8);
            this.bRL.setVisibility(8);
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
    public void ZZ() {
        aab();
        b(true, true, true, true, true);
        aaa();
    }

    private void aaa() {
        if (this.bRJ != null) {
            n nVar = new n(this);
            this.bRM.setDispathEventAction(nVar);
            this.bRN.setDispathEventAction(nVar);
            this.bRO.setDispathEventAction(nVar);
            this.bRP.setDispathEventAction(nVar);
            this.bRQ.setDispathEventAction(nVar);
            this.bRR.setDispathEventAction(nVar);
            this.bRB.setDispathEventAction(new o(this));
            this.bRJ.setItemOnclickListener(this.bSc);
        }
    }

    private void aab() {
        if (this.bRJ != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_post_th_activity);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.btn_frs_shop);
            Bitmap resBitmapPowerOf2Size9 = BitmapHelper.getResBitmapPowerOf2Size(this.bET.getPageContext().getPageActivity(), u.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size7 == null || resBitmapPowerOf2Size9 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                av(this.bET.getPageContext().getPageActivity());
                this.bRJ = null;
                this.bRK = null;
                return;
            }
            int c = com.baidu.adp.lib.util.k.c(this.bET.getPageContext().getPageActivity(), u.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            this.bRL = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRL.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size9, resBitmapPowerOf2Size2, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRL.setLayoutParams(layoutParams);
            this.bRM = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRM.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRM.setLayoutParams(layoutParams);
            this.bRN = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRN.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRN.setLayoutParams(layoutParams);
            this.bRO = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRO.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRO.setLayoutParams(layoutParams);
            this.bRP = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRP.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRP.setLayoutParams(layoutParams);
            this.bRQ = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRQ.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRQ.setLayoutParams(layoutParams);
            this.bRR = new com.baidu.tieba.b.d.f(this.bET.getPageContext().getPageActivity());
            this.bRR.b(resBitmapPowerOf2Size8, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.bRR.setLayoutParams(layoutParams);
            this.bRB.addView(this.bRK);
            this.bRB.addView(this.bRJ);
        }
    }

    public void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean Fq = EcommSwitchStatic.Fq() & z5;
        if (this.bRJ != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.bRL);
            arrayList.add(this.bRM);
            if (z) {
                arrayList.add(this.bRN);
            }
            if (z2) {
                arrayList.add(this.bRO);
            }
            if (z4) {
                arrayList.add(this.bRP);
            }
            if (z3) {
                arrayList.add(this.bRQ);
            }
            if (Fq) {
                arrayList.add(this.bRR);
            }
            if (this.bRT != z || this.bRU != z2 || this.bRV != z3 || this.bRW != z4 || this.bRX != Fq) {
                this.bRJ.setWriteViewList(arrayList);
                this.bRT = z;
                this.bRU = z2;
                this.bRV = z3;
                this.bRW = z4;
                this.bRX = Fq;
            }
            this.bRJ.KD();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Yd() {
        if (this.bRJ != null) {
            com.baidu.adp.lib.h.h.dM().removeCallbacks(this.bSa);
            com.baidu.adp.lib.h.h.dM().removeCallbacks(this.bSb);
            this.bRJ.Kz();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Ye() {
        if (this.bRJ != null && !this.bRJ.fD(1)) {
            com.baidu.adp.lib.h.h.dM().postDelayed(this.bSa, 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean Wk() {
        if (this.bRJ == null || this.bRJ.fD(1)) {
            return false;
        }
        this.bRJ.KB();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.bRK != null) {
            this.bRK.onChangeSkinType(i);
        }
    }
}
