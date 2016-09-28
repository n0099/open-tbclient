package com.baidu.tieba.homepage.mygod.b;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.flow.a.b {
    final /* synthetic */ a cFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cFa = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tz() {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        tbPageContext = this.cFa.Gd;
        eVar.setHeight((int) (k.K(tbPageContext.getPageActivity()) / 3.5294118f));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c ty() {
        com.baidu.tbadk.core.flow.a.c ty = super.ty();
        if (ty != null) {
            ty.setGravity(81);
            ty.ct(r.e.ds20);
        }
        return ty;
    }
}
