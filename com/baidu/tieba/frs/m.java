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
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.aj
    public void a(View view, com.baidu.adp.widget.ListView.ai aiVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pm.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pn.getId()) {
                if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.c)) {
                    this.aLY.c((com.baidu.tbadk.core.data.c) aiVar, i);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aj.cpQ.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Po.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pp.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Pq.getId()) {
                    if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aiVar;
                        if (!cVar.qv()) {
                            if (!cVar.qw()) {
                                return;
                            }
                            this.aLY.a(cVar);
                            return;
                        }
                        this.aLY.c(cVar, i);
                    }
                } else if (aiVar != null && (aiVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) aiVar;
                    if (wVar.getAnchorInfoData() == null || wVar.getAnchorInfoData().getGroup_id() == 0 || this.aLY.checkUpIsLogin()) {
                        if ((wVar.rv() != 1 && wVar.rv() != 2) || this.aLY.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.jL(wVar.getId())) {
                                readThreadHistory.jK(wVar.getId());
                            }
                            boolean z = false;
                            String rl = wVar.rl();
                            if (rl != null && !rl.equals("")) {
                                z = true;
                                new Thread(new n(this, rl)).start();
                            }
                            String tid = wVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (wVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.bi tO = com.baidu.tbadk.core.util.bi.tO();
                                TbPageContext<?> pageContext = this.aLY.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                tO.b(pageContext, strArr);
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                wVar.setId(tid.substring(3));
                            }
                            FrsActivity frsActivity = this.aLY;
                            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aLY.getPageContext().getPageActivity());
                            str = this.aLY.aLc;
                            frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, z)));
                        }
                    }
                }
            }
        }
    }
}
