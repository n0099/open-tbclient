package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c amK;
    private b amL;
    private a amM;

    /* loaded from: classes.dex */
    public interface b {
        void aW(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> amP;

        c(e eVar) {
            this.amP = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.amP.get()) == null) {
                return;
            }
            eVar.zF();
        }
    }

    public e(String str, b bVar) {
        this.amK = null;
        this.amL = null;
        this.amM = null;
        this.amK = new c(this);
        this.amL = bVar;
        this.amK.sendEmptyMessageDelayed(0, 50000L);
        this.amM = new a(this, null);
        this.amM.setSelfExecute(true);
        this.amM.execute(String.valueOf(zE()) + str);
    }

    private String zE() {
        switch (com.baidu.adp.lib.util.i.iT()) {
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
    public void zF() {
        if (this.amM != null) {
            this.amM.cancel(true);
        }
        if (this.amK != null) {
            this.amK.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process amN;

        private a() {
            this.amN = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.amN = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.amN.waitFor() == 0;
                        this.amN.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.amN.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.amN.destroy();
                    }
                } catch (Throwable th) {
                    this.amN.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.amN != null) {
                try {
                    this.amN.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.amL != null) {
                e.this.amL.aW(false);
            }
            if (e.this.amK != null) {
                e.this.amK.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.amL != null) {
                e.this.amL.aW(bool == null ? false : bool.booleanValue());
            }
            if (e.this.amK != null) {
                e.this.amK.removeMessages(0);
            }
        }
    }
}
