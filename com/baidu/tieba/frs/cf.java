package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ cd bSJ;
    private final /* synthetic */ com.baidu.tbadk.core.data.av bSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cd cdVar, com.baidu.tbadk.core.data.av avVar) {
        this.bSJ = cdVar;
        this.bSK = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ax qE = this.bSK.qE();
        if (com.baidu.adp.lib.util.i.gm()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bSJ.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(qE.getUserId()), qE.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bSJ.aPR.showToast(t.j.im_error_default);
    }
}
