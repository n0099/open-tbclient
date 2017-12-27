package com.baidu.tieba.frs.f;

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
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    public com.baidu.tieba.write.c dIZ;
    private com.baidu.tieba.p.a dJh;
    private NoPressedRelativeLayout dMI;
    public boolean dMX = false;
    public ImageView dMY;
    private com.baidu.tieba.frs.i dxW;

    public d(com.baidu.tieba.frs.i iVar, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (iVar != null && noPressedRelativeLayout != null) {
            this.dxW = iVar;
            this.dMI = noPressedRelativeLayout;
            this.dMY = (ImageView) this.dMI.findViewById(d.g.normal_write_icon);
            aj.s(this.dMY, d.f.icon_tabbar_chaticon_n);
            aj.c(this.dMY, d.f.icon_tabbar_add_n);
            this.dJh = new com.baidu.tieba.p.a(iVar.getPageContext());
            this.dMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ax.be(d.this.dxW.getPageContext().getPageActivity()) && !d.this.dJh.bGo() && !d.this.awB()) {
                        if (d.this.dIZ == null) {
                            d.this.dIZ = new com.baidu.tieba.write.c(d.this.dxW.getPageContext(), d.this.dMI, "frs");
                            d.this.dIZ.uF("2");
                        }
                        d.this.dIZ.a(d.this.dxW.atr());
                        d.this.dIZ.op(false);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fy(boolean z) {
        if (this.dMY != null && z != this.dMX) {
            this.dMX = z;
            this.dMY.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void avu() {
        if (this.dIZ != null) {
            this.dIZ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void avv() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void avw() {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean atD() {
        if (this.dIZ == null || !this.dIZ.isShowing()) {
            return false;
        }
        this.dIZ.bLt();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.dIZ != null) {
            this.dIZ.onChangeSkinType();
        }
        aj.s(this.dMY, d.f.icon_tabbar_chaticon_n);
        aj.c(this.dMY, d.f.icon_tabbar_add_n);
    }

    public boolean awB() {
        l atn;
        String fixedText;
        if (this.dxW != null && (atn = this.dxW.atn()) != null) {
            if (ax.be(this.dxW.getPageContext().getPageActivity())) {
                AntiData xJ = atn.xJ();
                if (xJ != null) {
                    if (a(xJ.getBlock_stat(), xJ.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (xJ.getIfpost() == 0 && !StringUtils.isNull(xJ.getForbid_info())) {
                        String forbid_info = xJ.getForbid_info();
                        if (am.ec(forbid_info) > 14) {
                            forbid_info = am.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b = BdToast.b(this.dxW.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        b.U(1.25f);
                        b.AQ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.dxW.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(this.dxW.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            b.U(1.25f);
            b.AQ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dxW.getPageContext().getPageActivity());
        aVar.cZ(am.getFixedText(string, 50, true));
        aVar.b(am.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.dxW.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.f.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(am.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.f.d.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    av.Di().c(d.this.dxW.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.dxW.getPageContext()).AI();
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean avx() {
        if (this.dIZ == null) {
            return false;
        }
        return this.dIZ.isShowing();
    }
}
