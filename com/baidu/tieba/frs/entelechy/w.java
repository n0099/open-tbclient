package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.s> {
    final /* synthetic */ u bKK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bKK = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void f(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ba vt = ba.vt();
        tbPageContext = this.bKK.Fp;
        boolean c = vt.c(tbPageContext, new String[]{str});
        frsActivity = this.bKK.bHh;
        if (frsActivity != null && c) {
            ar arVar = new ar("c11677");
            frsActivity2 = this.bKK.bHh;
            TiebaStatic.log(arVar.ab("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.s sVar) {
    }
}
