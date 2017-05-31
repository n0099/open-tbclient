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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.b.d.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.k bUl;
    private com.baidu.tieba.frs.r bVm;
    private NoPressedRelativeLayout cgT;
    public TextView chD;
    public com.baidu.tieba.b.d.d chq;
    private d.a chr;
    public com.baidu.tieba.b.d.h chs;
    public com.baidu.tieba.b.d.h cht;
    public com.baidu.tieba.b.d.h chu;
    public com.baidu.tieba.b.d.h chv;
    public com.baidu.tieba.b.d.h chw;
    public TextView chx;
    private boolean chy = false;
    private boolean chz = false;
    private boolean chA = false;
    private boolean chB = false;
    private boolean chC = false;
    private Runnable chE = new j(this);
    private Runnable chF = new m(this);
    private View.OnClickListener chG = new n(this);
    private Runnable chH = new o(this);
    private Runnable chI = new p(this);

    private boolean adP() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && com.baidu.tbadk.core.util.ai.uT().vc();
    }

    public i(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (rVar != null && noPressedRelativeLayout != null) {
            this.bVm = rVar;
            this.cgT = noPressedRelativeLayout;
            if (adP()) {
                bl(this.bVm.getPageContext().getPageActivity());
            } else {
                bm(this.bVm.getPageContext().getPageActivity());
            }
        }
    }

    private void bl(Context context) {
        this.chq = bn(context);
        this.chr = bo(context);
        this.chq.setShadeViewContainer(this.chr);
    }

    public void bm(Context context) {
        this.chx = new TextView(context);
        int g = com.baidu.adp.lib.util.k.g(context, w.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.chx.setBackgroundResource(w.g.btn_frs_post_more);
        this.chx.setLayoutParams(layoutParams);
        this.chx.setOnClickListener(new q(this));
        this.cgT.addView(this.chx);
        this.chx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adQ() {
        if (this.bVm != null) {
            boolean z = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bUl = new com.baidu.tieba.frs.view.k(this.bVm.getPageContext(), this.cgT, new r(this));
            this.bUl.f(false, showXiaoyingTool, z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ec(boolean z) {
        if (this.chx != null) {
            if (z) {
                this.chx.setVisibility(0);
            } else {
                this.chx.setVisibility(8);
            }
        } else if (!this.chB) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.chF);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.chF, 100L);
            this.chC = z;
        } else if (this.chq != null && this.chr != null && this.chs != null) {
            if (z) {
                this.chq.setVisibility(0);
                this.chr.setVisibility(0);
                this.chs.setVisibility(0);
                return;
            }
            this.chq.setVisibility(8);
            this.chr.setVisibility(8);
            this.chs.setVisibility(8);
        }
    }

    private com.baidu.tieba.b.d.d bn(Context context) {
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

    private d.a bo(Context context) {
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
    public void adR() {
        adT();
        a(false, true, false, true);
        adS();
    }

    private void adS() {
        if (this.chq != null) {
            s sVar = new s(this);
            this.cht.setDispathEventAction(sVar);
            this.chu.setDispathEventAction(sVar);
            this.chv.setDispathEventAction(sVar);
            this.chw.setDispathEventAction(sVar);
            this.cgT.setDispathEventAction(new t(this));
            this.chq.setItemOnclickListener(this.chG);
        }
    }

    private void adT() {
        if (this.chq != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_url);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size7 = BitmapHelper.getResBitmapPowerOf2Size(this.bVm.getPageContext().getPageActivity(), w.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size5 == null || resBitmapPowerOf2Size7 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bm(this.bVm.getPageContext().getPageActivity());
                this.chq = null;
                this.chr = null;
                return;
            }
            int g = com.baidu.adp.lib.util.k.g(this.bVm.getPageContext().getPageActivity(), w.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            try {
                this.chs = new com.baidu.tieba.b.d.h(this.bVm.getPageContext().getPageActivity());
                this.chs.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size7, resBitmapPowerOf2Size2, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.chs.setLayoutParams(layoutParams);
                this.cht = new com.baidu.tieba.b.d.h(this.bVm.getPageContext().getPageActivity());
                this.cht.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.cht.setLayoutParams(layoutParams);
                this.chu = new com.baidu.tieba.b.d.h(this.bVm.getPageContext().getPageActivity());
                this.chu.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.chu.setLayoutParams(layoutParams);
                this.chv = new com.baidu.tieba.b.d.h(this.bVm.getPageContext().getPageActivity());
                this.chv.b(resBitmapPowerOf2Size6, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.chv.setLayoutParams(layoutParams);
                this.chw = new com.baidu.tieba.b.d.h(this.bVm.getPageContext().getPageActivity());
                this.chw.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7, resBitmapPowerOf2Size7);
                this.chw.setLayoutParams(layoutParams);
                this.cgT.addView(this.chr);
                this.cgT.addView(this.chq);
                this.chD = new TextView(this.bVm.getPageContext().getPageActivity());
                this.chD.setGravity(17);
                this.chD.setTextColor(this.bVm.getResources().getColor(w.e.cp_cont_g));
                this.chD.setTextSize(this.bVm.getResources().getDimensionPixelSize(w.f.ds10));
                this.chD.setBackgroundResource(w.g.pic_sign_tip_right);
                this.chD.setSingleLine(true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bm(this.bVm.getPageContext().getPageActivity());
                this.chq = null;
                this.chr = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.chq != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.chs);
            arrayList.add(this.cht);
            if (com.baidu.tbadk.n.ac.fV()) {
                arrayList.add(this.chw);
            }
            if (z2) {
                arrayList.add(this.chu);
            }
            if (z4) {
                arrayList.add(this.chv);
            }
            if (this.chy != z || this.chz != z2 || this.chA != z3) {
                this.chq.setWriteViewList(arrayList);
                this.chy = z;
                this.chz = z2;
                this.chA = z3;
            }
            this.chq.SM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.chD.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.chD.setPadding((int) this.bVm.getResources().getDimension(w.f.ds8), (int) this.bVm.getResources().getDimension(w.f.ds8), (int) this.bVm.getResources().getDimension(w.f.ds16), (int) this.bVm.getResources().getDimension(w.f.ds8));
                        com.baidu.adp.lib.g.h.fS().postDelayed(this.chH, 440L);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abU() {
        if (this.chq != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.chE);
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.chF);
            this.chq.SI();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abV() {
        if (this.chq != null) {
            if (!this.chq.ha(1)) {
                com.baidu.adp.lib.g.h.fS().postDelayed(this.chE, 1000L);
            }
            this.chq.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void abW() {
        if (this.chq != null) {
            this.chq.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean aaG() {
        if (this.chq == null || this.chq.ha(1)) {
            return false;
        }
        if (this.chD != null) {
            this.chD.setVisibility(8);
        }
        this.chq.SK();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.chr != null) {
            this.chr.onChangeSkinType(i);
        }
    }

    public boolean adU() {
        com.baidu.tieba.tbadkCore.n aau;
        if (this.bVm != null && (aau = this.bVm.aau()) != null) {
            if (bh.aN(this.bVm.getPageContext().getPageActivity())) {
                AntiData qh = aau.qh();
                if (qh != null) {
                    if (a(qh.getBlock_stat(), qh.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qh.getIfpost() == 0 && !StringUtils.isNull(qh.getForbid_info())) {
                        String forbid_info = qh.getForbid_info();
                        if (au.dw(forbid_info) > 14) {
                            String fixedText = au.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bVm.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
                        b.P(1.25f);
                        b.tk();
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, BlockPopInfoData blockPopInfoData) {
        String str;
        String str2;
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (StringUtils.isNull(blockPopInfoData.block_info)) {
            str = this.bVm.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.bVm.getPageContext().getPageActivity(), str, w.g.icon_toast_game_error);
            b.P(1.25f);
            b.tk();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bVm.getPageContext().getPageActivity());
        aVar.cB(au.getFixedText(str, 50, true));
        if (StringUtils.isNull(blockPopInfoData.ok_info)) {
            str2 = this.bVm.getResources().getString(w.l.group_create_private_isee);
        } else {
            str2 = blockPopInfoData.ok_info;
        }
        aVar.b(au.getFixedText(str2, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(au.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bVm.getPageContext()).tc();
        return true;
    }
}
