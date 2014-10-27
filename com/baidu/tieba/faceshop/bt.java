package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.tbadk.b.a.a {
    final /* synthetic */ bs auQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(bs bsVar, Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.auQ = bsVar;
    }

    @Override // com.baidu.tbadk.b.a.a
    public void onClick() {
        com.baidu.tbadk.b.a.b bVar;
        MessageManager messageManager = MessageManager.getInstance();
        bVar = FaceshopStatic.auP;
        messageManager.sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(bVar.getContext(), "faceshop_from_more")));
    }
}
