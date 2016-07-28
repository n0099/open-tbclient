package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ ch bHD;
    private final /* synthetic */ com.baidu.tbadk.core.data.at bHE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar, com.baidu.tbadk.core.data.at atVar) {
        this.bHD = chVar;
        this.bHE = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.av pA = this.bHE.pA();
        if (com.baidu.adp.lib.util.i.fq()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bHD.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(pA.getUserId()), pA.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bHD.bem.showToast(u.j.im_error_default);
    }
}
