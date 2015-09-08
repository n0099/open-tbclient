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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ud.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.c)) {
                    return;
                }
                this.aZI.c((com.baidu.tbadk.core.data.c) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.cQk.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ue.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ug.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                        com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                        if (!cVar.rv()) {
                            if (!cVar.rw()) {
                                return;
                            }
                            this.aZI.a(cVar);
                            return;
                        }
                        this.aZI.c(cVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.x)) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) uVar;
                    if (xVar.getAnchorInfoData() == null || xVar.getAnchorInfoData().getGroup_id() == 0 || this.aZI.checkUpIsLogin()) {
                        if ((xVar.sC() != 1 && xVar.sC() != 2) || this.aZI.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.lj(xVar.getId())) {
                                readThreadHistory.li(xVar.getId());
                            }
                            boolean z = false;
                            String sq = xVar.sq();
                            if (sq != null && !sq.equals("")) {
                                z = true;
                                new Thread(new g(this, sq)).start();
                            }
                            String tid = xVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (xVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                ax uX = ax.uX();
                                TbPageContext<?> pageContext = this.aZI.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                uX.b(pageContext, strArr);
                            } else if (xVar.sv() == 33 || (xVar instanceof com.baidu.tbadk.core.data.q)) {
                                ao aoVar = new ao(xVar.sv() == 33 ? "c10245" : "c10180");
                                str = this.aZI.forumId;
                                TiebaStatic.log(aoVar.af(ImageViewerConfig.FORUM_ID, str));
                                this.aZI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.aZI.getPageContext().getPageActivity(), xVar.getTid()).ch("from_frs").bs(18003).ro()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    xVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.aZI;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZI.getPageContext().getPageActivity());
                                str2 = this.aZI.aUF;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(xVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
