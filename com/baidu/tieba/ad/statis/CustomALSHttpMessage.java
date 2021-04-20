package com.baidu.tieba.ad.statis;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class CustomALSHttpMessage extends HttpMessage {
    public static final TbHttpMessageTask task;
    public Handler mUIHandler;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().sendMessage(CustomALSHttpMessage.this, CustomALSHttpMessage.task);
        }
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CUSTOM_ALS, TbConfig.REPORT_PLOG);
        task = tbHttpMessageTask;
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(true);
        task.setResponsedClass(CustomALSResponseHttpMessage.class);
    }

    public CustomALSHttpMessage() {
        super(CmdConfigHttp.CMD_CUSTOM_ALS);
        this.mUIHandler = null;
        addParam("productId", "2");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        addParam(AdUploadHttpRequest.KEY_OS_TYPE, "ANDROID");
        addParam("net_type", String.valueOf(j.I()));
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public CustomALSHttpMessage init(String str, String str2) {
        addParam("c_id", str);
        addParam("c_type", str2);
        return this;
    }

    public void send() {
        MessageManager.getInstance().sendMessage(this, task);
    }

    public void sendBackground() {
        this.mUIHandler.post(new a());
    }
}
