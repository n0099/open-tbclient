package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonGroupActivity personGroupActivity) {
        this.bjc = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bjc.biQ = com.baidu.tbadk.core.account.o.bh(3) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "group");
        httpMessage.addParam("val", String.valueOf(this.bjc.biQ + 1));
        this.bjc.sendMessage(httpMessage);
    }
}
