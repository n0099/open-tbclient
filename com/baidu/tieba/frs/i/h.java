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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.p bPF;
    private FrsActivity bRp;
    private NoPressedRelativeLayout ceJ;
    public com.baidu.tieba.b.d.b ceR;
    private b.a ceS;
    public com.baidu.tieba.b.d.f ceT;
    public com.baidu.tieba.b.d.f ceU;
    public com.baidu.tieba.b.d.f ceV;
    public com.baidu.tieba.b.d.f ceW;
    public com.baidu.tieba.b.d.f ceX;
    public com.baidu.tieba.b.d.f ceY;
    public com.baidu.tieba.b.d.f ceZ;
    public TextView cfa;
    private boolean cfb = false;
    private boolean cfc = false;
    private boolean cfd = false;
    private boolean cfe = false;
    private boolean cff = true;
    private boolean cfg = false;
    private boolean cfh = false;
    private Runnable cfi = new i(this);
    private Runnable cfj = new j(this);
    private View.OnClickListener cfk = new k(this);

    private boolean afk() {
        return UtilHelper.detectOpenGLES20(this.bRp.getPageContext().getPageActivity());
    }

    public h(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bRp = frsActivity;
            this.ceJ = noPressedRelativeLayout;
            if (afk()) {
                aG(this.bRp.getPageContext().getPageActivity());
            } else {
                aH(this.bRp.getPageContext().getPageActivity());
            }
        }
    }

    private void aG(Context context) {
        this.ceR = aI(context);
        this.ceS = aJ(context);
        this.ceR.setShadeViewContainer(this.ceS);
    }

    public void aH(Context context) {
        this.cfa = new TextView(context);
        int e = com.baidu.adp.lib.util.k.e(context, t.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, t.e.ds20), com.baidu.adp.lib.util.k.e(context, t.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.cfa.setBackgroundResource(t.f.btn_frs_post_more);
        this.cfa.setLayoutParams(layoutParams);
        this.cfa.setOnClickListener(new l(this));
        this.ceJ.addView(this.cfa);
        this.cfa.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        if (this.bRp != null) {
            boolean z = (this.bRp.aaR() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bRp.aaR().aLP() == null || this.bRp.aaR().aLP().getAnchorPower() == null || this.bRp.aaR().aLP().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            boolean GE = this.bRp.aaR().getUserData().canPostHi() ? com.baidu.tbadk.plugins.g.GE() : false;
            this.bPF = new com.baidu.tieba.frs.view.p(this.bRp.getPageContext(), this.ceJ, new m(this));
            this.bPF.d(z, showXiaoyingTool, GE);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dF(boolean z) {
        if (this.cfa != null) {
            if (z) {
                this.cfa.setVisibility(0);
            } else {
                this.cfa.setVisibility(8);
            }
        } else if (!this.cfg) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfj);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cfj, 100L);
            this.cfh = z;
        } else if (this.ceR != null && this.ceS != null && this.ceT != null) {
            if (z) {
                this.ceR.setVisibility(0);
                this.ceS.setVisibility(0);
                this.ceT.setVisibility(0);
                return;
            }
            this.ceR.setVisibility(8);
            this.ceS.setVisibility(8);
            this.ceT.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.b aI(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.b.d.b bVar = new com.baidu.tieba.b.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, t.e.ds20), com.baidu.adp.lib.util.k.e(context, t.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        bVar.setLayoutParams(layoutParams);
        bVar.setOrientation(1);
        bVar.setVisibility(8);
        return bVar;
    }

    private b.a aJ(Context context) {
        if (context == null) {
            return null;
        }
        b.a aVar = new b.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, t.e.ds20), com.baidu.adp.lib.util.k.e(context, t.e.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        afo();
        b(true, true, true, true, true);
        afn();
    }

    private void afn() {
        if (this.ceR != null) {
            n nVar = new n(this);
            this.ceU.setDispathEventAction(nVar);
            this.ceV.setDispathEventAction(nVar);
            this.ceW.setDispathEventAction(nVar);
            this.ceX.setDispathEventAction(nVar);
            this.ceY.setDispathEventAction(nVar);
            this.ceZ.setDispathEventAction(nVar);
            this.ceJ.setDispathEventAction(new o(this));
            this.ceR.setItemOnclickListener(this.cfk);
        }
    }

    private void afo() {
        if (this.ceR != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_post_th_activity);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.btn_frs_shop);
            Bitmap resBitmapPowerOf2Size9 = BitmapHelper.getResBitmapPowerOf2Size(this.bRp.getPageContext().getPageActivity(), t.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size7 == null || resBitmapPowerOf2Size9 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aH(this.bRp.getPageContext().getPageActivity());
                this.ceR = null;
                this.ceS = null;
                return;
            }
            int e = com.baidu.adp.lib.util.k.e(this.bRp.getPageContext().getPageActivity(), t.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            this.ceT = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceT.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size9, resBitmapPowerOf2Size2, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceT.setLayoutParams(layoutParams);
            this.ceU = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceU.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceU.setLayoutParams(layoutParams);
            this.ceV = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceV.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceV.setLayoutParams(layoutParams);
            this.ceW = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceW.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceW.setLayoutParams(layoutParams);
            this.ceX = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceX.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceX.setLayoutParams(layoutParams);
            this.ceY = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceY.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceY.setLayoutParams(layoutParams);
            this.ceZ = new com.baidu.tieba.b.d.f(this.bRp.getPageContext().getPageActivity());
            this.ceZ.b(resBitmapPowerOf2Size8, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9, resBitmapPowerOf2Size9);
            this.ceZ.setLayoutParams(layoutParams);
            this.ceJ.addView(this.ceS);
            this.ceJ.addView(this.ceR);
        }
    }

    public void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean GL = EcommSwitchStatic.GL() & z5;
        if (this.ceR != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.ceT);
            arrayList.add(this.ceU);
            if (z) {
                arrayList.add(this.ceV);
            }
            if (z2) {
                arrayList.add(this.ceW);
            }
            if (z4) {
                arrayList.add(this.ceX);
            }
            if (z3) {
                arrayList.add(this.ceY);
            }
            if (GL) {
                arrayList.add(this.ceZ);
            }
            if (this.cfb != z || this.cfc != z2 || this.cfd != z3 || this.cfe != z4 || this.cff != GL) {
                this.ceR.setWriteViewList(arrayList);
                this.cfb = z;
                this.cfc = z2;
                this.cfd = z3;
                this.cfe = z4;
                this.cff = GL;
            }
            this.ceR.Ne();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void adj() {
        if (this.ceR != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfi);
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfj);
            this.ceR.Na();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void adk() {
        if (this.ceR != null && !this.ceR.ga(1)) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cfi, 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean abx() {
        if (this.ceR == null || this.ceR.ga(1)) {
            return false;
        }
        this.ceR.Nc();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.ceS != null) {
            this.ceS.onChangeSkinType(i);
        }
    }
}
