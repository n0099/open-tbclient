package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
class i implements d {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void C(Object obj) {
        if (obj != null) {
            this.atC.ek(com.baidu.adp.lib.g.c.toInt(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.atC.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
        this.atC.finish();
    }
}
