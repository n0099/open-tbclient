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
    private com.baidu.tieba.frs.i dFP;
    public com.baidu.tieba.write.c dQW;
    private com.baidu.tieba.p.a dRf;
    private NoPressedRelativeLayout dUR;
    public boolean dVg = false;
    public ImageView dVh;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dFP = iVar;
            this.dUR = noPressedRelativeLayout;
            this.dVh = (ImageView) this.dUR.findViewById(d.g.normal_write_icon);
            aj.s(this.dVh, d.f.icon_tabbar_chaticon_n);
            aj.c(this.dVh, d.f.icon_tabbar_add_n);
            this.dRf = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ay.ba(d.this.dFP.getPageContext().getPageActivity()) && !d.this.dRf.bAx() && !d.this.ayH()) {
                        if (d.this.dQW == null) {
                            d.this.dQW = new com.baidu.tieba.write.c(d.this.dFP.getPageContext(), d.this.dUR, "frs");
                            d.this.dQW.uo("2");
                        }
                        d.this.dQW.a(d.this.dFP.avo());
                        d.this.dQW.nC(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fN(boolean z) {
        if (this.dVh != null && z != this.dVg) {
            this.dVg = z;
            this.dVh.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axB() {
        if (this.dQW != null) {
            this.dQW.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axC() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void axD() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avM() {
        if (this.dQW == null || !this.dQW.isShowing()) {
            return false;
        }
        this.dQW.bFJ();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dQW != null) {
            this.dQW.onChangeSkinType();
        }
        aj.s(this.dVh, d.f.icon_tabbar_chaticon_n);
        aj.c(this.dVh, d.f.icon_tabbar_add_n);
    }

    public boolean ayH() {
        l avl;
        String fixedText;
        if (this.dFP != null && (avl = this.dFP.avl()) != null) {
            if (ay.ba(this.dFP.getPageContext().getPageActivity())) {
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
                        BdToast b = BdToast.b(this.dFP.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dFP.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dFP.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.aa(1.25f);
            b.Bc();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dFP.getPageContext().getPageActivity());
        aVar.dk(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dFP.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    aw.Du().c(d.this.dFP.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dFP.getPageContext()).AU();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean axE() {
        if (this.dQW == null) {
            return false;
        }
        return this.dQW.isShowing();
    }
}
