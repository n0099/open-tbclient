package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c awj;
    private b awk;
    private a awl;

    /* loaded from: classes.dex */
    public interface b {
        void bt(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> awo;

        c(e eVar) {
            this.awo = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.awo.get()) == null) {
                return;
            }
            eVar.BM();
        }
    }

    public e(String str, b bVar) {
        this.awj = null;
        this.awk = null;
        this.awl = null;
        this.awj = new c(this);
        this.awk = bVar;
        this.awj.sendEmptyMessageDelayed(0, 50000L);
        this.awl = new a(this, null);
        this.awl.setSelfExecute(true);
        this.awl.execute(String.valueOf(BL()) + str);
    }

    private String BL() {
        switch (com.baidu.adp.lib.util.i.hk()) {
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
    public void BM() {
        if (this.awl != null) {
            this.awl.cancel(true);
        }
        if (this.awj != null) {
            this.awj.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process awm;

        private a() {
            this.awm = null;
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
                        this.awm = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.awm.waitFor() == 0;
                        this.awm.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.awm.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.awm.destroy();
                    }
                } catch (Throwable th) {
                    this.awm.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.awm != null) {
                try {
                    this.awm.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.awk != null) {
                e.this.awk.bt(false);
            }
            if (e.this.awj != null) {
                e.this.awj.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.awk != null) {
                e.this.awk.bt(bool == null ? false : bool.booleanValue());
            }
            if (e.this.awj != null) {
                e.this.awj.removeMessages(0);
            }
        }
    }
}
