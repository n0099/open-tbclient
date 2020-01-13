package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c dqm;
    private b dqn;
    private a dqo;

    /* loaded from: classes.dex */
    public interface b {
        void gl(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> dqr;

        c(d dVar) {
            this.dqr = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.dqr.get()) != null) {
                dVar.HR();
            }
        }
    }

    public d(String str, b bVar) {
        this.dqm = null;
        this.dqn = null;
        this.dqo = null;
        this.dqm = new c(this);
        this.dqn = bVar;
        this.dqm.sendEmptyMessageDelayed(0, 50000L);
        this.dqo = new a();
        this.dqo.setSelfExecute(true);
        this.dqo.execute(aKV() + str);
    }

    private String aKV() {
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
    public void HR() {
        if (this.dqo != null) {
            this.dqo.cancel(true);
        }
        if (this.dqm != null) {
            this.dqm.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process dqp;

        private a() {
            this.dqp = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.dqp = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.dqp.waitFor() == 0;
                        this.dqp.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.dqp.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.dqp.destroy();
                    }
                } catch (Throwable th) {
                    this.dqp.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dqp != null) {
                try {
                    this.dqp.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.dqn != null) {
                d.this.dqn.gl(false);
            }
            if (d.this.dqm != null) {
                d.this.dqm.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.dqn != null) {
                d.this.dqn.gl(bool == null ? false : bool.booleanValue());
            }
            if (d.this.dqm != null) {
                d.this.dqm.removeMessages(0);
            }
        }
    }
}
