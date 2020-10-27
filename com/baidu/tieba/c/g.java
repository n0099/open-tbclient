package com.baidu.tieba.c;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class g {
    private bw akq;
    private com.baidu.tbadk.coreExtra.model.a eHC;
    private i hYq;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eHC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void r(bw bwVar) {
        this.akq = bwVar;
    }

    public void PJ() {
        if (this.hYq == null) {
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
                    if (bg.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                        if (g.this.akq != null) {
                            g.this.eHC.a(false, g.this.akq.bka().getPortrait(), g.this.akq.bka().getUserId(), g.this.akq.bka().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new aq("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(g.this.hYq, g.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.g.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (g.this.hYq != null) {
                        com.baidu.adp.lib.f.g.b(g.this.hYq, g.this.mPageContext);
                    }
                }
            });
            kVar.bk(arrayList);
            this.hYq = new i(this.mPageContext, kVar);
            this.hYq.Y(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.hYq, this.mPageContext);
    }

    public void GU() {
        com.baidu.adp.lib.f.g.b(this.hYq, this.mPageContext);
    }
}
