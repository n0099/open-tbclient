package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aQL;
    private final /* synthetic */ String aQM;
    private final /* synthetic */ String aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MsgActivityView msgActivityView, String str, String str2) {
        this.aQL = msgActivityView;
        this.aQM = str;
        this.aQN = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aQL.getPageContext().getPageActivity(), this.aQM, this.aQN)));
    }
}
