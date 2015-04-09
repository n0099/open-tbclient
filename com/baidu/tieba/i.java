package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
/* loaded from: classes.dex */
class i implements d {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // com.baidu.tieba.d
    public void C(Object obj) {
        if (obj != null) {
            this.atK.ek(com.baidu.adp.lib.g.c.toInt(String.valueOf(obj), 0));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.atK.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
        this.atK.finish();
    }
}
