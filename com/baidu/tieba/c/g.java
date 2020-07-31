package com.baidu.tieba.c;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class g {
    private bv aii;
    private com.baidu.tbadk.coreExtra.model.a eaU;
    private i hcW;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void q(bv bvVar) {
        this.aii = bvVar;
    }

    public void showDialog() {
        if (this.hcW == null) {
            k kVar = new k(this.mPageContext.getPageActivity());
            kVar.setTitleText(this.mPageContext.getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(R.string.confirm), kVar);
            gVar.a(new k.b() { // from class: com.baidu.tieba.c.g.1
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    if (!j.isNetworkAvailableForImmediately()) {
                        g.this.mPageContext.showToast(R.string.network_ungeilivable);
                    }
                    if (bf.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                        if (g.this.aii != null) {
                            g.this.eaU.a(false, g.this.aii.aWl().getPortrait(), g.this.aii.aWl().getUserId(), g.this.aii.aWl().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new ap("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(g.this.hcW, g.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.g.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (g.this.hcW != null) {
                        com.baidu.adp.lib.f.g.b(g.this.hcW, g.this.mPageContext);
                    }
                }
            });
            kVar.aS(arrayList);
            this.hcW = new i(this.mPageContext, kVar);
            this.hcW.P(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.hcW, this.mPageContext);
    }

    public void zA() {
        com.baidu.adp.lib.f.g.b(this.hcW, this.mPageContext);
    }
}
