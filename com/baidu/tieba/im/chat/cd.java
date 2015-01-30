package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class cd implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ cb aSP;
    private final /* synthetic */ CustomMessage amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar, CustomMessage customMessage) {
        this.aSP = cbVar;
        this.amr = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.amr.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.amr.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.amr.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.amr.getData()).startActivity();
        }
    }
}
