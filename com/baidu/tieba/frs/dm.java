package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class dm extends com.baidu.adp.base.d {
    private static final String b = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/zan/like";
    private static TbHttpMessageTask c = new TbHttpMessageTask(CmdConfig.COMMON_PRAISE_Y_OR_N, b);
    private Cdo a;
    private HttpMessageListener d = new dn(this, CmdConfig.COMMON_PRAISE_Y_OR_N);

    static {
        c.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(c);
    }

    public dm(Cdo cdo) {
        this.a = null;
        this.a = cdo;
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
        HttpMessage httpMessage = new HttpMessage(CmdConfig.COMMON_PRAISE_Y_OR_N);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str4);
        httpMessage.addParam("action", str4);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.POST_ID, new StringBuilder(String.valueOf(str)).toString());
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, new StringBuilder(String.valueOf(str2)).toString());
        httpMessage.addParam("st_param", str3);
        httpMessage.setTag(CmdConfig.COMMON_PRAISE_Y_OR_N);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }
}
