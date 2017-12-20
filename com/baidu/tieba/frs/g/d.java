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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.k;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    private com.baidu.tieba.frs.g cIy;
    public com.baidu.tieba.write.c cWK;
    public boolean daD = false;
    public ImageView daE;
    private NoPressedRelativeLayout dam;

    public d(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (gVar != null && noPressedRelativeLayout != null) {
            this.cIy = gVar;
            this.dam = noPressedRelativeLayout;
            this.daE = (ImageView) this.dam.findViewById(d.g.normal_write_icon);
            aj.j(this.daE, d.f.icon_tabbar_chaticon_n);
            aj.c(this.daE, d.f.icon_tabbar_add_n);
            this.daE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.apA()) {
                        if (d.this.cWK == null) {
                            d.this.cWK = new com.baidu.tieba.write.c(d.this.cIy.getPageContext(), d.this.dam, "frs");
                            d.this.cWK.uC("2");
                        }
                        d.this.cWK.a(d.this.cIy.alH());
                        d.this.cWK.nV(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eS(boolean z) {
        if (this.daE != null && z != this.daD) {
            this.daD = z;
            this.daE.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anT() {
        if (this.cWK != null) {
            this.cWK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anU() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anV() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean alS() {
        if (this.cWK == null || !this.cWK.isShowing()) {
            return false;
        }
        this.cWK.bFK();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cWK != null) {
            this.cWK.onChangeSkinType();
        }
        aj.j(this.daE, d.f.icon_tabbar_chaticon_n);
        aj.c(this.daE, d.f.icon_tabbar_add_n);
    }

    public boolean apA() {
        k alE;
        String fixedText;
        if (this.cIy != null && (alE = this.cIy.alE()) != null) {
            if (ax.aS(this.cIy.getPageContext().getPageActivity())) {
                AntiData qg = alE.qg();
                if (qg != null) {
                    if (a(qg.getBlock_stat(), qg.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qg.getIfpost() == 0 && !StringUtils.isNull(qg.getForbid_info())) {
                        String forbid_info = qg.getForbid_info();
                        if (am.dV(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cIy.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.E(1.25f);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cIy.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cIy.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cIy.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cIy.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.vI().c(d.this.cIy.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cIy.getPageContext()).th();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean anW() {
        if (this.cWK == null) {
            return false;
        }
        return this.cWK.isShowing();
    }
}
