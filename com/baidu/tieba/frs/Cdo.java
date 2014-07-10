package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* renamed from: com.baidu.tieba.frs.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.adp.base.e {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/zan/like";
    private static TbHttpMessageTask c = new TbHttpMessageTask(1001600, b);
    private dq a;
    private HttpMessageListener d = new dp(this, 1001600);

    static {
        c.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(c);
    }

    public Cdo(dq dqVar) {
        this.a = null;
        this.a = dqVar;
    }

    public void a() {
        registerListener(this.d);
    }

    public void a(String str, String str2, int i, String str3) {
        String str4;
        if (i == 1) {
            str4 = "unlike";
        } else {
            str4 = "like";
        }
        HttpMessage httpMessage = new HttpMessage(1001600);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str4);
        httpMessage.addParam("action", str4);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.POST_ID, new StringBuilder(String.valueOf(str)).toString());
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, new StringBuilder(String.valueOf(str2)).toString());
        httpMessage.addParam("st_param", str3);
        httpMessage.setTag(1001600);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
