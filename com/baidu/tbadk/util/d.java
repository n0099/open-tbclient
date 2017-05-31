package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d aIO = new d();
    private b aIP;
    private a aIQ;

    /* loaded from: classes.dex */
    public interface a {
        void al(boolean z);
    }

    private d() {
    }

    public static d Gh() {
        return aIO;
    }

    public void a(a aVar) {
        this.aIQ = aVar;
        if (this.aIP != null) {
            this.aIP.cancel();
        }
        this.aIP = new b(this, null);
        this.aIP.setPriority(4);
        this.aIP.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gi() {
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
            return Boolean.valueOf(d.this.Gi());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aIQ != null && bool != null) {
                d.this.aIQ.al(bool.booleanValue());
            }
        }
    }
}
