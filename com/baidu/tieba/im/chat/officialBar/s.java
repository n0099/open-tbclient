package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ q aUo;
    private final /* synthetic */ CustomMessage amr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, CustomMessage customMessage) {
        this.aUo = qVar;
        this.amr = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.amr.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.amr.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.amr.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.amr.getData()).startActivity();
        }
    }
}
