package com.baidu.tieba.frs.h;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.write.b cEa;
    private NoPressedRelativeLayout cHF;
    public boolean cHU = false;
    public ImageView cHV;
    private com.baidu.tieba.frs.f crI;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.crI = fVar;
            this.cHF = noPressedRelativeLayout;
            this.cHV = (ImageView) this.cHF.findViewById(d.h.normal_write_icon);
            aj.j(this.cHV, d.g.icon_tabbar_chaticon_n);
            aj.c(this.cHV, d.g.icon_tabbar_add_n);
            this.cHV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.akD()) {
                        if (d.this.cEa == null) {
                            d.this.cEa = new com.baidu.tieba.write.b(d.this.crI.getPageContext(), d.this.cHF, "frs");
                            d.this.cEa.sX("2");
                        }
                        d.this.cEa.a(d.this.crI.aho());
                        d.this.cEa.nn(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eA(boolean z) {
        if (this.cHV != null && z != this.cHU) {
            this.cHU = z;
            this.cHV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aju() {
        if (this.cEa != null) {
            this.cEa.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajv() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajw() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahz() {
        if (this.cEa == null || !this.cEa.isShowing()) {
            return false;
        }
        this.cEa.byS();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cEa != null) {
            this.cEa.onChangeSkinType();
        }
        aj.j(this.cHV, d.g.icon_tabbar_chaticon_n);
        aj.c(this.cHV, d.g.icon_tabbar_add_n);
    }

    public boolean akD() {
        i ahk;
        String fixedText;
        if (this.crI != null && (ahk = this.crI.ahk()) != null) {
            if (ax.aU(this.crI.getPageContext().getPageActivity())) {
                AntiData qh = ahk.qh();
                if (qh != null) {
                    if (a(qh.getBlock_stat(), qh.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qh.getIfpost() == 0 && !StringUtils.isNull(qh.getForbid_info())) {
                        String forbid_info = qh.getForbid_info();
                        if (am.dO(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.crI.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.F(1.25f);
                        b.tq();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.crI.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.crI.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.F(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.crI.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.crI.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vH().c(d.this.crI.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.crI.getPageContext()).ti();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajx() {
        if (this.cEa == null) {
            return false;
        }
        return this.cEa.isShowing();
    }
}
