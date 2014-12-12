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
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.an
    public void a(View view, com.baidu.adp.widget.ListView.am amVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Di.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Dj.getId()) {
                if (amVar != null && (amVar instanceof com.baidu.tbadk.core.data.c)) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) amVar;
                    this.aCV.a(cVar, "area_click");
                    this.aCV.b(cVar, "click");
                    int i2 = cVar.Dk;
                    if (i2 == 0) {
                        this.aCV.a(cVar, i);
                    } else if (i2 == 2) {
                        com.baidu.tieba.frs.utils.a.G(this.aCV.getPageContext().getPageActivity(), cVar.Dq);
                    }
                    TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Dq);
                }
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ag.bTc.getId() && amVar != null && (amVar instanceof com.baidu.tbadk.core.data.w)) {
                com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) amVar;
                com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.ip(wVar.getId())) {
                    readThreadHistory.io(wVar.getId());
                }
                boolean z = false;
                String nu = wVar.nu();
                if (nu != null && !nu.equals("")) {
                    z = true;
                    new Thread(new u(this, nu)).start();
                }
                String tid = wVar.getTid();
                if (tid == null) {
                    tid = "";
                }
                if (wVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                    com.baidu.tbadk.core.util.bh pK = com.baidu.tbadk.core.util.bh.pK();
                    TbPageContext<?> pageContext = this.aCV.getPageContext();
                    String[] strArr = new String[3];
                    strArr[0] = tid;
                    strArr[1] = "";
                    pK.b(pageContext, strArr);
                    return;
                }
                if (tid.startsWith("pb:")) {
                    wVar.setId(tid.substring(3));
                }
                FrsActivity frsActivity = this.aCV;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aCV.getPageContext().getPageActivity());
                str = this.aCV.aBP;
                frsActivity.sendMessage(new CustomMessage(2004001, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, z)));
            }
        }
    }
}
