package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Runnable runnable;
        s sVar;
        s sVar2;
        Runnable runnable2;
        this.this$0.aoe = false;
        runnable = this.this$0.aog;
        if (runnable != null) {
            com.baidu.adp.lib.g.i hs = com.baidu.adp.lib.g.i.hs();
            runnable2 = this.this$0.aog;
            hs.removeCallbacks(runnable2);
        }
        if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
            if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                sVar = this.this$0.anW;
                if (sVar != null) {
                    sVar2 = this.this$0.anW;
                    sVar2.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
            }
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
        }
    }
}
