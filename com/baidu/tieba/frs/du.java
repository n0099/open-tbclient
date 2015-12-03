package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du implements View.OnClickListener {
    final /* synthetic */ ds ber;
    private final /* synthetic */ com.baidu.tbadk.core.data.u bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(ds dsVar, com.baidu.tbadk.core.data.u uVar) {
        this.ber = dsVar;
        this.bes = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.v so = this.bes.so();
        if (com.baidu.adp.lib.util.i.iP()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.ber.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(so.getUserId()), so.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.ber.aXA.showToast(n.i.im_error_default);
    }
}
