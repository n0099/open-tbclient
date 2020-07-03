package com.baidu.tieba.c;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private bu aiq;
    private com.baidu.tbadk.coreExtra.model.a dUB;
    private i gXr;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dUB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void q(bu buVar) {
        this.aiq = buVar;
    }

    public void showDialog() {
        if (this.gXr == null) {
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
                    if (be.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                        if (g.this.aiq != null) {
                            g.this.dUB.a(false, g.this.aiq.aSp().getPortrait(), g.this.aiq.aSp().getUserId(), g.this.aiq.aSp().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new ao("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(g.this.gXr, g.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.g.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (g.this.gXr != null) {
                        com.baidu.adp.lib.f.g.b(g.this.gXr, g.this.mPageContext);
                    }
                }
            });
            kVar.aL(arrayList);
            this.gXr = new i(this.mPageContext, kVar);
            this.gXr.P(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.gXr, this.mPageContext);
    }

    public void yY() {
        com.baidu.adp.lib.f.g.b(this.gXr, this.mPageContext);
    }
}
