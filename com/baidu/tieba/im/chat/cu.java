package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class cu implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ cs a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cs csVar, CustomMessage customMessage) {
        this.a = csVar;
        this.b = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r5) {
        ((com.baidu.tbadk.core.atomData.bc) this.b.getData()).getIntent().setClass(((com.baidu.tbadk.core.atomData.bc) this.b.getData()).getContext(), PersonalChatActivity.class);
        if (((com.baidu.tbadk.core.atomData.bc) this.b.getData()).a().getUserIdLong() != 0) {
            ((com.baidu.tbadk.core.atomData.bc) this.b.getData()).startActivity();
        }
    }
}
