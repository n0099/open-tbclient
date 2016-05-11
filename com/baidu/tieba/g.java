package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class g implements p.a {
    final /* synthetic */ f aGS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aGS = fVar;
    }

    @Override // com.baidu.tieba.p.a
    public void HM() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aGS.aGQ;
            logoActivity2 = this.aGS.aGQ;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aGS.aGQ;
            logoActivity5 = this.aGS.aGQ;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        com.baidu.adp.lib.h.k.dM().c(new h(this));
        logoActivity3 = this.aGS.aGQ;
        logoActivity3.finish();
    }
}
