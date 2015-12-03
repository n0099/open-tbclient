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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.v {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ug.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uh.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.bgy.c((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dyo.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ui.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uj.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uk.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.rC()) {
                            if (!bVar.rD()) {
                                return;
                            }
                            this.bgy.a(bVar);
                            return;
                        }
                        this.bgy.c(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.z)) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                    if (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0 || this.bgy.checkUpIsLogin()) {
                        if ((zVar.sY() != 1 && zVar.sY() != 2) || this.bgy.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.mF(zVar.getId())) {
                                readThreadHistory.mE(zVar.getId());
                            }
                            boolean z = false;
                            String sN = zVar.sN();
                            if (sN != null && !sN.equals("")) {
                                z = true;
                                new Thread(new g(this, sN)).start();
                            }
                            String tid = zVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                bf vD = bf.vD();
                                TbPageContext<?> pageContext = this.bgy.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                vD.b(pageContext, strArr);
                            } else if (zVar.getThreadType() == 33 || (zVar instanceof com.baidu.tbadk.core.data.t)) {
                                av avVar = new av(zVar.getThreadType() == 33 ? "c10245" : "c10180");
                                str = this.bgy.forumId;
                                TiebaStatic.log(avVar.ab(ImageViewerConfig.FORUM_ID, str));
                                this.bgy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bgy.getPageContext().getPageActivity(), zVar.getTid()).cn("from_frs").bv(18003).rw()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    zVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.bgy;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgy.getPageContext().getPageActivity());
                                str2 = this.bgy.aZi;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
