package com.baidu.tieba.homepage.mygod.b;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.flow.a.b {
    final /* synthetic */ a cpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cpI = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e to() {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        tbPageContext = this.cpI.Gf;
        eVar.setHeight((int) (k.I(tbPageContext.getPageActivity()) / 3.5294118f));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tn() {
        com.baidu.tbadk.core.flow.a.c tn = super.tn();
        if (tn != null) {
            tn.setGravity(81);
            tn.cw(r.e.ds20);
        }
        return tn;
    }
}
