package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bqi;
    private b bqj;
    private a bqk;

    /* loaded from: classes.dex */
    public interface b {
        void bX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bqn;

        c(d dVar) {
            this.bqn = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bqn.get()) != null) {
                dVar.Kf();
            }
        }
    }

    public d(String str, b bVar) {
        this.bqi = null;
        this.bqj = null;
        this.bqk = null;
        this.bqi = new c(this);
        this.bqj = bVar;
        this.bqi.sendEmptyMessageDelayed(0, 50000L);
        this.bqk = new a();
        this.bqk.setSelfExecute(true);
        this.bqk.execute(Ke() + str);
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
        if (this.bqk != null) {
            this.bqk.cancel(true);
        }
        if (this.bqi != null) {
            this.bqi.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bql;

        private a() {
            this.bql = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bql = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bql.waitFor() == 0;
                        this.bql.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bql.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bql.destroy();
                    }
                } catch (Throwable th) {
                    this.bql.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bql != null) {
                try {
                    this.bql.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bqj != null) {
                d.this.bqj.bX(false);
            }
            if (d.this.bqi != null) {
                d.this.bqi.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bqj != null) {
                d.this.bqj.bX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bqi != null) {
                d.this.bqi.removeMessages(0);
            }
        }
    }
}
