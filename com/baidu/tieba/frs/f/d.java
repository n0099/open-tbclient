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
    private com.baidu.tieba.frs.i dCx;
    public com.baidu.tieba.write.c dNB;
    private com.baidu.tieba.p.a dNJ;
    public ImageView dRA;
    private NoPressedRelativeLayout dRk;
    public boolean dRz = false;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dCx = iVar;
            this.dRk = noPressedRelativeLayout;
            this.dRA = (ImageView) this.dRk.findViewById(d.g.normal_write_icon);
            aj.s(this.dRA, d.f.icon_tabbar_chaticon_n);
            aj.c(this.dRA, d.f.icon_tabbar_add_n);
            this.dNJ = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dRA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ax.be(d.this.dCx.getPageContext().getPageActivity()) && !d.this.dNJ.bzL() && !d.this.axE()) {
                        if (d.this.dNB == null) {
                            d.this.dNB = new com.baidu.tieba.write.c(d.this.dCx.getPageContext(), d.this.dRk, "frs");
                            d.this.dNB.ua("2");
                        }
                        d.this.dNB.a(d.this.dCx.auu());
                        d.this.dNB.ns(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fC(boolean z) {
        if (this.dRA != null && z != this.dRz) {
            this.dRz = z;
            this.dRA.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awx() {
        if (this.dNB != null) {
            this.dNB.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awy() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void awz() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean auG() {
        if (this.dNB == null || !this.dNB.isShowing()) {
            return false;
        }
        this.dNB.bET();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dNB != null) {
            this.dNB.onChangeSkinType();
        }
        aj.s(this.dRA, d.f.icon_tabbar_chaticon_n);
        aj.c(this.dRA, d.f.icon_tabbar_add_n);
    }

    public boolean axE() {
        l auq;
        String fixedText;
        if (this.dCx != null && (auq = this.dCx.auq()) != null) {
            if (ax.be(this.dCx.getPageContext().getPageActivity())) {
                AntiData xG = auq.xG();
                if (xG != null) {
                    if (a(xG.getBlock_stat(), xG.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (xG.getIfpost() == 0 && !StringUtils.isNull(xG.getForbid_info())) {
                        String forbid_info = xG.getForbid_info();
                        if (am.ec(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dCx.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.U(1.25f);
                        b.AI();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dCx.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dCx.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AI();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dCx.getPageContext().getPageActivity());
        aVar.cZ(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dCx.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.f.d.2
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
                    av.CZ().c(d.this.dCx.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dCx.getPageContext()).AA();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean awA() {
        if (this.dNB == null) {
            return false;
        }
        return this.dNB.isShowing();
    }
}
