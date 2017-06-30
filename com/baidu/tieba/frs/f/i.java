package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.frs.entelechy.b.e {
    private com.baidu.tieba.frs.r cdv;
    public boolean cpH = false;
    public View cpI;
    public com.baidu.tieba.write.e cpJ;
    private NoPressedRelativeLayout cpj;

    public i(com.baidu.tieba.frs.r rVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (rVar != null && noPressedRelativeLayout != null) {
            this.cdv = rVar;
            this.cpj = noPressedRelativeLayout;
            this.cpI = this.cpj.findViewById(w.h.normal_write_icon);
            as.j(this.cpI, w.g.btn_frs_post_more);
            this.cpI.setOnClickListener(new j(this));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eu(boolean z) {
        if (this.cpI != null && z != this.cpH) {
            this.cpH = z;
            this.cpI.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void afL() {
        if (this.cpJ != null) {
            this.cpJ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void afM() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void afN() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean aex() {
        if (this.cpJ == null || !this.cpJ.isShowing()) {
            return false;
        }
        this.cpJ.brz();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cpJ != null) {
            this.cpJ.onChangeSkinType();
        }
        as.j(this.cpI, w.g.btn_frs_post_more);
    }

    public boolean ahI() {
        com.baidu.tieba.tbadkCore.n aek;
        if (this.cdv != null && (aek = this.cdv.aek()) != null) {
            if (bl.aN(this.cdv.getPageContext().getPageActivity())) {
                AntiData qe = aek.qe();
                if (qe != null) {
                    if (a(qe.getBlock_stat(), qe.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qe.getIfpost() == 0 && !StringUtils.isNull(qe.getForbid_info())) {
                        String forbid_info = qe.getForbid_info();
                        if (aw.dQ(forbid_info) > 14) {
                            String fixedText = aw.getFixedText(forbid_info, 7, false);
                            forbid_info = String.valueOf(fixedText) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cdv.getPageContext().getPageActivity(), forbid_info, w.g.icon_toast_game_error);
                        b.P(1.25f);
                        b.ti();
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
            str = this.cdv.getResources().getString(w.l.frs_forbiden_dialog_msg);
        } else {
            str = blockPopInfoData.block_info;
        }
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cdv.getPageContext().getPageActivity(), str, w.g.icon_toast_game_error);
            b.P(1.25f);
            b.ti();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cdv.getPageContext().getPageActivity());
        aVar.cI(aw.getFixedText(str, 50, true));
        if (StringUtils.isNull(blockPopInfoData.ok_info)) {
            str2 = this.cdv.getResources().getString(w.l.group_create_private_isee);
        } else {
            str2 = blockPopInfoData.ok_info;
        }
        aVar.b(aw.getFixedText(str2, 4, true), new k(this));
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(aw.getFixedText(blockPopInfoData.ahead_info, 4, true), new l(this, blockPopInfoData));
        }
        aVar.b(this.cdv.getPageContext()).ta();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean afO() {
        if (this.cpJ == null) {
            return false;
        }
        return this.cpJ.isShowing();
    }
}
