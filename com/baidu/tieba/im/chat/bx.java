package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class bx implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aOM;
    private final /* synthetic */ String aON;
    private final /* synthetic */ String aOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgActivityView msgActivityView, String str, String str2) {
        this.aOM = msgActivityView;
        this.aON = str;
        this.aOO = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aOM.getContext(), this.aON, this.aOO)));
    }
}
