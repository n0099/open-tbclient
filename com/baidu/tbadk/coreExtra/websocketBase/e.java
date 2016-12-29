package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c arJ;
    private b arK;
    private a arL;

    /* loaded from: classes.dex */
    public interface b {
        void bu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> arO;

        c(e eVar) {
            this.arO = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.arO.get()) == null) {
                return;
            }
            eVar.By();
        }
    }

    public e(String str, b bVar) {
        this.arJ = null;
        this.arK = null;
        this.arL = null;
        this.arJ = new c(this);
        this.arK = bVar;
        this.arJ.sendEmptyMessageDelayed(0, 50000L);
        this.arL = new a(this, null);
        this.arL.setSelfExecute(true);
        this.arL.execute(String.valueOf(Bx()) + str);
    }

    private String Bx() {
        switch (com.baidu.adp.lib.util.i.gs()) {
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
    public void By() {
        if (this.arL != null) {
            this.arL.cancel(true);
        }
        if (this.arJ != null) {
            this.arJ.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process arM;

        private a() {
            this.arM = null;
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
                        this.arM = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.arM.waitFor() == 0;
                        this.arM.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.arM.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.arM.destroy();
                    }
                } catch (Throwable th) {
                    this.arM.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.arM != null) {
                try {
                    this.arM.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.arK != null) {
                e.this.arK.bu(false);
            }
            if (e.this.arJ != null) {
                e.this.arJ.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.arK != null) {
                e.this.arK.bu(bool == null ? false : bool.booleanValue());
            }
            if (e.this.arJ != null) {
                e.this.arJ.removeMessages(0);
            }
        }
    }
}
