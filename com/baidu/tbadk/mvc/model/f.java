package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends HttpMessageListener {
    final /* synthetic */ NetModel XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.XX = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        this.XX.isLoading = false;
        if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
            if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                jVar = this.XX.XO;
                if (jVar != null) {
                    jVar2 = this.XX.XO;
                    jVar2.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkApplication.m251getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
            }
        } else if (TbadkApplication.m251getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
        }
    }
}
