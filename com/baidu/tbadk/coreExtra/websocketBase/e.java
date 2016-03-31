package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c arl;
    private b arm;
    private a arn;

    /* loaded from: classes.dex */
    public interface b {
        void bi(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> arq;

        c(e eVar) {
            this.arq = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.arq.get()) == null) {
                return;
            }
            eVar.Cl();
        }
    }

    public e(String str, b bVar) {
        this.arl = null;
        this.arm = null;
        this.arn = null;
        this.arl = new c(this);
        this.arm = bVar;
        this.arl.sendEmptyMessageDelayed(0, 50000L);
        this.arn = new a(this, null);
        this.arn.setSelfExecute(true);
        this.arn.execute(String.valueOf(Ck()) + str);
    }

    private String Ck() {
        switch (com.baidu.adp.lib.util.i.jl()) {
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
    public void Cl() {
        if (this.arn != null) {
            this.arn.cancel(true);
        }
        if (this.arl != null) {
            this.arl.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aro;

        private a() {
            this.aro = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aro = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aro.waitFor() == 0;
                        this.aro.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aro.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aro.destroy();
                    }
                } catch (Throwable th) {
                    this.aro.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aro != null) {
                try {
                    this.aro.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.arm != null) {
                e.this.arm.bi(false);
            }
            if (e.this.arl != null) {
                e.this.arl.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.arm != null) {
                e.this.arm.bi(bool == null ? false : bool.booleanValue());
            }
            if (e.this.arl != null) {
                e.this.arl.removeMessages(0);
            }
        }
    }
}
