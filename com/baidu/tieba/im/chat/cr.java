package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cr implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ cp a;
    private final /* synthetic */ CustomMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cp cpVar, CustomMessage customMessage) {
        this.a = cpVar;
        this.b = customMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        ((com.baidu.tbadk.core.atomData.at) this.b.getData()).getIntent().setClass(((com.baidu.tbadk.core.atomData.at) this.b.getData()).getContext(), PersonalChatActivity.class);
        UserData a = ((com.baidu.tbadk.core.atomData.at) this.b.getData()).a();
        if (a.getUserIdLong() == 0) {
            BdLog.d("userid = " + a.getUserId());
        } else {
            ((com.baidu.tbadk.core.atomData.at) this.b.getData()).startActivity();
        }
    }
}
