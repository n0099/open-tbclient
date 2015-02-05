package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ q aUn;
    private final /* synthetic */ CustomMessage amo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, CustomMessage customMessage) {
        this.aUn = qVar;
        this.amo = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.amo.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.amo.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.amo.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.amo.getData()).startActivity();
        }
    }
}
