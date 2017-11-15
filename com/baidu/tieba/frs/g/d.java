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
    public com.baidu.tieba.write.c cNn;
    private NoPressedRelativeLayout cQY;
    public boolean cRn = false;
    public ImageView cRo;
    private com.baidu.tieba.frs.f czk;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.czk = fVar;
            this.cQY = noPressedRelativeLayout;
            this.cRo = (ImageView) this.cQY.findViewById(d.g.normal_write_icon);
            aj.j(this.cRo, d.f.icon_tabbar_chaticon_n);
            aj.c(this.cRo, d.f.icon_tabbar_add_n);
            this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.any()) {
                        if (d.this.cNn == null) {
                            d.this.cNn = new com.baidu.tieba.write.c(d.this.czk.getPageContext(), d.this.cQY, "frs");
                            d.this.cNn.tP("2");
                        }
                        d.this.cNn.a(d.this.czk.ajF());
                        d.this.cNn.ns(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eA(boolean z) {
        if (this.cRo != null && z != this.cRn) {
            this.cRn = z;
            this.cRo.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alQ() {
        if (this.cNn != null) {
            this.cNn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alR() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void alS() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajQ() {
        if (this.cNn == null || !this.cNn.isShowing()) {
            return false;
        }
        this.cNn.bCv();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cNn != null) {
            this.cNn.onChangeSkinType();
        }
        aj.j(this.cRo, d.f.icon_tabbar_chaticon_n);
        aj.c(this.cRo, d.f.icon_tabbar_add_n);
    }

    public boolean any() {
        j ajB;
        String fixedText;
        if (this.czk != null && (ajB = this.czk.ajB()) != null) {
            if (ax.aT(this.czk.getPageContext().getPageActivity())) {
                AntiData qf = ajB.qf();
                if (qf != null) {
                    if (a(qf.getBlock_stat(), qf.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qf.getIfpost() == 0 && !StringUtils.isNull(qf.getForbid_info())) {
                        String forbid_info = qf.getForbid_info();
                        if (am.dT(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.czk.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.czk.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.czk.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tq();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.czk.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.czk.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    av.vI().c(d.this.czk.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.czk.getPageContext()).th();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean alT() {
        if (this.cNn == null) {
            return false;
        }
        return this.cNn.isShowing();
    }
}
