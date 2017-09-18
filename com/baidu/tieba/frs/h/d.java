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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.write.b cDh;
    private NoPressedRelativeLayout cGM;
    public boolean cHb = false;
    public ImageView cHc;
    private com.baidu.tieba.frs.f crm;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.crm = fVar;
            this.cGM = noPressedRelativeLayout;
            this.cHc = (ImageView) this.cGM.findViewById(d.h.normal_write_icon);
            aj.j(this.cHc, d.g.icon_tabbar_chaticon_n);
            aj.c(this.cHc, d.g.icon_tabbar_add_n);
            this.cHc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.akz()) {
                        if (d.this.cDh == null) {
                            d.this.cDh = new com.baidu.tieba.write.b(d.this.crm.getPageContext(), d.this.cGM);
                            d.this.cDh.sT("2");
                        }
                        d.this.cDh.a(d.this.crm.ahv());
                        d.this.cDh.ni(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eK(boolean z) {
        if (this.cHc != null && z != this.cHb) {
            this.cHb = z;
            this.cHc.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajp() {
        if (this.cDh != null) {
            this.cDh.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajq() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajr() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahG() {
        if (this.cDh == null || !this.cDh.isShowing()) {
            return false;
        }
        this.cDh.bxD();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cDh != null) {
            this.cDh.onChangeSkinType();
        }
        aj.j(this.cHc, d.g.icon_tabbar_chaticon_n);
        aj.c(this.cHc, d.g.icon_tabbar_add_n);
    }

    public boolean akz() {
        i ahq;
        String fixedText;
        if (this.crm != null && (ahq = this.crm.ahq()) != null) {
            if (ax.aU(this.crm.getPageContext().getPageActivity())) {
                AntiData qn = ahq.qn();
                if (qn != null) {
                    if (a(qn.getBlock_stat(), qn.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qn.getIfpost() == 0 && !StringUtils.isNull(qn.getForbid_info())) {
                        String forbid_info = qn.getForbid_info();
                        if (am.dV(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.crm.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.E(1.25f);
                        b.tw();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.crm.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.crm.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.E(1.25f);
            b.tw();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.crm.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.crm.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.2
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
                    au.wd().c(d.this.crm.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.crm.getPageContext()).to();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajs() {
        if (this.cDh == null) {
            return false;
        }
        return this.cDh.isShowing();
    }
}
