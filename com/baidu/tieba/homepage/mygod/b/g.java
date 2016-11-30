package com.baidu.tieba.homepage.mygod.b;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.flow.a.b {
    final /* synthetic */ a cKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cKn = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tD() {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        tbPageContext = this.cKn.Gf;
        eVar.setHeight((int) (k.K(tbPageContext.getPageActivity()) / 3.5294118f));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tC() {
        com.baidu.tbadk.core.flow.a.c tC = super.tC();
        if (tC != null) {
            tC.setGravity(81);
            tC.cu(r.e.ds20);
        }
        return tC;
    }
}
