package com.baidu.tbadk.h;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.a.d {
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
            TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
            if (httpMessage.removeParam("reloin_key") == null && ReloginManager.ug().uj() && tbHttpMessageTask.isNeedLogin()) {
                httpMessage.addParam("reloin_key", "reloin_value");
                ReloginManager.ug().a(httpMessage);
                return null;
            }
            return httpMessage;
        }
        return httpMessage;
    }
}
