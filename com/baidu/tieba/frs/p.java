package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ub.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId()) {
                if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                    this.this$0.c((com.baidu.tbadk.core.data.c) uVar, i);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.y.cHK.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ud.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ue.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uf.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                        if (!cVar.rw()) {
                            if (!cVar.rx()) {
                                return;
                            }
                            this.this$0.a(cVar);
                            return;
                        }
                        this.this$0.c(cVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.v)) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) uVar;
                    if (vVar.getAnchorInfoData() == null || vVar.getAnchorInfoData().getGroup_id() == 0 || this.this$0.checkUpIsLogin()) {
                        if ((vVar.sz() != 1 && vVar.sz() != 2) || this.this$0.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.kE(vVar.getId())) {
                                readThreadHistory.kD(vVar.getId());
                            }
                            boolean z = false;
                            String sp = vVar.sp();
                            if (sp != null && !sp.equals("")) {
                                z = true;
                                new Thread(new q(this, sp)).start();
                            }
                            String tid = vVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (vVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.ax uR = com.baidu.tbadk.core.util.ax.uR();
                                TbPageContext<?> pageContext = this.this$0.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uR.b(pageContext, strArr);
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                vVar.setId(tid.substring(3));
                            }
                            this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.this$0.getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.this$0.aUq, null, 18003, true, false, z)));
                        }
                    }
                }
            }
        }
    }
}
