package com.baidu.tieba.frs.g;

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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.frs.i dFD;
    public com.baidu.tieba.write.c dQK;
    private com.baidu.tieba.p.a dQT;
    private NoPressedRelativeLayout dUF;
    public boolean dUU = false;
    public ImageView dUV;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dFD = iVar;
            this.dUF = noPressedRelativeLayout;
            this.dUV = (ImageView) this.dUF.findViewById(d.g.normal_write_icon);
            aj.s(this.dUV, d.f.icon_tabbar_chaticon_n);
            aj.c(this.dUV, d.f.icon_tabbar_add_n);
            this.dQT = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ay.ba(d.this.dFD.getPageContext().getPageActivity()) && !d.this.dQT.bAw() && !d.this.ayG()) {
                        if (d.this.dQK == null) {
                            d.this.dQK = new com.baidu.tieba.write.c(d.this.dFD.getPageContext(), d.this.dUF, "frs");
                            d.this.dQK.uo("2");
                        }
                        d.this.dQK.a(d.this.dFD.avn());
                        d.this.dQK.nC(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fN(boolean z) {
        if (this.dUV != null && z != this.dUU) {
            this.dUU = z;
            this.dUV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axA() {
        if (this.dQK != null) {
            this.dQK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axB() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axC() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avL() {
        if (this.dQK == null || !this.dQK.isShowing()) {
            return false;
        }
        this.dQK.bFI();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dQK != null) {
            this.dQK.onChangeSkinType();
        }
        aj.s(this.dUV, d.f.icon_tabbar_chaticon_n);
        aj.c(this.dUV, d.f.icon_tabbar_add_n);
    }

    public boolean ayG() {
        l avk;
        String fixedText;
        if (this.dFD != null && (avk = this.dFD.avk()) != null) {
            if (ay.ba(this.dFD.getPageContext().getPageActivity())) {
                AntiData yn = avk.yn();
                if (yn != null) {
                    if (a(yn.getBlock_stat(), yn.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (yn.getIfpost() == 0 && !StringUtils.isNull(yn.getForbid_info())) {
                        String forbid_info = yn.getForbid_info();
                        if (am.es(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dFD.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.aa(1.25f);
                        b.Bc();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dFD.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dFD.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bc();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dFD.getPageContext().getPageActivity());
        aVar.dk(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dFD.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aw.Dt().c(d.this.dFD.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dFD.getPageContext()).AU();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axD() {
        if (this.dQK == null) {
            return false;
        }
        return this.dQK.isShowing();
    }
}
