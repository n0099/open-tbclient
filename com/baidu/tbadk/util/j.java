package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.util.DaemonServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class j {
    private static j euZ = new j();
    private b eva;
    private a evb;

    /* loaded from: classes.dex */
    public interface a {
        void onResult(boolean z);
    }

    private j() {
    }

    public static j bgu() {
        return euZ;
    }

    public void a(a aVar) {
        this.evb = aVar;
        if (this.eva != null) {
            this.eva.cancel();
        }
        this.eva = new b();
        this.eva.setPriority(4);
        this.eva.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCrashNumOverLimit() {
        int i;
        long j = 0;
        byte[] GetFileData = com.baidu.tbadk.core.util.m.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + DaemonServiceManager.CRASH_HOUR_RECORD_FILE);
        String str = null;
        if (GetFileData != null) {
            str = new String(GetFileData);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                j = com.baidu.adp.lib.f.b.toLong(split[1], j2);
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
            return Boolean.valueOf(j.this.checkCrashNumOverLimit());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (j.this.evb != null && bool != null) {
                j.this.evb.onResult(bool.booleanValue());
            }
        }
    }
}
