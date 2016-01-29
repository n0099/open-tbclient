package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class g implements p.a {
    final /* synthetic */ f aHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aHL = fVar;
    }

    @Override // com.baidu.tieba.p.a
    public void HZ() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aHL.aHJ;
            logoActivity5 = this.aHL.aHJ;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
        } else {
            logoActivity = this.aHL.aHJ;
            logoActivity2 = this.aHL.aHJ;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.h.k.hs().c(new h(this));
        logoActivity3 = this.aHL.aHJ;
        logoActivity3.finish();
    }
}
