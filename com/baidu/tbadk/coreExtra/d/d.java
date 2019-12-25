package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c dqb;
    private b dqc;
    private a dqd;

    /* loaded from: classes.dex */
    public interface b {
        void gg(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> dqg;

        c(d dVar) {
            this.dqg = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.dqg.get()) != null) {
                dVar.Hv();
            }
        }
    }

    public d(String str, b bVar) {
        this.dqb = null;
        this.dqc = null;
        this.dqd = null;
        this.dqb = new c(this);
        this.dqc = bVar;
        this.dqb.sendEmptyMessageDelayed(0, 50000L);
        this.dqd = new a();
        this.dqd.setSelfExecute(true);
        this.dqd.execute(aKC() + str);
    }

    private String aKC() {
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
    public void Hv() {
        if (this.dqd != null) {
            this.dqd.cancel(true);
        }
        if (this.dqb != null) {
            this.dqb.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process dqe;

        private a() {
            this.dqe = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.dqe = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.dqe.waitFor() == 0;
                        this.dqe.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.dqe.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.dqe.destroy();
                    }
                } catch (Throwable th) {
                    this.dqe.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dqe != null) {
                try {
                    this.dqe.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.dqc != null) {
                d.this.dqc.gg(false);
            }
            if (d.this.dqb != null) {
                d.this.dqb.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.dqc != null) {
                d.this.dqc.gg(bool == null ? false : bool.booleanValue());
            }
            if (d.this.dqb != null) {
                d.this.dqb.removeMessages(0);
            }
        }
    }
}
