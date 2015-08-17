package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends HttpMessageListener {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        this.this$0.avu = false;
        if (this.this$0.avx != null) {
            com.baidu.adp.lib.g.h.hi().removeCallbacks(this.this$0.avx);
        }
        if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
            if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                if (this.this$0.avl != null) {
                    this.this$0.avl.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
            }
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
        }
    }
}
