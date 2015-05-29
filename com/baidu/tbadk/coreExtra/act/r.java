package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.atomData.VoiceCheckActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements SapiWebView.VoiceLoginHandler {
    final /* synthetic */ LoginActivity abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LoginActivity loginActivity) {
        this.abx = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.VoiceLoginHandler
    public void handleVoiceLogin() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoiceCheckActivityConfig(this.abx.getPageContext().getPageActivity())));
    }
}
