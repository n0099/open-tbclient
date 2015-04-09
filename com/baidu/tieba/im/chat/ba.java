package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aXu;
    private final /* synthetic */ String aXv;
    private final /* synthetic */ String aXw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MsgActivityView msgActivityView, String str, String str2) {
        this.aXu = msgActivityView;
        this.aXv = str;
        this.aXw = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aXu.getPageContext().getPageActivity(), this.aXv, this.aXw)));
    }
}
