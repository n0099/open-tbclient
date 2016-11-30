package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e implements n.a {
    final /* synthetic */ d aLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aLN = dVar;
    }

    @Override // com.baidu.tieba.n.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aLN.aLM;
            logoActivity2 = this.aLN.aLM;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aLN.aLM;
            logoActivity5 = this.aLN.aLM;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        com.baidu.adp.lib.h.k.eH().f(new f(this));
        logoActivity3 = this.aLN.aLM;
        logoActivity3.finish();
    }
}
