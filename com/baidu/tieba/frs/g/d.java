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
    private com.baidu.tieba.frs.g cIC;
    public com.baidu.tieba.write.c cWO;
    public boolean daH = false;
    public ImageView daI;
    private NoPressedRelativeLayout daq;

    public d(com.baidu.tieba.frs.g gVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (gVar != null && noPressedRelativeLayout != null) {
            this.cIC = gVar;
            this.daq = noPressedRelativeLayout;
            this.daI = (ImageView) this.daq.findViewById(d.g.normal_write_icon);
            aj.j(this.daI, d.f.icon_tabbar_chaticon_n);
            aj.c(this.daI, d.f.icon_tabbar_add_n);
            this.daI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.apB()) {
                        if (d.this.cWO == null) {
                            d.this.cWO = new com.baidu.tieba.write.c(d.this.cIC.getPageContext(), d.this.daq, "frs");
                            d.this.cWO.uC("2");
                        }
                        d.this.cWO.a(d.this.cIC.alI());
                        d.this.cWO.nV(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eS(boolean z) {
        if (this.daI != null && z != this.daH) {
            this.daH = z;
            this.daI.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anU() {
        if (this.cWO != null) {
            this.cWO.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anV() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anW() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean alT() {
        if (this.cWO == null || !this.cWO.isShowing()) {
            return false;
        }
        this.cWO.bFL();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cWO != null) {
            this.cWO.onChangeSkinType();
        }
        aj.j(this.daI, d.f.icon_tabbar_chaticon_n);
        aj.c(this.daI, d.f.icon_tabbar_add_n);
    }

    public boolean apB() {
        k alE;
        String fixedText;
        if (this.cIC != null && (alE = this.cIC.alE()) != null) {
            if (ax.aS(this.cIC.getPageContext().getPageActivity())) {
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
                        BdToast b = BdToast.b(this.cIC.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cIC.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cIC.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cIC.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cIC.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    av.vI().c(d.this.cIC.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cIC.getPageContext()).th();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean anX() {
        if (this.cWO == null) {
            return false;
        }
        return this.cWO.isShowing();
    }
}
