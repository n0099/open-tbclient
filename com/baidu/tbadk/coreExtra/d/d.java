package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c erO;
    private b erP;
    private a erQ;

    /* loaded from: classes.dex */
    public interface b {
        void hW(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> erT;

        c(d dVar) {
            this.erT = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.erT.get()) != null) {
                dVar.VQ();
            }
        }
    }

    public d(String str, b bVar) {
        this.erO = null;
        this.erP = null;
        this.erQ = null;
        this.erO = new c(this);
        this.erP = bVar;
        this.erO.sendEmptyMessageDelayed(0, 50000L);
        this.erQ = new a();
        this.erQ.setSelfExecute(true);
        this.erQ.execute(bef() + str);
    }

    private String bef() {
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
    public void VQ() {
        if (this.erQ != null) {
            this.erQ.cancel(true);
        }
        if (this.erO != null) {
            this.erO.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process erR;

        private a() {
            this.erR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.erR = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.erR.waitFor() == 0;
                        this.erR.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.erR.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.erR.destroy();
                    }
                } catch (Throwable th) {
                    this.erR.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.erR != null) {
                try {
                    this.erR.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.erP != null) {
                d.this.erP.hW(false);
            }
            if (d.this.erO != null) {
                d.this.erO.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.erP != null) {
                d.this.erP.hW(bool == null ? false : bool.booleanValue());
            }
            if (d.this.erO != null) {
                d.this.erO.removeMessages(0);
            }
        }
    }
}
