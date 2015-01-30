package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ CustomMessage amr;
    final /* synthetic */ u bac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, CustomMessage customMessage) {
        this.bac = uVar;
        this.amr = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.amr.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.amr.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.amr.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.amr.getData()).startActivity();
        }
    }
}
