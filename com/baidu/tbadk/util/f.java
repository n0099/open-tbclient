package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f bDa = new f();
    private b bDb;
    private a bDc;

    /* loaded from: classes.dex */
    public interface a {
        void aU(boolean z);
    }

    private f() {
    }

    public static f OX() {
        return bDa;
    }

    public void a(a aVar) {
        this.bDc = aVar;
        if (this.bDb != null) {
            this.bDb.cancel();
        }
        this.bDb = new b();
        this.bDb.setPriority(4);
        this.bDb.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OY() {
        int i;
        long j = 0;
        byte[] dR = com.baidu.tbadk.core.util.k.dR(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (dR != null) {
            str = new String(dR);
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
            return Boolean.valueOf(f.this.OY());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.bDc != null && bool != null) {
                f.this.bDc.aU(bool.booleanValue());
            }
        }
    }
}
