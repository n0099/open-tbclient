package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class h implements q.a {
    final /* synthetic */ g aIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aIl = gVar;
    }

    @Override // com.baidu.tieba.q.a
    public void onCompleted() {
        LogoActivity logoActivity;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        LogoActivity logoActivity4;
        LogoActivity logoActivity5;
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            logoActivity = this.aIl.aIj;
            logoActivity2 = this.aIl.aIj;
            logoActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(logoActivity2.getPageContext().getPageActivity()).createNormalCfg(1)));
        } else {
            boolean z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("has_shown_app_guide", false);
            logoActivity4 = this.aIl.aIj;
            logoActivity5 = this.aIl.aIj;
            logoActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(logoActivity5.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, z ? 1 : 3)));
        }
        com.baidu.adp.lib.h.k.dM().f(new i(this));
        logoActivity3 = this.aIl.aIj;
        logoActivity3.finish();
    }
}
