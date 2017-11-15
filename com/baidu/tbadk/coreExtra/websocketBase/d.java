package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ayO;
    private b ayP;
    private a ayQ;

    /* loaded from: classes.dex */
    public interface b {
        void bo(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ayT;

        c(d dVar) {
            this.ayT = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ayT.get()) != null) {
                dVar.BU();
            }
        }
    }

    public d(String str, b bVar) {
        this.ayO = null;
        this.ayP = null;
        this.ayQ = null;
        this.ayO = new c(this);
        this.ayP = bVar;
        this.ayO.sendEmptyMessageDelayed(0, 50000L);
        this.ayQ = new a();
        this.ayQ.setSelfExecute(true);
        this.ayQ.execute(BT() + str);
    }

    private String BT() {
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
    public void BU() {
        if (this.ayQ != null) {
            this.ayQ.cancel(true);
        }
        if (this.ayO != null) {
            this.ayO.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ayR;

        private a() {
            this.ayR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ayR = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ayR.waitFor() == 0;
                        this.ayR.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ayR.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ayR.destroy();
                    }
                } catch (Throwable th) {
                    this.ayR.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ayR != null) {
                try {
                    this.ayR.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.ayP != null) {
                d.this.ayP.bo(false);
            }
            if (d.this.ayO != null) {
                d.this.ayO.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.ayP != null) {
                d.this.ayP.bo(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ayO != null) {
                d.this.ayO.removeMessages(0);
            }
        }
    }
}
