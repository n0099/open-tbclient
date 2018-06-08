package com.baidu.tbadk.widget.lottie;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
import java.io.File;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    private a bbY;
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
        this.bbY = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String doInBackground(Void... voidArr) {
        if (ao.isEmpty(this.mPath) || ao.isEmpty(this.mUrl) || !l.dR(this.mPath)) {
            return null;
        }
        String bj = s.bj(this.mUrl);
        String str = this.mPath + bj + "/";
        if (hQ(str)) {
            return bj;
        }
        this.mNetWork = new y();
        this.mNetWork.setUrl(this.mUrl);
        String str2 = this.mPath + bj + ".zip";
        if (this.mNetWork.a(str2, null, 0, 3, 0, true) && az(str2, str)) {
            hP(str2);
            return bj;
        }
        hP(str2);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.bbY != null) {
            if (!ao.isEmpty(str)) {
                this.bbY.e(true, str);
            } else {
                this.bbY.e(false, null);
            }
        }
    }

    private boolean az(String str, String str2) {
        if (ao.isEmpty(str) || ao.isEmpty(str2)) {
            return false;
        }
        return r.X(str, str2);
    }

    private void hP(String str) {
        if (!ao.isEmpty(str)) {
            l.r(new File(str));
        }
    }

    private boolean hQ(String str) {
        return !ao.isEmpty(str) && new File(str).exists();
    }
}
