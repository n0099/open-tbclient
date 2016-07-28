package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        NetModel.d dVar;
        NetModel.d dVar2;
        this.this$0.axe = false;
        if (this.this$0.axh != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.this$0.axh);
        }
        if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
            if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                dVar = this.this$0.awX;
                if (dVar != null) {
                    dVar2 = this.this$0.awX;
                    dVar2.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkCoreApplication.m10getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
            }
        } else if (TbadkCoreApplication.m10getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
        }
    }
}
