package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.ad;
import java.io.File;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    private final String Gv;
    final /* synthetic */ FileDownloader aks;
    private final String mUrl;
    private ad AR = null;
    private volatile boolean kK = false;

    public f(FileDownloader fileDownloader, String str, String str2) {
        this.aks = fileDownloader;
        this.mUrl = str;
        this.Gv = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        File ck;
        Handler handler;
        Boolean bool = false;
        while (!this.kK) {
            try {
                this.AR = new ad(this.mUrl);
                handler = this.aks.handler;
                bool = Boolean.valueOf(this.AR.a(String.valueOf(this.Gv) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.AR.pa() == -2) {
                    break;
                } else if (!this.AR.oW().pW().pg()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tbadk.core.util.s.cp(this.Gv);
            File cj = com.baidu.tbadk.core.util.s.cj(String.valueOf(this.Gv) + ".tmp");
            if (cj != null && (ck = com.baidu.tbadk.core.util.s.ck(this.Gv)) != null) {
                cj.renameTo(ck);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.aks.mDowndingTask = null;
        this.kK = true;
        if (this.AR != null) {
            this.AR.dL();
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
        this.aks.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.aks.getBaseContext(), 10);
            handler = this.aks.handler;
            handler2 = this.aks.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.Gv), 100L);
            return;
        }
        Context baseContext = this.aks.getBaseContext();
        i = this.aks.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.aks.getString(z.error_sd_error), false);
        this.aks.stopSelf();
    }
}
