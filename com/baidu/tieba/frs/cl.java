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
public class cl implements View.OnClickListener {
    final /* synthetic */ cj aYj;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj cjVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYj = cjVar;
        this.aYk = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.r rZ = this.aYk.rZ();
        if (com.baidu.adp.lib.util.i.iO()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aYj.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(rZ.getUserId()), rZ.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aYj.aSJ.showToast(i.C0057i.im_error_default);
    }
}
