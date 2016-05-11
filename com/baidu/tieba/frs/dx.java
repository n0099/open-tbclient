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
public class dx implements View.OnClickListener {
    final /* synthetic */ dv blu;
    private final /* synthetic */ com.baidu.tbadk.core.data.am blv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dv dvVar, com.baidu.tbadk.core.data.am amVar) {
        this.blu = dvVar;
        this.blv = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ao pX = this.blv.pX();
        if (com.baidu.adp.lib.util.i.fq()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.blu.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(pX.getUserId()), pX.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.blu.bek.showToast(t.j.im_error_default);
    }
}
