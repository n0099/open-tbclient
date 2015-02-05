package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private ad AO = null;
    private final String GB;
    private final String RJ;
    private final String RK;

    public d(String str, String str2, String str3) {
        this.RJ = str;
        this.GB = str2;
        this.RK = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bool = false;
        try {
            this.AO = new ad(this.RJ);
            bool = Boolean.valueOf(this.AO.a(String.valueOf(this.GB) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
            if (bool != null && bool.booleanValue()) {
                if (!StringUtils.isNull(s.e(null, String.valueOf(this.GB) + ".tmp", null, this.GB))) {
                    s.ck(bh.cE(this.RK));
                }
            } else {
                s.ck(String.valueOf(this.GB) + ".tmp");
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
            new c().so();
        }
    }
}
