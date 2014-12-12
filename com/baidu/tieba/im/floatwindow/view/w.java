package com.baidu.tieba.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ u aYG;
    private final /* synthetic */ CustomMessage alx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, CustomMessage customMessage) {
        this.aYG = uVar;
        this.alx = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((FloatingPersonalChatActivityConfig) this.alx.getData()).getIntent().setClass(((FloatingPersonalChatActivityConfig) this.alx.getData()).getContext(), FloatingPersonalChatActivity.class);
        if (((FloatingPersonalChatActivityConfig) this.alx.getData()).getUserData().getUserIdLong() != 0) {
            ((FloatingPersonalChatActivityConfig) this.alx.getData()).startActivity();
        }
    }
}
