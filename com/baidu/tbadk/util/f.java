package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class f {
    private static f beb = new f();
    private b bec;
    private a bed;

    /* loaded from: classes.dex */
    public interface a {
        void onResult(boolean z);
    }

    private f() {
    }

    public static f Oy() {
        return beb;
    }

    public void a(a aVar) {
        this.bed = aVar;
        if (this.bec != null) {
            this.bec.cancel();
        }
        this.bec = new b();
        this.bec.setPriority(4);
        this.bec.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oz() {
        int i;
        long j = 0;
        byte[] eR = com.baidu.tbadk.core.util.l.eR(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (eR != null) {
            str = new String(eR);
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
            return Boolean.valueOf(f.this.Oz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (f.this.bed != null && bool != null) {
                f.this.bed.onResult(bool.booleanValue());
            }
        }
    }
}
