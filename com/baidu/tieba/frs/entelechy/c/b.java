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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements bz {
    final /* synthetic */ a chn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.chn = aVar;
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(ca caVar) {
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, cf cfVar) {
        r rVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        bz bzVar;
        bz bzVar2;
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
            au auVar = new au("c12103");
            rVar10 = this.chn.cbE;
            TiebaStatic.log(auVar.Z("fid", rVar10.getForumId()));
        }
        if (i > 100) {
            if (cfVar != null && (cfVar.cfg instanceof String)) {
                this.chn.aQ((String) cfVar.cfg, "c10079");
            }
        } else {
            au auVar2 = new au("c10074");
            auVar2.r("obj_type", i);
            rVar = this.chn.cbE;
            auVar2.Z("fid", rVar.getForumId());
            TiebaStatic.log(auVar2);
            if (i == 99) {
                au auVar3 = new au("c11500");
                auVar3.Z("obj_param1", "2").Z("obj_param2", "1");
                TiebaStatic.log(auVar3);
            }
        }
        if (HorizontalTabView.jg(i) && cfVar != null) {
            String str = (String) cfVar.cfg;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    rVar8 = this.chn.cbE;
                    k.showToast(rVar8.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                be vP = be.vP();
                rVar9 = this.chn.cbE;
                vP.c(rVar9.getPageContext(), new String[]{str});
            }
        } else if (i == 301) {
            rVar2 = this.chn.cbE;
            if (rVar2 != null) {
                rVar3 = this.chn.cbE;
                if (rVar3.getPageContext() != null) {
                    rVar4 = this.chn.cbE;
                    if (rVar4.getPageContext().getPageActivity() != null) {
                        rVar5 = this.chn.cbE;
                        rVar6 = this.chn.cbE;
                        FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(rVar6.getPageContext().getPageActivity());
                        rVar7 = this.chn.cbE;
                        rVar5.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(rVar7.ccb, FrsActivityConfig.FRS_FROM_LIKE)));
                    }
                }
            }
        } else {
            if (i == 1) {
                aVar2 = this.chn.chg;
                aVar2.afR();
            } else {
                aVar = this.chn.chg;
                aVar.afS();
            }
            bzVar = this.chn.chh;
            if (bzVar != null) {
                bzVar2 = this.chn.chh;
                bzVar2.a(i, i2, cfVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.bz
    public void init() {
    }

    @Override // com.baidu.tieba.frs.bz
    public void Og() {
    }
}
