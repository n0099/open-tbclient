package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f aWj = new f();
    private b aWk;
    private a aWl;

    /* loaded from: classes.dex */
    public interface a {
        void ap(boolean z);
    }

    private f() {
    }

    public static f Lk() {
        return aWj;
    }

    public void a(a aVar) {
        this.aWl = aVar;
        if (this.aWk != null) {
            this.aWk.cancel();
        }
        this.aWk = new b();
        this.aWk.setPriority(4);
        this.aWk.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ll() {
        int i;
        long j = 0;
        byte[] el = com.baidu.tbadk.core.util.l.el(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (el != null) {
            str = new String(el);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(SystemInfoUtil.COLON);
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
            return Boolean.valueOf(f.this.Ll());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.aWl != null && bool != null) {
                f.this.aWl.ap(bool.booleanValue());
            }
        }
    }
}
