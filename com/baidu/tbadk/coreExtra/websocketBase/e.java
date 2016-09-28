package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c arm;
    private b arn;
    private a aro;

    /* loaded from: classes.dex */
    public interface b {
        void bq(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> arr;

        c(e eVar) {
            this.arr = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.arr.get()) == null) {
                return;
            }
            eVar.BE();
        }
    }

    public e(String str, b bVar) {
        this.arm = null;
        this.arn = null;
        this.aro = null;
        this.arm = new c(this);
        this.arn = bVar;
        this.arm.sendEmptyMessageDelayed(0, 50000L);
        this.aro = new a(this, null);
        this.aro.setSelfExecute(true);
        this.aro.execute(String.valueOf(BD()) + str);
    }

    private String BD() {
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
    public void BE() {
        if (this.aro != null) {
            this.aro.cancel(true);
        }
        if (this.arm != null) {
            this.arm.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process arp;

        private a() {
            this.arp = null;
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
                        this.arp = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.arp.waitFor() == 0;
                        this.arp.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.arp.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.arp.destroy();
                    }
                } catch (Throwable th) {
                    this.arp.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.arp != null) {
                try {
                    this.arp.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.arn != null) {
                e.this.arn.bq(false);
            }
            if (e.this.arm != null) {
                e.this.arm.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.arn != null) {
                e.this.arn.bq(bool == null ? false : bool.booleanValue());
            }
            if (e.this.arm != null) {
                e.this.arm.removeMessages(0);
            }
        }
    }
}
