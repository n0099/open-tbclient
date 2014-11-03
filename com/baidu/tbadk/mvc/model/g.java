package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NetModel XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.XX = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        k kVar;
        k kVar2;
        this.XX.isLoading = false;
        if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
            if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                kVar = this.XX.XP;
                if (kVar != null) {
                    kVar2 = this.XX.XP;
                    kVar2.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkApplication.m251getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
            }
        } else if (TbadkApplication.m251getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
        }
    }
}
