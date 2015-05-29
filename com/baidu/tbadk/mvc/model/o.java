package com.baidu.tbadk.mvc.model;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends HttpMessageListener {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(NetModel netModel, int i, boolean z) {
        super(i, z);
        this.this$0 = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Runnable runnable;
        r rVar;
        r rVar2;
        Runnable runnable2;
        this.this$0.aoe = false;
        runnable = this.this$0.aog;
        if (runnable != null) {
            com.baidu.adp.lib.g.i hs = com.baidu.adp.lib.g.i.hs();
            runnable2 = this.this$0.aog;
            hs.removeCallbacks(runnable2);
        }
        if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
            if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                rVar = this.this$0.anV;
                if (rVar != null) {
                    rVar2 = this.this$0.anV;
                    rVar2.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                }
            } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
            }
        } else if (TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
        }
    }
}
