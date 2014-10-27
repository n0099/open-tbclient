package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.widget.ListView.an {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.an
    public boolean b(View view, com.baidu.adp.widget.ListView.al alVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        com.baidu.tbadk.core.data.q qVar3;
        com.baidu.tbadk.core.data.q qVar4;
        com.baidu.tbadk.core.data.q qVar5;
        bu buVar;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.a.zd.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.a.ze.getId()) {
                this.aBk.amB = (com.baidu.tbadk.core.data.q) alVar;
                qVar = this.aBk.amB;
                if (qVar instanceof com.baidu.tbadk.core.data.a) {
                    qVar2 = this.aBk.amB;
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) qVar2;
                    if (!aVar.jH()) {
                        if (aVar.zf == 0) {
                            this.aBk.a(aVar, i);
                        }
                        TiebaStatic.eventStat(this.aBk, "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.data.af.alz.getId()) {
                this.aBk.amB = (com.baidu.tbadk.core.data.q) alVar;
                FrsActivity frsActivity = this.aBk;
                qVar3 = this.aBk.amB;
                frsActivity.mThreadId = qVar3.getId();
                qVar4 = this.aBk.amB;
                String kA = qVar4.kA();
                if (kA == null || kA.equals("")) {
                    this.aBk.aAu = false;
                } else {
                    this.aBk.aAu = true;
                }
                FrsActivity frsActivity2 = this.aBk;
                qVar5 = this.aBk.amB;
                frsActivity2.d(qVar5);
                buVar = this.aBk.aAv;
                buVar.Gj();
            }
        }
        return false;
    }
}
