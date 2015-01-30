package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aRU;
    private final /* synthetic */ String aRV;
    private final /* synthetic */ String aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(MsgActivityView msgActivityView, String str, String str2) {
        this.aRU = msgActivityView;
        this.aRV = str;
        this.aRW = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aRU.getPageContext().getPageActivity(), this.aRV, this.aRW)));
    }
}
