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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.b.d.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.q bFU;
    private FrsActivity bHh;
    private NoPressedRelativeLayout bUK;
    public com.baidu.tieba.b.d.d bVi;
    private d.a bVj;
    public com.baidu.tieba.b.d.h bVk;
    public com.baidu.tieba.b.d.h bVl;
    public com.baidu.tieba.b.d.h bVm;
    public com.baidu.tieba.b.d.h bVn;
    public com.baidu.tieba.b.d.h bVo;
    public com.baidu.tieba.b.d.h bVp;
    public TextView bVq;
    public TextView bVw;
    private boolean bVr = false;
    private boolean bVs = false;
    private boolean bVt = false;
    private boolean bVu = false;
    private boolean bVv = false;
    private Runnable bVx = new j(this);
    private Runnable bVy = new m(this);
    private View.OnClickListener bVz = new n(this);
    private Runnable bVA = new o(this);
    private Runnable bVB = new p(this);

    private boolean acO() {
        return com.baidu.tbadk.core.util.ah.uP().uX();
    }

    public i(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bHh = frsActivity;
            this.bUK = noPressedRelativeLayout;
            if (acO()) {
                aP(this.bHh.getPageContext().getPageActivity());
            } else {
                aQ(this.bHh.getPageContext().getPageActivity());
            }
        }
    }

    private void aP(Context context) {
        this.bVi = aR(context);
        this.bVj = aS(context);
        this.bVi.setShadeViewContainer(this.bVj);
    }

    public void aQ(Context context) {
        this.bVq = new TextView(context);
        int e = com.baidu.adp.lib.util.k.e(context, r.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, e);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.f.ds20), com.baidu.adp.lib.util.k.e(context, r.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bVq.setBackgroundResource(r.g.btn_frs_post_more);
        this.bVq.setLayoutParams(layoutParams);
        this.bVq.setOnClickListener(new q(this));
        this.bUK.addView(this.bVq);
        this.bVq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acP() {
        if (this.bHh != null) {
            boolean z = (this.bHh.XW() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bHh.XW().aJY() == null || this.bHh.XW().aJY().getAnchorPower() == null || this.bHh.XW().aJY().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bFU = new com.baidu.tieba.frs.view.q(this.bHh.getPageContext(), this.bUK, new r(this));
            this.bFU.d(z, showXiaoyingTool, z2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dB(boolean z) {
        if (this.bVq != null) {
            if (z) {
                this.bVq.setVisibility(0);
            } else {
                this.bVq.setVisibility(8);
            }
        } else if (!this.bVu) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bVy);
            com.baidu.adp.lib.g.h.eE().postDelayed(this.bVy, 100L);
            this.bVv = z;
        } else if (this.bVi != null && this.bVj != null && this.bVk != null) {
            if (z) {
                this.bVi.setVisibility(0);
                this.bVj.setVisibility(0);
                this.bVk.setVisibility(0);
                return;
            }
            this.bVi.setVisibility(8);
            this.bVj.setVisibility(8);
            this.bVk.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.d aR(Context context) {
        if (context == null) {
            return null;
        }
        com.baidu.tieba.b.d.d dVar = new com.baidu.tieba.b.d.d(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.f.ds20), com.baidu.adp.lib.util.k.e(context, r.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        dVar.setLayoutParams(layoutParams);
        dVar.setOrientation(1);
        dVar.setVisibility(8);
        return dVar;
    }

    private d.a aS(Context context) {
        if (context == null) {
            return null;
        }
        d.a aVar = new d.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(context, r.f.ds20), com.baidu.adp.lib.util.k.e(context, r.f.ds100));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        aVar.setLayoutParams(layoutParams);
        aVar.setOrientation(1);
        aVar.setVisibility(8);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acQ() {
        acS();
        a(true, true, true, true);
        acR();
    }

    private void acR() {
        if (this.bVi != null) {
            s sVar = new s(this);
            this.bVl.setDispathEventAction(sVar);
            this.bVm.setDispathEventAction(sVar);
            this.bVn.setDispathEventAction(sVar);
            this.bVo.setDispathEventAction(sVar);
            this.bVp.setDispathEventAction(sVar);
            this.bUK.setDispathEventAction(new t(this));
            this.bVi.setItemOnclickListener(this.bVz);
        }
    }

    private void acS() {
        if (this.bVi != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bHh.getPageContext().getPageActivity(), r.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aQ(this.bHh.getPageContext().getPageActivity());
                this.bVi = null;
                this.bVj = null;
                return;
            }
            int e = com.baidu.adp.lib.util.k.e(this.bHh.getPageContext().getPageActivity(), r.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            try {
                this.bVk = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVk.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVk.setLayoutParams(layoutParams);
                this.bVl = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVl.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVl.setLayoutParams(layoutParams);
                this.bVm = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVm.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVm.setLayoutParams(layoutParams);
                this.bVn = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVn.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVn.setLayoutParams(layoutParams);
                this.bVo = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVo.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVo.setLayoutParams(layoutParams);
                this.bVp = new com.baidu.tieba.b.d.h(this.bHh.getPageContext().getPageActivity());
                this.bVp.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.bVp.setLayoutParams(layoutParams);
                this.bUK.addView(this.bVj);
                this.bUK.addView(this.bVi);
                this.bVw = new TextView(this.bHh.getPageContext().getPageActivity());
                this.bVw.setGravity(17);
                this.bVw.setTextColor(this.bHh.getResources().getColor(r.e.cp_cont_g));
                this.bVw.setTextSize(this.bHh.getResources().getDimensionPixelSize(r.f.ds10));
                this.bVw.setBackgroundResource(r.g.pic_sign_tip_right);
                this.bVw.setSingleLine(true);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                aQ(this.bHh.getPageContext().getPageActivity());
                this.bVi = null;
                this.bVj = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.bVi != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.bVk);
            arrayList.add(this.bVl);
            if (z4) {
                arrayList.add(this.bVp);
            }
            if (z) {
                arrayList.add(this.bVm);
            }
            if (z2) {
                arrayList.add(this.bVn);
            }
            if (z3) {
                arrayList.add(this.bVo);
            }
            if (this.bVr != z || this.bVs != z2 || this.bVt != z3) {
                this.bVi.setWriteViewList(arrayList);
                this.bVr = z;
                this.bVs = z2;
                this.bVt = z3;
            }
            this.bVi.QN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.bVw.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.bVw.setPadding((int) this.bHh.getResources().getDimension(r.f.ds8), (int) this.bHh.getResources().getDimension(r.f.ds8), (int) this.bHh.getResources().getDimension(r.f.ds16), (int) this.bHh.getResources().getDimension(r.f.ds8));
                        com.baidu.adp.lib.g.h.eE().postDelayed(this.bVA, 440L);
                        com.baidu.tbadk.core.sharedPref.b.tQ().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aai() {
        if (this.bVi != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bVx);
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bVy);
            this.bVi.QJ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aaj() {
        if (this.bVi != null) {
            if (!this.bVi.gG(1)) {
                com.baidu.adp.lib.g.h.eE().postDelayed(this.bVx, 1000L);
            }
            this.bVi.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aak() {
        if (this.bVi != null) {
            this.bVi.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean Yx() {
        if (this.bVi == null || this.bVi.gG(1)) {
            return false;
        }
        if (this.bVw != null) {
            this.bVw.setVisibility(8);
        }
        this.bVi.QL();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.bVj != null) {
            this.bVj.onChangeSkinType(i);
        }
    }

    public boolean acT() {
        com.baidu.tieba.tbadkCore.n XW;
        if (this.bHh != null && (XW = this.bHh.XW()) != null) {
            if (bf.ak(this.bHh.getPageContext().getPageActivity())) {
                AntiData qm = XW.qm();
                if (qm != null) {
                    if (a(qm.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qm.getIfpost() == 0 && !StringUtils.isNull(qm.getForbid_info())) {
                        String forbid_info = qm.getForbid_info();
                        if (at.dB(forbid_info) > 14) {
                            String fixedText = at.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bHh.getPageContext().getPageActivity(), forbid_info, r.g.icon_toast_game_error);
                        b.Q(1.25f);
                        b.td();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bHh.getPageContext().getPageActivity());
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bHh.getResources().getString(r.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        aVar.cE(at.getFixedText(str, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.bHh.getResources().getString(r.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(at.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bHh.getPageContext()).sV();
        return true;
    }
}
