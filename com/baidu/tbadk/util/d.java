package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d aJb = new d();
    private b aJc;
    private a aJd;

    /* loaded from: classes.dex */
    public interface a {
        void am(boolean z);
    }

    private d() {
    }

    public static d Gn() {
        return aJb;
    }

    public void a(a aVar) {
        this.aJd = aVar;
        if (this.aJc != null) {
            this.aJc.cancel();
        }
        this.aJc = new b(this, null);
        this.aJc.setPriority(4);
        this.aJc.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Go() {
        int i;
        long j = 0;
        byte[] au = com.baidu.adp.lib.util.e.au("crash_hour_record.log");
        String str = null;
        if (au != null) {
            str = new String(au);
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

        /* synthetic */ b(d dVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(d.this.Go());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aJd != null && bool != null) {
                d.this.aJd.am(bool.booleanValue());
            }
        }
    }
}
