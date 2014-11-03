package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.adp.widget.ListView.am {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.am
    public void a(View view, com.baidu.adp.widget.ListView.al alVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.a.zd.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.a.ze.getId()) {
                if (alVar != null && (alVar instanceof com.baidu.tbadk.core.data.a)) {
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) alVar;
                    this.aBu.a(aVar, "area_click");
                    this.aBu.b(aVar, "click");
                    int i2 = aVar.zf;
                    if (i2 == 0) {
                        this.aBu.a(aVar, i);
                    } else if (i2 == 2) {
                        com.baidu.tieba.frs.a.a.x(this.aBu, aVar.zl);
                    }
                    TiebaStatic.eventStat(this.aBu, "frs_ck_app", null, 1, "app_name", aVar.zl);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.data.af.alI.getId() && alVar != null && (alVar instanceof com.baidu.tbadk.core.data.q)) {
                com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) alVar;
                com.baidu.tieba.util.o wL = com.baidu.tieba.aj.wm().wL();
                if (wL != null && !wL.hH(qVar.getId())) {
                    wL.hG(qVar.getId());
                }
                boolean z = false;
                String kA = qVar.kA();
                if (kA != null && !kA.equals("")) {
                    z = true;
                    new Thread(new z(this, kA)).start();
                }
                String tid = qVar.getTid();
                if (tid == null) {
                    tid = "";
                }
                if (qVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                    com.baidu.tbadk.core.util.bg mR = com.baidu.tbadk.core.util.bg.mR();
                    FrsActivity frsActivity = this.aBu;
                    String[] strArr = new String[3];
                    strArr[0] = tid;
                    strArr[1] = "";
                    mR.b(frsActivity, strArr);
                    return;
                }
                if (tid.startsWith("pb:")) {
                    qVar.setId(tid.substring(3));
                }
                FrsActivity frsActivity2 = this.aBu;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aBu);
                str = this.aBu.aAx;
                frsActivity2.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(qVar, str, null, 18003, true, false, z)));
            }
        }
    }
}
