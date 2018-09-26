package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f aZB = new f();
    private b aZC;
    private a aZD;

    /* loaded from: classes.dex */
    public interface a {
        void av(boolean z);
    }

    private f() {
    }

    public static f MA() {
        return aZB;
    }

    public void a(a aVar) {
        this.aZD = aVar;
        if (this.aZC != null) {
            this.aZC.cancel();
        }
        this.aZC = new b();
        this.aZC.setPriority(4);
        this.aZC.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MB() {
        int i;
        long j = 0;
        byte[] eB = com.baidu.tbadk.core.util.l.eB(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (eB != null) {
            str = new String(eB);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.l(split[0], 0);
                j = com.baidu.adp.lib.g.b.d(split[1], j2);
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
            return Boolean.valueOf(f.this.MB());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.aZD != null && bool != null) {
                f.this.aZD.av(bool.booleanValue());
            }
        }
    }
}
