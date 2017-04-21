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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements cd {
    final /* synthetic */ a bVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bVt = aVar;
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        cd cdVar;
        cd cdVar2;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        if (i > 100) {
            if (clVar != null && (clVar.bSx instanceof String)) {
                this.bVt.aL((String) clVar.bSx, "c10079");
            }
        } else {
            as asVar = new as("c10074");
            asVar.s("obj_type", i);
            frsActivity = this.bVt.bVk;
            asVar.aa("fid", frsActivity.getForumId());
            TiebaStatic.log(asVar);
            if (i == 99) {
                as asVar2 = new as("c11500");
                asVar2.aa("obj_param1", "2").aa("obj_param2", "1");
                TiebaStatic.log(asVar2);
            }
        }
        if (HorizontalTabView.iE(i) && clVar != null) {
            String str = (String) clVar.bSx;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity8 = this.bVt.bVk;
                    k.showToast(frsActivity8.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                bb wn = bb.wn();
                frsActivity9 = this.bVt.bVk;
                wn.c(frsActivity9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            frsActivity2 = this.bVt.bVk;
            if (frsActivity2 != null) {
                frsActivity3 = this.bVt.bVk;
                if (frsActivity3.getPageContext() != null) {
                    frsActivity4 = this.bVt.bVk;
                    if (frsActivity4.getPageContext().getPageActivity() != null) {
                        frsActivity5 = this.bVt.bVk;
                        frsActivity6 = this.bVt.bVk;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity6.getPageContext().getPageActivity());
                        frsActivity7 = this.bVt.bVk;
                        frsActivity5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity7.bOL, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar2 = this.bVt.bVm;
                aVar2.acO();
            } else {
                aVar = this.bVt.bVm;
                aVar.acP();
            }
            cdVar = this.bVt.bVn;
            if (cdVar != null) {
                cdVar2 = this.bVt.bVn;
                cdVar2.a(i, i2, clVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void Nx() {
    }
}
