package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.io.File;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    private final String GE;
    final /* synthetic */ FileDownloader akW;
    private final String mUrl;
    private com.baidu.tbadk.core.util.ad AR = null;
    private volatile boolean kN = false;

    public f(FileDownloader fileDownloader, String str, String str2) {
        this.akW = fileDownloader;
        this.mUrl = str;
        this.GE = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        File ci;
        Handler handler;
        Boolean bool = false;
        while (!this.kN) {
            try {
                this.AR = new com.baidu.tbadk.core.util.ad(this.mUrl);
                handler = this.akW.handler;
                bool = Boolean.valueOf(this.AR.a(String.valueOf(this.GE) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.AR.pd() == -2) {
                    break;
                } else if (!this.AR.oZ().qh().pj()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tbadk.core.util.s.cn(this.GE);
            File ch = com.baidu.tbadk.core.util.s.ch(String.valueOf(this.GE) + ".tmp");
            if (ch != null && (ci = com.baidu.tbadk.core.util.s.ci(this.GE)) != null) {
                ch.renameTo(ci);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.akW.mDowndingTask = null;
        this.kN = true;
        if (this.AR != null) {
            this.AR.dJ();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        int i;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.akW.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.akW.getBaseContext(), 10);
            handler = this.akW.handler;
            handler2 = this.akW.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.GE), 100L);
            return;
        }
        Context baseContext = this.akW.getBaseContext();
        i = this.akW.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.akW.getString(z.error_sd_error), false);
        this.akW.stopSelf();
    }
}
