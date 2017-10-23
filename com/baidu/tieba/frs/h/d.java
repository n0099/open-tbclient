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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.e {
    public com.baidu.tieba.write.b cDO;
    public boolean cHI = false;
    public ImageView cHJ;
    private NoPressedRelativeLayout cHt;
    private com.baidu.tieba.frs.f crw;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.crw = fVar;
            this.cHt = noPressedRelativeLayout;
            this.cHJ = (ImageView) this.cHt.findViewById(d.h.normal_write_icon);
            aj.j(this.cHJ, d.g.icon_tabbar_chaticon_n);
            aj.c(this.cHJ, d.g.icon_tabbar_add_n);
            this.cHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.aky()) {
                        if (d.this.cDO == null) {
                            d.this.cDO = new com.baidu.tieba.write.b(d.this.crw.getPageContext(), d.this.cHt, "frs");
                            d.this.cDO.sW("2");
                        }
                        d.this.cDO.a(d.this.crw.ahj());
                        d.this.cDO.nm(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ez(boolean z) {
        if (this.cHJ != null && z != this.cHI) {
            this.cHI = z;
            this.cHJ.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajp() {
        if (this.cDO != null) {
            this.cDO.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajq() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void ajr() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ahu() {
        if (this.cDO == null || !this.cDO.isShowing()) {
            return false;
        }
        this.cDO.byL();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cDO != null) {
            this.cDO.onChangeSkinType();
        }
        aj.j(this.cHJ, d.g.icon_tabbar_chaticon_n);
        aj.c(this.cHJ, d.g.icon_tabbar_add_n);
    }

    public boolean aky() {
        i ahf;
        String fixedText;
        if (this.crw != null && (ahf = this.crw.ahf()) != null) {
            if (ax.aT(this.crw.getPageContext().getPageActivity())) {
                AntiData qa = ahf.qa();
                if (qa != null) {
                    if (a(qa.getBlock_stat(), qa.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qa.getIfpost() == 0 && !StringUtils.isNull(qa.getForbid_info())) {
                        String forbid_info = qa.getForbid_info();
                        if (am.dN(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.crw.getPageContext().getPageActivity(), forbid_info, d.g.icon_toast_game_error);
                        b.F(1.25f);
                        b.tj();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.crw.getResources().getString(d.l.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.crw.getPageContext().getPageActivity(), string, d.g.icon_toast_game_error);
            b.F(1.25f);
            b.tj();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.crw.getPageContext().getPageActivity());
        aVar.cL(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.crw.getResources().getString(d.l.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.h.d.2
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
                    av.vA().c(d.this.crw.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.crw.getPageContext()).tb();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean ajs() {
        if (this.cDO == null) {
            return false;
        }
        return this.cDO.isShowing();
    }
}
