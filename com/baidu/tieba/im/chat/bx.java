package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class bx implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aPa;
    private final /* synthetic */ String aPb;
    private final /* synthetic */ String aPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgActivityView msgActivityView, String str, String str2) {
        this.aPa = msgActivityView;
        this.aPb = str;
        this.aPc = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aPa.getContext(), this.aPb, this.aPc)));
    }
}
