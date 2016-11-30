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
public class bl implements View.OnClickListener {
    final /* synthetic */ bj bUR;
    private final /* synthetic */ com.baidu.tbadk.core.data.az bUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar, com.baidu.tbadk.core.data.az azVar) {
        this.bUR = bjVar;
        this.bUS = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.bb qR = this.bUS.qR();
        if (com.baidu.adp.lib.util.i.gm()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bUR.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(qR.getUserId()), qR.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bUR.aTb.showToast(r.j.im_error_default);
    }
}
