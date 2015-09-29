package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements View.OnClickListener {
    final /* synthetic */ dc aYa;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dc dcVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYa = dcVar;
        this.aYb = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.r rS = this.aYb.rS();
        if (com.baidu.adp.lib.util.i.iM()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aYa.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(rS.getUserId()), rS.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aYa.aRT.showToast(i.h.im_error_default);
    }
}
