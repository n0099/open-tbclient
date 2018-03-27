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
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.frs.i dFH;
    public com.baidu.tieba.write.c dQP;
    private com.baidu.tieba.p.a dQY;
    private NoPressedRelativeLayout dUK;
    public ImageView dVa;
    public boolean dUZ = false;
    private boolean dVb = false;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dFH = iVar;
            this.dUK = noPressedRelativeLayout;
            this.dVa = (ImageView) this.dUK.findViewById(d.g.normal_write_icon);
            aj.s(this.dVa, this.dVb ? d.f.icon_tabbar_chaticon_gray_n : d.f.icon_tabbar_chaticon_n);
            aj.c(this.dVa, d.f.icon_tabbar_add_n);
            this.dQY = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ay.ba(d.this.dFH.getPageContext().getPageActivity()) && !d.this.dQY.bAB() && !d.this.ayI()) {
                        if (d.this.dQP == null) {
                            d.this.dQP = new com.baidu.tieba.write.c(d.this.dFH.getPageContext(), d.this.dUK, "frs");
                            d.this.dQP.uo("2");
                        }
                        d.this.dQP.a(d.this.dFH.avo());
                        d.this.dQP.nH(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fN(boolean z) {
        if (this.dVa != null && z != this.dUZ) {
            this.dUZ = z;
            this.dVa.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axC() {
        if (this.dQP != null) {
            this.dQP.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axD() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axE() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avN() {
        if (this.dQP == null || !this.dQP.isShowing()) {
            return false;
        }
        this.dQP.bFN();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dQP != null) {
            this.dQP.onChangeSkinType();
        }
        aj.s(this.dVa, (i == 1 || !this.dVb) ? d.f.icon_tabbar_chaticon_n : d.f.icon_tabbar_chaticon_gray_n);
        aj.c(this.dVa, d.f.icon_tabbar_add_n);
    }

    public boolean ayI() {
        m avl;
        String fixedText;
        if (this.dFH != null && (avl = this.dFH.avl()) != null) {
            if (ay.ba(this.dFH.getPageContext().getPageActivity())) {
                AntiData yn = avl.yn();
                if (yn != null) {
                    if (a(yn.getBlock_stat(), yn.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (yn.getIfpost() == 0 && !StringUtils.isNull(yn.getForbid_info())) {
                        String forbid_info = yn.getForbid_info();
                        if (am.es(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dFH.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.aa(1.25f);
                        b.Bd();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dFH.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dFH.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bd();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dFH.getPageContext().getPageActivity());
        aVar.dk(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dFH.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    aw.Du().c(d.this.dFH.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dFH.getPageContext()).AV();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axF() {
        if (this.dQP == null) {
            return false;
        }
        return this.dQP.isShowing();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void gf(boolean z) {
        if (this.dVb != z) {
            this.dVb = z;
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
