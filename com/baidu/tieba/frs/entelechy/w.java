package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.d<com.baidu.tbadk.core.data.r> {
    final /* synthetic */ u bEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bEm = uVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void f(int i, String str) {
        TbPageContext<?> tbPageContext;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        bc vz = bc.vz();
        tbPageContext = this.bEm.Gf;
        boolean c = vz.c(tbPageContext, new String[]{str});
        frsActivity = this.bEm.bzH;
        if (frsActivity != null && c) {
            at atVar = new at("c11677");
            frsActivity2 = this.bEm.bzH;
            TiebaStatic.log(atVar.ab("fid", frsActivity2.getForumId()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tbadk.core.data.r rVar) {
    }
}
