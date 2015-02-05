package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.io.File;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    private final String GB;
    final /* synthetic */ FileDownloader akT;
    private final String mUrl;
    private com.baidu.tbadk.core.util.ad AO = null;
    private volatile boolean kN = false;

    public f(FileDownloader fileDownloader, String str, String str2) {
        this.akT = fileDownloader;
        this.mUrl = str;
        this.GB = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        File cf;
        Handler handler;
        Boolean bool = false;
        while (!this.kN) {
            try {
                this.AO = new com.baidu.tbadk.core.util.ad(this.mUrl);
                handler = this.akT.handler;
                bool = Boolean.valueOf(this.AO.a(String.valueOf(this.GB) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.AO.oW() == -2) {
                    break;
                } else if (!this.AO.oS().qa().pc()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tbadk.core.util.s.ck(this.GB);
            File ce = com.baidu.tbadk.core.util.s.ce(String.valueOf(this.GB) + ".tmp");
            if (ce != null && (cf = com.baidu.tbadk.core.util.s.cf(this.GB)) != null) {
                ce.renameTo(cf);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.akT.mDowndingTask = null;
        this.kN = true;
        if (this.AO != null) {
            this.AO.dJ();
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
        this.akT.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.akT.getBaseContext(), 10);
            handler = this.akT.handler;
            handler2 = this.akT.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.GB), 100L);
            return;
        }
        Context baseContext = this.akT.getBaseContext();
        i = this.akT.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.akT.getString(z.error_sd_error), false);
        this.akT.stopSelf();
    }
}
