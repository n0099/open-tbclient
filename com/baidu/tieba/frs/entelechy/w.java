package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.r> {
    final /* synthetic */ u bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bVr = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        bh vL = bh.vL();
        tbPageContext = this.bVr.Gd;
        boolean c = vL.c(tbPageContext, new String[]{str});
        frsActivity = this.bVr.bRi;
        if (frsActivity != null && c) {
            ax axVar = new ax("c11677");
            frsActivity2 = this.bVr.bRi;
            TiebaStatic.log(axVar.ab("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.r rVar) {
    }
}
