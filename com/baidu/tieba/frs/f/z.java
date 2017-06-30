package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements ae.b {
    final /* synthetic */ x cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.cqf = xVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.frs.r rVar;
        av avVar;
        av avVar2;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        rVar = this.cqf.cbE;
        rVar.refresh();
        avVar = this.cqf.ccj;
        if (avVar != null) {
            avVar2 = this.cqf.ccj;
            avVar2.ch(true);
            rVar2 = this.cqf.cbE;
            rVar2.et(true);
            au auVar = new au("c11749");
            rVar3 = this.cqf.cbE;
            TiebaStatic.log(auVar.Z("fid", rVar3.getFid()).Z("obj_locate", "1"));
        }
    }
}
