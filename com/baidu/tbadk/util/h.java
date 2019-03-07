package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static h ctk = new h();
    private b ctl;
    private a ctm;

    /* loaded from: classes.dex */
    public interface a {
        void bt(boolean z);
    }

    private h() {
    }

    public static h apU() {
        return ctk;
    }

    public void a(a aVar) {
        this.ctm = aVar;
        if (this.ctl != null) {
            this.ctl.cancel();
        }
        this.ctl = new b();
        this.ctl.setPriority(4);
        this.ctl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apV() {
        int i;
        long j = 0;
        byte[] mg = com.baidu.tbadk.core.util.m.mg(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (mg != null) {
            str = new String(mg);
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
            return Boolean.valueOf(h.this.apV());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (h.this.ctm != null && bool != null) {
                h.this.ctm.bt(bool.booleanValue());
            }
        }
    }
}
