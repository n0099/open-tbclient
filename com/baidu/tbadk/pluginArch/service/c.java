package com.baidu.tbadk.pluginArch.service;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ RemoteSynchronousDataService a;

    private c(RemoteSynchronousDataService remoteSynchronousDataService) {
        this.a = remoteSynchronousDataService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(RemoteSynchronousDataService remoteSynchronousDataService, c cVar) {
        this(remoteSynchronousDataService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                RemoteSynchronousDataService.access$0(this.a).add(message.replyTo);
                return;
            case 1:
                RemoteSynchronousDataService.access$0(this.a).remove(message.replyTo);
                return;
            case 2:
                BdLog.i("service----WHAT_OPERATE_FORBIDDEN");
                RemoteSynchronousDataService.access$1(this.a, message);
                return;
            case 3:
                BdLog.i("service----WHAT_INSTALL_PLUGIN");
                RemoteSynchronousDataService.access$2(this.a, message);
                return;
            case 4:
                BdLog.i("service----WHAT_NET_CONFIG");
                RemoteSynchronousDataService.access$3(this.a, message);
                return;
            default:
                return;
        }
    }
}
