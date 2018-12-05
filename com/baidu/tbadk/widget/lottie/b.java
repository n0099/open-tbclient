package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bps;
    private x mNetWork;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z, String str);
    }

    public static boolean iV(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.j("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.bps = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public String doInBackground(Void... voidArr) {
        if (ao.isEmpty(this.mPath) || ao.isEmpty(this.mUrl) || !iV(this.mPath)) {
            return null;
        }
        String bC = s.bC(this.mUrl);
        String str = this.mPath + bC + "/";
        if (iX(str)) {
            return bC;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.mPath + bC + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && aQ(str2, str)) {
            iW(str2);
            return bC;
        }
        iW(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bps != null) {
            if (!ao.isEmpty(str)) {
                this.bps.d(true, str);
            } else {
                this.bps.d(false, null);
            }
        }
    }

    private boolean aQ(String str, String str2) {
        if (ao.isEmpty(str) || ao.isEmpty(str2)) {
            return false;
        }
        return r.at(str, str2);
    }

    private void iW(String str) {
        if (!ao.isEmpty(str)) {
            l.y(new File(str));
        }
    }

    private boolean iX(String str) {
        return !ao.isEmpty(str) && new File(str).exists();
    }
}
