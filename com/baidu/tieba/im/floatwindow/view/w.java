package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage amo;
    final /* synthetic */ u bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, CustomMessage customMessage) {
        this.bab = uVar;
        this.amo = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.amo.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.amo.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.amo.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.amo.getData()).startActivity();
        }
    }
}
