package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private ad AR = null;
    private final String Gv;
    private final String Ri;
    private final String Rj;

    public d(String str, String str2, String str3) {
        this.Ri = str;
        this.Gv = str2;
        this.Rj = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bool = false;
        try {
            this.AR = new ad(this.Ri);
            bool = Boolean.valueOf(this.AR.a(String.valueOf(this.Gv) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
            if (bool != null && bool.booleanValue()) {
                if (!StringUtils.isNull(s.d(null, String.valueOf(this.Gv) + ".tmp", null, this.Gv))) {
                    s.cp(bc.cI(this.Rj));
                }
            } else {
                s.cp(String.valueOf(this.Gv) + ".tmp");
            }
        } catch (Exception e) {
        }
        return bool;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            new c().se();
        }
    }
}
