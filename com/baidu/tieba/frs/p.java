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
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v25, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tieba.frs.mc.a aVar;
        String str;
        com.baidu.tieba.frs.mc.a aVar2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TM.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.aUz.c((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cXD.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.rq()) {
                            if (!bVar.rr()) {
                                return;
                            }
                            this.aUz.a(bVar);
                            return;
                        }
                        this.aUz.c(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.v)) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) uVar;
                    if (vVar.getAnchorInfoData() == null || vVar.getAnchorInfoData().getGroup_id() == 0 || this.aUz.checkUpIsLogin()) {
                        if ((vVar.sx() != 1 && vVar.sx() != 2) || this.aUz.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.lI(vVar.getId())) {
                                readThreadHistory.lH(vVar.getId());
                            }
                            boolean z = false;
                            String sl = vVar.sl();
                            if (sl != null && !sl.equals("")) {
                                z = true;
                                new Thread(new q(this, sl)).start();
                            }
                            String tid = vVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (vVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.ay uV = com.baidu.tbadk.core.util.ay.uV();
                                TbPageContext<?> pageContext = this.aUz.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uV.b(pageContext, strArr);
                            } else if (vVar.sq() == 33 || (vVar instanceof com.baidu.tbadk.core.data.p)) {
                                String str2 = vVar.sq() == 33 ? "c10245" : "c10180";
                                aVar = this.aUz.aTX;
                                if (aVar.Ng() == 5) {
                                    str2 = "c10387";
                                }
                                com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap(str2);
                                str = this.aUz.forumId;
                                TiebaStatic.log(apVar.ae(ImageViewerConfig.FORUM_ID, str));
                                this.aUz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.aUz.getPageContext().getPageActivity(), vVar.getTid()).ch("from_frs").bs(18003).rk()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    vVar.setId(tid.substring(3));
                                }
                                com.baidu.tbadk.core.util.ap apVar2 = new com.baidu.tbadk.core.util.ap("c10077");
                                aVar2 = this.aUz.aTX;
                                apVar2.r("obj_source", aVar2.Ng());
                                TiebaStatic.log(apVar2);
                                this.aUz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUz.getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUz.aTB, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
