package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.t> {
    final /* synthetic */ t bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bRF = tVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        bb wn = bb.wn();
        tbPageContext = this.bRF.aaX;
        boolean c = wn.c(tbPageContext, new String[]{str});
        frsActivity = this.bRF.bOf;
        if (frsActivity != null && c) {
            as asVar = new as("c11677");
            frsActivity2 = this.bRF.bOf;
            TiebaStatic.log(asVar.aa("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.t tVar) {
    }
}
