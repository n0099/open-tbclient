package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c asg;
    private b ash;
    private a asi;

    /* loaded from: classes.dex */
    public interface b {
        void bu(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> asl;

        c(e eVar) {
            this.asl = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.asl.get()) == null) {
                return;
            }
            eVar.BL();
        }
    }

    public e(String str, b bVar) {
        this.asg = null;
        this.ash = null;
        this.asi = null;
        this.asg = new c(this);
        this.ash = bVar;
        this.asg.sendEmptyMessageDelayed(0, 50000L);
        this.asi = new a(this, null);
        this.asi.setSelfExecute(true);
        this.asi.execute(String.valueOf(BK()) + str);
    }

    private String BK() {
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
    public void BL() {
        if (this.asi != null) {
            this.asi.cancel(true);
        }
        if (this.asg != null) {
            this.asg.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process asj;

        private a() {
            this.asj = null;
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
                        this.asj = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.asj.waitFor() == 0;
                        this.asj.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.asj.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.asj.destroy();
                    }
                } catch (Throwable th) {
                    this.asj.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.asj != null) {
                try {
                    this.asj.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.ash != null) {
                e.this.ash.bu(false);
            }
            if (e.this.asg != null) {
                e.this.asg.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.ash != null) {
                e.this.ash.bu(bool == null ? false : bool.booleanValue());
            }
            if (e.this.asg != null) {
                e.this.asg.removeMessages(0);
            }
        }
    }
}
