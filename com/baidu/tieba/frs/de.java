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
    final /* synthetic */ dc aYu;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dc dcVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYu = dcVar;
        this.aYv = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s rR = this.aYv.rR();
        if (com.baidu.adp.lib.util.i.iN()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aYu.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(rR.getUserId()), rR.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aYu.aSm.showToast(i.h.im_error_default);
    }
}
