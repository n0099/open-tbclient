package com.baidu.tieba.frs.h;

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
import com.baidu.tieba.a.d.b;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.x bgH;
    private FrsActivity bjB;
    private NoPressedRelativeLayout btR;
    public com.baidu.tieba.a.d.b btZ;
    private b.a bua;
    public com.baidu.tieba.a.d.f bub;
    public com.baidu.tieba.a.d.f buc;
    public com.baidu.tieba.a.d.f bud;
    public com.baidu.tieba.a.d.f bue;
    public com.baidu.tieba.a.d.f buf;
    public com.baidu.tieba.a.d.f bug;
    public TextView buh;
    private boolean bui = false;
    private boolean buj = false;
    private boolean buk = false;
    private boolean bul = false;
    private Runnable bum = new f(this);
    private Runnable bun = new g(this);
    private View.OnClickListener buo = new h(this);

    private boolean TH() {
        return UtilHelper.detectOpenGLES20(this.bjB.getPageContext().getPageActivity());
    }

    public e(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bjB = frsActivity;
            this.btR = noPressedRelativeLayout;
            if (TH()) {
                as(this.bjB.getPageContext().getPageActivity());
            } else {
                at(this.bjB.getPageContext().getPageActivity());
            }
        }
    }

    private void as(Context context) {
        this.btZ = au(context);
        this.bua = av(context);
        this.btZ.setShadeViewContainer(this.bua);
        com.baidu.adp.lib.h.h.dL().postDelayed(this.bun, 100L);
    }

    public void at(Context context) {
        this.buh = new TextView(context);
        int c = com.baidu.adp.lib.util.k.c(context, t.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c, c);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, t.e.ds20), com.baidu.adp.lib.util.k.c(context, t.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.buh.setBackgroundResource(t.f.btn_frs_post_more);
        this.buh.setLayoutParams(layoutParams);
        this.buh.setOnClickListener(new i(this));
        this.btR.addView(this.buh);
        this.buh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PP() {
        if (this.bjB != null) {
            boolean z = (this.bjB.PZ() == null || !TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bjB.PZ().avD() == null || this.bjB.PZ().avD().getAnchorPower() == null || this.bjB.PZ().avD().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            boolean Fc = this.bjB.PZ().getUserData().canPostHi() ? com.baidu.tbadk.plugins.g.Fc() : false;
            this.bgH = new com.baidu.tieba.frs.view.x(this.bjB.getPageContext(), this.btR, new j(this));
            this.bgH.d(z, showXiaoyingTool, Fc);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void cO(boolean z) {
        if (this.buh != null) {
            if (z) {
                this.buh.setVisibility(0);
            } else {
                this.buh.setVisibility(8);
            }
        } else if (this.btZ != null && this.bua != null) {
            if (z) {
                this.btZ.setVisibility(0);
                this.bua.setVisibility(0);
                return;
            }
            this.btZ.setVisibility(8);
            this.bua.setVisibility(8);
        }
    }

    private com.baidu.tieba.a.d.b au(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.a.d.b bVar = new com.baidu.tieba.a.d.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, t.e.ds20), com.baidu.adp.lib.util.k.c(context, t.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        bVar.setLayoutParams(layoutParams);
        bVar.setOrientation(1);
        bVar.setVisibility(8);
        return bVar;
    }

    private b.a av(Context context) {
        if (context == null) {
            return null;
        }
        b.a aVar = new b.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(context, t.e.ds20), com.baidu.adp.lib.util.k.c(context, t.e.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        TK();
        a(true, true, true, true);
        TJ();
    }

    private void TJ() {
        if (this.btZ != null) {
            k kVar = new k(this);
            this.buc.setDispathEventAction(kVar);
            this.bud.setDispathEventAction(kVar);
            this.bue.setDispathEventAction(kVar);
            this.buf.setDispathEventAction(kVar);
            this.bug.setDispathEventAction(kVar);
            this.btR.setDispathEventAction(new l(this));
            this.btZ.setItemOnclickListener(this.buo);
            this.bub.setForceInterrupt(true);
            this.btR.setTopOrderView(this.bub);
        }
    }

    private void TK() {
        if (this.btZ != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.btn_frs_post_th_activity);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bjB.getPageContext().getPageActivity(), t.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size7 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m11getInst().onAppMemoryLow();
                at(this.bjB.getPageContext().getPageActivity());
                this.btZ = null;
                this.bua = null;
                return;
            }
            int c = com.baidu.adp.lib.util.k.c(this.bjB.getPageContext().getPageActivity(), t.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            this.bub = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.bub.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.bub.setLayoutParams(layoutParams);
            this.buc = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.buc.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.buc.setLayoutParams(layoutParams);
            this.bud = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.bud.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.bud.setLayoutParams(layoutParams);
            this.bue = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.bue.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.bue.setLayoutParams(layoutParams);
            this.buf = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.buf.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.buf.setLayoutParams(layoutParams);
            this.bug = new com.baidu.tieba.a.d.f(this.bjB.getPageContext().getPageActivity());
            this.bug.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
            this.bug.setLayoutParams(layoutParams);
            this.btR.addView(this.bua);
            this.btR.addView(this.btZ);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.btZ != null) {
            ArrayList<com.baidu.tieba.a.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.bub);
            arrayList.add(this.buc);
            if (z) {
                arrayList.add(this.bud);
            }
            if (z2) {
                arrayList.add(this.bue);
            }
            if (z4) {
                arrayList.add(this.buf);
            }
            if (z3) {
                arrayList.add(this.bug);
            }
            if (this.bui != z || this.buj != z2 || this.buk != z3 || this.bul != z4) {
                this.btZ.setWriteViewList(arrayList);
                this.bui = z;
                this.buj = z2;
                this.buk = z3;
                this.bul = z4;
            }
            this.btZ.JF();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void SE() {
        if (this.btZ != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bum);
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bun);
            this.btZ.JB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void SF() {
        if (this.btZ != null && !this.btZ.fr(1)) {
            com.baidu.adp.lib.h.h.dL().postDelayed(this.bum, 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean QM() {
        if (this.btZ == null || this.btZ.fr(1)) {
            return false;
        }
        this.btZ.JD();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.bua != null) {
            this.bua.onChangeSkinType(i);
        }
    }
}
