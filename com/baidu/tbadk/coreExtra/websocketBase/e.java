package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c aqO;
    private b aqP;
    private a aqQ;

    /* loaded from: classes.dex */
    public interface b {
        void bu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aqT;

        c(e eVar) {
            this.aqT = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aqT.get()) == null) {
                return;
            }
            eVar.Bt();
        }
    }

    public e(String str, b bVar) {
        this.aqO = null;
        this.aqP = null;
        this.aqQ = null;
        this.aqO = new c(this);
        this.aqP = bVar;
        this.aqO.sendEmptyMessageDelayed(0, 50000L);
        this.aqQ = new a(this, null);
        this.aqQ.setSelfExecute(true);
        this.aqQ.execute(String.valueOf(Bs()) + str);
    }

    private String Bs() {
        switch (com.baidu.adp.lib.util.i.gq()) {
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
    public void Bt() {
        if (this.aqQ != null) {
            this.aqQ.cancel(true);
        }
        if (this.aqO != null) {
            this.aqO.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aqR;

        private a() {
            this.aqR = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aqR = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aqR.waitFor() == 0;
                        this.aqR.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aqR.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aqR.destroy();
                    }
                } catch (Throwable th) {
                    this.aqR.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aqR != null) {
                try {
                    this.aqR.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aqP != null) {
                e.this.aqP.bu(false);
            }
            if (e.this.aqO != null) {
                e.this.aqO.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.aqP != null) {
                e.this.aqP.bu(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aqO != null) {
                e.this.aqO.removeMessages(0);
            }
        }
    }
}
