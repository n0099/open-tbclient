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
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        String str2;
        if (bdUniqueId != null) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UF.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UH.getId()) {
                if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                    return;
                }
                this.bkp.b((com.baidu.tbadk.core.data.b) uVar, i);
            } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dFI.getId()) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UI.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UJ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UK.getId()) {
                    if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                        com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                        if (!bVar.rl()) {
                            if (!bVar.rm()) {
                                return;
                            }
                            this.bkp.b(bVar);
                            return;
                        }
                        this.bkp.b(bVar, i);
                    }
                } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.z)) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                    if (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0 || this.bkp.checkUpIsLogin()) {
                        if ((zVar.sI() != 1 && zVar.sI() != 2) || this.bkp.checkUpIsLogin()) {
                            com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.mC(zVar.getId())) {
                                readThreadHistory.mB(zVar.getId());
                            }
                            boolean z = false;
                            String sx = zVar.sx();
                            if (sx != null && !sx.equals("")) {
                                z = true;
                                new Thread(new g(this, sx)).start();
                            }
                            String tid = zVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                bf vn = bf.vn();
                                TbPageContext<?> pageContext = this.bkp.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                vn.b(pageContext, strArr);
                            } else if (zVar.getThreadType() == 33 || (zVar instanceof com.baidu.tbadk.core.data.t)) {
                                av avVar = new av(zVar.getThreadType() == 33 ? "c10245" : "c10180");
                                str = this.bkp.forumId;
                                TiebaStatic.log(avVar.aa(ImageViewerConfig.FORUM_ID, str));
                                this.bkp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bkp.getPageContext().getPageActivity(), zVar.getTid()).cp("from_frs").bo(18003).rf()));
                            } else {
                                if (tid.startsWith("pb:")) {
                                    zVar.setId(tid.substring(3));
                                }
                                FrsGoodActivity frsGoodActivity = this.bkp;
                                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkp.getPageContext().getPageActivity());
                                str2 = this.bkp.bde;
                                frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str2, null, 18003, true, false, z)));
                            }
                        }
                    }
                }
            }
        }
    }
}
