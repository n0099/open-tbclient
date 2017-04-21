package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aIZ = new c();
    private b aJa;
    private a aJb;

    /* loaded from: classes.dex */
    public interface a {
        void an(boolean z);
    }

    private c() {
    }

    public static c Hh() {
        return aIZ;
    }

    public void a(a aVar) {
        this.aJb = aVar;
        if (this.aJa != null) {
            this.aJa.cancel();
        }
        this.aJa = new b(this, null);
        this.aJa.setPriority(4);
        this.aJa.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hi() {
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

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.Hi());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (c.this.aJb != null && bool != null) {
                c.this.aJb.an(bool.booleanValue());
            }
        }
    }
}
