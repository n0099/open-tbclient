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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements cb {
    final /* synthetic */ a bMi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bMi = aVar;
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
            if (cjVar != null && (cjVar.bJi instanceof String)) {
                this.bMi.aK((String) cjVar.bJi, "c10079");
            }
        } else {
            ar arVar = new ar("c10074");
            arVar.s("obj_type", i);
            frsActivity = this.bMi.bLZ;
            arVar.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(arVar);
            if (i == 99) {
                ar arVar2 = new ar("c11500");
                arVar2.ab("obj_param1", "2").ab("obj_param2", "1");
                TiebaStatic.log(arVar2);
            }
        }
        if (HorizontalTabView.iB(i) && cjVar != null) {
            String str = (String) cjVar.bJi;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity8 = this.bMi.bLZ;
                    k.showToast(frsActivity8.getPageContext().getPageActivity(), r.l.book_plugin_not_install_tip);
                    return;
                }
                ba vt = ba.vt();
                frsActivity9 = this.bMi.bLZ;
                vt.c(frsActivity9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            frsActivity2 = this.bMi.bLZ;
            if (frsActivity2 != null) {
                frsActivity3 = this.bMi.bLZ;
                if (frsActivity3.getPageContext() != null) {
                    frsActivity4 = this.bMi.bLZ;
                    if (frsActivity4.getPageContext().getPageActivity() != null) {
                        frsActivity5 = this.bMi.bLZ;
                        frsActivity6 = this.bMi.bLZ;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity6.getPageContext().getPageActivity());
                        frsActivity7 = this.bMi.bLZ;
                        frsActivity5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity7.bFw, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar3 = this.bMi.bMb;
                aVar3.aau();
            } else {
                aVar = this.bMi.bMb;
                aVar.aav();
            }
            cbVar = this.bMi.bMc;
            if (cbVar != null) {
                aVar2 = this.bMi.bMb;
                if (aVar2.aat() != 4 || i != 1) {
                    cbVar2 = this.bMi.bMc;
                    cbVar2.a(i, i2, cjVar);
                    return;
                }
                cbVar3 = this.bMi.bMc;
                cbVar3.a(2, i2, cjVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cb
    public void Me() {
    }
}
