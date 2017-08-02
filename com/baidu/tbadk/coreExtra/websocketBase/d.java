package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ayl;
    private b aym;
    private a ayn;

    /* loaded from: classes.dex */
    public interface b {
        void bv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ayq;

        c(d dVar) {
            this.ayq = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ayq.get()) != null) {
                dVar.BU();
            }
        }
    }

    public d(String str, b bVar) {
        this.ayl = null;
        this.aym = null;
        this.ayn = null;
        this.ayl = new c(this);
        this.aym = bVar;
        this.ayl.sendEmptyMessageDelayed(0, 50000L);
        this.ayn = new a();
        this.ayn.setSelfExecute(true);
        this.ayn.execute(BT() + str);
    }

    private String BT() {
        switch (i.hn()) {
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
    public void BU() {
        if (this.ayn != null) {
            this.ayn.cancel(true);
        }
        if (this.ayl != null) {
            this.ayl.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ayo;

        private a() {
            this.ayo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ayo = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ayo.waitFor() == 0;
                        this.ayo.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ayo.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ayo.destroy();
                    }
                } catch (Throwable th) {
                    this.ayo.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ayo != null) {
                try {
                    this.ayo.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aym != null) {
                d.this.aym.bv(false);
            }
            if (d.this.ayl != null) {
                d.this.ayl.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aym != null) {
                d.this.aym.bv(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ayl != null) {
                d.this.ayl.removeMessages(0);
            }
        }
    }
}
