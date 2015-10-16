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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TO.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TP.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TQ.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.aZM.c((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cYd.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TR.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.TT.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.rq()) {
                            if (!bVar.rr()) {
                                return;
                            }
                            this.aZM.a(bVar);
                            return;
                        }
                        this.aZM.c(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) uVar;
                    if (wVar.getAnchorInfoData() == null || wVar.getAnchorInfoData().getGroup_id() == 0 || this.aZM.checkUpIsLogin()) {
                        if ((wVar.sx() != 1 && wVar.sx() != 2) || this.aZM.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.lL(wVar.getId())) {
                                readThreadHistory.lK(wVar.getId());
                            }
                            boolean z = false;
                            String sl = wVar.sl();
                            if (sl != null && !sl.equals("")) {
                                z = true;
                                new Thread(new g(this, sl)).start();
                            }
                            String tid = wVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (wVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                az uW = az.uW();
                                TbPageContext<?> pageContext = this.aZM.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uW.b(pageContext, strArr);
                            } else if (wVar.sq() == 33 || (wVar instanceof com.baidu.tbadk.core.data.q)) {
                                aq aqVar = new aq(wVar.sq() == 33 ? "c10245" : "c10180");
                                str = this.aZM.forumId;
                                TiebaStatic.log(aqVar.ae(ImageViewerConfig.FORUM_ID, str));
                                this.aZM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.aZM.getPageContext().getPageActivity(), wVar.getTid()).ci("from_frs").bs(18003).rk()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    wVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.aZM;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZM.getPageContext().getPageActivity());
                                str2 = this.aZM.aTM;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
