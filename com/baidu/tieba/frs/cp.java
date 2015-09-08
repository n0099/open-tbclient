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
public class cp implements View.OnClickListener {
    final /* synthetic */ cn aYy;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cn cnVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYy = cnVar;
        this.aYz = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s rX = this.aYz.rX();
        if (com.baidu.adp.lib.util.i.iL()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aYy.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(rX.getUserId()), rX.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aYy.aSX.showToast(i.h.im_error_default);
    }
}
