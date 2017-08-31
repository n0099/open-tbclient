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
    public com.baidu.tieba.write.b cCp;
    private NoPressedRelativeLayout cFU;
    public boolean cGj = false;
    public ImageView cGk;
    private com.baidu.tieba.frs.f cqt;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.cqt = fVar;
            this.cFU = noPressedRelativeLayout;
            this.cGk = (ImageView) this.cFU.findViewById(d.h.normal_write_icon);
            aj.j(this.cGk, d.g.icon_tabbar_chaticon_n);
            aj.c(this.cGk, d.g.icon_tabbar_add_n);
            this.cGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.ako()) {
                        if (d.this.cCp == null) {
                            d.this.cCp = new com.baidu.tieba.write.b(d.this.cqt.getPageContext(), d.this.cFU);
                            d.this.cCp.sR("2");
                        }
                        d.this.cCp.a(d.this.cqt.ahk());
                        d.this.cCp.nh(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eJ(boolean z) {
        if (this.cGk != null && z != this.cGj) {
            this.cGj = z;
            this.cGk.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void aje() {
        if (this.cCp != null) {
            this.cCp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajf() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajg() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahv() {
        if (this.cCp == null || !this.cCp.isShowing()) {
            return false;
        }
        this.cCp.bxs();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cCp != null) {
            this.cCp.onChangeSkinType();
        }
        aj.j(this.cGk, d.g.icon_tabbar_chaticon_n);
        aj.c(this.cGk, d.g.icon_tabbar_add_n);
    }

    public boolean ako() {
        i ahf;
        String fixedText;
        if (this.cqt != null && (ahf = this.cqt.ahf()) != null) {
            if (ax.aT(this.cqt.getPageContext().getPageActivity())) {
                AntiData qn = ahf.qn();
                if (qn != null) {
                    if (a(qn.getBlock_stat(), qn.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qn.getIfpost() == 0 && !StringUtils.isNull(qn.getForbid_info())) {
                        String forbid_info = qn.getForbid_info();
                        if (am.dV(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cqt.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cqt.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cqt.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.E(1.25f);
            b.tw();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cqt.getPageContext().getPageActivity());
        aVar.cM(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cqt.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.2
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
                    au.wd().c(d.this.cqt.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cqt.getPageContext()).to();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajh() {
        if (this.cCp == null) {
            return false;
        }
        return this.cCp.isShowing();
    }
}
