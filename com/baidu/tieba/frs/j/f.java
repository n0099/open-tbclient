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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.q bSl;
    private FrsActivity bTA;
    public com.baidu.tieba.b.d.b cjB;
    private b.a cjC;
    public com.baidu.tieba.b.d.f cjD;
    public com.baidu.tieba.b.d.f cjE;
    public com.baidu.tieba.b.d.f cjF;
    public com.baidu.tieba.b.d.f cjG;
    public com.baidu.tieba.b.d.f cjH;
    public com.baidu.tieba.b.d.f cjI;
    public TextView cjJ;
    private boolean cjK = false;
    private boolean cjL = false;
    private boolean cjM = false;
    private boolean cjN = true;
    private boolean cjO = false;
    private boolean cjP = false;
    private Runnable cjQ = new g(this);
    private Runnable cjR = new h(this);
    private View.OnClickListener cjS = new i(this);
    private NoPressedRelativeLayout cjh;

    private boolean ahl() {
        return UtilHelper.detectOpenGLES20(this.bTA.getPageContext().getPageActivity());
    }

    public f(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bTA = frsActivity;
            this.cjh = noPressedRelativeLayout;
            if (ahl()) {
                aQ(this.bTA.getPageContext().getPageActivity());
            } else {
                aR(this.bTA.getPageContext().getPageActivity());
            }
        }
    }

    private void aQ(Context context) {
        this.cjB = aS(context);
        this.cjC = aT(context);
        this.cjB.setShadeViewContainer(this.cjC);
    }

    public void aR(Context context) {
        this.cjJ = new TextView(context);
        int e = com.baidu.adp.lib.util.k.e(context, r.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.e.ds20), com.baidu.adp.lib.util.k.e(context, r.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.cjJ.setBackgroundResource(r.f.btn_frs_post_more);
        this.cjJ.setLayoutParams(layoutParams);
        this.cjJ.setOnClickListener(new j(this));
        this.cjh.addView(this.cjJ);
        this.cjJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahm() {
        boolean z;
        if (this.bTA != null) {
            if (this.bTA.acr() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && this.bTA.acr().aOk() != null && this.bTA.acr().aOk().getAnchorPower() != null && this.bTA.acr().aOk().getAnchorPower().can_add_live_post.intValue() != 2) {
                z = true;
            } else {
                z = false;
            }
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bSl = new com.baidu.tieba.frs.view.q(this.bTA.getPageContext(), this.cjh, new k(this));
            this.bSl.o(z, showXiaoyingTool);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dM(boolean z) {
        if (this.cjJ != null) {
            if (z) {
                this.cjJ.setVisibility(0);
            } else {
                this.cjJ.setVisibility(8);
            }
        } else if (!this.cjO) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cjR);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cjR, 100L);
            this.cjP = z;
        } else if (this.cjB != null && this.cjC != null && this.cjD != null) {
            if (z) {
                this.cjB.setVisibility(0);
                this.cjC.setVisibility(0);
                this.cjD.setVisibility(0);
                return;
            }
            this.cjB.setVisibility(8);
            this.cjC.setVisibility(8);
            this.cjD.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.b aS(Context context) {
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

    private b.a aT(Context context) {
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
    public void ahn() {
        ahp();
        a(true, true, true, true);
        aho();
    }

    private void aho() {
        if (this.cjB != null) {
            l lVar = new l(this);
            this.cjE.setDispathEventAction(lVar);
            this.cjF.setDispathEventAction(lVar);
            this.cjG.setDispathEventAction(lVar);
            this.cjH.setDispathEventAction(lVar);
            this.cjI.setDispathEventAction(lVar);
            this.cjh.setDispathEventAction(new m(this));
            this.cjB.setItemOnclickListener(this.cjS);
        }
    }

    private void ahp() {
        if (this.cjB != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.btn_frs_shop);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bTA.getPageContext().getPageActivity(), r.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aR(this.bTA.getPageContext().getPageActivity());
                this.cjB = null;
                this.cjC = null;
                return;
            }
            int e = com.baidu.adp.lib.util.k.e(this.bTA.getPageContext().getPageActivity(), r.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            try {
                this.cjD = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjD.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjD.setLayoutParams(layoutParams);
                this.cjE = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjE.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjE.setLayoutParams(layoutParams);
                this.cjF = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjF.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjF.setLayoutParams(layoutParams);
                this.cjG = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjG.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjG.setLayoutParams(layoutParams);
                this.cjH = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjH.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjH.setLayoutParams(layoutParams);
                this.cjI = new com.baidu.tieba.b.d.f(this.bTA.getPageContext().getPageActivity());
                this.cjI.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cjI.setLayoutParams(layoutParams);
                this.cjh.addView(this.cjC);
                this.cjh.addView(this.cjB);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aR(this.bTA.getPageContext().getPageActivity());
                this.cjB = null;
                this.cjC = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean GN = EcommSwitchStatic.GN() & z4;
        if (this.cjB != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.cjD);
            arrayList.add(this.cjE);
            if (z) {
                arrayList.add(this.cjF);
            }
            if (z2) {
                arrayList.add(this.cjG);
            }
            if (z3) {
                arrayList.add(this.cjH);
            }
            if (GN) {
                arrayList.add(this.cjI);
            }
            if (this.cjK != z || this.cjL != z2 || this.cjM != z3 || this.cjN != GN) {
                this.cjB.setWriteViewList(arrayList);
                this.cjK = z;
                this.cjL = z2;
                this.cjM = z3;
                this.cjN = GN;
            }
            this.cjB.OI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aeL() {
        if (this.cjB != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cjQ);
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cjR);
            this.cjB.OE();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aeM() {
        if (this.cjB != null) {
            if (!this.cjB.gf(1)) {
                com.baidu.adp.lib.h.h.eG().postDelayed(this.cjQ, 1000L);
            }
            this.cjB.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aeN() {
        if (this.cjB != null) {
            this.cjB.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean acS() {
        if (this.cjB == null || this.cjB.gf(1)) {
            return false;
        }
        this.cjB.OG();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cjC != null) {
            this.cjC.onChangeSkinType(i);
        }
    }
}
