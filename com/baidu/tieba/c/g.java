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
/* loaded from: classes20.dex */
public class g {
    private bw ajX;
    private com.baidu.tbadk.coreExtra.model.a emW;
    private i hwY;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.emW = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void r(bw bwVar) {
        this.ajX = bwVar;
    }

    public void NY() {
        if (this.hwY == null) {
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
                        if (g.this.ajX != null) {
                            g.this.emW.a(false, g.this.ajX.bfy().getPortrait(), g.this.ajX.bfy().getUserId(), g.this.ajX.bfy().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new aq("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(g.this.hwY, g.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.g.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (g.this.hwY != null) {
                        com.baidu.adp.lib.f.g.b(g.this.hwY, g.this.mPageContext);
                    }
                }
            });
            kVar.aX(arrayList);
            this.hwY = new i(this.mPageContext, kVar);
            this.hwY.U(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.hwY, this.mPageContext);
    }

    public void FD() {
        com.baidu.adp.lib.f.g.b(this.hwY, this.mPageContext);
    }
}
