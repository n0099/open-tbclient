package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    private com.baidu.tieba.frs.f ckZ;
    public com.baidu.tieba.write.b cvM;
    public boolean czR = false;
    public View czS;
    private NoPressedRelativeLayout czt;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.ckZ = fVar;
            this.czt = noPressedRelativeLayout;
            this.czS = this.czt.findViewById(d.h.normal_write_icon);
            ai.j(this.czS, d.g.btn_frs_post_more);
            this.czS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.aiH()) {
                        if (d.this.cvM == null) {
                            d.this.cvM = new com.baidu.tieba.write.b(d.this.ckZ.getPageContext(), d.this.czt);
                            d.this.cvM.sR("2");
                        }
                        d.this.cvM.a(d.this.ckZ.afS());
                        d.this.cvM.nb(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eH(boolean z) {
        if (this.czS != null && z != this.czR) {
            this.czR = z;
            this.czS.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahx() {
        if (this.cvM != null) {
            this.cvM.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahy() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahz() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean agd() {
        if (this.cvM == null || !this.cvM.isShowing()) {
            return false;
        }
        this.cvM.byl();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cvM != null) {
            this.cvM.onChangeSkinType();
        }
        ai.j(this.czS, d.g.btn_frs_post_more);
    }

    public boolean aiH() {
        i afN;
        String fixedText;
        if (this.ckZ != null && (afN = this.ckZ.afN()) != null) {
            if (aw.aO(this.ckZ.getPageContext().getPageActivity())) {
                AntiData qr = afN.qr();
                if (qr != null) {
                    if (a(qr.getBlock_stat(), qr.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qr.getIfpost() == 0 && !StringUtils.isNull(qr.getForbid_info())) {
                        String forbid_info = qr.getForbid_info();
                        if (al.dZ(forbid_info) > 14) {
                            forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.ckZ.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.P(1.25f);
                        b.tz();
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.ckZ.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.ckZ.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tz();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ckZ.getPageContext().getPageActivity());
        aVar.cT(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.ckZ.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(al.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    at.wf().c(d.this.ckZ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.ckZ.getPageContext()).tr();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahA() {
        if (this.cvM == null) {
            return false;
        }
        return this.cvM.isShowing();
    }
}
