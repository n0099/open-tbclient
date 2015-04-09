package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ y aZn;
    private final /* synthetic */ CustomMessage aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, CustomMessage customMessage) {
        this.aZn = yVar;
        this.aZp = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.aZp.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.aZp.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.aZp.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.aZp.getData()).startActivity();
        }
    }
}
