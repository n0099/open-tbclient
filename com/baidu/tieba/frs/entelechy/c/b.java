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
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements cb {
    final /* synthetic */ a bTo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTo = aVar;
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        cb cbVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        cb cbVar2;
        cb cbVar3;
        com.baidu.tieba.frs.entelechy.c.a.a aVar3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        if (i > 100) {
            if (cjVar != null && (cjVar.bQr instanceof String)) {
                this.bTo.aI((String) cjVar.bQr, "c10079");
            }
        } else {
            as asVar = new as("c10074");
            asVar.s("obj_type", i);
            frsActivity = this.bTo.bTf;
            asVar.Z("fid", frsActivity.getForumId());
            TiebaStatic.log(asVar);
            if (i == 99) {
                as asVar2 = new as("c11500");
                asVar2.Z("obj_param1", "2").Z("obj_param2", "1");
                TiebaStatic.log(asVar2);
            }
        }
        if (HorizontalTabView.ix(i) && cjVar != null) {
            String str = (String) cjVar.bQr;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity8 = this.bTo.bTf;
                    k.showToast(frsActivity8.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                bb vQ = bb.vQ();
                frsActivity9 = this.bTo.bTf;
                vQ.c(frsActivity9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            frsActivity2 = this.bTo.bTf;
            if (frsActivity2 != null) {
                frsActivity3 = this.bTo.bTf;
                if (frsActivity3.getPageContext() != null) {
                    frsActivity4 = this.bTo.bTf;
                    if (frsActivity4.getPageContext().getPageActivity() != null) {
                        frsActivity5 = this.bTo.bTf;
                        frsActivity6 = this.bTo.bTf;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity6.getPageContext().getPageActivity());
                        frsActivity7 = this.bTo.bTf;
                        frsActivity5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity7.bME, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar3 = this.bTo.bTh;
                aVar3.abr();
            } else {
                aVar = this.bTo.bTh;
                aVar.abs();
            }
            cbVar = this.bTo.bTi;
            if (cbVar != null) {
                aVar2 = this.bTo.bTh;
                if (aVar2.abq() != 4 || i != 1) {
                    cbVar2 = this.bTo.bTi;
                    cbVar2.a(i, i2, cjVar);
                    return;
                }
                cbVar3 = this.bTo.bTi;
                cbVar3.a(2, i2, cjVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cb
    public void MQ() {
    }
}
