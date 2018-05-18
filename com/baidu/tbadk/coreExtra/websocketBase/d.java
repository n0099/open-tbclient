package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private a aAA;
    private c aAy;
    private b aAz;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aAD;

        c(d dVar) {
            this.aAD = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aAD.get()) != null) {
                dVar.CJ();
            }
        }
    }

    public d(String str, b bVar) {
        this.aAy = null;
        this.aAz = null;
        this.aAA = null;
        this.aAy = new c(this);
        this.aAz = bVar;
        this.aAy.sendEmptyMessageDelayed(0, 50000L);
        this.aAA = new a();
        this.aAA.setSelfExecute(true);
        this.aAA.execute(CI() + str);
    }

    private String CI() {
        switch (j.gV()) {
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
    public void CJ() {
        if (this.aAA != null) {
            this.aAA.cancel(true);
        }
        if (this.aAy != null) {
            this.aAy.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aAB;

        private a() {
            this.aAB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aAB = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aAB.waitFor() == 0;
                        this.aAB.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aAB.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aAB.destroy();
                    }
                } catch (Throwable th) {
                    this.aAB.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aAB != null) {
                try {
                    this.aAB.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aAz != null) {
                d.this.aAz.bp(false);
            }
            if (d.this.aAy != null) {
                d.this.aAy.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aAz != null) {
                d.this.aAz.bp(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aAy != null) {
                d.this.aAy.removeMessages(0);
            }
        }
    }
}
