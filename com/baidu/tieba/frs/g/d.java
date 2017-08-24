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
    private com.baidu.tieba.frs.f cla;
    public com.baidu.tieba.write.b cvM;
    public boolean czR = false;
    public View czS;
    private NoPressedRelativeLayout czt;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.cla = fVar;
            this.czt = noPressedRelativeLayout;
            this.czS = this.czt.findViewById(d.h.normal_write_icon);
            ai.j(this.czS, d.g.btn_frs_post_more);
            this.czS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.aiB()) {
                        if (d.this.cvM == null) {
                            d.this.cvM = new com.baidu.tieba.write.b(d.this.cla.getPageContext(), d.this.czt);
                            d.this.cvM.sW("2");
                        }
                        d.this.cvM.a(d.this.cla.afM());
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
    public void ahr() {
        if (this.cvM != null) {
            this.cvM.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ahs() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aht() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean afX() {
        if (this.cvM == null || !this.cvM.isShowing()) {
            return false;
        }
        this.cvM.byd();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cvM != null) {
            this.cvM.onChangeSkinType();
        }
        ai.j(this.czS, d.g.btn_frs_post_more);
    }

    public boolean aiB() {
        i afH;
        String fixedText;
        if (this.cla != null && (afH = this.cla.afH()) != null) {
            if (aw.aO(this.cla.getPageContext().getPageActivity())) {
                AntiData qs = afH.qs();
                if (qs != null) {
                    if (a(qs.getBlock_stat(), qs.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qs.getIfpost() == 0 && !StringUtils.isNull(qs.getForbid_info())) {
                        String forbid_info = qs.getForbid_info();
                        if (al.ed(forbid_info) > 14) {
                            forbid_info = al.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cla.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.P(1.25f);
                        b.tA();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cla.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cla.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.P(1.25f);
            b.tA();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cla.getPageContext().getPageActivity());
        aVar.cW(al.getFixedText(string, 50, true));
        aVar.b(al.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cla.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    at.wg().c(d.this.cla.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cla.getPageContext()).ts();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahu() {
        if (this.cvM == null) {
            return false;
        }
        return this.cvM.isShowing();
    }
}
