package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cDg;
    private b cDh;
    private a cDi;

    /* loaded from: classes.dex */
    public interface b {
        void eU(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cDl;

        c(d dVar) {
            this.cDl = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cDl.get()) != null) {
                dVar.CH();
            }
        }
    }

    public d(String str, b bVar) {
        this.cDg = null;
        this.cDh = null;
        this.cDi = null;
        this.cDg = new c(this);
        this.cDh = bVar;
        this.cDg.sendEmptyMessageDelayed(0, 50000L);
        this.cDi = new a();
        this.cDi.setSelfExecute(true);
        this.cDi.execute(atg() + str);
    }

    private String atg() {
        switch (j.netType()) {
            case 1:
                return "ping -c 3 -w 3000 ";
            case 2:
                return "ping -c 3 -w 10000 ";
            case 3:
                return "ping -c 3 -w 5000 ";
            default:
                return "ping -c 3 -w 5000 ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH() {
        if (this.cDi != null) {
            this.cDi.cancel(true);
        }
        if (this.cDg != null) {
            this.cDg.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cDj;

        private a() {
            this.cDj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cDj = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cDj.waitFor() == 0;
                        this.cDj.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cDj.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cDj.destroy();
                    }
                } catch (Throwable th) {
                    this.cDj.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cDj != null) {
                try {
                    this.cDj.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cDh != null) {
                d.this.cDh.eU(false);
            }
            if (d.this.cDg != null) {
                d.this.cDg.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cDh != null) {
                d.this.cDh.eU(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cDg != null) {
                d.this.cDg.removeMessages(0);
            }
        }
    }
}
