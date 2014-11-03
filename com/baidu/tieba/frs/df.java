package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class df extends com.baidu.adp.base.e {
    private static final String aEy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/zan/like";
    private static TbHttpMessageTask aEz = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, aEy);
    private final HttpMessageListener aEA;
    private dh aEx;

    static {
        aEz.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(aEz);
    }

    public df(Context context, dh dhVar) {
        super(context);
        this.aEx = null;
        this.aEA = new dg(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.aEx = dhVar;
    }

    public void registerListener() {
        registerListener(this.aEA);
    }

    public void a(String str, String str2, int i, String str3) {
        String str4;
        if (i == 1) {
            str4 = "unlike";
        } else {
            str4 = "like";
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        httpMessage.addParam("st_type", str4);
        httpMessage.addParam("action", str4);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(str)).toString());
        httpMessage.addParam("thread_id", new StringBuilder(String.valueOf(str2)).toString());
        httpMessage.addParam("st_param", str3);
        sendMessage(httpMessage);
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
