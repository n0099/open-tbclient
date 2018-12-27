package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f biu = new f();
    private b biv;
    private a biw;

    /* loaded from: classes.dex */
    public interface a {
        void onResult(boolean z);
    }

    private f() {
    }

    public static f PP() {
        return biu;
    }

    public void a(a aVar) {
        this.biw = aVar;
        if (this.biv != null) {
            this.biv.cancel();
        }
        this.biv = new b();
        this.biv.setPriority(4);
        this.biv.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PQ() {
        int i;
        long j = 0;
        byte[] fj = com.baidu.tbadk.core.util.l.fj(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (fj != null) {
            str = new String(fj);
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
            return Boolean.valueOf(f.this.PQ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.biw != null && bool != null) {
                f.this.biw.onResult(bool.booleanValue());
            }
        }
    }
}
