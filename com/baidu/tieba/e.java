package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class e implements j.a {
    final /* synthetic */ d aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aFk = dVar;
    }

    @Override // com.baidu.tieba.j.a
    public void GJ() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aFk.aFj;
            logoActivity5 = this.aFk.aFj;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            logoActivity = this.aFk.aFj;
            logoActivity2 = this.aFk.aFj;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.h.k.hk().c(new f(this));
        logoActivity3 = this.aFk.aFj;
        logoActivity3.finish();
    }
}
