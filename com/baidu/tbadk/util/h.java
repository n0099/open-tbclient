package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static h ctj = new h();
    private b ctk;
    private a ctl;

    /* loaded from: classes.dex */
    public interface a {
        void bt(boolean z);
    }

    private h() {
    }

    public static h apR() {
        return ctj;
    }

    public void a(a aVar) {
        this.ctl = aVar;
        if (this.ctk != null) {
            this.ctk.cancel();
        }
        this.ctk = new b();
        this.ctk.setPriority(4);
        this.ctk.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apS() {
        int i;
        long j = 0;
        byte[] mh = com.baidu.tbadk.core.util.m.mh(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (mh != null) {
            str = new String(mh);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(Config.TRACE_TODAY_VISIT_SPLIT);
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
            return Boolean.valueOf(h.this.apS());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (h.this.ctl != null && bool != null) {
                h.this.ctl.bt(bool.booleanValue());
            }
        }
    }
}
