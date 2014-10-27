package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.io.File;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    private final String Cj;
    final /* synthetic */ FileDownloader acC;
    private final String mUrl;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private volatile boolean kJ = false;

    public f(FileDownloader fileDownloader, String str, String str2) {
        this.acC = fileDownloader;
        this.mUrl = str;
        this.Cj = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        File bs;
        Handler handler;
        Boolean bool = false;
        while (!this.kJ) {
            try {
                this.mNetWork = new com.baidu.tbadk.core.util.ac(this.mUrl);
                handler = this.acC.handler;
                bool = Boolean.valueOf(this.mNetWork.a(String.valueOf(this.Cj) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.mNetWork.mg() == -2) {
                    break;
                } else if (!this.mNetWork.mc().nb().mm()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tbadk.core.util.s.bx(this.Cj);
            File br = com.baidu.tbadk.core.util.s.br(String.valueOf(this.Cj) + ".tmp");
            if (br != null && (bs = com.baidu.tbadk.core.util.s.bs(this.Cj)) != null) {
                br.renameTo(bs);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.acC.mDowndingTask = null;
        this.kJ = true;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
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
        this.acC.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.acC.getBaseContext(), 10);
            handler = this.acC.handler;
            handler2 = this.acC.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.Cj), 100L);
            return;
        }
        Context baseContext = this.acC.getBaseContext();
        i = this.acC.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.acC.getString(y.error_sd_error), false);
        this.acC.stopSelf();
    }
}
