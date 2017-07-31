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
    private com.baidu.tieba.frs.f ckn;
    public com.baidu.tieba.write.b ctI;
    public boolean cxT = false;
    public View cxU;
    private NoPressedRelativeLayout cxv;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.ckn = fVar;
            this.cxv = noPressedRelativeLayout;
            this.cxU = this.cxv.findViewById(d.h.normal_write_icon);
            ai.j(this.cxU, d.g.btn_frs_post_more);
            this.cxU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.aia()) {
                        if (d.this.ctI == null) {
                            d.this.ctI = new com.baidu.tieba.write.b(d.this.ckn.getPageContext(), d.this.cxv);
                            d.this.ctI.sP("2");
                        }
                        d.this.ctI.a(d.this.ckn.afv());
                        d.this.ctI.mY(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eF(boolean z) {
        if (this.cxU != null && z != this.cxT) {
            this.cxT = z;
            this.cxU.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahc() {
        if (this.ctI != null) {
            this.ctI.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahd() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahe() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean afG() {
        if (this.ctI == null || !this.ctI.isShowing()) {
            return false;
        }
        this.ctI.bxD();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.ctI != null) {
            this.ctI.onChangeSkinType();
        }
        ai.j(this.cxU, d.g.btn_frs_post_more);
    }

    public boolean aia() {
        i afr;
        String fixedText;
        if (this.ckn != null && (afr = this.ckn.afr()) != null) {
            if (aw.aO(this.ckn.getPageContext().getPageActivity())) {
                AntiData qr = afr.qr();
                if (qr != null) {
                    if (a(qr.getBlock_stat(), qr.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qr.getIfpost() == 0 && !StringUtils.isNull(qr.getForbid_info())) {
                        String forbid_info = qr.getForbid_info();
                        if (al.dZ(forbid_info) > 14) {
                            forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.ckn.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.ckn.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.ckn.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tz();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ckn.getPageContext().getPageActivity());
        aVar.cT(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.ckn.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    at.wf().c(d.this.ckn.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.ckn.getPageContext()).tr();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahf() {
        if (this.ctI == null) {
            return false;
        }
        return this.ctI.isShowing();
    }
}
