package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements by {
    final /* synthetic */ a bZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bZe = aVar;
    }

    @Override // com.baidu.tieba.frs.by
    public void a(bz bzVar) {
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i, int i2, ce ceVar) {
        r rVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        by byVar;
        by byVar2;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        r rVar9;
        r rVar10;
        if (i == 101) {
            as asVar = new as("c12103");
            rVar10 = this.bZe.bTw;
            TiebaStatic.log(asVar.Z("fid", rVar10.getForumId()));
        }
        if (i > 100) {
            if (ceVar != null && (ceVar.bWX instanceof String)) {
                this.bZe.aJ((String) ceVar.bWX, "c10079");
            }
        } else {
            as asVar2 = new as("c10074");
            asVar2.r("obj_type", i);
            rVar = this.bZe.bTw;
            asVar2.Z("fid", rVar.getForumId());
            TiebaStatic.log(asVar2);
            if (i == 99) {
                as asVar3 = new as("c11500");
                asVar3.Z("obj_param1", "2").Z("obj_param2", "1");
                TiebaStatic.log(asVar3);
            }
        }
        if (HorizontalTabView.iU(i) && ceVar != null) {
            String str = (String) ceVar.bWX;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    rVar8 = this.bZe.bTw;
                    k.showToast(rVar8.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                bb vy = bb.vy();
                rVar9 = this.bZe.bTw;
                vy.c(rVar9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            rVar2 = this.bZe.bTw;
            if (rVar2 != null) {
                rVar3 = this.bZe.bTw;
                if (rVar3.getPageContext() != null) {
                    rVar4 = this.bZe.bTw;
                    if (rVar4.getPageContext().getPageActivity() != null) {
                        rVar5 = this.bZe.bTw;
                        rVar6 = this.bZe.bTw;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(rVar6.getPageContext().getPageActivity());
                        rVar7 = this.bZe.bTw;
                        rVar5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(rVar7.bTS, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar2 = this.bZe.bYX;
                aVar2.abZ();
            } else {
                aVar = this.bZe.bYX;
                aVar.aca();
            }
            byVar = this.bZe.bYY;
            if (byVar != null) {
                byVar2 = this.bZe.bYY;
                byVar2.a(i, i2, ceVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void init() {
    }

    @Override // com.baidu.tieba.frs.by
    public void MT() {
    }
}
