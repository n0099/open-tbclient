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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGoodActivity frsGoodActivity) {
        this.aZB = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TM.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.aZB.c((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cXD.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.rq()) {
                            if (!bVar.rr()) {
                                return;
                            }
                            this.aZB.a(bVar);
                            return;
                        }
                        this.aZB.c(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.v)) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) uVar;
                    if (vVar.getAnchorInfoData() == null || vVar.getAnchorInfoData().getGroup_id() == 0 || this.aZB.checkUpIsLogin()) {
                        if ((vVar.sx() != 1 && vVar.sx() != 2) || this.aZB.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.lI(vVar.getId())) {
                                readThreadHistory.lH(vVar.getId());
                            }
                            boolean z = false;
                            String sl = vVar.sl();
                            if (sl != null && !sl.equals("")) {
                                z = true;
                                new Thread(new g(this, sl)).start();
                            }
                            String tid = vVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (vVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                ay uV = ay.uV();
                                TbPageContext<?> pageContext = this.aZB.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uV.b(pageContext, strArr);
                            } else if (vVar.sq() == 33 || (vVar instanceof com.baidu.tbadk.core.data.p)) {
                                ap apVar = new ap(vVar.sq() == 33 ? "c10245" : "c10180");
                                str = this.aZB.forumId;
                                TiebaStatic.log(apVar.ae(ImageViewerConfig.FORUM_ID, str));
                                this.aZB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.aZB.getPageContext().getPageActivity(), vVar.getTid()).ch("from_frs").bs(18003).rk()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    vVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.aZB;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZB.getPageContext().getPageActivity());
                                str2 = this.aZB.aTB;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
