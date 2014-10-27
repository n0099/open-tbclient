package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class dc implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ da aPK;
    private final /* synthetic */ CustomMessage aea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(da daVar, CustomMessage customMessage) {
        this.aPK = daVar;
        this.aea = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.aea.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.aea.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.aea.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.aea.getData()).startActivity();
        }
    }
}
