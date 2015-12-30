package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class e implements j.a {
    final /* synthetic */ d aGK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aGK = dVar;
    }

    @Override // com.baidu.tieba.j.a
    public void Gy() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            logoActivity4 = this.aGK.aGJ;
            logoActivity5 = this.aGK.aGJ;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            logoActivity = this.aGK.aGJ;
            logoActivity2 = this.aGK.aGJ;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.h.k.hk().c(new f(this));
        logoActivity3 = this.aGK.aGJ;
        logoActivity3.finish();
    }
}
