package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends HttpMessageListener {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        this.this$0.aAd = false;
        if (this.this$0.aAg != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.this$0.aAg);
        }
        if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
            if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                if (this.this$0.azV != null) {
                    this.this$0.azV.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkCoreApplication.m9getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
            }
        } else if (TbadkCoreApplication.m9getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
        }
    }
}
