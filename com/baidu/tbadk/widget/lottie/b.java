package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bdm;
    private y mNetWork;
    private String mPath;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface a {
        void e(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.mPath = str;
        this.mUrl = str2;
        this.bdm = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public String doInBackground(Void... voidArr) {
        if (ap.isEmpty(this.mPath) || ap.isEmpty(this.mUrl) || !l.dU(this.mPath)) {
            return null;
        }
        String bl = s.bl(this.mUrl);
        String str = this.mPath + bl + "/";
        if (hU(str)) {
            return bl;
        }
        this.mNetWork = new y();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.mPath + bl + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && az(str2, str)) {
            hT(str2);
            return bl;
        }
        hT(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bdm != null) {
            if (!ap.isEmpty(str)) {
                this.bdm.e(true, str);
            } else {
                this.bdm.e(false, null);
            }
        }
    }

    private boolean az(String str, String str2) {
        if (ap.isEmpty(str) || ap.isEmpty(str2)) {
            return false;
        }
        return r.X(str, str2);
    }

    private void hT(String str) {
        if (!ap.isEmpty(str)) {
            l.r(new File(str));
        }
    }

    private boolean hU(String str) {
        return !ap.isEmpty(str) && new File(str).exists();
    }
}
