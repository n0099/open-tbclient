package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonGroupActivity personGroupActivity) {
        this.bfQ = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bfQ.bfD = com.baidu.tbadk.core.account.o.aL(3) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "group");
        httpMessage.addParam("val", String.valueOf(this.bfQ.bfD + 1));
        this.bfQ.sendMessage(httpMessage);
    }
}
