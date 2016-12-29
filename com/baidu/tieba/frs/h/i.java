package com.baidu.tieba.frs.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.b.d.b;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.b.d.b bOL;
    private b.a bOM;
    public com.baidu.tieba.b.d.f bON;
    public com.baidu.tieba.b.d.f bOO;
    public com.baidu.tieba.b.d.f bOP;
    public com.baidu.tieba.b.d.f bOQ;
    public com.baidu.tieba.b.d.f bOR;
    public TextView bOS;
    private NoPressedRelativeLayout bOn;
    public com.baidu.tieba.frs.view.q byv;
    private FrsActivity bzH;
    private boolean bOT = false;
    private boolean bOU = false;
    private boolean bOV = false;
    private boolean bOW = false;
    private boolean bOX = false;
    private Runnable bOY = new j(this);
    private Runnable bOZ = new k(this);
    private View.OnClickListener bPa = new l(this);

    private boolean abH() {
        return UtilHelper.detectOpenGLES20(this.bzH.getPageContext().getPageActivity());
    }

    public i(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bzH = frsActivity;
            this.bOn = noPressedRelativeLayout;
            if (abH()) {
                aO(this.bzH.getPageContext().getPageActivity());
            } else {
                aP(this.bzH.getPageContext().getPageActivity());
            }
        }
    }

    private void aO(Context context) {
        this.bOL = aQ(context);
        this.bOM = aR(context);
        this.bOL.setShadeViewContainer(this.bOM);
    }

    public void aP(Context context) {
        this.bOS = new TextView(context);
        int e = com.baidu.adp.lib.util.k.e(context, r.e.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.e.ds20), com.baidu.adp.lib.util.k.e(context, r.e.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bOS.setBackgroundResource(r.f.btn_frs_post_more);
        this.bOS.setLayoutParams(layoutParams);
        this.bOS.setOnClickListener(new m(this));
        this.bOn.addView(this.bOS);
        this.bOS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abI() {
        boolean z;
        if (this.bzH != null) {
            if (this.bzH.WF() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && this.bzH.WF().aIk() != null && this.bzH.WF().aIk().getAnchorPower() != null && this.bzH.WF().aIk().getAnchorPower().can_add_live_post.intValue() != 2) {
                z = true;
            } else {
                z = false;
            }
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.byv = new com.baidu.tieba.frs.view.q(this.bzH.getPageContext(), this.bOn, new n(this));
            this.byv.p(z, showXiaoyingTool);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void du(boolean z) {
        if (this.bOS != null) {
            if (z) {
                this.bOS.setVisibility(0);
            } else {
                this.bOS.setVisibility(8);
            }
        } else if (!this.bOW) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bOZ);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bOZ, 100L);
            this.bOX = z;
        } else if (this.bOL != null && this.bOM != null && this.bON != null) {
            if (z) {
                this.bOL.setVisibility(0);
                this.bOM.setVisibility(0);
                this.bON.setVisibility(0);
                return;
            }
            this.bOL.setVisibility(8);
            this.bOM.setVisibility(8);
            this.bON.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.b aQ(Context context) {
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

    private b.a aR(Context context) {
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
    public void abJ() {
        abL();
        d(true, true, true);
        abK();
    }

    private void abK() {
        if (this.bOL != null) {
            o oVar = new o(this);
            this.bOO.setDispathEventAction(oVar);
            this.bOP.setDispathEventAction(oVar);
            this.bOQ.setDispathEventAction(oVar);
            this.bOR.setDispathEventAction(oVar);
            this.bOn.setDispathEventAction(new p(this));
            this.bOL.setItemOnclickListener(this.bPa);
        }
    }

    private void abL() {
        if (this.bOL != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bzH.getPageContext().getPageActivity(), r.f.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size7 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aP(this.bzH.getPageContext().getPageActivity());
                this.bOL = null;
                this.bOM = null;
                return;
            }
            int e = com.baidu.adp.lib.util.k.e(this.bzH.getPageContext().getPageActivity(), r.e.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            try {
                this.bON = new com.baidu.tieba.b.d.f(this.bzH.getPageContext().getPageActivity());
                this.bON.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size7, resBitmapPowerOf2Size2, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.bON.setLayoutParams(layoutParams);
                this.bOO = new com.baidu.tieba.b.d.f(this.bzH.getPageContext().getPageActivity());
                this.bOO.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.bOO.setLayoutParams(layoutParams);
                this.bOP = new com.baidu.tieba.b.d.f(this.bzH.getPageContext().getPageActivity());
                this.bOP.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.bOP.setLayoutParams(layoutParams);
                this.bOQ = new com.baidu.tieba.b.d.f(this.bzH.getPageContext().getPageActivity());
                this.bOQ.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.bOQ.setLayoutParams(layoutParams);
                this.bOR = new com.baidu.tieba.b.d.f(this.bzH.getPageContext().getPageActivity());
                this.bOR.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.bOR.setLayoutParams(layoutParams);
                this.bOn.addView(this.bOM);
                this.bOn.addView(this.bOL);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aP(this.bzH.getPageContext().getPageActivity());
                this.bOL = null;
                this.bOM = null;
            }
        }
    }

    public void d(boolean z, boolean z2, boolean z3) {
        if (this.bOL != null) {
            ArrayList<com.baidu.tieba.b.d.f> arrayList = new ArrayList<>();
            arrayList.add(this.bON);
            arrayList.add(this.bOO);
            if (z) {
                arrayList.add(this.bOP);
            }
            if (z2) {
                arrayList.add(this.bOQ);
            }
            if (z3) {
                arrayList.add(this.bOR);
            }
            if (this.bOT != z || this.bOU != z2 || this.bOV != z3) {
                this.bOL.setWriteViewList(arrayList);
                this.bOT = z;
                this.bOU = z2;
                this.bOV = z3;
            }
            this.bOL.NU();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Zg() {
        if (this.bOL != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bOY);
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bOZ);
            this.bOL.NQ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Zh() {
        if (this.bOL != null) {
            if (!this.bOL.ge(1)) {
                com.baidu.adp.lib.h.h.eG().postDelayed(this.bOY, 1000L);
            }
            this.bOL.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void Zi() {
        if (this.bOL != null) {
            this.bOL.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean Xi() {
        if (this.bOL == null || this.bOL.ge(1)) {
            return false;
        }
        this.bOL.NS();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.bOM != null) {
            this.bOM.onChangeSkinType(i);
        }
    }

    public boolean abM() {
        com.baidu.tieba.tbadkCore.o WF;
        if (this.bzH != null && (WF = this.bzH.WF()) != null) {
            if (bh.ai(this.bzH.getPageContext().getPageActivity())) {
                AntiData qt = WF.qt();
                if (qt != null) {
                    if (a(qt.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qt.getIfpost() == 0 && !StringUtils.isNull(qt.getForbid_info())) {
                        String forbid_info = qt.getForbid_info();
                        if (av.dD(forbid_info) > 14) {
                            String fixedText = av.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bzH.getPageContext().getPageActivity(), forbid_info, r.f.icon_toast_game_error);
                        b.P(1.25f);
                        b.tj();
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(BlockPopInfoData blockPopInfoData) {
        String str;
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bzH.getPageContext().getPageActivity());
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bzH.getResources().getString(r.j.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        aVar.cG(av.getFixedText(str, 50, true));
        aVar.b(av.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.bzH.getResources().getString(r.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new q(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(av.getFixedText(blockPopInfoData.ahead_info, 4, true), new r(this, blockPopInfoData));
        }
        aVar.b(this.bzH.getPageContext()).tb();
        return true;
    }
}
