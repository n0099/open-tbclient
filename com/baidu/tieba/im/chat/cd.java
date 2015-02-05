package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class cd implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ cb aSO;
    private final /* synthetic */ CustomMessage amo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar, CustomMessage customMessage) {
        this.aSO = cbVar;
        this.amo = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.amo.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.amo.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.amo.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.amo.getData()).startActivity();
        }
    }
}
