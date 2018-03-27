package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bpY;
    private b bpZ;
    private a bqa;

    /* loaded from: classes.dex */
    public interface b {
        void bX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bqd;

        c(d dVar) {
            this.bqd = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bqd.get()) != null) {
                dVar.Kf();
            }
        }
    }

    public d(String str, b bVar) {
        this.bpY = null;
        this.bpZ = null;
        this.bqa = null;
        this.bpY = new c(this);
        this.bpZ = bVar;
        this.bpY.sendEmptyMessageDelayed(0, 50000L);
        this.bqa = new a();
        this.bqa.setSelfExecute(true);
        this.bqa.execute(Ke() + str);
    }

    private String Ke() {
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
    public void Kf() {
        if (this.bqa != null) {
            this.bqa.cancel(true);
        }
        if (this.bpY != null) {
            this.bpY.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bqb;

        private a() {
            this.bqb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bqb = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bqb.waitFor() == 0;
                        this.bqb.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bqb.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bqb.destroy();
                    }
                } catch (Throwable th) {
                    this.bqb.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bqb != null) {
                try {
                    this.bqb.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bpZ != null) {
                d.this.bpZ.bX(false);
            }
            if (d.this.bpY != null) {
                d.this.bpY.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bpZ != null) {
                d.this.bpZ.bX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bpY != null) {
                d.this.bpY.removeMessages(0);
            }
        }
    }
}
