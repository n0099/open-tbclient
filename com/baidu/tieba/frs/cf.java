package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ cd bSC;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cd cdVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bSC = cdVar;
        this.bSD = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.az qP = this.bSD.qP();
        if (com.baidu.adp.lib.util.i.gm()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bSC.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(qP.getUserId()), qP.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bSC.aRd.showToast(r.j.im_error_default);
    }
}
