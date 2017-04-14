package com.baidu.tieba.homepage.mygod.b;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.flow.a.b {
    final /* synthetic */ a cwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cwH = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e uc() {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        tbPageContext = this.cwH.aaX;
        eVar.setHeight((int) (k.af(tbPageContext.getPageActivity()) / 3.5294118f));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c ub() {
        com.baidu.tbadk.core.flow.a.c ub = super.ub();
        if (ub != null) {
            ub.setGravity(81);
            ub.cu(w.f.ds20);
        }
        return ub;
    }
}
