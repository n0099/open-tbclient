package com.baidu.tieba.frs.f;

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
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.frs.i dCS;
    public com.baidu.tieba.write.c dNW;
    private com.baidu.tieba.p.a dOe;
    private NoPressedRelativeLayout dRF;
    public boolean dRU = false;
    public ImageView dRV;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dCS = iVar;
            this.dRF = noPressedRelativeLayout;
            this.dRV = (ImageView) this.dRF.findViewById(d.g.normal_write_icon);
            aj.s(this.dRV, d.f.icon_tabbar_chaticon_n);
            aj.c(this.dRV, d.f.icon_tabbar_add_n);
            this.dOe = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ax.bb(d.this.dCS.getPageContext().getPageActivity()) && !d.this.dOe.bzN() && !d.this.axJ()) {
                        if (d.this.dNW == null) {
                            d.this.dNW = new com.baidu.tieba.write.c(d.this.dCS.getPageContext(), d.this.dRF, "frs");
                            d.this.dNW.ui("2");
                        }
                        d.this.dNW.a(d.this.dCS.auz());
                        d.this.dNW.nv(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fF(boolean z) {
        if (this.dRV != null && z != this.dRU) {
            this.dRU = z;
            this.dRV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awC() {
        if (this.dNW != null) {
            this.dNW.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awD() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awE() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean auL() {
        if (this.dNW == null || !this.dNW.isShowing()) {
            return false;
        }
        this.dNW.bEV();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dNW != null) {
            this.dNW.onChangeSkinType();
        }
        aj.s(this.dRV, d.f.icon_tabbar_chaticon_n);
        aj.c(this.dRV, d.f.icon_tabbar_add_n);
    }

    public boolean axJ() {
        l auv;
        String fixedText;
        if (this.dCS != null && (auv = this.dCS.auv()) != null) {
            if (ax.bb(this.dCS.getPageContext().getPageActivity())) {
                AntiData xH = auv.xH();
                if (xH != null) {
                    if (a(xH.getBlock_stat(), xH.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (xH.getIfpost() == 0 && !StringUtils.isNull(xH.getForbid_info())) {
                        String forbid_info = xH.getForbid_info();
                        if (am.eh(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dCS.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.U(1.25f);
                        b.AJ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dCS.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dCS.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AJ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dCS.getPageContext().getPageActivity());
        aVar.cZ(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dCS.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.f.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.f.d.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.Da().c(d.this.dCS.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dCS.getPageContext()).AB();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awF() {
        if (this.dNW == null) {
            return false;
        }
        return this.dNW.isShowing();
    }
}
