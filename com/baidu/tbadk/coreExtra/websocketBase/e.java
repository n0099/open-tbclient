package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c amE;
    private b amF;
    private a amG;

    /* loaded from: classes.dex */
    public interface b {
        void aW(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> amJ;

        c(e eVar) {
            this.amJ = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.amJ.get()) == null) {
                return;
            }
            eVar.zD();
        }
    }

    public e(String str, b bVar) {
        this.amE = null;
        this.amF = null;
        this.amG = null;
        this.amE = new c(this);
        this.amF = bVar;
        this.amE.sendEmptyMessageDelayed(0, 50000L);
        this.amG = new a(this, null);
        this.amG.setSelfExecute(true);
        this.amG.execute(String.valueOf(zC()) + str);
    }

    private String zC() {
        switch (com.baidu.adp.lib.util.i.iS()) {
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
    public void zD() {
        if (this.amG != null) {
            this.amG.cancel(true);
        }
        if (this.amE != null) {
            this.amE.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process amH;

        private a() {
            this.amH = null;
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
                        this.amH = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.amH.waitFor() == 0;
                        this.amH.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.amH.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.amH.destroy();
                    }
                } catch (Throwable th) {
                    this.amH.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.amH != null) {
                try {
                    this.amH.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.amF != null) {
                e.this.amF.aW(false);
            }
            if (e.this.amE != null) {
                e.this.amE.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.amF != null) {
                e.this.amF.aW(bool == null ? false : bool.booleanValue());
            }
            if (e.this.amE != null) {
                e.this.amE.removeMessages(0);
            }
        }
    }
}
