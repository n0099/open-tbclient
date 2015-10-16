package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c amF;
    private b amG;
    private a amH;

    /* loaded from: classes.dex */
    public interface b {
        void aW(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> amK;

        c(e eVar) {
            this.amK = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.amK.get()) == null) {
                return;
            }
            eVar.zD();
        }
    }

    public e(String str, b bVar) {
        this.amF = null;
        this.amG = null;
        this.amH = null;
        this.amF = new c(this);
        this.amG = bVar;
        this.amF.sendEmptyMessageDelayed(0, 50000L);
        this.amH = new a(this, null);
        this.amH.setSelfExecute(true);
        this.amH.execute(String.valueOf(zC()) + str);
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
        if (this.amH != null) {
            this.amH.cancel(true);
        }
        if (this.amF != null) {
            this.amF.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process amI;

        private a() {
            this.amI = null;
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
                        this.amI = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.amI.waitFor() == 0;
                        this.amI.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.amI.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.amI.destroy();
                    }
                } catch (Throwable th) {
                    this.amI.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.amI != null) {
                try {
                    this.amI.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.amG != null) {
                e.this.amG.aW(false);
            }
            if (e.this.amF != null) {
                e.this.amF.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.amG != null) {
                e.this.amG.aW(bool == null ? false : bool.booleanValue());
            }
            if (e.this.amF != null) {
                e.this.amF.removeMessages(0);
            }
        }
    }
}
