package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cgg;
    private b cgh;
    private a cgi;

    /* loaded from: classes.dex */
    public interface b {
        void ex(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cgl;

        c(d dVar) {
            this.cgl = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cgl.get()) != null) {
                dVar.wp();
            }
        }
    }

    public d(String str, b bVar) {
        this.cgg = null;
        this.cgh = null;
        this.cgi = null;
        this.cgg = new c(this);
        this.cgh = bVar;
        this.cgg.sendEmptyMessageDelayed(0, 50000L);
        this.cgi = new a();
        this.cgi.setSelfExecute(true);
        this.cgi.execute(akT() + str);
    }

    private String akT() {
        switch (j.netType()) {
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
    public void wp() {
        if (this.cgi != null) {
            this.cgi.cancel(true);
        }
        if (this.cgg != null) {
            this.cgg.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cgj;

        private a() {
            this.cgj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cgj = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cgj.waitFor() == 0;
                        this.cgj.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cgj.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cgj.destroy();
                    }
                } catch (Throwable th) {
                    this.cgj.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cgj != null) {
                try {
                    this.cgj.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cgh != null) {
                d.this.cgh.ex(false);
            }
            if (d.this.cgg != null) {
                d.this.cgg.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cgh != null) {
                d.this.cgh.ex(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cgg != null) {
                d.this.cgg.removeMessages(0);
            }
        }
    }
}
