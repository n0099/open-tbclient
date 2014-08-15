package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class cv implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ct a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ct ctVar, CustomMessage customMessage) {
        this.a = ctVar;
        this.b = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r5) {
        ((com.baidu.tbadk.core.atomData.bj) this.b.getData()).getIntent().setClass(((com.baidu.tbadk.core.atomData.bj) this.b.getData()).getContext(), PersonalChatActivity.class);
        if (((com.baidu.tbadk.core.atomData.bj) this.b.getData()).a().getUserIdLong() != 0) {
            ((com.baidu.tbadk.core.atomData.bj) this.b.getData()).startActivity();
        }
    }
}
