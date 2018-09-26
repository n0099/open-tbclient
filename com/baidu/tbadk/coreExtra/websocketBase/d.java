package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aNj;
    private b aNk;
    private a aNl;

    /* loaded from: classes.dex */
    public interface b {
        void bH(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aNo;

        c(d dVar) {
            this.aNo = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aNo.get()) != null) {
                dVar.HQ();
            }
        }
    }

    public d(String str, b bVar) {
        this.aNj = null;
        this.aNk = null;
        this.aNl = null;
        this.aNj = new c(this);
        this.aNk = bVar;
        this.aNj.sendEmptyMessageDelayed(0, 50000L);
        this.aNl = new a();
        this.aNl.setSelfExecute(true);
        this.aNl.execute(HP() + str);
    }

    private String HP() {
        switch (j.kQ()) {
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
    public void HQ() {
        if (this.aNl != null) {
            this.aNl.cancel(true);
        }
        if (this.aNj != null) {
            this.aNj.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aNm;

        private a() {
            this.aNm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aNm = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aNm.waitFor() == 0;
                        this.aNm.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aNm.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aNm.destroy();
                    }
                } catch (Throwable th) {
                    this.aNm.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aNm != null) {
                try {
                    this.aNm.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aNk != null) {
                d.this.aNk.bH(false);
            }
            if (d.this.aNj != null) {
                d.this.aNj.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aNk != null) {
                d.this.aNk.bH(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aNj != null) {
                d.this.aNj.removeMessages(0);
            }
        }
    }
}
