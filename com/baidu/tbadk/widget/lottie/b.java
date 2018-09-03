package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bdz;
    private y mNetWork;
    private String mUrl;
    private String wg;

    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z, String str);
    }

    public static boolean hQ(String str) {
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
        this.wg = str;
        this.mUrl = str2;
        this.bdz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.wg) || ap.isEmpty(this.mUrl) || !hQ(this.wg)) {
            return null;
        }
        String bm = s.bm(this.mUrl);
        String str = this.wg + bm + "/";
        if (hS(str)) {
            return bm;
        }
        this.mNetWork = new y();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.wg + bm + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && au(str2, str)) {
            hR(str2);
            return bm;
        }
        hR(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bdz != null) {
            if (!ap.isEmpty(str)) {
                this.bdz.d(true, str);
            } else {
                this.bdz.d(false, null);
            }
        }
    }

    private boolean au(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.W(str, str2);
    }

    private void hR(String str) {
        if (!ap.isEmpty(str)) {
            l.r(new File(str));
        }
    }

    private boolean hS(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
