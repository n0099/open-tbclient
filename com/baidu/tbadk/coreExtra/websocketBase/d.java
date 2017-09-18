package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ayM;
    private b ayN;
    private a ayO;

    /* loaded from: classes.dex */
    public interface b {
        void bu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ayR;

        c(d dVar) {
            this.ayR = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ayR.get()) != null) {
                dVar.BX();
            }
        }
    }

    public d(String str, b bVar) {
        this.ayM = null;
        this.ayN = null;
        this.ayO = null;
        this.ayM = new c(this);
        this.ayN = bVar;
        this.ayM.sendEmptyMessageDelayed(0, 50000L);
        this.ayO = new a();
        this.ayO.setSelfExecute(true);
        this.ayO.execute(BW() + str);
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
        if (this.ayO != null) {
            this.ayO.cancel(true);
        }
        if (this.ayM != null) {
            this.ayM.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ayP;

        private a() {
            this.ayP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ayP = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ayP.waitFor() == 0;
                        this.ayP.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ayP.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ayP.destroy();
                    }
                } catch (Throwable th) {
                    this.ayP.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ayP != null) {
                try {
                    this.ayP.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.ayN != null) {
                d.this.ayN.bu(false);
            }
            if (d.this.ayM != null) {
                d.this.ayM.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.ayN != null) {
                d.this.ayN.bu(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ayM != null) {
                d.this.ayM.removeMessages(0);
            }
        }
    }
}
