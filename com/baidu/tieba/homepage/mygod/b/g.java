package com.baidu.tieba.homepage.mygod.b;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.flow.a.b {
    final /* synthetic */ a cyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cyh = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tF() {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        tbPageContext = this.cyh.aaI;
        eVar.setHeight((int) (k.ag(tbPageContext.getPageActivity()) / 3.5294118f));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tE() {
        com.baidu.tbadk.core.flow.a.c tE = super.tE();
        if (tE != null) {
            tE.setGravity(81);
            tE.cr(w.f.ds20);
        }
        return tE;
    }
}
