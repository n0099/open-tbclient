package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ y aYX;
    private final /* synthetic */ CustomMessage aYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, CustomMessage customMessage) {
        this.aYX = yVar;
        this.aYZ = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r5) {
        ((OfficalBarChatActivityConfig) this.aYZ.getData()).getIntent().setClass(((OfficalBarChatActivityConfig) this.aYZ.getData()).getContext(), OfficialBarChatActivity.class);
        if (((OfficalBarChatActivityConfig) this.aYZ.getData()).getUserData().getUserIdLong() != 0) {
            ((OfficalBarChatActivityConfig) this.aYZ.getData()).startActivity();
        }
    }
}
