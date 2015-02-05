package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.adp.widget.ListView.an {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v13, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.an
    public void a(View view, com.baidu.adp.widget.ListView.am amVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dh.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Di.getId()) {
                if (amVar != null && (amVar instanceof com.baidu.tbadk.core.data.c)) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) amVar;
                    this.aDT.a(cVar, "area_click");
                    this.aDT.b(cVar, "click");
                    int i2 = cVar.Dj;
                    if (i2 == 0) {
                        this.aDT.a(cVar, i);
                    } else if (i2 == 2) {
                        TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "down_success", null, 1, "app_name", cVar.Dp, cVar.Do);
                        this.aDT.b(cVar, "down_success");
                        com.baidu.tieba.frs.utils.a.F(this.aDT.getPageContext().getPageActivity(), cVar.Dp);
                    }
                    TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Dp);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bUU.getId() && amVar != null && (amVar instanceof com.baidu.tbadk.core.data.x)) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) amVar;
                com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.iu(xVar.getId())) {
                    readThreadHistory.it(xVar.getId());
                }
                boolean z = false;
                String np = xVar.np();
                if (np != null && !np.equals("")) {
                    z = true;
                    new Thread(new u(this, np)).start();
                }
                String tid = xVar.getTid();
                if (tid == null) {
                    tid = "";
                }
                if (xVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                    com.baidu.tbadk.core.util.bm pO = com.baidu.tbadk.core.util.bm.pO();
                    TbPageContext<?> pageContext = this.aDT.getPageContext();
                    String[] strArr = new String[3];
                    strArr[0] = tid;
                    strArr[1] = "";
                    pO.b(pageContext, strArr);
                    return;
                }
                if (tid.startsWith("pb:")) {
                    xVar.setId(tid.substring(3));
                }
                FrsActivity frsActivity = this.aDT;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDT.getPageContext().getPageActivity());
                str = this.aDT.aCN;
                frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str, null, 18003, true, false, z)));
            }
        }
    }
}
