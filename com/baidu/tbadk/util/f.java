package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class f {
    private static f bAO = new f();
    private b bAP;
    private a bAQ;

    /* loaded from: classes.dex */
    public interface a {
        void aQ(boolean z);
    }

    private f() {
    }

    public static f Oq() {
        return bAO;
    }

    public void a(a aVar) {
        this.bAQ = aVar;
        if (this.bAP != null) {
            this.bAP.cancel();
        }
        this.bAP = new b();
        this.bAP.setPriority(4);
        this.bAP.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Or() {
        int i;
        long j = 0;
        byte[] aL = com.baidu.adp.lib.util.f.aL("crash_hour_record.log");
        String str = null;
        if (aL != null) {
            str = new String(aL);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.h(split[0], 0);
                j = com.baidu.adp.lib.g.b.c(split[1], j2);
            }
        }
        if (j == j2 && i > 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(f.this.Or());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.bAQ != null && bool != null) {
                f.this.bAQ.aQ(bool.booleanValue());
            }
        }
    }
}
