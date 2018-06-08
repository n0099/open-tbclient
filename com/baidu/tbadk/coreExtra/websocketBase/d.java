package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aIT;
    private b aIU;
    private a aIV;

    /* loaded from: classes.dex */
    public interface b {
        void bt(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aIY;

        c(d dVar) {
            this.aIY = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aIY.get()) != null) {
                dVar.Gm();
            }
        }
    }

    public d(String str, b bVar) {
        this.aIT = null;
        this.aIU = null;
        this.aIV = null;
        this.aIT = new c(this);
        this.aIU = bVar;
        this.aIT.sendEmptyMessageDelayed(0, 50000L);
        this.aIV = new a();
        this.aIV.setSelfExecute(true);
        this.aIV.execute(Gl() + str);
    }

    private String Gl() {
        switch (j.jJ()) {
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
    public void Gm() {
        if (this.aIV != null) {
            this.aIV.cancel(true);
        }
        if (this.aIT != null) {
            this.aIT.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aIW;

        private a() {
            this.aIW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aIW = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aIW.waitFor() == 0;
                        this.aIW.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aIW.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aIW.destroy();
                    }
                } catch (Throwable th) {
                    this.aIW.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aIW != null) {
                try {
                    this.aIW.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aIU != null) {
                d.this.aIU.bt(false);
            }
            if (d.this.aIT != null) {
                d.this.aIT.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aIU != null) {
                d.this.aIU.bt(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aIT != null) {
                d.this.aIT.removeMessages(0);
            }
        }
    }
}
