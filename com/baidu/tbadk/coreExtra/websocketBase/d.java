package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bpV;
    private b bpW;
    private a bpX;

    /* loaded from: classes.dex */
    public interface b {
        void bX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bqa;

        c(d dVar) {
            this.bqa = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bqa.get()) != null) {
                dVar.Ke();
            }
        }
    }

    public d(String str, b bVar) {
        this.bpV = null;
        this.bpW = null;
        this.bpX = null;
        this.bpV = new c(this);
        this.bpW = bVar;
        this.bpV.sendEmptyMessageDelayed(0, 50000L);
        this.bpX = new a();
        this.bpX.setSelfExecute(true);
        this.bpX.execute(Kd() + str);
    }

    private String Kd() {
        switch (j.oP()) {
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
    public void Ke() {
        if (this.bpX != null) {
            this.bpX.cancel(true);
        }
        if (this.bpV != null) {
            this.bpV.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bpY;

        private a() {
            this.bpY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bpY = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bpY.waitFor() == 0;
                        this.bpY.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bpY.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bpY.destroy();
                    }
                } catch (Throwable th) {
                    this.bpY.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bpY != null) {
                try {
                    this.bpY.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bpW != null) {
                d.this.bpW.bX(false);
            }
            if (d.this.bpV != null) {
                d.this.bpV.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bpW != null) {
                d.this.bpW.bX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bpV != null) {
                d.this.bpV.removeMessages(0);
            }
        }
    }
}
