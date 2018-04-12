package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aAx;
    private b aAy;
    private a aAz;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aAC;

        c(d dVar) {
            this.aAC = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aAC.get()) != null) {
                dVar.CL();
            }
        }
    }

    public d(String str, b bVar) {
        this.aAx = null;
        this.aAy = null;
        this.aAz = null;
        this.aAx = new c(this);
        this.aAy = bVar;
        this.aAx.sendEmptyMessageDelayed(0, 50000L);
        this.aAz = new a();
        this.aAz.setSelfExecute(true);
        this.aAz.execute(CK() + str);
    }

    private String CK() {
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
    public void CL() {
        if (this.aAz != null) {
            this.aAz.cancel(true);
        }
        if (this.aAx != null) {
            this.aAx.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aAA;

        private a() {
            this.aAA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aAA = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aAA.waitFor() == 0;
                        this.aAA.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aAA.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aAA.destroy();
                    }
                } catch (Throwable th) {
                    this.aAA.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aAA != null) {
                try {
                    this.aAA.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aAy != null) {
                d.this.aAy.bp(false);
            }
            if (d.this.aAx != null) {
                d.this.aAx.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aAy != null) {
                d.this.aAy.bp(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aAx != null) {
                d.this.aAx.removeMessages(0);
            }
        }
    }
}
