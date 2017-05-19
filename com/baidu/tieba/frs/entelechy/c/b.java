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
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements bx {
    final /* synthetic */ a bTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTm = aVar;
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(by byVar) {
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(int i, int i2, cd cdVar) {
        r rVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        bx bxVar;
        bx bxVar2;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        r rVar9;
        if (i > 100) {
            if (cdVar != null && (cdVar.bRh instanceof String)) {
                this.bTm.aL((String) cdVar.bRh, "c10079");
            }
        } else {
            as asVar = new as("c10074");
            asVar.s("obj_type", i);
            rVar = this.bTm.bNK;
            asVar.aa("fid", rVar.getForumId());
            TiebaStatic.log(asVar);
            if (i == 99) {
                as asVar2 = new as("c11500");
                asVar2.aa("obj_param1", "2").aa("obj_param2", "1");
                TiebaStatic.log(asVar2);
            }
        }
        if (HorizontalTabView.iw(i) && cdVar != null) {
            String str = (String) cdVar.bRh;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    rVar8 = this.bTm.bNK;
                    k.showToast(rVar8.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                bb vB = bb.vB();
                rVar9 = this.bTm.bNK;
                vB.c(rVar9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            rVar2 = this.bTm.bNK;
            if (rVar2 != null) {
                rVar3 = this.bTm.bNK;
                if (rVar3.getPageContext() != null) {
                    rVar4 = this.bTm.bNK;
                    if (rVar4.getPageContext().getPageActivity() != null) {
                        rVar5 = this.bTm.bNK;
                        rVar6 = this.bTm.bNK;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(rVar6.getPageContext().getPageActivity());
                        rVar7 = this.bTm.bNK;
                        rVar5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(rVar7.bOf, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar2 = this.bTm.bTf;
                aVar2.aaV();
            } else {
                aVar = this.bTm.bTf;
                aVar.aaW();
            }
            bxVar = this.bTm.bTg;
            if (bxVar != null) {
                bxVar2 = this.bTm.bTg;
                bxVar2.a(i, i2, cdVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void init() {
    }

    @Override // com.baidu.tieba.frs.bx
    public void ML() {
    }
}
