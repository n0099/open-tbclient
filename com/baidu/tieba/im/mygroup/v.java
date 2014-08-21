package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonGroupActivity personGroupActivity) {
        this.a = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d = com.baidu.tbadk.core.account.o.a(3) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "group");
        httpMessage.addParam("val", String.valueOf(this.a.d + 1));
        this.a.a(httpMessage);
    }
}
