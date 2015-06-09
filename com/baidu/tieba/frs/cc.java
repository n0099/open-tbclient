package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ ca aOP;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar, com.baidu.tbadk.core.data.s sVar) {
        this.aOP = caVar;
        this.aOQ = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.t qW = this.aOQ.qW();
        if (UtilHelper.isNetOk()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aOP.mContext;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, String.valueOf(qW.getUserId()), qW.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aOP.aMl.showToast(com.baidu.tieba.t.im_error_default);
    }
}
