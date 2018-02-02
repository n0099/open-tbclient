package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f bAW = new f();
    private b bAX;
    private a bAY;

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    private f() {
    }

    public static f Os() {
        return bAW;
    }

    public void a(a aVar) {
        this.bAY = aVar;
        if (this.bAX != null) {
            this.bAX.cancel();
        }
        this.bAX = new b();
        this.bAX.setPriority(4);
        this.bAX.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ot() {
        int i;
        long j = 0;
        byte[] dG = com.baidu.tbadk.core.util.k.dG(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (dG != null) {
            str = new String(dG);
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
            return Boolean.valueOf(f.this.Ot());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.bAY != null && bool != null) {
                f.this.bAY.aR(bool.booleanValue());
            }
        }
    }
}
