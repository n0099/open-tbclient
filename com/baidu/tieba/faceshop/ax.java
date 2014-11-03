package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ aw aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.aup = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aup.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(context, "faceshop_from_more")));
        context2 = this.aup.mContext;
        ((BaseActivity) context2).finish();
    }
}
