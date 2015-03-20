package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.aj {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.aj
    public void a(View view, com.baidu.adp.widget.ListView.ai aiVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OQ.getId()) {
                if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.c)) {
                    this.aJG.c((com.baidu.tbadk.core.data.c) aiVar, i);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aj.clA.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.OT.getId()) {
                    if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aiVar;
                        if (!cVar.pP()) {
                            if (!cVar.pQ()) {
                                return;
                            }
                            this.aJG.a(cVar);
                            return;
                        }
                        this.aJG.c(cVar, i);
                    }
                } else if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) aiVar;
                    com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.iO(wVar.getId())) {
                        readThreadHistory.iN(wVar.getId());
                    }
                    boolean z = false;
                    String qF = wVar.qF();
                    if (qF != null && !qF.equals("")) {
                        z = true;
                        new Thread(new n(this, qF)).start();
                    }
                    String tid = wVar.getTid();
                    if (tid == null) {
                        tid = "";
                    }
                    if (wVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                        com.baidu.tbadk.core.util.bk tl = com.baidu.tbadk.core.util.bk.tl();
                        TbPageContext<?> pageContext = this.aJG.getPageContext();
                        String[] strArr = new String[3];
                        strArr[0] = tid;
                        strArr[1] = "";
                        tl.b(pageContext, strArr);
                        return;
                    }
                    if (tid.startsWith("pb:")) {
                        wVar.setId(tid.substring(3));
                    }
                    FrsActivity frsActivity = this.aJG;
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aJG.getPageContext().getPageActivity());
                    str = this.aJG.aIK;
                    frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, z)));
                }
            }
        }
    }
}
