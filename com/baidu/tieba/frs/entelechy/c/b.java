package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.r;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements cd {
    final /* synthetic */ a bFR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bFR = aVar;
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
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        cd cdVar2;
        cd cdVar3;
        com.baidu.tieba.frs.entelechy.c.a.a aVar3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        URI uri;
        if (i > 100) {
            if (clVar != null && (clVar.bBQ instanceof String)) {
                try {
                    uri = new URI((String) clVar.bBQ);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    at atVar = new at("c10079");
                    atVar.ab("obj_type", host);
                    TiebaStatic.log(atVar);
                }
            }
        } else {
            at atVar2 = new at("c10074");
            atVar2.s("obj_type", i);
            frsActivity = this.bFR.bFI;
            atVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(atVar2);
            if (i == 99) {
                at atVar3 = new at("c11500");
                atVar3.ab("obj_param1", "2").ab("obj_param2", "1");
                TiebaStatic.log(atVar3);
            }
        }
        if (HorizontalTabView.hO(i) && clVar != null) {
            String str = (String) clVar.bBQ;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity8 = this.bFR.bFI;
                    k.showToast(frsActivity8.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                    return;
                }
                bc vz = bc.vz();
                frsActivity9 = this.bFR.bFI;
                vz.c(frsActivity9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            frsActivity2 = this.bFR.bFI;
            if (frsActivity2 != null) {
                frsActivity3 = this.bFR.bFI;
                if (frsActivity3.getPageContext() != null) {
                    frsActivity4 = this.bFR.bFI;
                    if (frsActivity4.getPageContext().getPageActivity() != null) {
                        frsActivity5 = this.bFR.bFI;
                        frsActivity6 = this.bFR.bFI;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity6.getPageContext().getPageActivity());
                        frsActivity7 = this.bFR.bFI;
                        frsActivity5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity7.bxY, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar3 = this.bFR.bFK;
                aVar3.Zr();
            } else {
                aVar = this.bFR.bFK;
                aVar.Zs();
            }
            cdVar = this.bFR.bFL;
            if (cdVar != null) {
                aVar2 = this.bFR.bFK;
                if (aVar2.Zq() != 4 || i != 1) {
                    cdVar2 = this.bFR.bFL;
                    cdVar2.a(i, i2, clVar);
                    return;
                }
                cdVar3 = this.bFR.bFL;
                cdVar3.a(2, i2, clVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void VI() {
    }
}
