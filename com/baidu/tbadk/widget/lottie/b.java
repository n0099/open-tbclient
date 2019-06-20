package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a cJf;
    private x mNetWork;
    private String mUrl;
    private String wU;

    /* loaded from: classes.dex */
    public interface a {
        void h(boolean z, String str);
    }

    public static boolean rf(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.i("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public b(String str, String str2, a aVar) {
        this.wU = str;
        this.mUrl = str2;
        this.cJf = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wU) || ap.isEmpty(this.mUrl) || !rf(this.wU)) {
            return null;
        }
        String bm = s.bm(this.mUrl);
        String str = this.wU + bm + "/";
        if (rh(str)) {
            return bm;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.wU + bm + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && cg(str2, str)) {
            rg(str2);
            return bm;
        }
        rg(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.cJf != null) {
            if (!ap.isEmpty(str)) {
                this.cJf.h(true, str);
            } else {
                this.cJf.h(false, null);
            }
        }
    }

    private boolean cg(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.bK(str, str2);
    }

    private void rg(String str) {
        if (!ap.isEmpty(str)) {
            m.A(new File(str));
        }
    }

    private boolean rh(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
