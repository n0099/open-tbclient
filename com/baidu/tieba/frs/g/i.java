package com.baidu.tieba.frs.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.b.d.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.q bPj;
    private FrsActivity bQw;
    private NoPressedRelativeLayout ccU;
    public TextView cdA;
    public TextView cdG;
    public com.baidu.tieba.b.d.d cds;
    private d.a cdt;
    public com.baidu.tieba.b.d.h cdu;
    public com.baidu.tieba.b.d.h cdv;
    public com.baidu.tieba.b.d.h cdw;
    public com.baidu.tieba.b.d.h cdx;
    public com.baidu.tieba.b.d.h cdy;
    public com.baidu.tieba.b.d.h cdz;
    private boolean cdB = false;
    private boolean cdC = false;
    private boolean cdD = false;
    private boolean cdE = false;
    private boolean cdF = false;
    private Runnable cdH = new j(this);
    private Runnable cdI = new m(this);
    private View.OnClickListener cdJ = new n(this);
    private Runnable cdK = new o(this);
    private Runnable cdL = new p(this);

    private boolean aeK() {
        return com.baidu.tbadk.core.util.ai.vJ().vR();
    }

    public i(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bQw = frsActivity;
            this.ccU = noPressedRelativeLayout;
            if (aeK()) {
                bi(this.bQw.getPageContext().getPageActivity());
            } else {
                bj(this.bQw.getPageContext().getPageActivity());
            }
        }
    }

    private void bi(Context context) {
        this.cds = bk(context);
        this.cdt = bl(context);
        this.cds.setShadeViewContainer(this.cdt);
    }

    public void bj(Context context) {
        this.cdA = new TextView(context);
        int g = com.baidu.adp.lib.util.k.g(context, w.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.cdA.setBackgroundResource(w.g.btn_frs_post_more);
        this.cdA.setLayoutParams(layoutParams);
        this.cdA.setOnClickListener(new q(this));
        this.ccU.addView(this.cdA);
        this.cdA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeL() {
        if (this.bQw != null) {
            boolean z = (this.bQw.aas() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bQw.aas().aKx() == null || this.bQw.aas().aKx().getAnchorPower() == null || this.bQw.aas().aKx().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bPj = new com.baidu.tieba.frs.view.q(this.bQw.getPageContext(), this.ccU, new r(this));
            this.bPj.d(z, showXiaoyingTool, z2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dN(boolean z) {
        if (this.cdA != null) {
            if (z) {
                this.cdA.setVisibility(0);
            } else {
                this.cdA.setVisibility(8);
            }
        } else if (!this.cdE) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cdI);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.cdI, 100L);
            this.cdF = z;
        } else if (this.cds != null && this.cdt != null && this.cdu != null) {
            if (z) {
                this.cds.setVisibility(0);
                this.cdt.setVisibility(0);
                this.cdu.setVisibility(0);
                return;
            }
            this.cds.setVisibility(8);
            this.cdt.setVisibility(8);
            this.cdu.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.d bk(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.b.d.d dVar = new com.baidu.tieba.b.d.d(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        dVar.setLayoutParams(layoutParams);
        dVar.setOrientation(1);
        dVar.setVisibility(8);
        return dVar;
    }

    private d.a bl(Context context) {
        if (context == null) {
            return null;
        }
        d.a aVar = new d.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeM() {
        aeO();
        a(true, true, true, true);
        aeN();
    }

    private void aeN() {
        if (this.cds != null) {
            s sVar = new s(this);
            this.cdv.setDispathEventAction(sVar);
            this.cdw.setDispathEventAction(sVar);
            this.cdx.setDispathEventAction(sVar);
            this.cdy.setDispathEventAction(sVar);
            this.cdz.setDispathEventAction(sVar);
            this.ccU.setDispathEventAction(new t(this));
            this.cds.setItemOnclickListener(this.cdJ);
        }
    }

    private void aeO() {
        if (this.cds != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bQw.getPageContext().getPageActivity(), w.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bj(this.bQw.getPageContext().getPageActivity());
                this.cds = null;
                this.cdt = null;
                return;
            }
            int g = com.baidu.adp.lib.util.k.g(this.bQw.getPageContext().getPageActivity(), w.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            try {
                this.cdu = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdu.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdu.setLayoutParams(layoutParams);
                this.cdv = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdv.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdv.setLayoutParams(layoutParams);
                this.cdw = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdw.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdw.setLayoutParams(layoutParams);
                this.cdx = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdx.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdx.setLayoutParams(layoutParams);
                this.cdy = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdy.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdy.setLayoutParams(layoutParams);
                this.cdz = new com.baidu.tieba.b.d.h(this.bQw.getPageContext().getPageActivity());
                this.cdz.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cdz.setLayoutParams(layoutParams);
                this.ccU.addView(this.cdt);
                this.ccU.addView(this.cds);
                this.cdG = new TextView(this.bQw.getPageContext().getPageActivity());
                this.cdG.setGravity(17);
                this.cdG.setTextColor(this.bQw.getResources().getColor(w.e.cp_cont_g));
                this.cdG.setTextSize(this.bQw.getResources().getDimensionPixelSize(w.f.ds10));
                this.cdG.setBackgroundResource(w.g.pic_sign_tip_right);
                this.cdG.setSingleLine(true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bj(this.bQw.getPageContext().getPageActivity());
                this.cds = null;
                this.cdt = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.cds != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.cdu);
            arrayList.add(this.cdv);
            if (z4) {
                arrayList.add(this.cdz);
            }
            if (z) {
                arrayList.add(this.cdw);
            }
            if (z2) {
                arrayList.add(this.cdx);
            }
            if (z3) {
                arrayList.add(this.cdy);
            }
            if (this.cdB != z || this.cdC != z2 || this.cdD != z3) {
                this.cds.setWriteViewList(arrayList);
                this.cdB = z;
                this.cdC = z2;
                this.cdD = z3;
            }
            this.cds.Tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.cdG.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.cdG.setPadding((int) this.bQw.getResources().getDimension(w.f.ds8), (int) this.bQw.getResources().getDimension(w.f.ds8), (int) this.bQw.getResources().getDimension(w.f.ds16), (int) this.bQw.getResources().getDimension(w.f.ds8));
                        com.baidu.adp.lib.g.h.fS().postDelayed(this.cdK, 440L);
                        com.baidu.tbadk.core.sharedPref.b.uL().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void acD() {
        if (this.cds != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cdH);
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cdI);
            this.cds.Tb();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void acE() {
        if (this.cds != null) {
            if (!this.cds.gM(1)) {
                com.baidu.adp.lib.g.h.fS().postDelayed(this.cdH, 1000L);
            }
            this.cds.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void acF() {
        if (this.cds != null) {
            this.cds.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean aaV() {
        if (this.cds == null || this.cds.gM(1)) {
            return false;
        }
        if (this.cdG != null) {
            this.cdG.setVisibility(8);
        }
        this.cds.Td();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cdt != null) {
            this.cdt.onChangeSkinType(i);
        }
    }

    public boolean aeP() {
        com.baidu.tieba.tbadkCore.n aas;
        if (this.bQw != null && (aas = this.bQw.aas()) != null) {
            if (bg.aK(this.bQw.getPageContext().getPageActivity())) {
                AntiData rb = aas.rb();
                if (rb != null) {
                    if (a(rb.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (rb.getIfpost() == 0 && !StringUtils.isNull(rb.getForbid_info())) {
                        String forbid_info = rb.getForbid_info();
                        if (com.baidu.tbadk.core.util.au.dB(forbid_info) > 14) {
                            String fixedText = com.baidu.tbadk.core.util.au.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bQw.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
                        b.Q(1.25f);
                        b.tY();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bQw.getPageContext().getPageActivity());
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bQw.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        aVar.cE(com.baidu.tbadk.core.util.au.getFixedText(str, 50, true));
        aVar.b(com.baidu.tbadk.core.util.au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.bQw.getResources().getString(w.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(com.baidu.tbadk.core.util.au.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bQw.getPageContext()).tQ();
        return true;
    }
}
