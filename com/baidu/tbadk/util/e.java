package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class e {
    private static e aMC = new e();
    private b aMD;
    private a aME;

    /* loaded from: classes.dex */
    public interface a {
        void al(boolean z);
    }

    private e() {
    }

    public static e Hb() {
        return aMC;
    }

    public void a(a aVar) {
        this.aME = aVar;
        if (this.aMD != null) {
            this.aMD.cancel();
        }
        this.aMD = new b();
        this.aMD.setPriority(4);
        this.aMD.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hc() {
        int i;
        long j = 0;
        byte[] aI = com.baidu.adp.lib.util.e.aI("crash_hour_record.log");
        String str = null;
        if (aI != null) {
            str = new String(aI);
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
            return Boolean.valueOf(e.this.Hc());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.aME != null && bool != null) {
                e.this.aME.al(bool.booleanValue());
            }
        }
    }
}
