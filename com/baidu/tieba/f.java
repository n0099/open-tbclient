package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.io.File;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    private final String Ck;
    final /* synthetic */ FileDownloader acH;
    private final String mUrl;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private volatile boolean kJ = false;

    public f(FileDownloader fileDownloader, String str, String str2) {
        this.acH = fileDownloader;
        this.mUrl = str;
        this.Ck = str2;
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
                handler = this.acH.handler;
                bool = Boolean.valueOf(this.mNetWork.a(String.valueOf(this.Ck) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
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
            com.baidu.tbadk.core.util.s.bx(this.Ck);
            File br = com.baidu.tbadk.core.util.s.br(String.valueOf(this.Ck) + ".tmp");
            if (br != null && (bs = com.baidu.tbadk.core.util.s.bs(this.Ck)) != null) {
                br.renameTo(bs);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.acH.mDowndingTask = null;
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
        this.acH.mDowndingTask = null;
        if (bool.booleanValue()) {
            NotificationHelper.cancelNotification(this.acH.getBaseContext(), 10);
            handler = this.acH.handler;
            handler2 = this.acH.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.Ck), 100L);
            return;
        }
        Context baseContext = this.acH.getBaseContext();
        i = this.acH.progress;
        NotificationHelper.showProgressNotification(baseContext, 10, null, i, this.mUrl, this.acH.getString(y.error_sd_error), false);
        this.acH.stopSelf();
    }
}
