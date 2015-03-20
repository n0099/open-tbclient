package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonGroupActivity personGroupActivity) {
        this.bln = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bln.blb = com.baidu.tbadk.core.a.j.bl(3) % 3;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "group");
        httpMessage.addParam("val", String.valueOf(this.bln.blb + 1));
        this.bln.sendMessage(httpMessage);
    }
}
