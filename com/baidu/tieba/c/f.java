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
    private bj agz;
    private com.baidu.tbadk.coreExtra.model.a dzD;
    private i gvs;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dzD = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void q(bj bjVar) {
        this.agz = bjVar;
    }

    public void showDialog() {
        if (this.gvs == null) {
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
                        if (f.this.agz != null) {
                            f.this.dzD.a(false, f.this.agz.aKE().getPortrait(), f.this.agz.aKE().getUserId(), f.this.agz.aKE().isGod(), "0", f.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new an("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(f.this.gvs, f.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.f.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (f.this.gvs != null) {
                        com.baidu.adp.lib.f.g.b(f.this.gvs, f.this.mPageContext);
                    }
                }
            });
            kVar.aI(arrayList);
            this.gvs = new i(this.mPageContext, kVar);
            this.gvs.O(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.gvs, this.mPageContext);
    }

    public void xl() {
        com.baidu.adp.lib.f.g.b(this.gvs, this.mPageContext);
    }
}
