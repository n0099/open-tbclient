package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ayP;
    private b ayQ;
    private a ayR;

    /* loaded from: classes.dex */
    public interface b {
        void bu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ayU;

        c(d dVar) {
            this.ayU = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ayU.get()) != null) {
                dVar.BX();
            }
        }
    }

    public d(String str, b bVar) {
        this.ayP = null;
        this.ayQ = null;
        this.ayR = null;
        this.ayP = new c(this);
        this.ayQ = bVar;
        this.ayP.sendEmptyMessageDelayed(0, 50000L);
        this.ayR = new a();
        this.ayR.setSelfExecute(true);
        this.ayR.execute(BW() + str);
    }

    private String BW() {
        switch (i.ho()) {
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
    public void BX() {
        if (this.ayR != null) {
            this.ayR.cancel(true);
        }
        if (this.ayP != null) {
            this.ayP.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ayS;

        private a() {
            this.ayS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ayS = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ayS.waitFor() == 0;
                        this.ayS.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ayS.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ayS.destroy();
                    }
                } catch (Throwable th) {
                    this.ayS.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ayS != null) {
                try {
                    this.ayS.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.ayQ != null) {
                d.this.ayQ.bu(false);
            }
            if (d.this.ayP != null) {
                d.this.ayP.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.ayQ != null) {
                d.this.ayQ.bu(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ayP != null) {
                d.this.ayP.removeMessages(0);
            }
        }
    }
}
