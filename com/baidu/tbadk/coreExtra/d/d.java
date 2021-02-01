package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c fzi;
    private b fzj;
    private a fzk;

    /* loaded from: classes.dex */
    public interface b {
        void kD(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> fzn;

        c(d dVar) {
            this.fzn = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.fzn.get()) != null) {
                dVar.akH();
            }
        }
    }

    public d(String str, b bVar) {
        this.fzi = null;
        this.fzj = null;
        this.fzk = null;
        this.fzi = new c(this);
        this.fzj = bVar;
        this.fzi.sendEmptyMessageDelayed(0, 50000L);
        this.fzk = new a();
        this.fzk.setSelfExecute(true);
        this.fzk.execute(bAh() + str);
    }

    private String bAh() {
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
    public void akH() {
        if (this.fzk != null) {
            this.fzk.cancel(true);
        }
        if (this.fzi != null) {
            this.fzi.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process fzl;

        private a() {
            this.fzl = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.fzl = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.fzl.waitFor() == 0;
                        this.fzl.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.fzl.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.fzl.destroy();
                    }
                } catch (Throwable th) {
                    this.fzl.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.fzl != null) {
                try {
                    this.fzl.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.fzj != null) {
                d.this.fzj.kD(false);
            }
            if (d.this.fzi != null) {
                d.this.fzi.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.fzj != null) {
                d.this.fzj.kD(bool == null ? false : bool.booleanValue());
            }
            if (d.this.fzi != null) {
                d.this.fzi.removeMessages(0);
            }
        }
    }
}
