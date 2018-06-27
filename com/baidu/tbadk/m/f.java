package com.baidu.tbadk.m;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.a.d {
    public f(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
            TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
            if (httpMessage.removeParam("reloin_key") == null && ReloginManager.yc().ye() && tbHttpMessageTask.isNeedLogin()) {
                httpMessage.addParam("reloin_key", "reloin_value");
                ReloginManager.yc().a(httpMessage);
                return null;
            }
            return httpMessage;
        }
        return httpMessage;
    }
}
