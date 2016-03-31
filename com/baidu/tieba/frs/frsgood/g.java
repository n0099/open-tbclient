package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RU.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.c)) {
                    return;
                }
                this.bsj.e((com.baidu.tbadk.core.data.c) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.eoi.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RV.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RW.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RX.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                        if (!cVar.rl()) {
                            if (!cVar.rm()) {
                                return;
                            }
                            this.bsj.b(cVar);
                            return;
                        }
                        this.bsj.e(cVar, i);
                    }
                } else if (uVar != null && (uVar instanceof as)) {
                    as asVar = (as) uVar;
                    if (asVar.getAnchorInfoData() == null || asVar.getAnchorInfoData().getGroup_id() == 0 || this.bsj.checkUpIsLogin()) {
                        if ((asVar.tI() != 1 && asVar.tI() != 2) || this.bsj.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.oh(asVar.getId())) {
                                readThreadHistory.og(asVar.getId());
                            }
                            boolean z = false;
                            String tt = asVar.tt();
                            if (tt != null && !tt.equals("")) {
                                z = true;
                                new Thread(new h(this, tt)).start();
                            }
                            String tid = asVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (asVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                bg wM = bg.wM();
                                TbPageContext<?> pageContext = this.bsj.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                wM.c(pageContext, strArr);
                            } else if (asVar.getThreadType() == 33 || (asVar instanceof com.baidu.tbadk.core.data.af)) {
                                aw awVar = new aw(asVar.getThreadType() == 33 ? "c10245" : "c10180");
                                str = this.bsj.forumId;
                                TiebaStatic.log(awVar.ac("fid", str));
                                this.bsj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bsj.getPageContext().getPageActivity(), asVar.getTid()).cl("from_frs").bC(18003).qT()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    asVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.bsj;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bsj.getPageContext().getPageActivity());
                                str2 = this.bsj.bkf;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(asVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
