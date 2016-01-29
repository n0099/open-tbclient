package com.baidu.tieba.frs.frsgood;

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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Um.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Un.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uo.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.c)) {
                    return;
                }
                this.bnm.d((com.baidu.tbadk.core.data.c) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.dVD.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Up.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uq.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ur.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                        if (!cVar.rN()) {
                            if (!cVar.rO()) {
                                return;
                            }
                            this.bnm.b(cVar);
                            return;
                        }
                        this.bnm.d(cVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.ah)) {
                    com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) uVar;
                    if (ahVar.getAnchorInfoData() == null || ahVar.getAnchorInfoData().getGroup_id() == 0 || this.bnm.checkUpIsLogin()) {
                        if ((ahVar.tE() != 1 && ahVar.tE() != 2) || this.bnm.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.mU(ahVar.getId())) {
                                readThreadHistory.mT(ahVar.getId());
                            }
                            boolean z = false;
                            String tq = ahVar.tq();
                            if (tq != null && !tq.equals("")) {
                                z = true;
                                new Thread(new h(this, tq)).start();
                            }
                            String tid = ahVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (ahVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                be wt = be.wt();
                                TbPageContext<?> pageContext = this.bnm.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                wt.c(pageContext, strArr);
                            } else if (ahVar.getThreadType() == 33 || (ahVar instanceof com.baidu.tbadk.core.data.x)) {
                                au auVar = new au(ahVar.getThreadType() == 33 ? "c10245" : "c10180");
                                str = this.bnm.forumId;
                                TiebaStatic.log(auVar.aa(ImageViewerConfig.FORUM_ID, str));
                                this.bnm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bnm.getPageContext().getPageActivity(), ahVar.getTid()).co("from_frs").bD(18003).rC()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    ahVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.bnm;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bnm.getPageContext().getPageActivity());
                                str2 = this.bnm.bfv;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
