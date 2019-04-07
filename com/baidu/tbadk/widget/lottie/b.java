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
    private a cAV;
    private x mNetWork;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void i(boolean z, String str);
    }

    public static boolean pX(String str) {
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
        this.cAV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.mPath) || ap.isEmpty(this.mUrl) || !pX(this.mPath)) {
            return null;
        }
        String bC = s.bC(this.mUrl);
        String str = this.mPath + bC + "/";
        if (pZ(str)) {
            return bC;
        }
        this.mNetWork = new x();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.mPath + bC + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && bW(str2, str)) {
            pY(str2);
            return bC;
        }
        pY(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.cAV != null) {
            if (!ap.isEmpty(str)) {
                this.cAV.i(true, str);
            } else {
                this.cAV.i(false, null);
            }
        }
    }

    private boolean bW(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.bB(str, str2);
    }

    private void pY(String str) {
        if (!ap.isEmpty(str)) {
            m.G(new File(str));
        }
    }

    private boolean pZ(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
