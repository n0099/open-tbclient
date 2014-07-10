package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ u a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, CustomMessage customMessage) {
        this.a = uVar;
        this.b = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r5) {
        ((com.baidu.tbadk.core.atomData.av) this.b.getData()).getIntent().setClass(((com.baidu.tbadk.core.atomData.av) this.b.getData()).getContext(), OfficialBarChatActivity.class);
        if (((com.baidu.tbadk.core.atomData.av) this.b.getData()).a().getUserIdLong() != 0) {
            ((com.baidu.tbadk.core.atomData.av) this.b.getData()).startActivity();
        }
    }
}
