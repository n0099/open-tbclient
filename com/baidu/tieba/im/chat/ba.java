package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aXe;
    private final /* synthetic */ String aXf;
    private final /* synthetic */ String aXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MsgActivityView msgActivityView, String str, String str2) {
        this.aXe = msgActivityView;
        this.aXf = str;
        this.aXg = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aXe.getPageContext().getPageActivity(), this.aXf, this.aXg)));
    }
}
