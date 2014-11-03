package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ q aRs;
    private final /* synthetic */ CustomMessage aei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, CustomMessage customMessage) {
        this.aRs = qVar;
        this.aei = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.aei.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.aei.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.aei.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.aei.getData()).startActivity();
        }
    }
}
