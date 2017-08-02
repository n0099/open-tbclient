package com.baidu.tieba.frs.h;

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
    private com.baidu.tieba.frs.f cjg;
    public com.baidu.tieba.write.b csx;
    public View cwA;
    private NoPressedRelativeLayout cwb;
    public boolean cwz = false;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.cjg = fVar;
            this.cwb = noPressedRelativeLayout;
            this.cwA = this.cwb.findViewById(d.h.normal_write_icon);
            ai.j(this.cwA, d.g.btn_frs_post_more);
            this.cwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.ahS()) {
                        if (d.this.csx == null) {
                            d.this.csx = new com.baidu.tieba.write.b(d.this.cjg.getPageContext(), d.this.cwb);
                            d.this.csx.sK("2");
                        }
                        d.this.csx.a(d.this.cjg.afq());
                        d.this.csx.mY(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eF(boolean z) {
        if (this.cwA != null && z != this.cwz) {
            this.cwz = z;
            this.cwA.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void agV() {
        if (this.csx != null) {
            this.csx.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void agW() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void agX() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean afB() {
        if (this.csx == null || !this.csx.isShowing()) {
            return false;
        }
        this.csx.bxw();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.csx != null) {
            this.csx.onChangeSkinType();
        }
        ai.j(this.cwA, d.g.btn_frs_post_more);
    }

    public boolean ahS() {
        i afm;
        String fixedText;
        if (this.cjg != null && (afm = this.cjg.afm()) != null) {
            if (aw.aN(this.cjg.getPageContext().getPageActivity())) {
                AntiData qh = afm.qh();
                if (qh != null) {
                    if (a(qh.getBlock_stat(), qh.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qh.getIfpost() == 0 && !StringUtils.isNull(qh.getForbid_info())) {
                        String forbid_info = qh.getForbid_info();
                        if (al.dT(forbid_info) > 14) {
                            forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cjg.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.P(1.25f);
                        b.tp();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cjg.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cjg.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tp();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cjg.getPageContext().getPageActivity());
        aVar.cN(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cjg.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(al.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    at.vV().c(d.this.cjg.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cjg.getPageContext()).th();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean agY() {
        if (this.csx == null) {
            return false;
        }
        return this.csx.isShowing();
    }
}
