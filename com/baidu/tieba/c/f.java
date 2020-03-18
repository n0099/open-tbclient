package com.baidu.tieba.c;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class f {
    private bj NR;
    private com.baidu.tbadk.coreExtra.model.a dap;
    private i fQK;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dap = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void q(bj bjVar) {
        this.NR = bjVar;
    }

    public void showDialog() {
        if (this.fQK == null) {
            k kVar = new k(this.mPageContext.getPageActivity());
            kVar.setTitleText(this.mPageContext.getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(R.string.confirm), kVar);
            gVar.a(new k.b() { // from class: com.baidu.tieba.c.f.1
                @Override // com.baidu.tbadk.core.dialog.k.b
                public void onClick() {
                    if (!j.isNetworkAvailableForImmediately()) {
                        f.this.mPageContext.showToast(R.string.network_ungeilivable);
                    }
                    if (bc.checkUpIsLogin(f.this.mPageContext.getPageActivity())) {
                        if (f.this.NR != null) {
                            f.this.dap.a(false, f.this.NR.aCr().getPortrait(), f.this.NR.aCr().getUserId(), f.this.NR.aCr().isGod(), "0", f.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new an("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(f.this.fQK, f.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.f.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (f.this.fQK != null) {
                        com.baidu.adp.lib.f.g.b(f.this.fQK, f.this.mPageContext);
                    }
                }
            });
            kVar.az(arrayList);
            this.fQK = new i(this.mPageContext, kVar);
            this.fQK.ae(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.fQK, this.mPageContext);
    }

    public void sS() {
        com.baidu.adp.lib.f.g.b(this.fQK, this.mPageContext);
    }
}
