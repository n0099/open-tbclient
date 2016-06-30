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
    final /* synthetic */ ch bGh;
    private final /* synthetic */ com.baidu.tbadk.core.data.ao bGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar, com.baidu.tbadk.core.data.ao aoVar) {
        this.bGh = chVar;
        this.bGi = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.aq pR = this.bGi.pR();
        if (com.baidu.adp.lib.util.i.fr()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bGh.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(pR.getUserId()), pR.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bGh.bkc.showToast(u.j.im_error_default);
    }
}
