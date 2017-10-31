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
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.write.c cMU;
    private NoPressedRelativeLayout cQE;
    public boolean cQT = false;
    public ImageView cQU;
    private com.baidu.tieba.frs.f cyR;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.cyR = fVar;
            this.cQE = noPressedRelativeLayout;
            this.cQU = (ImageView) this.cQE.findViewById(d.g.normal_write_icon);
            aj.j(this.cQU, d.f.icon_tabbar_chaticon_n);
            aj.c(this.cQU, d.f.icon_tabbar_add_n);
            this.cQU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.anh()) {
                        if (d.this.cMU == null) {
                            d.this.cMU = new com.baidu.tieba.write.c(d.this.cyR.getPageContext(), d.this.cQE, "frs");
                            d.this.cMU.tJ("2");
                        }
                        d.this.cMU.a(d.this.cyR.ajr());
                        d.this.cMU.nk(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ev(boolean z) {
        if (this.cQU != null && z != this.cQT) {
            this.cQT = z;
            this.cQU.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alC() {
        if (this.cMU != null) {
            this.cMU.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alD() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alE() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajC() {
        if (this.cMU == null || !this.cMU.isShowing()) {
            return false;
        }
        this.cMU.bCj();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cMU != null) {
            this.cMU.onChangeSkinType();
        }
        aj.j(this.cQU, d.f.icon_tabbar_chaticon_n);
        aj.c(this.cQU, d.f.icon_tabbar_add_n);
    }

    public boolean anh() {
        j ajn;
        String fixedText;
        if (this.cyR != null && (ajn = this.cyR.ajn()) != null) {
            if (ax.aT(this.cyR.getPageContext().getPageActivity())) {
                AntiData qf = ajn.qf();
                if (qf != null) {
                    if (a(qf.getBlock_stat(), qf.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qf.getIfpost() == 0 && !StringUtils.isNull(qf.getForbid_info())) {
                        String forbid_info = qf.getForbid_info();
                        if (am.dT(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cyR.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cyR.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cyR.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cyR.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cyR.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    av.vI().c(d.this.cyR.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cyR.getPageContext()).th();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean alF() {
        if (this.cMU == null) {
            return false;
        }
        return this.cMU.isShowing();
    }
}
