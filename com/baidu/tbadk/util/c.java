package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aIX = new c();
    private b aIY;
    private a aIZ;

    /* loaded from: classes.dex */
    public interface a {
        void an(boolean z);
    }

    private c() {
    }

    public static c Hh() {
        return aIX;
    }

    public void a(a aVar) {
        this.aIZ = aVar;
        if (this.aIY != null) {
            this.aIY.cancel();
        }
        this.aIY = new b(this, null);
        this.aIY.setPriority(4);
        this.aIY.execute(new String[0]);
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
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.Hi());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (c.this.aIZ != null && bool != null) {
                c.this.aIZ.an(bool.booleanValue());
            }
        }
    }
}
