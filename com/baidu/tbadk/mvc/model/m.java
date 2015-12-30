package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(NetModel netModel, int i, int i2) {
        super(i, i2);
        this.this$0 = netModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        NetModel.d dVar;
        NetModel.d dVar2;
        this.this$0.axY = false;
        if (this.this$0.ayb != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.this$0.ayb);
        }
        if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
            MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
            if (this.this$0.axP != null) {
                this.this$0.axP.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
            }
        } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
            MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
            dVar = this.this$0.axQ;
            if (dVar != null) {
                dVar2 = this.this$0.axQ;
                dVar2.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
            }
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
        }
    }
}
