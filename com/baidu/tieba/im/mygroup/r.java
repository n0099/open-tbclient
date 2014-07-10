package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonGroupActivity personGroupActivity) {
        this.a = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.c = com.baidu.tbadk.core.account.o.a(3) % 3;
        HttpMessage httpMessage = new HttpMessage(1001506);
        httpMessage.addParam("opt", "group");
        httpMessage.addParam("val", String.valueOf(this.a.c + 1));
        this.a.a(httpMessage);
    }
}
