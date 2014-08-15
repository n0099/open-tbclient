package com.baidu.tieba.im.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(MsglistModel msglistModel, int i) {
        super(i);
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.base.h hVar;
        if (customResponsedMessage instanceof ResponseUnLoginMessage) {
            this.a.mLoadDataMode = 11;
            hVar = this.a.mLoadDataCallBack;
            hVar.a(null);
        }
    }
}
