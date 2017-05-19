package com.baidu.tieba.frs.e;

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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.b.d.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.frs.view.k bOy;
    private com.baidu.tieba.frs.r bPw;
    private NoPressedRelativeLayout caH;
    public com.baidu.tieba.b.d.d cbf;
    private d.a cbg;
    public com.baidu.tieba.b.d.h cbh;
    public com.baidu.tieba.b.d.h cbi;
    public com.baidu.tieba.b.d.h cbj;
    public com.baidu.tieba.b.d.h cbk;
    public TextView cbl;
    public TextView cbr;
    private boolean cbm = false;
    private boolean cbn = false;
    private boolean cbo = false;
    private boolean cbp = false;
    private boolean cbq = false;
    private Runnable cbs = new j(this);
    private Runnable cbt = new m(this);
    private View.OnClickListener cbu = new n(this);
    private Runnable cbv = new o(this);
    private Runnable cbw = new p(this);

    private boolean acM() {
        return UtilHelper.detectOpenGLES20(TbadkCoreApplication.m9getInst().getContext()) && com.baidu.tbadk.core.util.ai.uW().vf();
    }

    public i(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (rVar != null && noPressedRelativeLayout != null) {
            this.bPw = rVar;
            this.caH = noPressedRelativeLayout;
            if (acM()) {
                bl(this.bPw.getPageContext().getPageActivity());
            } else {
                bm(this.bPw.getPageContext().getPageActivity());
            }
        }
    }

    private void bl(Context context) {
        this.cbf = bn(context);
        this.cbg = bo(context);
        this.cbf.setShadeViewContainer(this.cbg);
    }

    public void bm(Context context) {
        this.cbl = new TextView(context);
        int g = com.baidu.adp.lib.util.k.g(context, w.f.ds108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds20), com.baidu.adp.lib.util.k.g(context, w.f.ds124));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.cbl.setBackgroundResource(w.g.btn_frs_post_more);
        this.cbl.setLayoutParams(layoutParams);
        this.cbl.setOnClickListener(new q(this));
        this.caH.addView(this.cbl);
        this.cbl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acN() {
        if (this.bPw != null) {
            boolean z = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bOy = new com.baidu.tieba.frs.view.k(this.bPw.getPageContext(), this.caH, new r(this));
            this.bOy.e(false, showXiaoyingTool, z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void dM(boolean z) {
        if (this.cbl != null) {
            if (z) {
                this.cbl.setVisibility(0);
            } else {
                this.cbl.setVisibility(8);
            }
        } else if (!this.cbp) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cbt);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.cbt, 100L);
            this.cbq = z;
        } else if (this.cbf != null && this.cbg != null && this.cbh != null) {
            if (z) {
                this.cbf.setVisibility(0);
                this.cbg.setVisibility(0);
                this.cbh.setVisibility(0);
                return;
            }
            this.cbf.setVisibility(8);
            this.cbg.setVisibility(8);
            this.cbh.setVisibility(8);
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
    public void acO() {
        acQ();
        a(false, true, false, true);
        acP();
    }

    private void acP() {
        if (this.cbf != null) {
            s sVar = new s(this);
            this.cbi.setDispathEventAction(sVar);
            this.cbj.setDispathEventAction(sVar);
            this.cbk.setDispathEventAction(sVar);
            this.caH.setDispathEventAction(new t(this));
            this.cbf.setItemOnclickListener(this.cbu);
        }
    }

    private void acQ() {
        if (this.cbf != null) {
            Bitmap resBitmapPowerOf2Size = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.btn_frs_post_off);
            Bitmap resBitmapPowerOf2Size2 = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.btn_frs_post_more);
            Bitmap resBitmapPowerOf2Size3 = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.btn_frs_post_theme);
            Bitmap resBitmapPowerOf2Size4 = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.btn_frs_post_video);
            Bitmap resBitmapPowerOf2Size5 = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.btn_frs_post_live_video);
            Bitmap resBitmapPowerOf2Size6 = BitmapHelper.getResBitmapPowerOf2Size(this.bPw.getPageContext().getPageActivity(), w.g.cube_top);
            if (resBitmapPowerOf2Size == null || resBitmapPowerOf2Size2 == null || resBitmapPowerOf2Size3 == null || resBitmapPowerOf2Size4 == null || resBitmapPowerOf2Size6 == null) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bm(this.bPw.getPageContext().getPageActivity());
                this.cbf = null;
                this.cbg = null;
                return;
            }
            int g = com.baidu.adp.lib.util.k.g(this.bPw.getPageContext().getPageActivity(), w.f.ds124);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            try {
                this.cbh = new com.baidu.tieba.b.d.h(this.bPw.getPageContext().getPageActivity());
                this.cbh.b(resBitmapPowerOf2Size, resBitmapPowerOf2Size6, resBitmapPowerOf2Size2, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6);
                this.cbh.setLayoutParams(layoutParams);
                this.cbi = new com.baidu.tieba.b.d.h(this.bPw.getPageContext().getPageActivity());
                this.cbi.b(resBitmapPowerOf2Size3, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6);
                this.cbi.setLayoutParams(layoutParams);
                this.cbj = new com.baidu.tieba.b.d.h(this.bPw.getPageContext().getPageActivity());
                this.cbj.b(resBitmapPowerOf2Size4, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6);
                this.cbj.setLayoutParams(layoutParams);
                this.cbk = new com.baidu.tieba.b.d.h(this.bPw.getPageContext().getPageActivity());
                this.cbk.b(resBitmapPowerOf2Size5, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6, resBitmapPowerOf2Size6);
                this.cbk.setLayoutParams(layoutParams);
                this.caH.addView(this.cbg);
                this.caH.addView(this.cbf);
                this.cbr = new TextView(this.bPw.getPageContext().getPageActivity());
                this.cbr.setGravity(17);
                this.cbr.setTextColor(this.bPw.getResources().getColor(w.e.cp_cont_g));
                this.cbr.setTextSize(this.bPw.getResources().getDimensionPixelSize(w.f.ds10));
                this.cbr.setBackgroundResource(w.g.pic_sign_tip_right);
                this.cbr.setSingleLine(true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                bm(this.bPw.getPageContext().getPageActivity());
                this.cbf = null;
                this.cbg = null;
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.cbf != null) {
            ArrayList<com.baidu.tieba.b.d.h> arrayList = new ArrayList<>();
            arrayList.add(this.cbh);
            arrayList.add(this.cbi);
            if (z2) {
                arrayList.add(this.cbj);
            }
            if (z4) {
                arrayList.add(this.cbk);
            }
            if (this.cbm != z || this.cbn != z2 || this.cbo != z3) {
                this.cbf.setWriteViewList(arrayList);
                this.cbm = z;
                this.cbn = z2;
                this.cbo = z3;
            }
            this.cbf.SA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(boolean z) {
        if (z) {
            long j = com.baidu.tbadk.core.sharedPref.b.tX().getLong("key_frs_videolive_last_popup_time", 0L);
            if (!TextUtils.isEmpty(TbadkCoreApplication.m9getInst().getAlaMenuToast()) && TbadkCoreApplication.m9getInst().getAlaToastShowType() >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 0 || j == 0) {
                    if (TbadkCoreApplication.m9getInst().getAlaToastShowType() != 1 || j == 0 || currentTimeMillis - j >= 86400000) {
                        this.cbr.setText(TbadkCoreApplication.m9getInst().getAlaMenuToast());
                        this.cbr.setPadding((int) this.bPw.getResources().getDimension(w.f.ds8), (int) this.bPw.getResources().getDimension(w.f.ds8), (int) this.bPw.getResources().getDimension(w.f.ds16), (int) this.bPw.getResources().getDimension(w.f.ds8));
                        com.baidu.adp.lib.g.h.fS().postDelayed(this.cbv, 440L);
                        com.baidu.tbadk.core.sharedPref.b.tX().putLong("key_frs_videolive_last_popup_time", System.currentTimeMillis());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aaQ() {
        if (this.cbf != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cbs);
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cbt);
            this.cbf.Sw();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aaR() {
        if (this.cbf != null) {
            if (!this.cbf.gJ(1)) {
                com.baidu.adp.lib.g.h.fS().postDelayed(this.cbs, 1000L);
            }
            this.cbf.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aaS() {
        if (this.cbf != null) {
            this.cbf.onResume();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ZD() {
        if (this.cbf == null || this.cbf.gJ(1)) {
            return false;
        }
        if (this.cbr != null) {
            this.cbr.setVisibility(8);
        }
        this.cbf.Sy();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cbg != null) {
            this.cbg.onChangeSkinType(i);
        }
    }

    public boolean acR() {
        com.baidu.tieba.tbadkCore.n Zq;
        if (this.bPw != null && (Zq = this.bPw.Zq()) != null) {
            if (bg.aN(this.bPw.getPageContext().getPageActivity())) {
                AntiData ql = Zq.ql();
                if (ql != null) {
                    if (a(ql.getBlock_stat(), ql.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (ql.getIfpost() == 0 && !StringUtils.isNull(ql.getForbid_info())) {
                        String forbid_info = ql.getForbid_info();
                        if (au.dz(forbid_info) > 14) {
                            String fixedText = au.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.bPw.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
                        b.Q(1.25f);
                        b.tl();
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
            str = this.bPw.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.bPw.getPageContext().getPageActivity(), str, w.g.icon_toast_game_error);
            b.Q(1.25f);
            b.tl();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bPw.getPageContext().getPageActivity());
        aVar.cC(au.getFixedText(str, 50, true));
        if (StringUtils.isNull(blockPopInfoData.ok_info)) {
            str2 = this.bPw.getResources().getString(w.l.group_create_private_isee);
        } else {
            str2 = blockPopInfoData.ok_info;
        }
        aVar.b(au.getFixedText(str2, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(au.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.bPw.getPageContext()).td();
        return true;
    }
}
