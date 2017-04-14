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
    public com.baidu.tieba.frs.view.q bMS;
    private FrsActivity bOf;
    private NoPressedRelativeLayout caD;
    public com.baidu.tieba.b.d.d cbb;
    private d.a cbc;
    public com.baidu.tieba.b.d.h cbd;
    public com.baidu.tieba.b.d.h cbe;
    public com.baidu.tieba.b.d.h cbf;
    public com.baidu.tieba.b.d.h cbg;
    public com.baidu.tieba.b.d.h cbh;
    public com.baidu.tieba.b.d.h cbi;
    public TextView cbj;
    public TextView cbp;
    private boolean cbk = false;
    private boolean cbl = false;
    private boolean cbm = false;
    private boolean cbn = false;
    private boolean cbo = false;
    private Runnable cbq = new j(this);
    private Runnable cbr = new m(this);
    private View.OnClickListener cbs = new n(this);
    private Runnable cbt = new o(this);
    private Runnable cbu = new p(this);

    private boolean adJ() {
        return com.baidu.tbadk.core.util.ai.vJ().vR();
    }

    public i(FrsActivity frsActivity, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsActivity != null && noPressedRelativeLayout != null) {
            this.bOf = frsActivity;
            this.caD = noPressedRelativeLayout;
            if (adJ()) {
                bi(this.bOf.getPageContext().getPageActivity());
            } else {
                bj(this.bOf.getPageContext().getPageActivity());
            }
        }
    }

    private void bi(Context context) {
        this.cbb = bk(context);
        this.cbc = bl(context);
        this.cbb.setShadeViewContainer(this.cbc);
    }

    public void bj(Context context) {
        this.cbj = new TextView(context);
        int g = com.baidu.adp.lib.util.k.g(context, w.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.cbj.setBackgroundResource(w.g.btn_frs_post_more);
        this.cbj.setLayoutParams(layoutParams);
        this.cbj.setOnClickListener(new q(this));
        this.caD.addView(this.cbj);
        this.cbj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adK() {
        if (this.bOf != null) {
            boolean z = (this.bOf.Zr() == null || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bOf.Zr().aJw() == null || this.bOf.Zr().aJw().getAnchorPower() == null || this.bOf.Zr().aJw().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bMS = new com.baidu.tieba.frs.view.q(this.bOf.getPageContext(), this.caD, new r(this));
            this.bMS.d(z, showXiaoyingTool, z2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dD(boolean z) {
        if (this.cbj != null) {
            if (z) {
                this.cbj.setVisibility(0);
            } else {
                this.cbj.setVisibility(8);
            }
        } else if (!this.cbn) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cbr);
            com.baidu.adp.lib.g.h.fR().postDelayed(this.cbr, 100L);
            this.cbo = z;
        } else if (this.cbb != null && this.cbc != null && this.cbd != null) {
            if (z) {
                this.cbb.setVisibility(0);
                this.cbc.setVisibility(0);
                this.cbd.setVisibility(0);
                return;
            }
            this.cbb.setVisibility(8);
            this.cbc.setVisibility(8);
            this.cbd.setVisibility(8);
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
    public void adL() {
        adN();
        a(true, true, true, true);
        adM();
    }

    private void adM() {
        if (this.cbb != null) {
            s sVar = new s(this);
            this.cbe.setDispathEventAction(sVar);
            this.cbf.setDispathEventAction(sVar);
            this.cbg.setDispathEventAction(sVar);
            this.cbh.setDispathEventAction(sVar);
            this.cbi.setDispathEventAction(sVar);
            this.caD.setDispathEventAction(new t(this));
            this.cbb.setItemOnclickListener(this.cbs);
        }
    }

    private void adN() {
        if (this.cbb != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_live);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_vote);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size8 = BitmapHelper.getResBitmapPowerOf2Size(this.bOf.getPageContext().getPageActivity(), w.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size6 == null || resBitmapPowerOf2Size8 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bj(this.bOf.getPageContext().getPageActivity());
                this.cbb = null;
                this.cbc = null;
                return;
            }
            int g = com.baidu.adp.lib.util.k.g(this.bOf.getPageContext().getPageActivity(), w.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            try {
                this.cbd = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbd.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size8, resBitmapPowerOf2Size2, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbd.setLayoutParams(layoutParams);
                this.cbe = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbe.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbe.setLayoutParams(layoutParams);
                this.cbf = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbf.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbf.setLayoutParams(layoutParams);
                this.cbg = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbg.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbg.setLayoutParams(layoutParams);
                this.cbh = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbh.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbh.setLayoutParams(layoutParams);
                this.cbi = new com.baidu.tieba.b.d.h(this.bOf.getPageContext().getPageActivity());
                this.cbi.b(resBitmapPowerOf2Size7, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8, resBitmapPowerOf2Size8);
                this.cbi.setLayoutParams(layoutParams);
                this.caD.addView(this.cbc);
                this.caD.addView(this.cbb);
                this.cbp = new TextView(this.bOf.getPageContext().getPageActivity());
                this.cbp.setGravity(17);
                this.cbp.setTextColor(this.bOf.getResources().getColor(w.e.cp_cont_g));
                this.cbp.setTextSize(this.bOf.getResources().getDimensionPixelSize(w.f.ds10));
                this.cbp.setBackgroundResource(w.g.pic_sign_tip_right);
                this.cbp.setSingleLine(true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bj(this.bOf.getPageContext().getPageActivity());
                this.cbb = null;
                this.cbc = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.cbb != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.cbd);
            arrayList.add(this.cbe);
            if (z4) {
                arrayList.add(this.cbi);
            }
            if (z) {
                arrayList.add(this.cbf);
            }
            if (z2) {
                arrayList.add(this.cbg);
            }
            if (z3) {
                arrayList.add(this.cbh);
            }
            if (this.cbk != z || this.cbl != z2 || this.cbm != z3) {
                this.cbb.setWriteViewList(arrayList);
                this.cbk = z;
                this.cbl = z2;
                this.cbm = z3;
            }
            this.cbb.Sd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.cbp.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.cbp.setPadding((int) this.bOf.getResources().getDimension(w.f.ds8), (int) this.bOf.getResources().getDimension(w.f.ds8), (int) this.bOf.getResources().getDimension(w.f.ds16), (int) this.bOf.getResources().getDimension(w.f.ds8));
                        com.baidu.adp.lib.g.h.fR().postDelayed(this.cbt, 440L);
                        com.baidu.tbadk.core.sharedPref.b.uL().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abC() {
        if (this.cbb != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cbq);
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cbr);
            this.cbb.RZ();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abD() {
        if (this.cbb != null) {
            if (!this.cbb.gG(1)) {
                com.baidu.adp.lib.g.h.fR().postDelayed(this.cbq, 1000L);
            }
            this.cbb.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abE() {
        if (this.cbb != null) {
            this.cbb.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ZU() {
        if (this.cbb == null || this.cbb.gG(1)) {
            return false;
        }
        if (this.cbp != null) {
            this.cbp.setVisibility(8);
        }
        this.cbb.Sb();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cbc != null) {
            this.cbc.onChangeSkinType(i);
        }
    }

    public boolean adO() {
        com.baidu.tieba.tbadkCore.n Zr;
        if (this.bOf != null && (Zr = this.bOf.Zr()) != null) {
            if (bg.aK(this.bOf.getPageContext().getPageActivity())) {
                AntiData rb = Zr.rb();
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
                        BdToast b = BdToast.b(this.bOf.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bOf.getPageContext().getPageActivity());
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bOf.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        aVar.cE(com.baidu.tbadk.core.util.au.getFixedText(str, 50, true));
        aVar.b(com.baidu.tbadk.core.util.au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.bOf.getResources().getString(w.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(com.baidu.tbadk.core.util.au.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bOf.getPageContext()).tQ();
        return true;
    }
}
