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
    private a cJe;
    private x mNetWork;
    private String mUrl;
    private String wV;

    /* loaded from: classes.dex */
    public interface a {
        void h(boolean z, String str);
    }

    public static boolean rg(String str) {
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
        this.wV = str;
        this.mUrl = str2;
        this.cJe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wV) || ap.isEmpty(this.mUrl) || !rg(this.wV)) {
            return null;
        }
        String bm = s.bm(this.mUrl);
        String str = this.wV + bm + "/";
        if (ri(str)) {
            return bm;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.wV + bm + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && cg(str2, str)) {
            rh(str2);
            return bm;
        }
        rh(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.cJe != null) {
            if (!ap.isEmpty(str)) {
                this.cJe.h(true, str);
            } else {
                this.cJe.h(false, null);
            }
        }
    }

    private boolean cg(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.bK(str, str2);
    }

    private void rh(String str) {
        if (!ap.isEmpty(str)) {
            m.A(new File(str));
        }
    }

    private boolean ri(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
