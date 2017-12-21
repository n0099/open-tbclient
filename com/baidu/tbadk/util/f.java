package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class f {
    private static f aMS = new f();
    private b aMT;
    private a aMU;

    /* loaded from: classes.dex */
    public interface a {
        void aj(boolean z);
    }

    private f() {
    }

    public static f Hd() {
        return aMS;
    }

    public void a(a aVar) {
        this.aMU = aVar;
        if (this.aMT != null) {
            this.aMT.cancel();
        }
        this.aMT = new b();
        this.aMT.setPriority(4);
        this.aMT.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He() {
        int i;
        long j = 0;
        byte[] aD = com.baidu.adp.lib.util.f.aD("crash_hour_record.log");
        String str = null;
        if (aD != null) {
            str = new String(aD);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.g(split[0], 0);
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
            return Boolean.valueOf(f.this.He());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.aMU != null && bool != null) {
                f.this.aMU.aj(bool.booleanValue());
            }
        }
    }
}
