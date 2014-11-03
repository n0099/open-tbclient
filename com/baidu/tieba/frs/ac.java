package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.widget.ListView.an {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
                this.aBu.amK = (com.baidu.tbadk.core.data.q) alVar;
                qVar = this.aBu.amK;
                if (qVar instanceof com.baidu.tbadk.core.data.a) {
                    qVar2 = this.aBu.amK;
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) qVar2;
                    if (!aVar.jH()) {
                        if (aVar.zf == 0) {
                            this.aBu.a(aVar, i);
                        }
                        TiebaStatic.eventStat(this.aBu, "frs_tb_arc", "");
                    }
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.data.af.alI.getId()) {
                this.aBu.amK = (com.baidu.tbadk.core.data.q) alVar;
                FrsActivity frsActivity = this.aBu;
                qVar3 = this.aBu.amK;
                frsActivity.mThreadId = qVar3.getId();
                qVar4 = this.aBu.amK;
                String kA = qVar4.kA();
                if (kA == null || kA.equals("")) {
                    this.aBu.aAE = false;
                } else {
                    this.aBu.aAE = true;
                }
                FrsActivity frsActivity2 = this.aBu;
                qVar5 = this.aBu.amK;
                frsActivity2.d(qVar5);
                buVar = this.aBu.aAF;
                buVar.Gl();
            }
        }
        return false;
    }
}
