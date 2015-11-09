package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v25, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tieba.frs.mc.a aVar;
        String str;
        com.baidu.tieba.frs.mc.a aVar2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.aUS.c((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cZA.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TU.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.ro()) {
                            if (!bVar.rp()) {
                                return;
                            }
                            this.aUS.a(bVar);
                            return;
                        }
                        this.aUS.c(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) uVar;
                    if (wVar.getAnchorInfoData() == null || wVar.getAnchorInfoData().getGroup_id() == 0 || this.aUS.checkUpIsLogin()) {
                        if ((wVar.sx() != 1 && wVar.sx() != 2) || this.aUS.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.lR(wVar.getId())) {
                                readThreadHistory.lQ(wVar.getId());
                            }
                            boolean z = false;
                            String sl = wVar.sl();
                            if (sl != null && !sl.equals("")) {
                                z = true;
                                new Thread(new q(this, sl)).start();
                            }
                            String tid = wVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (wVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.az uX = com.baidu.tbadk.core.util.az.uX();
                                TbPageContext<?> pageContext = this.aUS.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uX.b(pageContext, strArr);
                            } else if (wVar.sq() == 33 || (wVar instanceof com.baidu.tbadk.core.data.q)) {
                                String str2 = wVar.sq() == 33 ? "c10245" : "c10180";
                                aVar = this.aUS.aUq;
                                if (aVar.Nv() == 5) {
                                    str2 = "c10387";
                                }
                                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str2);
                                str = this.aUS.forumId;
                                TiebaStatic.log(aqVar.ae(ImageViewerConfig.FORUM_ID, str));
                                this.aUS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.aUS.getPageContext().getPageActivity(), wVar.getTid()).cg("from_frs").bs(18003).ri()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    wVar.setId(tid.substring(3));
                                }
                                com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c10077");
                                aVar2 = this.aUS.aUq;
                                aqVar2.r("obj_source", aVar2.Nv());
                                TiebaStatic.log(aqVar2);
                                this.aUS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUS.getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aUS.aTU, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
