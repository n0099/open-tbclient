package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c fwS;
    private b fwT;
    private a fwU;

    /* loaded from: classes.dex */
    public interface b {
        void kA(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> fwX;

        c(d dVar) {
            this.fwX = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.fwX.get()) != null) {
                dVar.akj();
            }
        }
    }

    public d(String str, b bVar) {
        this.fwS = null;
        this.fwT = null;
        this.fwU = null;
        this.fwS = new c(this);
        this.fwT = bVar;
        this.fwS.sendEmptyMessageDelayed(0, 50000L);
        this.fwU = new a();
        this.fwU.setSelfExecute(true);
        this.fwU.execute(bzP() + str);
    }

    private String bzP() {
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
    public void akj() {
        if (this.fwU != null) {
            this.fwU.cancel(true);
        }
        if (this.fwS != null) {
            this.fwS.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process fwV;

        private a() {
            this.fwV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.fwV = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.fwV.waitFor() == 0;
                        this.fwV.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.fwV.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.fwV.destroy();
                    }
                } catch (Throwable th) {
                    this.fwV.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.fwV != null) {
                try {
                    this.fwV.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.fwT != null) {
                d.this.fwT.kA(false);
            }
            if (d.this.fwS != null) {
                d.this.fwS.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.fwT != null) {
                d.this.fwT.kA(bool == null ? false : bool.booleanValue());
            }
            if (d.this.fwS != null) {
                d.this.fwS.removeMessages(0);
            }
        }
    }
}
