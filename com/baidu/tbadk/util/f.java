package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f aVo = new f();
    private b aVp;
    private a aVq;

    /* loaded from: classes.dex */
    public interface a {
        void ap(boolean z);
    }

    private f() {
    }

    public static f KS() {
        return aVo;
    }

    public void a(a aVar) {
        this.aVq = aVar;
        if (this.aVp != null) {
            this.aVp.cancel();
        }
        this.aVp = new b();
        this.aVp.setPriority(4);
        this.aVp.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KT() {
        int i;
        long j = 0;
        byte[] ei = com.baidu.tbadk.core.util.l.ei(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (ei != null) {
            str = new String(ei);
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
            return Boolean.valueOf(f.this.KT());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.aVq != null && bool != null) {
                f.this.aVq.ap(bool.booleanValue());
            }
        }
    }
}
