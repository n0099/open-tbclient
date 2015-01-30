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
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v13, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.an
    public void a(View view, com.baidu.adp.widget.ListView.am amVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dk.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dl.getId()) {
                if (amVar != null && (amVar instanceof com.baidu.tbadk.core.data.c)) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) amVar;
                    this.aDW.a(cVar, "area_click");
                    this.aDW.b(cVar, "click");
                    int i2 = cVar.Dm;
                    if (i2 == 0) {
                        this.aDW.a(cVar, i);
                    } else if (i2 == 2) {
                        TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "down_success", null, 1, "app_name", cVar.Ds, cVar.Dr);
                        this.aDW.b(cVar, "down_success");
                        com.baidu.tieba.frs.utils.a.F(this.aDW.getPageContext().getPageActivity(), cVar.Ds);
                    }
                    TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Ds);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bUV.getId() && amVar != null && (amVar instanceof com.baidu.tbadk.core.data.x)) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) amVar;
                com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.iw(xVar.getId())) {
                    readThreadHistory.iv(xVar.getId());
                }
                boolean z = false;
                String nw = xVar.nw();
                if (nw != null && !nw.equals("")) {
                    z = true;
                    new Thread(new u(this, nw)).start();
                }
                String tid = xVar.getTid();
                if (tid == null) {
                    tid = "";
                }
                if (xVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                    com.baidu.tbadk.core.util.bm pV = com.baidu.tbadk.core.util.bm.pV();
                    TbPageContext<?> pageContext = this.aDW.getPageContext();
                    String[] strArr = new String[3];
                    strArr[0] = tid;
                    strArr[1] = "";
                    pV.b(pageContext, strArr);
                    return;
                }
                if (tid.startsWith("pb:")) {
                    xVar.setId(tid.substring(3));
                }
                FrsActivity frsActivity = this.aDW;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aDW.getPageContext().getPageActivity());
                str = this.aDW.aCQ;
                frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(xVar, str, null, 18003, true, false, z)));
            }
        }
    }
}
