package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
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
    public void a(Void r6) {
        ((com.baidu.tbadk.core.atomData.aq) this.b.getData()).getIntent().setClass(((com.baidu.tbadk.core.atomData.aq) this.b.getData()).getContext(), OfficialBarChatActivity.class);
        UserData a = ((com.baidu.tbadk.core.atomData.aq) this.b.getData()).a();
        if (a.getUserIdLong() == 0) {
            BdLog.d("userid = " + a.getUserId());
        } else {
            ((com.baidu.tbadk.core.atomData.aq) this.b.getData()).startActivity();
        }
    }
}
