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
    private com.baidu.tieba.frs.f cIp;
    public com.baidu.tieba.write.c cWz;
    private NoPressedRelativeLayout daa;
    public boolean dap = false;
    public ImageView daq;

    public d(com.baidu.tieba.frs.f fVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (fVar != null && noPressedRelativeLayout != null) {
            this.cIp = fVar;
            this.daa = noPressedRelativeLayout;
            this.daq = (ImageView) this.daa.findViewById(d.g.normal_write_icon);
            aj.j(this.daq, d.f.icon_tabbar_chaticon_n);
            aj.c(this.daq, d.f.icon_tabbar_add_n);
            this.daq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!d.this.aps()) {
                        if (d.this.cWz == null) {
                            d.this.cWz = new com.baidu.tieba.write.c(d.this.cIp.getPageContext(), d.this.daa, "frs");
                            d.this.cWz.ux("2");
                        }
                        d.this.cWz.a(d.this.cIp.alz());
                        d.this.cWz.nU(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void eR(boolean z) {
        if (this.daq != null && z != this.dap) {
            this.dap = z;
            this.daq.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anL() {
        if (this.cWz != null) {
            this.cWz.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anM() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void anN() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean alK() {
        if (this.cWz == null || !this.cWz.isShowing()) {
            return false;
        }
        this.cWz.bEZ();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public void onChangeSkinType(int i) {
        if (this.cWz != null) {
            this.cWz.onChangeSkinType();
        }
        aj.j(this.daq, d.f.icon_tabbar_chaticon_n);
        aj.c(this.daq, d.f.icon_tabbar_add_n);
    }

    public boolean aps() {
        k alv;
        String fixedText;
        if (this.cIp != null && (alv = this.cIp.alv()) != null) {
            if (ax.aV(this.cIp.getPageContext().getPageActivity())) {
                AntiData qi = alv.qi();
                if (qi != null) {
                    if (a(qi.getBlock_stat(), qi.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (qi.getIfpost() == 0 && !StringUtils.isNull(qi.getForbid_info())) {
                        String forbid_info = qi.getForbid_info();
                        if (am.dV(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.cIp.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.E(1.25f);
                        b.tt();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.cIp.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.cIp.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.E(1.25f);
            b.tt();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cIp.getPageContext().getPageActivity());
        aVar.cS(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.cIp.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.g.d.2
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
                    av.vL().c(d.this.cIp.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.cIp.getPageContext()).tk();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.e
    public boolean anO() {
        if (this.cWz == null) {
            return false;
        }
        return this.cWz.isShowing();
    }
}
