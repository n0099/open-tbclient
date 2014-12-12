package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class ca implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ by aRG;
    private final /* synthetic */ CustomMessage alx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(by byVar, CustomMessage customMessage) {
        this.aRG = byVar;
        this.alx = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.alx.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.alx.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.alx.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.alx.getData()).startActivity();
        }
    }
}
