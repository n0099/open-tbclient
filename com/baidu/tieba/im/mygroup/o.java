package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;
    private final /* synthetic */ int d;
    private final /* synthetic */ a e;
    private final /* synthetic */ ShareFromGameCenterMsgData f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonGroupActivity personGroupActivity, int i, String str, int i2, a aVar, ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.a = personGroupActivity;
        this.b = i;
        this.c = str;
        this.d = i2;
        this.e = aVar;
        this.f = shareFromGameCenterMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.y(this.a, this.b, this.c, this.d, "from_share", this.e.getLeaveMsg(), this.f.toChatMessageContent())));
        aVar.d();
        this.a.setResult(-1);
        this.a.finish();
    }
}
