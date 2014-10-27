package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ q aRe;
    private final /* synthetic */ CustomMessage aea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, CustomMessage customMessage) {
        this.aRe = qVar;
        this.aea = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.aea.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.aea.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.aea.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.aea.getData()).startActivity();
        }
    }
}
