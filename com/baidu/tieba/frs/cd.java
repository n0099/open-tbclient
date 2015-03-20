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
public class cd implements View.OnClickListener {
    final /* synthetic */ cb aMt;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar, com.baidu.tbadk.core.data.s sVar) {
        this.aMt = cbVar;
        this.aMu = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.t qq = this.aMu.qq();
        if (UtilHelper.isNetOk()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aMt.mContext;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, String.valueOf(qq.getUserId()), qq.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.aMt.aJT.showToast(com.baidu.tieba.y.im_error_default);
    }
}
