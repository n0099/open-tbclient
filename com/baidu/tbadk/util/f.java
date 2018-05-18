package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f aNq = new f();
    private b aNr;
    private a aNs;

    /* loaded from: classes.dex */
    public interface a {
        void am(boolean z);
    }

    private f() {
    }

    public static f Hy() {
        return aNq;
    }

    public void a(a aVar) {
        this.aNs = aVar;
        if (this.aNr != null) {
            this.aNr.cancel();
        }
        this.aNr = new b();
        this.aNr.setPriority(4);
        this.aNr.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hz() {
        int i;
        long j = 0;
        byte[] dI = com.baidu.tbadk.core.util.k.dI(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (dI != null) {
            str = new String(dI);
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
            return Boolean.valueOf(f.this.Hz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.aNs != null && bool != null) {
                f.this.aNs.am(bool.booleanValue());
            }
        }
    }
}
