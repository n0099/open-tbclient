package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class dc implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ da aPY;
    private final /* synthetic */ CustomMessage aei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(da daVar, CustomMessage customMessage) {
        this.aPY = daVar;
        this.aei = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r5) {
        ((PersonalChatActivityConfig) this.aei.getData()).getIntent().setClass(((PersonalChatActivityConfig) this.aei.getData()).getContext(), PersonalChatActivity.class);
        if (((PersonalChatActivityConfig) this.aei.getData()).getUserData().getUserIdLong() != 0) {
            ((PersonalChatActivityConfig) this.aei.getData()).startActivity();
        }
    }
}
