package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ NetModel XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NetModel netModel, int i, int i2) {
        super(i, i2);
        this.XX = netModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        k kVar;
        k kVar2;
        j jVar;
        j jVar2;
        this.XX.isLoading = false;
        if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
            MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
            jVar = this.XX.XO;
            if (jVar != null) {
                jVar2 = this.XX.XO;
                jVar2.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
            }
        } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
            MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
            kVar = this.XX.XP;
            if (kVar != null) {
                kVar2 = this.XX.XP;
                kVar2.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
            }
        } else if (TbadkApplication.m251getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
        }
    }
}
