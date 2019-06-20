package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cop;
    private b coq;
    private a cor;

    /* loaded from: classes.dex */
    public interface b {
        void eT(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cou;

        c(d dVar) {
            this.cou = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cou.get()) != null) {
                dVar.xh();
            }
        }
    }

    public d(String str, b bVar) {
        this.cop = null;
        this.coq = null;
        this.cor = null;
        this.cop = new c(this);
        this.coq = bVar;
        this.cop.sendEmptyMessageDelayed(0, 50000L);
        this.cor = new a();
        this.cor.setSelfExecute(true);
        this.cor.execute(apW() + str);
    }

    private String apW() {
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
    public void xh() {
        if (this.cor != null) {
            this.cor.cancel(true);
        }
        if (this.cop != null) {
            this.cop.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cos;

        private a() {
            this.cos = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cos = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cos.waitFor() == 0;
                        this.cos.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cos.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cos.destroy();
                    }
                } catch (Throwable th) {
                    this.cos.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cos != null) {
                try {
                    this.cos.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.coq != null) {
                d.this.coq.eT(false);
            }
            if (d.this.cop != null) {
                d.this.cop.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.coq != null) {
                d.this.coq.eT(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cop != null) {
                d.this.cop.removeMessages(0);
            }
        }
    }
}
