package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.t> {
    final /* synthetic */ u bRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bRQ = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        bb vQ = bb.vQ();
        tbPageContext = this.bRQ.aaI;
        boolean c = vQ.c(tbPageContext, new String[]{str});
        frsActivity = this.bRQ.bOq;
        if (frsActivity != null && c) {
            as asVar = new as("c11677");
            frsActivity2 = this.bRQ.bOq;
            TiebaStatic.log(asVar.Z("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.t tVar) {
    }
}
