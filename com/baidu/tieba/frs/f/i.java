package com.baidu.tieba.frs.f;

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
    public com.baidu.tieba.frs.view.q bNc;
    private FrsActivity bOq;
    public com.baidu.tieba.b.d.d ccA;
    private d.a ccB;
    public com.baidu.tieba.b.d.h ccC;
    public com.baidu.tieba.b.d.h ccD;
    public com.baidu.tieba.b.d.h ccE;
    public com.baidu.tieba.b.d.h ccF;
    public com.baidu.tieba.b.d.h ccG;
    public com.baidu.tieba.b.d.h ccH;
    public TextView ccI;
    public TextView ccO;
    private NoPressedRelativeLayout ccc;
    private boolean ccJ = false;
    private boolean ccK = false;
    private boolean ccL = false;
    private boolean ccM = false;
    private boolean ccN = false;
    private Runnable ccP = new j(this);
    private Runnable ccQ = new m(this);
    private View.OnClickListener ccR = new n(this);
    private Runnable ccS = new o(this);
    private Runnable ccT = new p(this);

    private boolean adO() {
        return com.baidu.tbadk.core.util.ai.vm().vu();
    }

    public i(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bOq = frsActivity;
            this.ccc = noPressedRelativeLayout;
            if (adO()) {
                bo(this.bOq.getPageContext().getPageActivity());
            } else {
                bp(this.bOq.getPageContext().getPageActivity());
            }
        }
    }

    private void bo(Context context) {
        this.ccA = bq(context);
        this.ccB = br(context);
        this.ccA.setShadeViewContainer(this.ccB);
    }

    public void bp(Context context) {
        this.ccI = new TextView(context);
        int g = com.baidu.adp.lib.util.k.g(context, w.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ccI.setBackgroundResource(w.g.btn_frs_post_more);
        this.ccI.setLayoutParams(layoutParams);
        this.ccI.setOnClickListener(new q(this));
        this.ccc.addView(this.ccI);
        this.ccI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adP() {
        if (this.bOq != null) {
            boolean z = (this.bOq.YV() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bOq.YV().aJp() == null || this.bOq.YV().aJp().getAnchorPower() == null || this.bOq.YV().aJp().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bNc = new com.baidu.tieba.frs.view.q(this.bOq.getPageContext(), this.ccc, new r(this));
            this.bNc.d(z, showXiaoyingTool, z2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dB(boolean z) {
        if (this.ccI != null) {
            if (z) {
                this.ccI.setVisibility(0);
            } else {
                this.ccI.setVisibility(8);
            }
        } else if (!this.ccM) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.ccQ);
            com.baidu.adp.lib.g.h.fM().postDelayed(this.ccQ, 100L);
            this.ccN = z;
        } else if (this.ccA != null && this.ccB != null && this.ccC != null) {
            if (z) {
                this.ccA.setVisibility(0);
                this.ccB.setVisibility(0);
                this.ccC.setVisibility(0);
                return;
            }
            this.ccA.setVisibility(8);
            this.ccB.setVisibility(8);
            this.ccC.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.d bq(Context context) {
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

    private d.a br(Context context) {
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
    public void adQ() {
        adS();
        a(true, true, true, true);
        adR();
    }

    private void adR() {
        if (this.ccA != null) {
            s sVar = new s(this);
            this.ccD.setDispathEventAction(sVar);
            this.ccE.setDispathEventAction(sVar);
            this.ccF.setDispathEventAction(sVar);
            this.ccG.setDispathEventAction(sVar);
            this.ccH.setDispathEventAction(sVar);
            this.ccc.setDispathEventAction(new t(this));
            this.ccA.setItemOnclickListener(this.ccR);
        }
    }

    private void adS() {
        if (this.ccA != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bOq.getPageContext().getPageActivity(), w.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bp(this.bOq.getPageContext().getPageActivity());
                this.ccA = null;
                this.ccB = null;
                return;
            }
            int g = com.baidu.adp.lib.util.k.g(this.bOq.getPageContext().getPageActivity(), w.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            try {
                this.ccC = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccC.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccC.setLayoutParams(layoutParams);
                this.ccD = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccD.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccD.setLayoutParams(layoutParams);
                this.ccE = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccE.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccE.setLayoutParams(layoutParams);
                this.ccF = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccF.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccF.setLayoutParams(layoutParams);
                this.ccG = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccG.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccG.setLayoutParams(layoutParams);
                this.ccH = new com.baidu.tieba.b.d.h(this.bOq.getPageContext().getPageActivity());
                this.ccH.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.ccH.setLayoutParams(layoutParams);
                this.ccc.addView(this.ccB);
                this.ccc.addView(this.ccA);
                this.ccO = new TextView(this.bOq.getPageContext().getPageActivity());
                this.ccO.setGravity(17);
                this.ccO.setTextColor(this.bOq.getResources().getColor(w.e.cp_cont_g));
                this.ccO.setTextSize(this.bOq.getResources().getDimensionPixelSize(w.f.ds10));
                this.ccO.setBackgroundResource(w.g.pic_sign_tip_right);
                this.ccO.setSingleLine(true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bp(this.bOq.getPageContext().getPageActivity());
                this.ccA = null;
                this.ccB = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.ccA != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.ccC);
            arrayList.add(this.ccD);
            if (z4) {
                arrayList.add(this.ccH);
            }
            if (z) {
                arrayList.add(this.ccE);
            }
            if (z2) {
                arrayList.add(this.ccF);
            }
            if (z3) {
                arrayList.add(this.ccG);
            }
            if (this.ccJ != z || this.ccK != z2 || this.ccL != z3) {
                this.ccA.setWriteViewList(arrayList);
                this.ccJ = z;
                this.ccK = z2;
                this.ccL = z3;
            }
            this.ccA.RF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.uo().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.ccO.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.ccO.setPadding((int) this.bOq.getResources().getDimension(w.f.ds8), (int) this.bOq.getResources().getDimension(w.f.ds8), (int) this.bOq.getResources().getDimension(w.f.ds16), (int) this.bOq.getResources().getDimension(w.f.ds8));
                        com.baidu.adp.lib.g.h.fM().postDelayed(this.ccS, 440L);
                        com.baidu.tbadk.core.sharedPref.b.uo().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abf() {
        if (this.ccA != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.ccP);
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.ccQ);
            this.ccA.RB();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abg() {
        if (this.ccA != null) {
            if (!this.ccA.gD(1)) {
                com.baidu.adp.lib.g.h.fM().postDelayed(this.ccP, 1000L);
            }
            this.ccA.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abh() {
        if (this.ccA != null) {
            this.ccA.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean Zw() {
        if (this.ccA == null || this.ccA.gD(1)) {
            return false;
        }
        if (this.ccO != null) {
            this.ccO.setVisibility(8);
        }
        this.ccA.RD();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.ccB != null) {
            this.ccB.onChangeSkinType(i);
        }
    }

    public boolean adT() {
        com.baidu.tieba.tbadkCore.n YV;
        if (this.bOq != null && (YV = this.bOq.YV()) != null) {
            if (bg.aI(this.bOq.getPageContext().getPageActivity())) {
                AntiData qE = YV.qE();
                if (qE != null) {
                    if (a(qE.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qE.getIfpost() == 0 && !StringUtils.isNull(qE.getForbid_info())) {
                        String forbid_info = qE.getForbid_info();
                        if (com.baidu.tbadk.core.util.au.dv(forbid_info) > 14) {
                            String fixedText = com.baidu.tbadk.core.util.au.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bOq.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
                        b.Q(1.25f);
                        b.tA();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bOq.getPageContext().getPageActivity());
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bOq.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        aVar.cx(com.baidu.tbadk.core.util.au.getFixedText(str, 50, true));
        aVar.b(com.baidu.tbadk.core.util.au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.bOq.getResources().getString(w.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(com.baidu.tbadk.core.util.au.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bOq.getPageContext()).ts();
        return true;
    }
}
