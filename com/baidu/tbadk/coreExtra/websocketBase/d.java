package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c azx;
    private b azy;
    private a azz;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> azC;

        c(d dVar) {
            this.azC = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.azC.get()) != null) {
                dVar.Cf();
            }
        }
    }

    public d(String str, b bVar) {
        this.azx = null;
        this.azy = null;
        this.azz = null;
        this.azx = new c(this);
        this.azy = bVar;
        this.azx.sendEmptyMessageDelayed(0, 50000L);
        this.azz = new a();
        this.azz.setSelfExecute(true);
        this.azz.execute(Ce() + str);
    }

    private String Ce() {
        switch (j.hn()) {
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
    public void Cf() {
        if (this.azz != null) {
            this.azz.cancel(true);
        }
        if (this.azx != null) {
            this.azx.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process azA;

        private a() {
            this.azA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.azA = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.azA.waitFor() == 0;
                        this.azA.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.azA.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.azA.destroy();
                    }
                } catch (Throwable th) {
                    this.azA.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.azA != null) {
                try {
                    this.azA.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.azy != null) {
                d.this.azy.bp(false);
            }
            if (d.this.azx != null) {
                d.this.azx.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.azy != null) {
                d.this.azy.bp(bool == null ? false : bool.booleanValue());
            }
            if (d.this.azx != null) {
                d.this.azx.removeMessages(0);
            }
        }
    }
}
