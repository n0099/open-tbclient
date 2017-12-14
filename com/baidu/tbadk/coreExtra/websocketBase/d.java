package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c azu;
    private b azv;
    private a azw;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> azz;

        c(d dVar) {
            this.azz = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.azz.get()) != null) {
                dVar.Cf();
            }
        }
    }

    public d(String str, b bVar) {
        this.azu = null;
        this.azv = null;
        this.azw = null;
        this.azu = new c(this);
        this.azv = bVar;
        this.azu.sendEmptyMessageDelayed(0, 50000L);
        this.azw = new a();
        this.azw.setSelfExecute(true);
        this.azw.execute(Ce() + str);
    }

    private String Ce() {
        switch (j.hn()) {
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
    public void Cf() {
        if (this.azw != null) {
            this.azw.cancel(true);
        }
        if (this.azu != null) {
            this.azu.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process azx;

        private a() {
            this.azx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.azx = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.azx.waitFor() == 0;
                        this.azx.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.azx.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.azx.destroy();
                    }
                } catch (Throwable th) {
                    this.azx.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.azx != null) {
                try {
                    this.azx.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.azv != null) {
                d.this.azv.bp(false);
            }
            if (d.this.azu != null) {
                d.this.azu.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.azv != null) {
                d.this.azv.bp(bool == null ? false : bool.booleanValue());
            }
            if (d.this.azu != null) {
                d.this.azu.removeMessages(0);
            }
        }
    }
}
