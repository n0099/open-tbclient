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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.p bPx;
    private FrsActivity bRi;
    private NoPressedRelativeLayout ceI;
    public com.baidu.tieba.b.d.b ceQ;
    private b.a ceR;
    public com.baidu.tieba.b.d.f ceS;
    public com.baidu.tieba.b.d.f ceT;
    public com.baidu.tieba.b.d.f ceU;
    public com.baidu.tieba.b.d.f ceV;
    public com.baidu.tieba.b.d.f ceW;
    public com.baidu.tieba.b.d.f ceX;
    public TextView ceY;
    private boolean ceZ = false;
    private boolean cfa = false;
    private boolean cfb = false;
    private boolean cfc = true;
    private boolean cfd = false;
    private boolean cfe = false;
    private Runnable cff = new i(this);
    private Runnable cfg = new j(this);
    private View.OnClickListener cfh = new k(this);

    private boolean afy() {
        return UtilHelper.detectOpenGLES20(this.bRi.getPageContext().getPageActivity());
    }

    public h(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bRi = frsActivity;
            this.ceI = noPressedRelativeLayout;
            if (afy()) {
                aE(this.bRi.getPageContext().getPageActivity());
            } else {
                aF(this.bRi.getPageContext().getPageActivity());
            }
        }
    }

    private void aE(Context context) {
        this.ceQ = aG(context);
        this.ceR = aH(context);
        this.ceQ.setShadeViewContainer(this.ceR);
    }

    public void aF(Context context) {
        this.ceY = new TextView(context);
        int e = com.baidu.adp.lib.util.k.e(context, r.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.e.ds20), com.baidu.adp.lib.util.k.e(context, r.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ceY.setBackgroundResource(r.f.btn_frs_post_more);
        this.ceY.setLayoutParams(layoutParams);
        this.ceY.setOnClickListener(new l(this));
        this.ceI.addView(this.ceY);
        this.ceY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afz() {
        boolean z;
        if (this.bRi != null) {
            if (this.bRi.abe() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && this.bRi.abe().aMr() != null && this.bRi.abe().aMr().getAnchorPower() != null && this.bRi.abe().aMr().getAnchorPower().can_add_live_post.intValue() != 2) {
                z = true;
            } else {
                z = false;
            }
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bPx = new com.baidu.tieba.frs.view.p(this.bRi.getPageContext(), this.ceI, new m(this));
            this.bPx.o(z, showXiaoyingTool);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dG(boolean z) {
        if (this.ceY != null) {
            if (z) {
                this.ceY.setVisibility(0);
            } else {
                this.ceY.setVisibility(8);
            }
        } else if (!this.cfd) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfg);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cfg, 100L);
            this.cfe = z;
        } else if (this.ceQ != null && this.ceR != null && this.ceS != null) {
            if (z) {
                this.ceQ.setVisibility(0);
                this.ceR.setVisibility(0);
                this.ceS.setVisibility(0);
                return;
            }
            this.ceQ.setVisibility(8);
            this.ceR.setVisibility(8);
            this.ceS.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.b aG(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.b.d.b bVar = new com.baidu.tieba.b.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.e.ds20), com.baidu.adp.lib.util.k.e(context, r.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        bVar.setLayoutParams(layoutParams);
        bVar.setOrientation(1);
        bVar.setVisibility(8);
        return bVar;
    }

    private b.a aH(Context context) {
        if (context == null) {
            return null;
        }
        b.a aVar = new b.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.e.ds20), com.baidu.adp.lib.util.k.e(context, r.e.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afA() {
        afC();
        a(true, true, true, true);
        afB();
    }

    private void afB() {
        if (this.ceQ != null) {
            n nVar = new n(this);
            this.ceT.setDispathEventAction(nVar);
            this.ceU.setDispathEventAction(nVar);
            this.ceV.setDispathEventAction(nVar);
            this.ceW.setDispathEventAction(nVar);
            this.ceX.setDispathEventAction(nVar);
            this.ceI.setDispathEventAction(new o(this));
            this.ceQ.setItemOnclickListener(this.cfh);
        }
    }

    private void afC() {
        if (this.ceQ != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.btn_frs_shop);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bRi.getPageContext().getPageActivity(), r.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aF(this.bRi.getPageContext().getPageActivity());
                this.ceQ = null;
                this.ceR = null;
                return;
            }
            int e = com.baidu.adp.lib.util.k.e(this.bRi.getPageContext().getPageActivity(), r.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            this.ceS = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceS.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceS.setLayoutParams(layoutParams);
            this.ceT = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceT.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceT.setLayoutParams(layoutParams);
            this.ceU = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceU.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceU.setLayoutParams(layoutParams);
            this.ceV = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceV.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceV.setLayoutParams(layoutParams);
            this.ceW = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceW.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceW.setLayoutParams(layoutParams);
            this.ceX = new com.baidu.tieba.b.d.f(this.bRi.getPageContext().getPageActivity());
            this.ceX.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.ceX.setLayoutParams(layoutParams);
            this.ceI.addView(this.ceR);
            this.ceI.addView(this.ceQ);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean GK = EcommSwitchStatic.GK() & z4;
        if (this.ceQ != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.ceS);
            arrayList.add(this.ceT);
            if (z) {
                arrayList.add(this.ceU);
            }
            if (z2) {
                arrayList.add(this.ceV);
            }
            if (z3) {
                arrayList.add(this.ceW);
            }
            if (GK) {
                arrayList.add(this.ceX);
            }
            if (this.ceZ != z || this.cfa != z2 || this.cfb != z3 || this.cfc != GK) {
                this.ceQ.setWriteViewList(arrayList);
                this.ceZ = z;
                this.cfa = z2;
                this.cfb = z3;
                this.cfc = GK;
            }
            this.ceQ.NF();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void adx() {
        if (this.ceQ != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cff);
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfg);
            this.ceQ.NB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ady() {
        if (this.ceQ != null && !this.ceQ.gf(1)) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cff, 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean abJ() {
        if (this.ceQ == null || this.ceQ.gf(1)) {
            return false;
        }
        this.ceQ.ND();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.ceR != null) {
            this.ceR.onChangeSkinType(i);
        }
    }
}
