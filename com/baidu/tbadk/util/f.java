package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f bje = new f();
    private b bjf;
    private a bjg;

    /* loaded from: classes.dex */
    public interface a {
        void onResult(boolean z);
    }

    private f() {
    }

    public static f Qh() {
        return bje;
    }

    public void a(a aVar) {
        this.bjg = aVar;
        if (this.bjf != null) {
            this.bjf.cancel();
        }
        this.bjf = new b();
        this.bjf.setPriority(4);
        this.bjf.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qi() {
        int i;
        long j = 0;
        byte[] ft = com.baidu.tbadk.core.util.l.ft(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (ft != null) {
            str = new String(ft);
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
            return Boolean.valueOf(f.this.Qi());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.bjg != null && bool != null) {
                f.this.bjg.onResult(bool.booleanValue());
            }
        }
    }
}
