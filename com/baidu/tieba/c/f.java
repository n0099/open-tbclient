package com.baidu.tieba.c;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class f {
    private bk ahg;
    private com.baidu.tbadk.coreExtra.model.a dNL;
    private i gKj;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
    }

    public void r(bk bkVar) {
        this.ahg = bkVar;
    }

    public void showDialog() {
        if (this.gKj == null) {
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
                        if (f.this.ahg != null) {
                            f.this.dNL.a(false, f.this.ahg.aQx().getPortrait(), f.this.ahg.aQx().getUserId(), f.this.ahg.aQx().isGod(), "0", f.this.mPageContext.getUniqueId(), null, "0");
                            TiebaStatic.log(new an("c13571"));
                        } else {
                            return;
                        }
                    }
                    com.baidu.adp.lib.f.g.b(f.this.gKj, f.this.mPageContext);
                }
            });
            arrayList.add(gVar);
            kVar.a(new k.a() { // from class: com.baidu.tieba.c.f.2
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    if (f.this.gKj != null) {
                        com.baidu.adp.lib.f.g.b(f.this.gKj, f.this.mPageContext);
                    }
                }
            });
            kVar.aD(arrayList);
            this.gKj = new i(this.mPageContext, kVar);
            this.gKj.N(0.7f);
        }
        com.baidu.adp.lib.f.g.a(this.gKj, this.mPageContext);
    }

    public void yy() {
        com.baidu.adp.lib.f.g.b(this.gKj, this.mPageContext);
    }
}
