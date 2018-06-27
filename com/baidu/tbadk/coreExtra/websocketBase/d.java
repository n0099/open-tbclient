package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aJQ;
    private b aJR;
    private a aJS;

    /* loaded from: classes.dex */
    public interface b {
        void bw(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aJV;

        c(d dVar) {
            this.aJV = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aJV.get()) != null) {
                dVar.GE();
            }
        }
    }

    public d(String str, b bVar) {
        this.aJQ = null;
        this.aJR = null;
        this.aJS = null;
        this.aJQ = new c(this);
        this.aJR = bVar;
        this.aJQ.sendEmptyMessageDelayed(0, 50000L);
        this.aJS = new a();
        this.aJS.setSelfExecute(true);
        this.aJS.execute(GD() + str);
    }

    private String GD() {
        switch (j.jJ()) {
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
    public void GE() {
        if (this.aJS != null) {
            this.aJS.cancel(true);
        }
        if (this.aJQ != null) {
            this.aJQ.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aJT;

        private a() {
            this.aJT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aJT = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aJT.waitFor() == 0;
                        this.aJT.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aJT.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aJT.destroy();
                    }
                } catch (Throwable th) {
                    this.aJT.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aJT != null) {
                try {
                    this.aJT.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aJR != null) {
                d.this.aJR.bw(false);
            }
            if (d.this.aJQ != null) {
                d.this.aJQ.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aJR != null) {
                d.this.aJR.bw(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aJQ != null) {
                d.this.aJQ.removeMessages(0);
            }
        }
    }
}
