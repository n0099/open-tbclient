package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.s> {
    final /* synthetic */ u bYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bYy = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void f(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        bf vP = bf.vP();
        tbPageContext = this.bYy.Gf;
        boolean c = vP.c(tbPageContext, new String[]{str});
        frsActivity = this.bYy.bTA;
        if (frsActivity != null && c) {
            av avVar = new av("c11677");
            frsActivity2 = this.bYy.bTA;
            TiebaStatic.log(avVar.ab("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.s sVar) {
    }
}
