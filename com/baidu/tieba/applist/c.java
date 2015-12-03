package com.baidu.tieba.applist;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ b aKs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.aKs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ApplistResponse)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putLong("applist_report_time", System.currentTimeMillis());
        }
    }
}
