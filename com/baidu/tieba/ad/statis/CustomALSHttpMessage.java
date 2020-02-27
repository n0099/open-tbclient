package com.baidu.tieba.ad.statis;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class CustomALSHttpMessage extends HttpMessage {
    private static final TbHttpMessageTask task = new TbHttpMessageTask(1003195, TbConfig.REPORT_PLOG);
    Handler mUIHandler;

    public CustomALSHttpMessage() {
        super(1003195);
        this.mUIHandler = null;
        addParam("productId", "2");
        addParam("_os_version", Build.VERSION.RELEASE);
        addParam("_os_type", "ANDROID");
        addParam("net_type", String.valueOf(j.netType()));
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
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.ad.statis.CustomALSHttpMessage.1
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().sendMessage(CustomALSHttpMessage.this, CustomALSHttpMessage.task);
            }
        });
    }

    static {
        task.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(true);
        task.setResponsedClass(CustomALSResponseHttpMessage.class);
    }
}
