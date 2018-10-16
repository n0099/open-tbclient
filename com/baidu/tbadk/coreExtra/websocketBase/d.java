package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aRL;
    private b aRM;
    private a aRN;

    /* loaded from: classes.dex */
    public interface b {
        void bQ(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aRQ;

        c(d dVar) {
            this.aRQ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aRQ.get()) != null) {
                dVar.timeOut();
            }
        }
    }

    public d(String str, b bVar) {
        this.aRL = null;
        this.aRM = null;
        this.aRN = null;
        this.aRL = new c(this);
        this.aRM = bVar;
        this.aRL.sendEmptyMessageDelayed(0, 50000L);
        this.aRN = new a();
        this.aRN.setSelfExecute(true);
        this.aRN.execute(JP() + str);
    }

    private String JP() {
        switch (j.ld()) {
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
    public void timeOut() {
        if (this.aRN != null) {
            this.aRN.cancel(true);
        }
        if (this.aRL != null) {
            this.aRL.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aRO;

        private a() {
            this.aRO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aRO = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aRO.waitFor() == 0;
                        this.aRO.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aRO.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aRO.destroy();
                    }
                } catch (Throwable th) {
                    this.aRO.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aRO != null) {
                try {
                    this.aRO.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aRM != null) {
                d.this.aRM.bQ(false);
            }
            if (d.this.aRL != null) {
                d.this.aRL.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aRM != null) {
                d.this.aRM.bQ(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aRL != null) {
                d.this.aRL.removeMessages(0);
            }
        }
    }
}
